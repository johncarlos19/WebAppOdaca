package odaca.servicios;

import odaca.entidades.Modelo;
import odaca.entidades.Producto;
import odaca.jsonObject.ModeloJson;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ModeloServicios   extends GestionadDB<Modelo>{
    private static ModeloServicios instancia;



    public static ModeloServicios getInstancia(){
        if(instancia==null){
            instancia = new ModeloServicios();
        }
        return instancia;
    }
    public ModeloServicios() {
        super(Modelo.class);
    }

    public List<ModeloJson> ModeloJsonList() {
        List<Modelo> lista = null;
        List<ModeloJson> lista1 = new ArrayList<ModeloJson>();
        final Session session = getHibernateSession();

//        EntityManager em = getEntityManager();
        try {


                Query query = session.createQuery("select m from Modelo m order by m.modelo asc " );

                //query.setParameter("nombre", apellido+"%");
                lista =  (List<Modelo>) query.getResultList();
            for (Modelo modelo : lista) {
                lista1.add(modelo.getModeloJson());
            }




        } finally {
            session.close();
        }return lista1;
    }

}