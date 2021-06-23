package odaca.jsonObject;

import odaca.entidades.ProductoModelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ModeloJson {

    private long id;
    private String modelo;

    public ModeloJson() {
    }

    public ModeloJson(long id, String modelo) {
        this.id = id;
        this.modelo = modelo;
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
