package odaca.servicios;

import odaca.entidades.Dispositivo;
import odaca.entidades.Foto;
import odaca.entidades.Usuario;
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


    public List<Dispositivo> listDispUser(String user) {
        List<Dispositivo> lista = null;
        final Session session = getHibernateSession();

//        EntityManager em = getEntityManager();
        try {

            Query query = session.createQuery("select p from Dispositivo p   where p.user = :id order by p.iddevice asc " );
            query.setParameter("id",user);

            //query.setParameter("nombre", apellido+"%");
            lista = query.getResultList();

        } finally {
            session.close();
        }return lista;
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