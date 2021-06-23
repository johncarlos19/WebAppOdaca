package odaca.servicios;

import odaca.entidades.Cliente;

public class ClienteServicios  extends GestionadDB<Cliente>{
    private static ClienteServicios instancia;



    public static ClienteServicios getInstancia(){
        if(instancia==null){
            instancia = new ClienteServicios();
        }
        return instancia;
    }
    public ClienteServicios() {
        super(Cliente.class);
    }

}
