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
    private String iddevice;
    private String user;
    private String useragent;
    private String numberValidate;
    private boolean validate = false;
    @CreationTimestamp
    private Timestamp fecha_registro;
    private Timestamp fechaExpiracion;

    public Dispositivo() {
    }

    public String getNumberValidate() {
        return numberValidate;
    }

    public void setNumberValidate(String numberValidate) {
        this.numberValidate = numberValidate;
    }

    public String getIddevice() {
        return iddevice;
    }

    public void setIddevice(String iddevice) {
        this.iddevice = iddevice;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
        return iddevice;
    }
}
