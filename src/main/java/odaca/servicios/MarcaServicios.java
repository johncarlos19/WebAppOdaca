package odaca.servicios;

import odaca.entidades.Marca;

public class MarcaServicios  extends GestionadDB<Marca>{
    private static MarcaServicios instancia;



    public static MarcaServicios getInstancia(){
        if(instancia==null){
            instancia = new MarcaServicios();
        }
        return instancia;
    }
    public MarcaServicios() {
        super(Marca.class);
    }

}