package odaca.jsonObject;

import odaca.entidades.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoJson {
    private String codigo;
    private String nombre;
    private String referencia;
    private boolean disponible;
    private String marca;
    private String ubicacionPrincipal;
    private FotoJson foto;
    private FotoJson fotoOri;
    private List<ModeloJson> modelos = new ArrayList<ModeloJson>();

    public ProductoJson() {
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getUbicacionPrincipal() {
        return ubicacionPrincipal;
    }

    public void setUbicacionPrincipal(String ubicacionPrincipal) {
        this.ubicacionPrincipal = ubicacionPrincipal;
    }

    public FotoJson getFoto() {
        return foto;
    }

    public void setFoto(FotoJson foto) {
        this.foto = foto;
    }

    public FotoJson getFotoOri() {
        return fotoOri;
    }

    public void setFotoOri(FotoJson fotoOri) {
        this.fotoOri = fotoOri;
    }

    public List<ModeloJson> getModelos() {
        return modelos;
    }

    public void setModelos(List<ModeloJson> modelos) {
        this.modelos = modelos;
    }
}
