package odaca.servicios;

import odaca.entidades.Politica;

public class PoliticaServicios    extends GestionadDB<Politica>{
    private static PoliticaServicios instancia;



    public static PoliticaServicios getInstancia(){
        if(instancia==null){
            instancia = new PoliticaServicios();
        }
        return instancia;
    }
    public PoliticaServicios() {
        super(Politica.class);
    }

}
