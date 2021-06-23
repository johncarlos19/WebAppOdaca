package odaca.jsonObject;

import odaca.entidades.Producto;

import javax.persistence.*;

public class FotoJson {

    private long id;
    private String nombre;
    private String mimeType;
    private String fotoBase64;
    private String type;


    public FotoJson(long id, String nombre, String mimeType, String fotoBase64, String type) {
        this.id = id;
        this.nombre = nombre;
        this.mimeType = mimeType;
        this.fotoBase64 = fotoBase64;
        this.type = type;
    }

    public FotoJson() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getFotoBase64() {
        return fotoBase64;
    }

    public void setFotoBase64(String fotoBase64) {
        this.fotoBase64 = fotoBase64;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
