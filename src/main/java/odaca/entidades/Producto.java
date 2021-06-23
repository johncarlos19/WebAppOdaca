package odaca.entidades;

import odaca.jsonObject.FotoJson;
import odaca.jsonObject.ModeloJson;
import odaca.jsonObject.ProductoJson;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Producto implements Identifiable<String>{

    @Id
    @GeneratedValue(generator = "cli-generator",strategy = GenerationType.AUTO)
    @GenericGenerator(name = "cli-generator", parameters = {@org.hibernate.annotations.Parameter(name = "prefix", value = "PRO"),@org.hibernate.annotations.Parameter(name = "longitud", value = "10")}
            , strategy = "odaca.entidades.MyGenerator")
    private String codigo;
    private String nombre;
    private String referencia;
    private boolean disponible;
    private String marca;
    private String ubicacionPrincipal;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "idProducto", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name="idproductoEnVenta")
    private List<ProductoModelo> productoModelos = new ArrayList<ProductoModelo>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idProducto", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name="idProducto")
    private List<Ubicacion> ubicacionList = new ArrayList<Ubicacion>();
    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL , orphanRemoval = true,mappedBy = "idProducto")
    private Foto foto;
    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL , orphanRemoval = true,mappedBy = "idProductoOri")
    private Foto fotoOriginal;
    @Transient
    private List<Modelo> modelos = new ArrayList<Modelo>();
    @Transient
    private List<Marca> marcas = new ArrayList<Marca>();



    public Producto() {
    }

    public Producto(String codigo, String nombre, String referencia, boolean disponible) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.referencia = referencia;
        this.disponible = disponible;

    }

    public ProductoJson getProductoJsonResize(){
        ProductoJson productoJson = new ProductoJson();
         List<ModeloJson> modelos1 = new ArrayList<ModeloJson>();
        for (ProductoModelo productoModelo : productoModelos) {
            modelos1.add(productoModelo.getIdModelo().getModeloJson());
        }
        productoJson.setCodigo(this.codigo);
        productoJson.setDisponible(this.disponible);
        productoJson.setFoto(new FotoJson(this.foto.getId(),this.foto.getNombre(),this.foto.getMimeType(),this.foto.getFotoBase(),"resize"));
        productoJson.setFotoOri(null);
        productoJson.setMarca(this.marca);
        productoJson.setNombre(this.nombre);
        productoJson.setReferencia(this.referencia);
        productoJson.setUbicacionPrincipal(this.ubicacionPrincipal);

        productoJson.setModelos(modelos1);
        return productoJson;
    }
    public ProductoJson getProductoJsonComplete(){
        ProductoJson productoJson = new ProductoJson();
         List<ModeloJson> modelos1 = new ArrayList<ModeloJson>();
        for (ProductoModelo productoModelo : productoModelos) {
            modelos1.add(productoModelo.getIdModelo().getModeloJson());
        }
        productoJson.setCodigo(this.codigo);
        productoJson.setDisponible(this.disponible);
        productoJson.setFoto(new FotoJson(this.foto.getId(),this.foto.getNombre(),this.foto.getMimeType(),this.foto.getFotoBase(),"resize"));
        productoJson.setFotoOri(new FotoJson(this.fotoOriginal.getId(),this.fotoOriginal.getNombre(),this.fotoOriginal.getMimeType(),this.fotoOriginal.getFotoBase(),"original"));
//        productoJson.setFotoOri(null);
        productoJson.setMarca(this.marca);
        productoJson.setNombre(this.nombre);
        productoJson.setReferencia(this.referencia);
        productoJson.setUbicacionPrincipal(this.ubicacionPrincipal);

        productoJson.setModelos(modelos1);
        return productoJson;
    }

    public ProductoModelo addModelo(Modelo modelo){


        ProductoModelo can = new ProductoModelo(this,modelo);
        modelo.getProductoModelo().add(can);
        productoModelos.add(can);
        return can;
//        impuesto.getProductoEnVentas().add(this);
//
//        impuestos.add(impuesto);
    }
    public List<ProductoModelo> getProductoModelos() {
        return productoModelos;
    }

    public void setProductoModelos(List<ProductoModelo> productoModelos) {
        this.productoModelos = productoModelos;
    }
    public void addFoto(Foto foto1){
        foto1.setIdProducto(this);
        this.foto = foto1;

    }
    public void addUbicacion(Ubicacion ubicacion){
        ubicacion.setIdProducto(this);
        this.ubicacionList.add(ubicacion);

    }
    public void addFotoOri(Foto foto1){
        foto1.setIdProductoOri(this);
        this.fotoOriginal = foto1;

    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }


    public List<Long> verifyAddNewModel(List<Modelo> modelos1) {
        List<Modelo> list = new ArrayList<Modelo>();
        List<Long> list1 = new ArrayList<Long>();
        int countAdd = 0;
        int previsteCantidad = modelos1.size();
        int oriCantidad = productoModelos.size();

        boolean es = false;
        for (Modelo modelo : modelos1) {
            for (ProductoModelo productoModelo : productoModelos) {
                if (modelo.getId() == productoModelo.getIdModelo().getId()){
                    es = true;
                    break;
                }
            }
            if (es==true){

                es = false;
            }else {
                addModelo(modelo);
                list.add(modelo);
                countAdd+=1;
            }

        }
        System.out.println("\n\n\naddtotal"+countAdd+"rr"+previsteCantidad);
        int total = previsteCantidad - countAdd;
        if (total<oriCantidad){
//            int posi = -1;
            for (int i = this.productoModelos.size() - 1; i >= 0; i--) {
                for (Modelo modelo : modelos1) {


                    if (modelo.getId() == this.productoModelos.get(i).getIdModelo().getId()){
                        es = true;
                        break;
                    }

                }
                if (es==true){

                    es = false;
                }else {
                    list1.add(this.productoModelos.get(i).getId());
                }



            }

        }
        System.out.println("\n\n\ntotal modelo add"+list1.size());
        return list1;

    }



    public List<String> getModelosEdit() {
        List<String> list = new ArrayList<String>();
        boolean es = false;
        for (Modelo modelo : modelos) {
            for (ProductoModelo productoModelo : productoModelos) {
                if (modelo.getId() == productoModelo.getIdModelo().getId()){
                    es = true;
                    break;
                }
            }
            if (es==true){
                list.add("<option value='"+modelo.getId()+"' selected >"+modelo.getModelo()+"</option>");
                es = false;
            }else {
                list.add("<option value='"+modelo.getId()+"'  >"+modelo.getModelo()+"</option>");
            }
        }
        return list;
    }
    public List<String> getMarcaEdit() {
        List<String> list = new ArrayList<String>();
        boolean es = false;
        for (Marca marc : marcas) {

                if (marc.getMarca().equalsIgnoreCase(marca) ){
                    es = true;

                }

            if (es==true){
                list.add("<option value='"+marc.getMarca()+"' selected >"+marc.getMarca()+"</option>");
                es = false;
            }else {
                list.add("<option value='"+marc.getMarca()+"'  >"+marc.getMarca()+"</option>");
            }
        }
        return list;
    }

    public String getUbicacionPrincipal() {
        return ubicacionPrincipal;
    }

    public void setUbicacionPrincipal(String ubicacionPrincipal) {
        this.ubicacionPrincipal = ubicacionPrincipal;
    }

    //    public Foto getButtonOri() {
//        return foto;
//    }
    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public Foto getFotoOriginal() {
        return fotoOriginal;
    }

    public void setFotoOriginal(Foto fotoOriginal) {
        this.fotoOriginal = fotoOriginal;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public List<Ubicacion> getUbicacionList() {
        return ubicacionList;
    }

    public void setUbicacionList(List<Ubicacion> ubicacionList) {
        this.ubicacionList = ubicacionList;
    }

    @Override
    public String getId() {
        return codigo;
    }
}
