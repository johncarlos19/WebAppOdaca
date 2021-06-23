package odaca.entidades;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Foto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JoinColumn(name = "idProducto")
    @OneToOne()
    private Producto idProducto;
    @JoinColumn(name = "idProductoOri")
    @OneToOne()
    private Producto idProductoOri;
    private String nombre;
    private String mimeType;
    @Lob
    private String fotoBase64;



    public Foto() {
    }

    public Foto(String nombre, String mimeType, String fotoBase64){
        this.nombre = nombre;
        this.mimeType = mimeType;
        this.fotoBase64 = fotoBase64;
    }


    public Producto getIdProductoOri() {
        return idProductoOri;
    }

    public void setIdProductoOri(Producto idProductoOri) {
        this.idProductoOri = idProductoOri;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
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
    public String getFotoBase() {
        try {
            if(fotoBase64 == null || fotoBase64.equalsIgnoreCase("")){


                return "../catalogo/assets/img/moto02.png";

            }else {
                return fotoBase64;
            }

        }catch (NullPointerException e){
            return "../catalogo/assets/img/moto02.png";
        }


    }



    public void setFotoBase64(String fotoBase64) {
        this.fotoBase64 = fotoBase64;
    }
}
