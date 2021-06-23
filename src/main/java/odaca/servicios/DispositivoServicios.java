package odaca.servicios;

import odaca.entidades.Dispositivo;
import odaca.entidades.Foto;
import org.hibernate.Session;

import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

public class DispositivoServicios extends GestionadDB<Dispositivo>{
    private static DispositivoServicios instancia;



    public static DispositivoServicios getInstancia(){
        if(instancia==null){
            instancia = new DispositivoServicios();
        }
        return instancia;
    }
    public DispositivoServicios() {
        super(Dispositivo.class);
    }


    public Dispositivo getDispositivoAnteDeExpirar(String id, int plazo){
        final Session session = getHibernateSession();

//        EntityManager em = getEntityManager();
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.add(calendar.MONTH,1*plazo);
            Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

            Query query = session.createQuery("select d from Dispositivo d where d.fechaExpiracion <= :fecha and d.iddevice = :id" );
            query.setParameter("fecha",timestamp);
            query.setParameter("id",id);


            //query.setParameter("nombre", apellido+"%");
            Dispositivo lista = (Dispositivo) query.getSingleResult() ;
            return lista;
        }catch (NullPointerException e){
            return null;
        }finally {
            session.close();
        }

    }


}