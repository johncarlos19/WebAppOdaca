package odaca.entidades;

import odaca.jsonObject.ModeloJson;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Modelo implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String modelo;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "idModelo", cascade = CascadeType.ALL)
//    @JoinColumn(name="idproductoEnVenta")
    private List<ProductoModelo> productoModelos = new ArrayList<ProductoModelo>();

    public Modelo(String modelo) {
        this.modelo = modelo;
    }

    public List<ProductoModelo> getProductoModelo() {
        return productoModelos;
    }

    public void setProductoModelo(List<ProductoModelo> productoModelos) {
        this.productoModelos = productoModelos;
    }

    public Modelo() {
    }

    public ModeloJson getModeloJson(){
        ModeloJson modeloJson = new ModeloJson(this.id,this.modelo);
        return modeloJson;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
