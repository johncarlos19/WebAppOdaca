package odaca.servicios;

import odaca.entidades.Usuario;
import org.hibernate.Session;

import javax.persistence.Query;

public class UsuarioServicios extends GestionadDB<Usuario> {
    private static UsuarioServicios instancia;



    public static UsuarioServicios getInstancia(){
        if(instancia==null){
            instancia = new UsuarioServicios();
        }
        return instancia;
    }
    public UsuarioServicios() {
        super(Usuario.class);
    }

    public Usuario crearUsuario(Usuario user) {
        boolean subio = false;
/*
        Connection con = null;
        try {

            String query = "insert into USUARIO(NOMBRE, USER, PASSWORD) VALUES (?,?,?);";
            con = DataBaseServices.getInstancia().getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.
            prepareStatement.setString(1, user.getNombre());
            prepareStatement.setString(2, user.getUsuario());
            prepareStatement.setString(3, user.getPassword());
            //
            int fila = prepareStatement.executeUpdate();
            subio = fila > 0 ;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServicios.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioServicios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        String id = user.getUsuario();
        Usuario usuario = (Usuario) createAndReturnObjectWithUniqueId(user);
//        usuario = find(id);
//        usuario.setPoliticaList(Mercado.getInstance().getListaPolitica(user.getPerfil(), 1,usuario));
//        usuario = (Usuario) editar(usuario);
        //usuario.setUsuario(id);

        return  usuario;//editar(usuario);
    }
    public boolean existe(String us){

        final Session session = getHibernateSession();


//        EntityManager em = getEntityManager();
        try {

            Query query = session.createQuery("select count(*) from Usuario u where u.usuario = '"+us+"' " );

            //query.setParameter("nombre", apellido+"%");
            long lista = (long)query.getSingleResult() ;
            System.out.println("\n\n\ncantidad totak"+lista);
            if (lista == 0){
                return false;
            }else{
                return true;
            }


        } finally {
            session.close();

        }

    }

    public Usuario getUsuario(String us) {
        /*
        Usuario user = null;
        Connection con = null;
        try {
            //utilizando los comodines (?)...
            String query = "select * from USUARIO where USER = ?";
            con = DataBaseServices.getInstancia().getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.
            prepareStatement.setString(1, us);
            //Ejecuto...
            ResultSet rs = prepareStatement.executeQuery();
            while(rs.next()){
                user =  new Usuario(rs.getString("USER"),rs.getString("NOMBRE"),rs.getString("PASSWORD"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServicios.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioServicios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/

        return buscar(us);
    }

}
