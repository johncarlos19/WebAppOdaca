package odaca.servicios;

import odaca.entidades.Producto;
import odaca.entidades.Ubicacion;
import odaca.entidades.Usuario;
import odaca.jsonObject.ProductoJson;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ProductoServicios extends GestionadDB<Producto>{
    private static ProductoServicios instancia;



    public static ProductoServicios getInstancia(){
        if(instancia==null){
            instancia = new ProductoServicios();
        }
        return instancia;
    }
    public ProductoServicios() {
        super(Producto.class);
    }




    public Producto getProductoSinFoto(String id) {
        Producto lista = null;
        final Session session = getHibernateSession();

//        EntityManager em = getEntityManager();
        try {

            try {
                Query query = session.createQuery("select p from Producto p inner join p.ubicacionList where p.codigo = :id group by p order by p.codigo desc " );
                query.setParameter("id",id);

                //query.setParameter("nombre", apellido+"%");
                lista = (Producto) query.getSingleResult();
            }catch (Exception e){
                e.printStackTrace();
                Query query = session.createQuery("select p from Producto p  where p.codigo = :id group by p order by p.codigo desc " );
                query.setParameter("id",id);

                //query.setParameter("nombre", apellido+"%");
                lista = (Producto) query.getSingleResult();
            }


        } finally {
            session.close();
        }return (Producto) lista;
    }
    public Producto getProductoConFoto(String id) {
        Producto lista = null;
        final Session session = getHibernateSession();

//        EntityManager em = getEntityManager();
        try {

            try {
                Query query = session.createQuery("select p from Producto p  inner join Foto f on f.idProducto.id = p.id or f.idProductoOri.id  = p.id  inner join p.ubicacionList ub where  p.codigo = :id group by p order by p.id, ub.ubicacionNow asc  " );
                query.setParameter("id",id);

                //query.setParameter("nombre", apellido+"%");
                lista = (Producto) query.getSingleResult();
                System.out.println("\n\n\nLa cantidad es:"+lista.getUbicacionList().size());
            }catch (Exception e){
                e.printStackTrace();
                Query query = session.createQuery("select p from Producto p  inner join Foto f on f.idProducto.id  = p.id or f.idProductoOri.id  = p.id  where  p.codigo = :id group by p order by p.id desc  " );
                query.setParameter("id",id);

                //query.setParameter("nombre", apellido+"%");
                lista = (Producto) query.getSingleResult();
                lista.setUbicacionList(new ArrayList<Ubicacion>());
            }



        } finally {
            session.close();
        }return (Producto) lista;
    }



    public Producto getProductoConFotoOri(String id) {
        Producto lista = null;
        final Session session = getHibernateSession();

//        EntityManager em = getEntityManager();
        try {

            Query query = session.createQuery("select p from Producto p  inner join p.fotoOriginal f where p.codigo = :id order by p.codigo desc " );
            query.setParameter("id",id);

            //query.setParameter("nombre", apellido+"%");
            lista = (Producto) query.getSingleResult();

        } finally {
            session.close();
        }return (Producto) lista;
    }


    public List<Producto> listProductoSinFoto() {
        List<Producto> lista = null;
        final Session session = getHibernateSession();

//        EntityManager em = getEntityManager();
        try {

            Query query = session.createQuery("select p from Producto p  order by p.id desc " );
//            query.setParameter("id",id);

            //query.setParameter("nombre", apellido+"%");
            lista = query.getResultList();

        } finally {
            session.close();
        }return lista;
    }

    public List<Producto> listProductoConFotoResize() {
        List<Producto> lista = null;
        final Session session = getHibernateSession();

//        EntityManager em = getEntityManager();
        try {

            Query query = session.createQuery("select p from Producto p  inner join p.foto f where f.idProducto.id = p.id order by p.id desc " );
//            query.setParameter("id",id);

            //query.setParameter("nombre", apellido+"%");
            lista = query.getResultList();

        } finally {
            session.close();
        }return lista;
    }
    public List<ProductoJson> listProductoConFotoResizeJson() {
        List<Producto> lista = null;
        List<ProductoJson> lista1 = new ArrayList<ProductoJson>();
        final Session session = getHibernateSession();

//        EntityManager em = getEntityManager();
        try {

            Query query = session.createQuery("select p from Producto p  inner join p.foto f where f.idProducto.codigo = p.codigo order by p.codigo desc " );
//            query.setParameter("id",id);

            //query.setParameter("nombre", apellido+"%");
            lista = (List<Producto>) query.getResultList();
            for (Producto producto : lista) {
                lista1.add(producto.getProductoJsonResize());
            }

        } finally {
            session.close();
        }return lista1;
    }
    public List<ProductoJson> listProductoConFotoJson() {
        List<Producto> lista = null;
        List<ProductoJson> lista1 = new ArrayList<ProductoJson>();
        final Session session = getHibernateSession();

//        EntityManager em = getEntityManager();
        try {

            Query query = session.createQuery("select p from Producto p   inner join Foto f on f.idProducto = p.codigo or f.idProductoOri = p.codigo   where f.idProducto.codigo = p.codigo order by p.codigo desc " );
//            query.setParameter("id",id);

            //query.setParameter("nombre", apellido+"%");
            lista = (List<Producto>) query.getResultList();
            for (Producto producto : lista) {
                lista1.add(producto.getProductoJsonComplete());
            }

        } finally {
            session.close();
        }return lista1;
    }
    public ProductoJson getProductoConFotoJson(String id) {
        Producto lista = null;
        ProductoJson productoJson = null;
        final Session session = getHibernateSession();

//        EntityManager em = getEntityManager();
        try {

            try {
                Query query = session.createQuery("select p from Producto p  inner join Foto f on f.idProducto = p.codigo or f.idProductoOri = p.codigo  inner join p.ubicacionList ub where  p.codigo = :id group by p order by p.codigo, ub.ubicacionNow asc  " );
                query.setParameter("id",id);

                //query.setParameter("nombre", apellido+"%");
                lista = (Producto) query.getSingleResult();
                System.out.println("\n\n\nLa cantidad es:"+lista.getUbicacionList().size());
                productoJson = lista.getProductoJsonComplete();
            }catch (Exception e){
                e.printStackTrace();
                Query query = session.createQuery("select p from Producto p  inner join Foto f on f.idProducto = p.codigo or f.idProductoOri = p.codigo  where  p.codigo = :id group by p order by p.codigo desc  " );
                query.setParameter("id",id);

                //query.setParameter("nombre", apellido+"%");
                lista = (Producto) query.getSingleResult();
                productoJson = lista.getProductoJsonComplete();
            }



        } finally {
            session.close();
        }return productoJson;
    }

    public long cantProducto(String tipo){
        long lista = -1;
        final Session session = getHibernateSession();

//        EntityManager em = getEntityManager();
        try {

            Query query = session.createQuery("select count (p) from Producto p   " );


            //query.setParameter("nombre", apellido+"%");
            lista = (long) query.getSingleResult();

        } finally {
            session.close();
        }return lista;
    }


    public List<Producto> listProductoConFotoOri() {
        List<Producto> lista = null;
        final Session session = getHibernateSession();

//        EntityManager em = getEntityManager();
        try {

            Query query = session.createQuery("select p from Producto p  inner join p.fotoOriginal f where f.idProductoOri.id  = p.id order by p.id desc " );
//            query.setParameter("id",id);

            //query.setParameter("nombre", apellido+"%");
            lista = query.getResultList();

        } finally {
            session.close();
        }return lista;
    }

}
