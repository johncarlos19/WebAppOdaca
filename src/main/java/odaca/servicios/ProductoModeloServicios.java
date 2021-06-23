package odaca.servicios;

import odaca.entidades.Producto;
import odaca.entidades.ProductoModelo;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;


public class ProductoModeloServicios  extends GestionadDB<ProductoModelo>{
    private static ProductoModeloServicios instancia;



    public static ProductoModeloServicios getInstancia(){
        if(instancia==null){
            instancia = new ProductoModeloServicios();
        }
        return instancia;
    }
    public ProductoModeloServicios() {
        super(ProductoModelo.class);
    }

    public void borrarProductoModelo(long id) {
        Producto lista = null;
        final Session session = getHibernateSession();
        Transaction txn = session.beginTransaction();

//        EntityManager em = getEntityManager();
        try {

            Query query = session.createQuery("delete from ProductoModelo pm where pm.id = :id" );
            query.setParameter("id",id);

            //query.setParameter("nombre", apellido+"%");
            query.executeUpdate();
            txn.commit();

        } finally {
            session.close();
        }
    }

}