package odaca;


import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;
import io.javalin.plugin.rendering.JavalinRenderer;
import io.javalin.plugin.rendering.template.JavalinThymeleaf;
import io.javalin.core.util.RouteOverviewPlugin;
import io.javalin.plugin.openapi.*;
import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.swagger.v3.oas.models.info.Info;
import odaca.controlador.ApiControlador;
import odaca.controlador.RecibirDatosControlador;
import odaca.entidades.Odaca;
import odaca.entidades.Usuario;
import odaca.servicios.DataBaseControlador;
import odaca.servicios.UsuarioServicios;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class Main {
    private static String modoConexion = "";
    public static void main(String[]args) throws SQLException, UnsupportedEncodingException {
        String mensaje1 = "Software ORM - JPA";
        System.out.println(mensaje1);
        if(args.length >= 1){
            modoConexion = args[0];
            System.out.println("Modo de Operacion: "+modoConexion);
        }
        if(modoConexion.isEmpty()) {
            DataBaseControlador.startDb();
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            DataBaseControlador.stopDb();
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            DataBaseControlador.startDb();
        }

//        CarroCompraServicios carroCompraServicios = new CarroCompraServicios();
        //DataBaseControlador.crearTablas();

        //System.out.println(new ProductoServicios().getIdentityMax());

        //Mercado.getInstance().agregar_Producto("Pan", BigDecimal.valueOf(500));
        //Mercado.getInstance().agregar_Producto("Ajo", BigDecimal.valueOf(20));
        //Mercado.getInstance().agregar_Producto("Queso", BigDecimal.valueOf(1000));
        //Mercado.getInstance().agregar_Producto("Molondron", BigDecimal.valueOf(2000));
        // Mercado.getInstance().getUsuario().add(new Usuario("admin","admin","admin"));
        //System.out.println(Mercado.getInstance().getUsuario().get(0).getNombre());
        String mensaje = "Hola Mundo en Javalin :-D";
        System.out.println(mensaje);
        Odaca.getInstance().loadDataBase();

        Javalin app = null;


        app = Javalin.create(config ->{
            config.addStaticFiles("/public"); //desde la carpeta de resources
            config.registerPlugin(new RouteOverviewPlugin("/rutas")); //aplicando plugins de las rutas
            config.enableCorsForAllOrigins();
            config.registerPlugin(new OpenApiPlugin(getOpenApiOptions()));
        }).start(getHerokuAssignedPort());
        registrandoPlantillas();
        RecibirDatosControlador recibirDatosControlador = new RecibirDatosControlador(app);
        recibirDatosControlador.aplicarRutas();

        ApiControlador apiControlador = new ApiControlador(app);
        apiControlador.aplicarRutas();

    }

    private static void registrandoPlantillas(){
        //registrando los sistemas de plantilla.
        //JavalinRenderer.register(JavalinFreemarker.INSTANCE, ".ftl");
        JavalinRenderer.register(JavalinThymeleaf.INSTANCE, ".html");

        // JavalinRenderer.register(JavalinVelocity.INSTANCE, ".vm");
    }
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 7000; //Retorna el puerto por defecto en caso de no estar en Heroku.
    }
    private static OpenApiOptions getOpenApiOptions() {
        Info applicationInfo = new Info()
                .version("2.0")
                .description("My Application");
        return new OpenApiOptions(applicationInfo).path("/openapi").swagger(new SwaggerOptions("/openapi-ui"));
    }
}
