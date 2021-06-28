package odaca.servicios;

import odaca.entidades.Producto;
import odaca.entidades.Ubicacion;
import odaca.entidades.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;


public class UbicacionServicios extends GestionadDB<Ubicacion>{
    private static UbicacionServicios instancia;



    public static UbicacionServicios getInstancia(){
        if(instancia==null){
            instancia = new UbicacionServicios();
        }
        return instancia;
    }
    public UbicacionServicios() {
        super(Ubicacion.class);
    }

    public void updateUbiPrincipal(String codigo, String ubi){
        final Session session = getHibernateSession();
        Transaction txn = session.beginTransaction();
//        EntityManager em = getEntityManager();
        try {

            Query query = session.createQuery("update Producto  p set p.ubicacionPrincipal = :ubi where p.codigo = :codigo ").setParameter("codigo",codigo).setParameter("ubi",ubi);

            query.executeUpdate();
            txn.commit();


//            return true;
        }finally {
            session.close();
        }
    }



    public void updateDisponible(boolean disp, int ubi){
        final Session session = getHibernateSession();
        Transaction txn = session.beginTransaction();
//        EntityManager em = getEntityManager();
        try {

            Query query = session.createQuery("update Ubicacion u set u.disponible = :disp where u.id = :ubi ").setParameter("disp",disp).setParameter("ubi",ubi);

            query.executeUpdate();
            txn.commit();


//            return true;
        }finally {
            session.close();
        }
    }
}
