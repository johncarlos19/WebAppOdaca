package odaca.entidades;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Politica {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String key;
    private boolean permitido = true;
    private String grupo;
//    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL )
//    @JoinColumn(name = "idUsuario")
//    private Usuario idUsuario;



    public Politica() {

    }

    public Politica(String key, boolean permitido) {

        this.key = key;
        this.permitido = permitido;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    //    public Usuario getIdUsuario() {
//        return idUsuario;
//    }
//
//    public void setIdUsuario(Usuario idUsuario) {
//        this.idUsuario = idUsuario;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        if (permitido==true){
            return "display: block";
        }else {
            return "display: none";
        }
    }


    public boolean isPermitido() {
        return permitido;
    }

    public void setPermitido(boolean permitido) {
        this.permitido = permitido;
    }
}
