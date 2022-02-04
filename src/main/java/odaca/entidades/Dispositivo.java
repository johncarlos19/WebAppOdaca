package odaca.entidades;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Dispositivo implements Identifiable<String> {
    @Id
    @GeneratedValue(generator = "cli-generator",strategy = GenerationType.AUTO)
    @GenericGenerator(name = "cli-generator", parameters = {@org.hibernate.annotations.Parameter(name = "prefix", value = "DIV"),@org.hibernate.annotations.Parameter(name = "longitud", value = "10")}
            , strategy = "odaca.entidades.MyGenerator")
    private String idDevice;

    private String useragent;
    private String numberValidate;
    private String usuario;
    private boolean validate = false;
    @CreationTimestamp
    private Timestamp fecha_registro;
    private Timestamp fechaExpiracion;

    public Dispositivo() {
    }


    public Dispositivo(String idDevice, String useragent, String numberValidate, String user, boolean validate) {
        this.idDevice = idDevice;
        this.useragent = useragent;
        this.numberValidate = numberValidate;
        this.usuario = usuario;
        this.validate = validate;
    }

    public String getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(String idDevice) {
        this.idDevice = idDevice;
    }

    public String getNumberValidate() {
        return numberValidate;
    }

    public void setNumberValidate(String numberValidate) {
        this.numberValidate = numberValidate;
    }



    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUseragent() {
        return useragent;
    }

    public void setUseragent(String useragent) {
        this.useragent = useragent;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public Timestamp getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Timestamp fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Timestamp getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Timestamp fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    @Override
    public String getId() {
        return idDevice;
    }
}
