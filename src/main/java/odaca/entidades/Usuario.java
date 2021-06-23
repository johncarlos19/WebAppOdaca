package odaca.entidades;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario implements Identifiable<String> {
    @Id
    @GeneratedValue(generator = "cli-generator",strategy = GenerationType.AUTO)
    @GenericGenerator(name = "cli-generator", parameters = {@org.hibernate.annotations.Parameter(name = "prefix", value = "CLI"),@org.hibernate.annotations.Parameter(name = "longitud", value = "10")}
            , strategy = "odaca.entidades.MyGenerator")

    private String usuario;
    private String nombre;
    private String contrasena;
    private String apellido;
    private String perfil;
    private String nombreCompania;
    private String pais;
    private String municipio;
    private String direccion;
    private String telefono;
    @CreationTimestamp
    private Timestamp fecha_registro;
    private Timestamp fechaNacimiento;
    private String email;
    private String documento;
    private String tipoDocumento;
    private String lactitud;
    private String longitud;

//    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL ,  orphanRemoval = true)
//    @JoinColumn(name="idUsuario")
//    @OrderBy(value = "id desc ")
//    private List<Politica> politicaList = new ArrayList<Politica>();


    public Usuario(){

    }


    public Timestamp getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Timestamp fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) throws UnsupportedEncodingException {
        this.nombreCompania = new String(nombreCompania.getBytes("UTF-8"), "ISO-8859-1");;
    }

//    public List<Politica> getPoliticaList() {
//        return politicaList;
//    }
//
//    public void setPoliticaList(List<Politica> politicaList) {
//        this.politicaList = politicaList;
//    }

    public Usuario(String usuario, String nombre) {
        this.usuario = usuario;
        this.nombre = nombre;
    }

//    public boolean addPolitica(Politica aux){
//        politicaList.add(aux);
//        return true;
//    }


    public String getContrasena() {
        return contrasena;
    }

    public String getLactitud() {
        return lactitud;
    }

    public void setLactitud(String lactitud) {
        this.lactitud = lactitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) throws UnsupportedEncodingException {
        this.apellido = new String(apellido.getBytes("UTF-8"), "ISO-8859-1");;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) throws UnsupportedEncodingException {
        this.pais = new String(pais.getBytes("UTF-8"), "ISO-8859-1");;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) throws UnsupportedEncodingException {
        this.municipio = new String(municipio.getBytes("UTF-8"), "ISO-8859-1");;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) throws UnsupportedEncodingException  {
        this.direccion = new String(direccion.getBytes("UTF-8"), "ISO-8859-1");;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Timestamp getFecha_registro() {
        return fecha_registro;
    }
    public String getFechaRegistroString() {
        return fecha_registro.toString();
    }

    public void setFecha_registro(Timestamp fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws UnsupportedEncodingException  {
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) throws UnsupportedEncodingException {
        this.documento = documento;
    }



    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws UnsupportedEncodingException  {
        this.nombre = new String(nombre.getBytes("UTF-8"), "ISO-8859-1");;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Override
    public String getId() {
        return usuario;
    }
}
