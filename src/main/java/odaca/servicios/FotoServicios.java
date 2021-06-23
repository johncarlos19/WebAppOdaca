package odaca.servicios;

import odaca.entidades.Foto;
import org.hibernate.Session;

import javax.persistence.Query;

public class FotoServicios  extends GestionadDB<Foto>{
    private static FotoServicios instancia;



    public static FotoServicios getInstancia(){
        if(instancia==null){
            instancia = new FotoServicios();
        }
        return instancia;
    }
    public FotoServicios() {
        super(Foto.class);
    }


}
