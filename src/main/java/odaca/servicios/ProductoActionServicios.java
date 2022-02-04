package odaca.servicios;

import odaca.entidades.Producto;
import odaca.entidades.ProductoAction;
import odaca.jsonObject.ProductoJson;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ProductoActionServicios extends GestionadDB<ProductoAction>{
    private static ProductoActionServicios instancia;



    public static ProductoActionServicios getInstancia(){
        if(instancia==null){
            instancia = new ProductoActionServicios();
        }
        return instancia;
    }
    public ProductoActionServicios() {
        super(ProductoAction.class);
    }

    public List<Producto> listProductoConFotoResizeTipo(String tipo) {
        List<Producto> lista = null;
        final Session session = getHibernateSession();

//        EntityManager em = getEntityManager();
        try {

            Query query = session.createQuery("select p from Producto p,ProductoAction pa inner join p.foto f where f.idProducto.id = p.id and pa.codigoProducto = p.codigo and pa.tipo = :tipo group by p order by p.id asc " );
            query.setParameter("tipo",tipo);

            //query.setParameter("nombre", apellido+"%");
            lista = query.getResultList();

        } finally {
            session.close();
        }return lista;
    }
    public List<ProductoJson> listProductoConFotoResizeTipoJson(String tipo) {
        List<Producto> lista = null;
        List<ProductoJson> lista1 = new ArrayList<ProductoJson>();
        final Session session = getHibernateSession();

//        EntityManager em = getEntityManager();
        try {

            Query query = session.createQuery("select p from Producto p,ProductoAction pa inner join p.foto f where f.idProducto.id = p.id and pa.codigoProducto = p.codigo and pa.tipo = :tipo  order by p.id asc " );
            query.setParameter("tipo",tipo);

            //query.setParameter("nombre", apellido+"%");
            lista = (List<Producto>) query.getResultList();
            for (Producto producto : lista) {
                lista1.add(producto.getProductoJsonResize());
            }













        } finally {
            session.close();
        }return lista1;
    }
    public List<Producto> listProductoConFotoResizeTipoAvailable(String tipo, int posi) {
        List<Producto> lista = null;
        final Session session = getHibernateSession();
        Query query = null;

//        EntityManager em = getEntityManager();
        try {
            switch (posi){
                case 1:
                    query = session.createQuery("select p1 from Producto p1  where p1.codigo not in (select p from Producto p left  join ProductoAction pa on pa.codigoProducto = p.codigo  where pa.tipo = :tipo  ) order by p1.codigo asc " );
                    query.setParameter("tipo",tipo);

                    //query.setParameter("nombre", apellido+"%");
                    lista = query.getResultList();
                    break;
                case 2:
                    query = session.createQuery("select p from Producto p inner join p.foto f where f.idProducto.codigo = p.codigo  order by p.codigo asc " );


                    //query.setParameter("nombre", apellido+"%");
                    lista = query.getResultList();
                    break;
                default:
                    break;
            }



        } finally {
            session.close();
        }return lista;
    }

    public long cantProductoAction(String tipo){
        long lista = -1;
        final Session session = getHibernateSession();

//        EntityManager em = getEntityManager();
        try {

            Query query = session.createQuery("select count (pa) from ProductoAction pa where pa.tipo = :tipo  " );
            query.setParameter("tipo",tipo);

            //query.setParameter("nombre", apellido+"%");
            lista = (long) query.getSingleResult();

        } finally {
            session.close();
        }return lista;
    }

    public void borrarProductoActiono(String codigo, String tipo) {
        Producto lista = null;
        final Session session = getHibernateSession();
        Transaction txn = session.beginTransaction();

//        EntityManager em = getEntityManager();
        try {

            Query query = session.createQuery("delete from ProductoAction pa where pa.codigoProducto = :codigo and  pa.tipo = :tipo" );
            query.setParameter("codigo",codigo);
            query.setParameter("tipo",tipo);

            //query.setParameter("nombre", apellido+"%");
            query.executeUpdate();
            txn.commit();

        } finally {
            session.close();
        }
    }

}
