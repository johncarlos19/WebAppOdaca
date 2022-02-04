package odaca.controlador;


import odaca.entidades.*;
import odaca.servicios.*;
import io.javalin.Javalin;
import io.jsonwebtoken.*;
import org.jasypt.util.text.AES256TextEncryptor;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.Key;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static io.javalin.apibuilder.ApiBuilder.*;

public class RecibirDatosControlador extends JavalinControlador {


    public final static String SECRET_KEY = "ghQaYY7Wo24sDqKSX3IM9ASGmdGPmkTd9jo1QTy4b7P9Ze5_9hKolVX8xNrQDcNRfVEdTZNOuOyqEGhXEbdJI-ZQ19k_o9MI0y3eZN2lp9jow55FfXMiINEdt1XR85VipRLSOkT6kSpzs2x-jbLDiz9iFVzkd81YKxMgPA7VfZeQUm4n-mOmnWMaVX30zGFU4L3oPBctYKkl4dYfqYWqRNfrgPJVi5DGFjywgxx0ASEiJHtV72paI3fDR2XwlSkyhhmY-ICjCRmsJN4fX1pdoL8a18-aQrvyu4j0Os6dVPYIoPvvY0SAZtWYKHfM15g7A3HD4cVREf9cUsprCRK93w";
    AES256TextEncryptor userEncryptor = new AES256TextEncryptor();
    AES256TextEncryptor passwordEncryptor = new AES256TextEncryptor();



    public RecibirDatosControlador(Javalin app) {
        super(app);
        userEncryptor.setPassword("admin");
        passwordEncryptor.setPassword("admin");

    }

    /**
     * Registrando los sistemas de plantillas utilizados.
     */


    @Override
    public void aplicarRutas() {

        app.before(ctx -> {






        });


//        app.get("/login", ctx -> {
//
//
//        });
//
//        app.get("/carrito_process", ctx -> {
//
//        });
//
//
//        app.get("/carrito", ctx -> {
//
//
//        });


        /**
         * Ejemplo para leer por parametros de consulta (query param)
         * http://localhost:7000/parametros?matricula=20011126&nombre=Carlos%20Camacho
         */




//        app.get("/doItChange", ctx -> {
//
//
//
//        });
//
//        app.post("/new_product", ctx -> {
//
//
//        });
//        app.get("/editar/:id", ctx -> {
//
//
//        });
//        app.get("/editar/eliminar/:id_foto/:id_producto", ctx -> {
//
//
//        });
//        app.get("/comentar", ctx -> {
//
//
//        });
//        app.get("/EliminarComentario", ctx -> {
//
//
//        });
//        app.post("/edit_now", ctx -> {
//
//
//
//        });
//        app.get("/add", ctx -> {
//
//        });
//
//
//
//        app.post("/login", ctx -> {
//
//
//        });



        app.exception(Exception.class, (exception, ctx) -> {
            ctx.status(404);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            exception.printStackTrace(pw);
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            System.out.println(formatter.format(date));
            String mensaje = "<!DOCTYPE html>\n" +
                    "<html lang='en' style='box-sizing: border-box;'>\n" +
                    "<head style='box-sizing: border-box;'>\n" +
                    "    <meta charset='utf-8' style='box-sizing: border-box;'>\n" +
                    "    <title style='box-sizing: border-box;'></title>\n" +
                    "    <meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no' style='box-sizing: border-box;'>\n" +
                    "    <meta name='description' content='' style='box-sizing: border-box;'>\n" +
                    "    <meta name='author' content='Mark Otto, Jacob Thornton, and Bootstrap contributors' style='box-sizing: border-box;'>\n" +
                    "    <meta name='generator' content='Jekyll v4.0.1' style='box-sizing: border-box;'>\n" +
                    "    <!-- Place favicon.ico in the root directory -->\n" +
                    "\n" +
                    "    <!--<link rel='stylesheet' href='bootstrap-4.5.2-dist/css/bootstrap.css1'>-->\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "    <style style='box-sizing: border-box;'>\n" +
                    "        /*! CSS Used from: Embedded */\n" +
                    "        .container{max-width:960px;}\n" +
                    "        .card-deck .card{min-width:220px;}\n" +
                    "        /*! CSS Used from: Embedded */\n" +
                    "        *,*::before,*::after{box-sizing:border-box;}\n" +
                    "        body{margin:0;font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', Arial, 'Noto Sans', sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol', 'Noto Color Emoji';font-size:1rem;font-weight:400;line-height:1.5;color:#212529;text-align:left;background-color:#fff;}\n" +
                    "        h4,h5{margin-top:0;margin-bottom:0.5rem;}\n" +
                    "        p{margin-top:0;margin-bottom:1rem;}\n" +
                    "        a{color:#007bff;text-decoration:none;background-color:transparent;}\n" +
                    "        a:hover{color:#0056b3;text-decoration:underline;}\n" +
                    "        a:not([href]):not([class]){color:inherit;text-decoration:none;}\n" +
                    "        a:not([href]):not([class]):hover{color:inherit;text-decoration:none;}\n" +
                    "        img{vertical-align:middle;border-style:none;}\n" +
                    "        h4,h5{margin-bottom:0.5rem;font-weight:500;line-height:1.2;}\n" +
                    "        h4{font-size:1.5rem;}\n" +
                    "        h5{font-size:1.25rem;}\n" +
                    "        .lead{font-size:1.25rem;font-weight:300;}\n" +
                    "        .container{width:100%;padding-right:15px;padding-left:15px;margin-right:auto;margin-left:auto;}\n" +
                    "        @media (min-width: 576px){\n" +
                    "            .container{max-width:540px;}\n" +
                    "        }\n" +
                    "        @media (min-width: 768px){\n" +
                    "            .container{max-width:720px;}\n" +
                    "        }\n" +
                    "        @media (min-width: 992px){\n" +
                    "            .container{max-width:960px;}\n" +
                    "        }\n" +
                    "        @media (min-width: 1200px){\n" +
                    "            .container{max-width:1140px;}\n" +
                    "        }\n" +
                    "        .row{display:-ms-flexbox;display:flex;-ms-flex-wrap:wrap;flex-wrap:wrap;margin-right:-15px;margin-left:-15px;}\n" +
                    "        .col-4,.col{position:relative;width:100%;padding-right:15px;padding-left:15px;}\n" +
                    "        .col{-ms-flex-preferred-size:0;flex-basis:0;-ms-flex-positive:1;flex-grow:1;max-width:100%;}\n" +
                    "        .col-4{-ms-flex:0 0 33.333333%;flex:0 0 33.333333%;max-width:33.333333%;}\n" +
                    "        .btn-danger{color:#fff;background-color:#dc3545;border-color:#dc3545;}\n" +
                    "        .btn-danger:hover{color:#fff;background-color:#c82333;border-color:#bd2130;}\n" +
                    "        .btn-danger:focus{color:#fff;background-color:#c82333;border-color:#bd2130;box-shadow:0 0 0 0.2rem rgba(225, 83, 97, 0.5);}\n" +
                    "        .btn-danger:disabled{color:#fff;background-color:#dc3545;border-color:#dc3545;}\n" +
                    "        .collapse:not(.show){display:none;}\n" +
                    "        .navbar{position:relative;display:-ms-flexbox;display:flex;-ms-flex-wrap:wrap;flex-wrap:wrap;-ms-flex-align:center;align-items:center;-ms-flex-pack:justify;justify-content:space-between;padding:0.5rem 1rem;}\n" +
                    "        .navbar-brand{display:inline-block;padding-top:0.3125rem;padding-bottom:0.3125rem;margin-right:1rem;font-size:1.25rem;line-height:inherit;white-space:nowrap;}\n" +
                    "        .navbar-brand:hover,.navbar-brand:focus{text-decoration:none;}\n" +
                    "        .navbar-collapse{-ms-flex-preferred-size:100%;flex-basis:100%;-ms-flex-positive:1;flex-grow:1;-ms-flex-align:center;align-items:center;}\n" +
                    "        @media (min-width: 768px){\n" +
                    "            .navbar-expand-md{-ms-flex-flow:row nowrap;flex-flow:row nowrap;-ms-flex-pack:start;justify-content:flex-start;}\n" +
                    "            .navbar-expand-md .navbar-collapse{display:-ms-flexbox!important;display:flex!important;-ms-flex-preferred-size:auto;flex-basis:auto;}\n" +
                    "        }\n" +
                    "        .navbar-dark .navbar-brand{color:#fff;}\n" +
                    "        .navbar-dark .navbar-brand:hover,.navbar-dark .navbar-brand:focus{color:#fff;}\n" +
                    "        .card{position:relative;display:-ms-flexbox;display:flex;-ms-flex-direction:column;flex-direction:column;min-width:0;word-wrap:break-word;background-color:#fff;background-clip:border-box;border:1px solid rgba(0, 0, 0, 0.125);border-radius:0.25rem;}\n" +
                    "        .card-body{-ms-flex:1 1 auto;flex:1 1 auto;min-height:1px;padding:1.25rem;}\n" +
                    "        .card-title{margin-bottom:0.75rem;}\n" +
                    "        .card-subtitle{margin-top:-0.375rem;margin-bottom:0;}\n" +
                    "        .card-text:last-child{margin-bottom:0;}\n" +
                    "        .card-header{padding:0.75rem 1.25rem;margin-bottom:0;background-color:rgba(0, 0, 0, 0.03);border-bottom:1px solid rgba(0, 0, 0, 0.125);}\n" +
                    "        .card-header:first-child{border-radius:calc(0.25rem - 1px) calc(0.25rem - 1px) 0 0;}\n" +
                    "        .card-deck .card{margin-bottom:15px;}\n" +
                    "        @media (min-width: 576px){\n" +
                    "            .card-deck{display:-ms-flexbox;display:flex;-ms-flex-flow:row wrap;flex-flow:row wrap;margin-right:-15px;margin-left:-15px;}\n" +
                    "            .card-deck .card{-ms-flex:1 0 0%;flex:1 0 0%;margin-right:15px;margin-bottom:0;margin-left:15px;}\n" +
                    "        }\n" +
                    "        .jumbotron{padding:2rem 1rem;margin-bottom:2rem;background-color:#e9ecef;border-radius:0.3rem;}\n" +
                    "        @media (min-width: 576px){\n" +
                    "            .jumbotron{padding:4rem 2rem;}\n" +
                    "        }\n" +
                    "        .justify-content-start{-ms-flex-pack:start!important;justify-content:flex-start!important;}\n" +
                    "        .fixed-top{position:fixed;top:0;right:0;left:0;z-index:1030;}\n" +
                    "        .shadow-sm{box-shadow:0 0.125rem 0.25rem rgba(0, 0, 0, 0.075)!important;}\n" +
                    "        .my-0{margin-top:0!important;}\n" +
                    "        .my-0{margin-bottom:0!important;}\n" +
                    "        .mb-2{margin-bottom:0.5rem!important;}\n" +
                    "        .mb-3{margin-bottom:1rem!important;}\n" +
                    "        .mb-4{margin-bottom:1.5rem!important;}\n" +
                    "        .text-left{text-align:left!important;}\n" +
                    "        .text-center{text-align:center!important;}\n" +
                    "        .font-weight-normal{font-weight:400!important;}\n" +
                    "        .text-muted{color:#6c757d!important;}\n" +
                    "        @media print{\n" +
                    "            *,*::before,*::after{text-shadow:none!important;box-shadow:none!important;}\n" +
                    "            a:not(.btn){text-decoration:underline;}\n" +
                    "            img{page-break-inside:avoid;}\n" +
                    "            p{orphans:3;widows:3;}\n" +
                    "            body{min-width:992px!important;}\n" +
                    "            .container{min-width:992px!important;}\n" +
                    "            .navbar{display:none;}\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "</head>\n" +
                    "<body style='min-height: 75rem;padding-top: 4.5rem;box-sizing: border-box;margin: 0;font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, Roboto, &quot;Helvetica Neue&quot;, Arial, &quot;Noto Sans&quot;, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Noto Color Emoji&quot;;font-size: 1rem;font-weight: 400;line-height: 1.5;color: #212529;text-align: left;background-color: #fff;'>\n" +
                    "\n" +
                    "<div class='navbar navbar-expand-md navbar-dark fixed-top ' style='background-color: #97ddee !important;box-sizing: border-box;'>\n" +
                    "  <span class='navbar-brand' style='box-sizing: border-box;'>\n" +
                    "    <img class='sp-default-logo' src='https://odaca.com.do/wp-content/uploads/2021/05/a.png' alt='CashSuite' width='160' style='box-sizing: border-box;vertical-align: middle;border-style: none;'>\n" +
                    "  </span>\n" +
                    "\n" +
                    "    <div class='collapse navbar-collapse' id='navbarCollapse' style='box-sizing: border-box;'>\n" +
                    "\n" +
                    "    </div>\n" +
                    "</div>\n" +
                    "<br style='box-sizing: border-box;'>\n" +
                    "<div role='main' class='container' style='box-sizing: border-box;max-width: 960px;width: 100%;padding-right: 15px;padding-left: 15px;margin-right: auto;margin-left: auto;'>\n" +
                    "\n" +
                    "\n" +
                    "    <div class='jumbotron' style='box-sizing: border-box;'>\n" +
                    "\n" +
                    "        <div class='card' style='box-sizing: border-box;'>\n" +
                    "            <div class='card-body' style='box-sizing: border-box;'>\n" +
                    "                <h4 class='card-title' style='box-sizing: border-box;margin-top: 0;margin-bottom: 0.5rem;font-weight: 500;line-height: 1.2;font-size: 1.5rem;'>Alert</h4>\n" +
                    "                <h5 class='card-subtitle mb-2 text-muted' style='box-sizing: border-box;margin-top: 0;margin-bottom: 0.5rem;font-weight: 500;line-height: 1.2;font-size: 1.25rem;'>Error en el servidor</h5>\n" +
                    "\n" +
                    "                <div class='row text-left' style='box-sizing: border-box;'>\n" +
                    "                    <div class='col-4' style='box-sizing: border-box;'>\n" +
                    "                        <h5 class='card-text' style='box-sizing: border-box;margin-top: 0;margin-bottom: 0.5rem;font-weight: 500;line-height: 1.2;font-size: 1.25rem;'>Severity: </h5>\n" +
                    "                    </div>\n" +
                    "                    <div class='col' style='box-sizing: border-box;'>\n" +
                    "                        <p class='card-text lead btn-danger' style='box-sizing: border-box;margin-top: 0;margin-bottom: 1rem;font-size: 1.25rem;font-weight: 300;'>Critical</p>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "                <div class='row text-left' style='box-sizing: border-box;'>\n" +
                    "                    <div class='col-4' style='box-sizing: border-box;'>\n" +
                    "                        <h5 class='card-text' style='box-sizing: border-box;margin-top: 0;margin-bottom: 0.5rem;font-weight: 500;line-height: 1.2;font-size: 1.25rem;'>PATH: </h5>\n" +
                    "                    </div>\n" +
                    "                    <div class='col' style='box-sizing: border-box;'>\n" +
                    "                        <p class='card-text lead' style='box-sizing: border-box;margin-top: 0;margin-bottom: 1rem;font-size: 1.25rem;font-weight: 300;'>" +
                    ctx.path()+
                    "</p>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "                <div class='row text-left' style='box-sizing: border-box;'>\n" +
                    "                    <div class='col-4' style='box-sizing: border-box;'>\n" +
                    "                        <h5 class='card-text' style='box-sizing: border-box;margin-top: 0;margin-bottom: 0.5rem;font-weight: 500;line-height: 1.2;font-size: 1.25rem;'>IP ADDRESS: </h5>\n" +
                    "                    </div>\n" +
                    "                    <div class='col' style='box-sizing: border-box;'>\n" +
                    "                        <p class='card-text lead' style='box-sizing: border-box;margin-top: 0;margin-bottom: 1rem;font-size: 1.25rem;font-weight: 300;'>" +
                    ctx.ip()+
                    "</p>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "                <div class='row text-left' style='box-sizing: border-box;'>\n" +
                    "                    <div class='col-4' style='box-sizing: border-box;'>\n" +
                    "                        <h5 class='card-text' style='box-sizing: border-box;margin-top: 0;margin-bottom: 0.5rem;font-weight: 500;line-height: 1.2;font-size: 1.25rem;'>METHOD: </h5>\n" +
                    "                    </div>\n" +
                    "                    <div class='col' style='box-sizing: border-box;'>\n" +
                    "                        <p class='card-text lead' style='box-sizing: border-box;margin-top: 0;margin-bottom: 1rem;font-size: 1.25rem;font-weight: 300;'>" +
                    ctx.method()+
                    "</p>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "                <div class='row text-left' style='box-sizing: border-box;'>\n" +
                    "                    <div class='col-4' style='box-sizing: border-box;'>\n" +
                    "                        <h5 class='card-text' style='box-sizing: border-box;margin-top: 0;margin-bottom: 0.5rem;font-weight: 500;line-height: 1.2;font-size: 1.25rem;'>Timestamp: </h5>\n" +
                    "                    </div>\n" +
                    "                    <div class='col' style='box-sizing: border-box;'>\n" +
                    "                        <p class='card-text lead' style='box-sizing: border-box;margin-top: 0;margin-bottom: 1rem;font-size: 1.25rem;font-weight: 300;'>" +
                    formatter.format(date).toString()+
                    "</p>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "\n" +
                    "\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "        <br style='box-sizing: border-box;'>\n" +
                    "        <div class='' style='box-sizing: border-box;'>\n" +
                    "            <div class='card-deck mb-3 text-center' style='box-sizing: border-box;'>\n" +
                    "\n" +
                    "                <div class='card mb-4 shadow-sm' style='box-sizing: border-box;min-width: 220px;'>\n" +
                    "                    <div class='card-header' style='box-sizing: border-box;'>\n" +
                    "                        <h4 class='my-0 font-weight-normal text-left' style='box-sizing: border-box;margin-top: 0;margin-bottom: 0.5rem;font-weight: 500;line-height: 1.2;font-size: 1.5rem;'>" +
                    exception.getClass().getName() +
                    "<a style='box-sizing: border-box;color: inherit;text-decoration: none;background-color: transparent;'></a></h4>\n" +
                    "                    </div>\n" +
                    "                    <div class='card-body ' style='box-sizing: border-box;'>\n" +
                    "                        <div class='justify-content-start' style='box-sizing: border-box;'>\n" +
                    "\n" +
                    "                            <div class='row text-left' style='box-sizing: border-box;'>\n" +
                    "                                <div class='col' style='box-sizing: border-box;'>\n" +
                    "                                    <p class='card-text' style='box-sizing: border-box;margin-top: 0;margin-bottom: 1rem;'>" +
                    sw.toString() +
                    "</p>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "\n" +
                    "\n" +
                    "                    </div>\n" +
                    "\n" +
                    "                </div>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "\n" +
                    "\n" +
                    "    </div>\n" +
                    "</div>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>";

//            Odaca.getInstance().send_correo_online("rm.dorville@gmail.com",mensaje,"Error Servidor CSUITE");
            Odaca.getInstance().send_correo_online("johncarlos1943.odaca@gmail.com",mensaje,"Error Servidor Catalogo Odaca");

            exception.printStackTrace();
            ctx.redirect("/error404");
        });
        app.get("/error404", ctx -> {

            ctx.render("/public/dashboard/error404.html");
        });


        app.routes(() -> {

            path("/", () -> {
                get(ctx -> {
                    Map<String, Object> contexto = new HashMap<>();
                    contexto.put("listaPaqueteProducto", "");
//                    ctx.render("/public/inicio/index.html", contexto);
                    ctx.redirect("/login");





                });
            });

            path("/logout", () -> {


                get(ctx -> {
                    String idSession = ctx.req.getSession().getId();


                    try {
                        Claims user = decodeJWT(Odaca.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
                        Odaca.getInstance().getLogins().remove(user.getId());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    ctx.removeCookie("User");
                    ctx.req.removeAttribute("User");
                    ctx.redirect("/login");

                });

            });


            path("/changePassword", () -> {


                post(ctx -> {
                    String user = ctx.formParam("id");
                    String password1 = ctx.formParam("password1");
                    String password2 = ctx.formParam("password2");
                    if (password1.equals(password2) && user!= null){
                        Usuario usuario = UsuarioServicios.getInstancia().getUsuario(user);
                        usuario.setContrasena(Odaca.getInstance().getPasswordEncryptor().encrypt(password1));
                        UsuarioServicios.getInstancia().editar(usuario);
                        switch (usuario.getPerfil()){
                            case "Oficina":
                                ctx.redirect("/dashboard/home");
                                break;
                            case "Admin":
                                ctx.redirect("/dashboard/home");
                                break;
                            case "Vendedor":
                                ctx.redirect("/catalogo");
                                break;
                        }
//                        ctx.redirect("/dashboard/home");

                    }else {
                        ctx.render("/public/dashboard/error404.html");
                    }

                });

            });

            path("/validate", () -> {


                post(ctx -> {
                    String user = ctx.formParam("user");
                    String password = ctx.formParam("password");
                    String iddevice = ctx.formParam("iddevice");
                    String codigo = ctx.formParam("codigo");
                    Dispositivo dispositivo = DispositivoServicios.getInstancia().find(iddevice);


                    if (dispositivo.getNumberValidate().equals(codigo) && user!= null){
                        dispositivo.setValidate(true);
                        DispositivoServicios.getInstancia().editar(dispositivo);
                        Usuario usuario = UsuarioServicios.getInstancia().getUsuario(user);
                        if(ctx.formParam("password").equalsIgnoreCase("admin1234")){
                            Map<String, Object> contexto2 = new HashMap<>();
                            contexto2.put("user", user);
                            contexto2.put("password", passwordEncryptor.encrypt(ctx.formParam("password")));
//                            ctx.render("/public/webPage/login_error.html",contexto2 );
                            ctx.render("/public/dashboard/restablecerpassword.html",contexto2 );
                        }else {
                            switch (usuario.getPerfil()){
                                case "Oficina":
                                    ctx.redirect("/dashboard/home");
                                    break;
                                case "Admin":
                                    ctx.redirect("/dashboard/home");
                                    break;
                                case "Vendedor":
                                    ctx.redirect("/catalogo");
                                    break;
                            }
                        }
//                        ctx.redirect("/dashboard/home");

                    }else {
                        Map<String, Object> contexto2 = new HashMap<>();
                        contexto2.put("user", user);
                        contexto2.put("iddevice", dispositivo.getIdDevice());
                        contexto2.put("texto1", "<div class='alert alert-danger alert-dismissible'>\n" +
                                "<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button>\n" +
                                "<h4><i class='icon fa fa-ban'></i> Alerta!</h4>\n" +
                                "¡ECodigo incorrecto, intentelo de nuevo!" +
                                "</div>");
                        contexto2.put("password", password);
//                            ctx.render("/public/webPage/login_error.html",contexto2 );
                        ctx.render("/public/dashboard/validate.html",contexto2 );
                    }

                });

            });



                path("/login", () -> {
                    get(ctx -> {

                        String idSession = ctx.req.getSession().getId();


                        try {
                            Claims user = decodeJWT(Odaca.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
                            Odaca.getInstance().getLogins().remove(user.getId());
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        ctx.removeCookie("User");
                        ctx.req.removeAttribute("User");
//                        ctx.redirect("/login");


                        System.out.println("\n\n"+ctx.userAgent());
                        Map<String, Object> contexto = new HashMap<>();
                        contexto.put("texto1", "");
                        contexto.put("offline", "/templates/sinconexion.appcache");

                        ctx.render("/public/dashboard/login.html", contexto);

                    });





                    post(ctx -> {







                        if (UsuarioServicios.getInstancia().existe(ctx.formParam("user"))){
                            String perfil = Odaca.getInstance().verificar_user(ctx.formParam("user"),ctx.formParam("password"));
                            if (perfil != null) {
                                if (isSessionAvailable(ctx.formParam("user"), ctx.req.getSession().getId())) {
                                    String user = ctx.formParam("user");
                                    Map<String, Object> map = null;
                                    String header = "Authorization";
                                    String dueno = user;
                                    String direccion;
                                    String compania;
                                    String telefono;
                                    String ciudadPais;
                                    if (perfil.equalsIgnoreCase("Admin") == false || perfil.equalsIgnoreCase("Oficina") == false) {

                                        map = Odaca.getInstance().getUserJefe(user);
                                        dueno = (String) map.get("user");
                                        direccion = (String) map.get("direccion");
                                        compania = (String) map.get("compania");
                                        telefono = (String) map.get("telefono");
                                        ciudadPais = (String) map.get("ciudadPais");
                                    } else {
                                        map = Odaca.getInstance().getUserJefe(user);
                                        direccion = (String) map.get("direccion");
                                        compania = (String) map.get("compania");
                                        telefono = (String) map.get("telefono");
                                        ciudadPais = (String) map.get("ciudadPais");
                                    }
                                    String jwt = createJWT(user, perfil, map);
                                    Login login = new Login(user, decodeJWT(jwt));
                                    login.setSession(ctx.req.getSession());
                                    Odaca.getInstance().getLogins().put(user,login);

                                    ctx.sessionAttribute("User", jwt);
                                    ctx.cookie("User", Odaca.getInstance().getUserEncryptor().encrypt(jwt), 2147483647);

                                    if(ctx.formParam("iddevice")!=null){
                                        Dispositivo dispositivo = DispositivoServicios.getInstancia().getDispositivoAnteDeExpirar(ctx.formParam("iddevice"),12);
                                        try {
                                            if (dispositivo.isValidate()==true){
                                                if(ctx.formParam("password").equalsIgnoreCase("admin1234")){
                                                    Map<String, Object> contexto2 = new HashMap<>();
                                                    contexto2.put("user", user);
                                                    contexto2.put("password", passwordEncryptor.encrypt(ctx.formParam("password")));
//                            ctx.render("/public/webPage/login_error.html",contexto2 );
                                                    ctx.render("/public/dashboard/restablecerpassword.html",contexto2 );
                                                }else {
                                                    switch (perfil){
                                                        case "Oficina":
                                                            ctx.redirect("/dashboard/home");
                                                            break;
                                                        case "Admin":
                                                            ctx.redirect("/dashboard/home");
                                                            break;
                                                        case "Vendedor":
                                                            ctx.redirect("/catalogo");
                                                            break;
                                                    }
                                                }
                                            }else {
                                                dispositivo.setNumberValidate(Odaca.getInstance().getRandomNumberString());
                                                String mensaje = "<!DOCTYPE html>\n" +
                                                        "<html lang='en'>\n" +
                                                        "<head>\n" +
                                                        "    <meta charset='UTF-8'>\n" +
                                                        "    <title>Validation</title>\n" +
                                                        "</head>\n" +
                                                        "<body>\n" +
                                                        "<div>\n" +
                                                        "    <p>Un dispositivo (id='<span>"+dispositivo.getIdDevice()+"</span>') intenta acceder con el usuario: <span>"+dispositivo.getUsuario()+"</span></p>\n" +
                                                        "    <p>El userAgent es: <span>"+dispositivo.getUseragent()+"</span></p>\n" +
                                                        "    <p>Su codigo de validación es: <span>"+dispositivo.getNumberValidate()+"</span></p>\n" +
                                                        "</div>\n" +
                                                        "\n" +
                                                        "</body>\n" +
                                                        "</html>";
                                                switch (perfil){
                                                    case "Oficina":
                                                        Odaca.getInstance().send_correo_online("johncarlos1943.odaca@gmail.com",mensaje,"CODE VALIDATE");
                                                        Odaca.getInstance().send_correo_online("ventas@odaca.com.do",mensaje,"CODE VALIDATE");
                                                        break;
                                                    case "Admin":
                                                        Odaca.getInstance().send_correo_online("johncarlos1943.odaca@gmail.com",mensaje,"CODE VALIDATE");

                                                        break;
                                                    case "Vendedor":
                                                        Odaca.getInstance().send_correo_online("johncarlos1943.odaca@gmail.com",mensaje,"CODE VALIDATE");
                                                        Odaca.getInstance().send_correo_online("ventas@odaca.com.do",mensaje,"CODE VALIDATE");
                                                        break;
                                                }

                                                DispositivoServicios.getInstancia().editar(dispositivo);
                                                Map<String, Object> contexto2 = new HashMap<>();
                                                contexto2.put("user", ctx.formParam("user"));
                                                contexto2.put("iddevice", dispositivo.getIdDevice());
                                                contexto2.put("texto1", "");
                                                contexto2.put("password", ctx.formParam("password"));
//                            ctx.render("/public/webPage/login_error.html",contexto2 );
                                                ctx.render("/public/dashboard/validate.html",contexto2 );
                                            }
                                        }catch (NullPointerException e){
                                            System.out.println("\nNo existe en el servidor");
                                            e.printStackTrace();

                                            Dispositivo dispositivo1 = new Dispositivo();
                                            dispositivo1.setIdDevice(ctx.formParam("iddevice"));
                                            System.out.println("\n\nEl id es"+dispositivo1.getIdDevice());
                                            dispositivo1.setUsuario(ctx.formParam("user"));
                                            dispositivo1.setNumberValidate(Odaca.getInstance().getRandomNumberString());
                                            dispositivo1.setUseragent(ctx.userAgent());
                                            Calendar calendar = Calendar.getInstance();
                                            calendar.add(calendar.MONTH,12);
                                            Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
                                            dispositivo1.setFechaExpiracion(timestamp);
                                            DispositivoServicios.getInstancia().createAndReturnObjectWithUniqueId(dispositivo1);

                                            String mensaje = "<!DOCTYPE html>\n" +
                                                    "<html lang='en'>\n" +
                                                    "<head>\n" +
                                                    "    <meta charset='UTF-8'>\n" +
                                                    "    <title>Validation</title>\n" +
                                                    "</head>\n" +
                                                    "<body>\n" +
                                                    "<div>\n" +
                                                    "    <p>Un dispositivo (id='<span>"+dispositivo1.getIdDevice()+"</span>') intenta acceder con el usuario: <span>"+dispositivo1.getUsuario()+"</span></p>\n" +
                                                    "    <p>El userAgent es: <span>"+dispositivo1.getUseragent()+"</span></p>\n" +
                                                    "    <p>Su codigo de validación es: <span>"+dispositivo1.getNumberValidate()+"</span></p>\n" +
                                                    "</div>\n" +
                                                    "\n" +
                                                    "</body>\n" +
                                                    "</html>";
                                            switch (perfil){
                                                case "Oficina":
                                                    Odaca.getInstance().send_correo_online("johncarlos1943.odaca@gmail.com",mensaje,"CODE VALIDATE");
                                                    Odaca.getInstance().send_correo_online("ventas@odaca.com.do",mensaje,"CODE VALIDATE");
                                                    break;
                                                case "Admin":
                                                    Odaca.getInstance().send_correo_online("johncarlos1943.odaca@gmail.com",mensaje,"CODE VALIDATE");

                                                    break;
                                                case "Vendedor":
                                                    Odaca.getInstance().send_correo_online("johncarlos1943.odaca@gmail.com",mensaje,"CODE VALIDATE");
                                                    Odaca.getInstance().send_correo_online("ventas@odaca.com.do",mensaje,"CODE VALIDATE");
                                                    break;
                                            }
                                            Map<String, Object> contexto2 = new HashMap<>();
                                            contexto2.put("user", ctx.formParam("user"));
                                            contexto2.put("iddevice", dispositivo1.getIdDevice());
                                            contexto2.put("texto1", "");
                                            contexto2.put("password", ctx.formParam("password"));
//                            ctx.render("/public/webPage/login_error.html",contexto2 );
                                            ctx.render("/public/dashboard/validate.html",contexto2 );

                                        }
                                    }else {
                                        Dispositivo dispositivo = new Dispositivo();
                                        dispositivo.setIdDevice(Odaca.getInstance().generateID());
                                        System.out.println("\n\nEl id es"+dispositivo.getIdDevice());
                                        dispositivo.setUsuario(ctx.formParam("user"));
                                        dispositivo.setNumberValidate(Odaca.getInstance().getRandomNumberString());
                                        dispositivo.setUseragent(ctx.userAgent());
                                        Calendar calendar = Calendar.getInstance();
                                        calendar.add(calendar.MONTH,12);
                                        Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
                                        dispositivo.setFechaExpiracion(timestamp);
                                        DispositivoServicios.getInstancia().createAndReturnObjectWithUniqueId(dispositivo);

                                        String mensaje = "<!DOCTYPE html>\n" +
                                                "<html lang='en'>\n" +
                                                "<head>\n" +
                                                "    <meta charset='UTF-8'>\n" +
                                                "    <title>Validation</title>\n" +
                                                "</head>\n" +
                                                "<body>\n" +
                                                "<div>\n" +
                                                "    <p>Un dispositivo (id='<span>"+dispositivo.getIdDevice()+"</span>') intenta acceder con el usuario: <span>"+dispositivo.getUsuario()+"</span></p>\n" +
                                                "    <p>El userAgent es: <span>"+dispositivo.getUseragent()+"</span></p>\n" +
                                                "    <p>Su codigo de validación es: <span>"+dispositivo.getNumberValidate()+"</span></p>\n" +
                                                "</div>\n" +
                                                "\n" +
                                                "</body>\n" +
                                                "</html>";
                                        switch (perfil){
                                            case "Oficina":
                                                Odaca.getInstance().send_correo_online("johncarlos1943.odaca@gmail.com",mensaje,"CODE VALIDATE");
                                                Odaca.getInstance().send_correo_online("ventas@odaca.com.do",mensaje,"CODE VALIDATE");
                                                break;
                                            case "Admin":
                                                Odaca.getInstance().send_correo_online("johncarlos1943.odaca@gmail.com",mensaje,"CODE VALIDATE");

                                                break;
                                            case "Vendedor":
                                                Odaca.getInstance().send_correo_online("johncarlos1943.odaca@gmail.com",mensaje,"CODE VALIDATE");
                                                Odaca.getInstance().send_correo_online("ventas@odaca.com.do",mensaje,"CODE VALIDATE");
                                                break;
                                        }
                                        Map<String, Object> contexto2 = new HashMap<>();
                                        contexto2.put("user", ctx.formParam("user"));
                                        contexto2.put("iddevice", dispositivo.getIdDevice());
                                        contexto2.put("texto1", "");
                                        contexto2.put("password", ctx.formParam("password"));
//                            ctx.render("/public/webPage/login_error.html",contexto2 );
                                        ctx.render("/public/dashboard/validate.html",contexto2 );

                                    }




                                } else {
                                    Map<String, Object> contexto1 = new HashMap<>();
                                    contexto1.put("texto1", "<div class='alert alert-danger alert-dismissible'>\n" +
                                            "<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button>\n" +
                                            "<h4><i class='icon fa fa-ban'></i> Alerta!</h4>\n" +
                                            "¡Esta cuenta ha iniciado sesión, debe salir de la sesión para poder entrar!" +
                                            "</div>");
//                                    ctx.render("/public/webPage/login_error.html", contexto1);
                                    ctx.render("/public/dashboard/login.html",contexto1 );
                                }
                            }else{
                                Map<String, Object> contexto2 = new HashMap<>();
                                contexto2.put("texto1", "<div class='alert alert-danger alert-dismissible'>\n" +
                                        "<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button>\n" +
                                        "<h4><i class='icon fa fa-ban'></i> Alerta!</h4>\n" +
                                        "¡Usuario o contraseña no coinciden!" +
                                        "</div>");
//                                    ctx.render("/public/webPage/login_error.html", contexto1);
                                ctx.render("/public/dashboard/login.html",contexto2 );
//                            ctx.render("/public/webPage/login_error.html",contexto2 );
                            }


                        }else{
                            Map<String, Object> contexto2 = new HashMap<>();
                            contexto2.put("texto1", "<div class='alert alert-danger alert-dismissible'>\n" +
                                    "<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button>\n" +
                                    "<h4><i class='icon fa fa-ban'></i> Alerta!</h4>\n" +
                                    "¡Usuario o contraseña no coinciden!" +
                                    "</div>");
//                                    ctx.render("/public/webPage/login_error.html", contexto1);
                            ctx.render("/public/dashboard/login.html",contexto2 );
                        }


                    });
            });

                });



        path("/dashboard", () -> {





            app.routes(() -> {
                before(ctx -> {


                    System.out.println("\n\n\n\n"+ctx.req.getPathInfo());

                    String headerAuth = ctx.req.getHeader("Authorization");
                    System.out.println(headerAuth);
                    String user = ctx.cookie("User");
                    String session = ctx.sessionAttribute("User");
                    System.out.println("este es el add:"+ctx.path());

//                    if (ctx.path().contains("/dashboardPlantilla/")==true  || ctx.path().contains("/webPage")==true ||ctx.path().contains("/js")==true ||ctx.path().contains("/bd")==true || ctx.path().contains("/assets")==true ){


                            if (ctx.path().contains("/home")==true  || ctx.path().contains("/inventoryShow")==true
                                    || ctx.path().contains("/inventory")==true
                                    || ctx.path().contains("/inventoryEdit")==true
                                    || ctx.path().contains("/inventoryCreate")==true
                                    || ctx.path().contains("/modelo")==true
                                    || ctx.path().contains("/modeloCreate")==true
                                    || ctx.path().contains("/marca")==true
                                    || ctx.path().contains("/marcaCreate")==true
                                    || ctx.path().contains("/addubicacion")==true
                                    || ctx.path().contains("/productoAction")==true
                                    || ctx.path().contains("/productoActionAdd")==true
                                    || ctx.path().contains("/user")==true
                                    || ctx.path().contains("/userCreate")==true
                                    || ctx.path().contains("/deviceShow")==true
                            ){
                                if (user==null || session == null){

                                    System.out.println(Odaca.getInstance().getUserEncryptor().decrypt(user));
                                    ctx.redirect("/login");

                                }else{
                                    System.out.println("\n\n\n\nverifico");

                                    if(Odaca.getInstance().getUserEncryptor().decrypt(user).equalsIgnoreCase(session)){
                                        try {
                                            if(isExpirate(decodeJWT(session))==false){



                                                Claims claims = decodeJWT(session);

                                                if (claims.getAudience().equalsIgnoreCase("Admin") || claims.getAudience().equalsIgnoreCase("Oficina")) {

                                                    String header = "Authorization";
                                                    String use = claims.getId();
                                                    Map<String, Object> map = new HashMap<String, Object>();
                                                    map.put("user",claims.get("user"));
                                                    map.put("direccion",claims.get("direccion"));
                                                    map.put("telefono",claims.get("telefono"));
                                                    map.put("compania",claims.get("compania"));
                                                    map.put("ciudadPais",claims.get("ciudadPais"));
                                                    map.put("nombreCompleto",claims.get("nombreCompleto"));

                                                    String jwt = createJWT(use,claims.getAudience(), map);
                                                    ctx.header(header,jwt);
                                                    ctx.sessionAttribute("User",jwt);
                                                    ctx.cookie("User",Odaca.getInstance().getUserEncryptor().encrypt(jwt),2147483647);
                                                    String mensaje = String.format("Manejador before aplicando a todas las llamadas: %s, Contexto: %s, Metodo: %s",
                                                            ctx.req.getRemoteHost(),
                                                            ctx.req.getServletPath(),
                                                            ctx.req.getMethod());
                                                    //
                                                    System.out.println(mensaje);
                                                    Odaca.getInstance().getLogins().get(use).setJwt(claims);
                                                    Odaca.getInstance().getLogins().get(use).setSession(ctx.req.getSession());
                                                }else {
                                                    ctx.redirect("/logout");
                                                }







                                            }else{

                                                ctx.redirect("/logout");
                                            }

                                        }catch (ExpiredJwtException e){

                                            ctx.redirect("/logout");
                                        }catch (NullPointerException e){

                                            ctx.redirect("/login");
                                        }
                                    }else{

                                        ctx.redirect("/login");
                                    }


                                }

                            }else{
                                System.out.println("entro");

                            }

                });




                path("/home", () -> {

                    get(ctx -> {


//
                        Claims user = decodeJWT(Odaca.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario"+user);
//                        System.out.println("\n\n\nusuario12"+user.getId());
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
//                        if(ctx.cookie("print")==null){
//                            ctx.cookie("print","thermal80",2147483647);
//                        }
                        Map<String, Object> contexto = new HashMap<>();
//                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
//                             ) {
//                            contexto.put(politica.getKey(), politica.getValue());
//                        }
                        contexto.put("user", user.getId());
//                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
//                        contexto.put("listaProducto", ProductoServicios.getInstancia().listaProducto(1,Mercado.getInstance().getUserJefeWithToken(user)));
//                        contexto.put("categoria", CategoriaServicios.getInstancia().cantidadCategoria(Mercado.getInstance().getUserJefeWithToken(user)));
//                        contexto.put("producto", ProductoServicios.getInstancia().cantidadProductos(Mercado.getInstance().getUserJefeWithToken(user)));
//                        contexto.put("cliente", ClienteServicios.getInstancia().cantidadCliente(Mercado.getInstance().getUserJefeWithToken(user)));
//
//                        contexto.put("ventas", NumberFormat.getCurrencyInstance(new Locale("en", "US"))
//                                .format(FacturaClienteServicios.getInstancia().ventasRealizadaEnMenos30Dias(Mercado.getInstance().getUserJefeWithToken(user))));

                        ctx.render("/public/dashboard/dashboard.html", contexto);
//
//
//
//
                    });

                });


                path("/inventory", () -> {

                    get(ctx -> {
                        Claims user = decodeJWT(Odaca.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
                        Map<String, Object> contexto = new HashMap<>();
                        contexto.put("listaProducto", ProductoServicios.getInstancia().listProductoConFotoResize());


                        contexto.put("user", user.getId());
//                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
//                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
//                        ) {
//                            contexto.put(politica.getKey(), politica.getValue());
//                        }
//                        contexto.put("categoria", CategoriaServicios.getInstancia().ListaCategoria(Mercado.getInstance().getUserJefeWithToken(user)));
                        ctx.render("/public/dashboard/listaProducto.html",contexto);




                    });
                });
                path("/user", () -> {

                    get(ctx -> {
                        Claims user = decodeJWT(Odaca.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
                        Map<String, Object> contexto = new HashMap<>();
                        contexto.put("listaUsuario", UsuarioServicios.getInstancia().listUsuarioNotAdmin());


                        contexto.put("user", user.getId());
//                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
//                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
//                        ) {
//                            contexto.put(politica.getKey(), politica.getValue());
//                        }
//                        contexto.put("categoria", CategoriaServicios.getInstancia().ListaCategoria(Mercado.getInstance().getUserJefeWithToken(user)));
                        ctx.render("/public/dashboard/listaUsuario.html",contexto);




                    });
                });

                path("/deviceShow", () -> {

                    post(ctx -> {
                        Claims user = decodeJWT(Odaca.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
                        switch (ctx.formParam("action")){
                            case "show":
                                Map<String, Object> contexto = new HashMap<>();
                                contexto.put("listaDispositivo", DispositivoServicios.getInstancia().listDispUser(ctx.formParam("user")));


                                contexto.put("user", user.getId());

                                ctx.render("/public/dashboard/deviceShow.html",contexto);
                                break;
                            case "delete":
                                DispositivoServicios.getInstancia().eliminar(ctx.formParam("id"));
                                ctx.redirect("/dashboard/user");
                                break;
                            default:
                                break;
                        }





                    });
                });


                path("/inventoryShow", () -> {

                    get(ctx -> {


                        Claims user = decodeJWT(Odaca.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
                        String id = ctx.queryParam("id");
                        System.out.println("el id es"+id);
                        if (id!=null){
                            Producto producto = ProductoServicios.getInstancia().getProductoConFoto(id);
                            System.out.println("");
                            Map<String, Object> contexto = new HashMap<>();
                            contexto.put("producto", producto);
                        contexto.put("user", user.getId());
//                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
//                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
//                        ) {
//                            contexto.put(politica.getKey(), politica.getValue());
//                        }
//                        contexto.put("categoria", CategoriaServicios.getInstancia().ListaCategoria(Mercado.getInstance().getUserJefeWithToken(user)));
                            ctx.render("/public/dashboard/inventaryshow.html",contexto);
                        }





                    });
                    post(ctx -> {



                    });
                });



                path("/inventoryEdit", () -> {

                    get(ctx -> {


                        Claims user = decodeJWT(Odaca.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
                        String id = ctx.queryParam("id");
                        System.out.println("el id es"+id);
                        if (id!=null){
                            Producto producto = ProductoServicios.getInstancia().getProductoConFoto(id);
                            producto.setMarcas(MarcaServicios.getInstancia().ListadoCompleto());
                            producto.setModelos(ModeloServicios.getInstancia().ListadoCompleto());
                            Map<String, Object> contexto = new HashMap<>();
                            contexto.put("producto", producto);
                        contexto.put("user", user.getId());
//                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
//                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
//                        ) {
//                            contexto.put(politica.getKey(), politica.getValue());
//                        }
//                        contexto.put("categoria", CategoriaServicios.getInstancia().ListaCategoria(Mercado.getInstance().getUserJefeWithToken(user)));
                            ctx.render("/public/dashboard/inventoryEdit.html",contexto);
                        }





                    });
                    post(ctx -> {

                        String codigo = ctx.formParam("codigo");
                        String referencia = ctx.formParam("referencia");
                        String descripcion = ctx.formParam("descripcion");
                        String marcaSelect = ctx.formParam("marcaSelect") ;
                        String photoResize = ctx.formParam("photoResize");
                        String photoOri = ctx.formParam("photoOri");
                        String namePhoto = ctx.formParam("namePhoto");
                        String mimetype = ctx.formParam("mimetype");
                        boolean disponible = false;
                        if (ctx.formParam("disponible")!=null){
                            disponible = true;
                        }
                        List<Modelo> modeloSelect = new ArrayList<Modelo>();
//                        "modeloSelect"

                        if (codigo==null || codigo.equalsIgnoreCase("")){

                        }else {

                            Producto producto = new Producto();

                            if (mimetype.equalsIgnoreCase("no") || namePhoto.equalsIgnoreCase("no") || photoResize.equalsIgnoreCase("no")){

                                producto =  ProductoServicios.getInstancia().getProductoSinFoto(codigo);
                                producto.setReferencia(referencia);
                                producto.setNombre(descripcion);
                                producto.setMarca(marcaSelect);
                                producto.setDisponible(disponible);

                                for (String s : ctx.formParams("modeloSelect")) {
                                    long idModel = Long.parseLong(s);
                                    modeloSelect.add(ModeloServicios.getInstancia().find(idModel));
                                }

                                List<Long> list = producto.verifyAddNewModel(modeloSelect);
                                producto = (Producto) ProductoServicios.getInstancia().editar(producto);
                                for (Long aLong : list) {
                                    ProductoModeloServicios.getInstancia().borrarProductoModelo((long)aLong);
                                }


                            }else{
                                producto =  ProductoServicios.getInstancia().getProductoConFoto(codigo);
                                producto.setReferencia(referencia);
                                producto.setNombre(descripcion);
                                producto.setMarca(marcaSelect);
                                producto.setDisponible(disponible);


                                for (String s : ctx.formParams("modeloSelect")) {
                                    long idModel = Long.parseLong(s);
                                    modeloSelect.add(ModeloServicios.getInstancia().find(idModel));
                                }



                                producto.getFoto().setFotoBase64(photoResize);
                                producto.getFoto().setMimeType(mimetype);
                                producto.getFoto().setNombre(namePhoto);

                                producto.getFotoOriginal().setFotoBase64(photoOri);
                                producto.getFoto().setMimeType(mimetype);
                                producto.getFoto().setNombre(namePhoto);


                                List<Long> list = producto.verifyAddNewModel(modeloSelect);
                                producto = (Producto) ProductoServicios.getInstancia().editar(producto);

                                for (Long aLong : list) {
                                    ProductoModeloServicios.getInstancia().borrarProductoModelo((long)aLong);
                                }

                            }









                            ctx.redirect("/dashboard/inventory");
                        }

                        Claims user = decodeJWT(Odaca.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
////                        System.out.println("\n\n\nusuario"+user);
////                        ctx.res.addHeader("Authorization",ctx.cookie("User"));

////                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
////                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
////                        ) {
////                            contexto.put(politica.getKey(), politica.getValue());
////                        }
////                        contexto.put("categoria", CategoriaServicios.getInstancia().ListaCategoria(Mercado.getInstance().getUserJefeWithToken(user)));
//                        ctx.render("/public/dashboard/listaProducto.html",contexto);




                    });
                });

                path("/inventoryCreate", () -> {

                    get(ctx -> {
                        Claims user = decodeJWT(Odaca.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
                        Map<String, Object> contexto = new HashMap<>();
                        contexto.put("listaModelo", ModeloServicios.getInstancia().ListadoCompleto());
                        contexto.put("listaMarca", MarcaServicios.getInstancia().ListadoCompleto());
                        contexto.put("user", user.getId());
//                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
//                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
//                        ) {
//                            contexto.put(politica.getKey(), politica.getValue());
//                        }
//                        contexto.put("categoria", CategoriaServicios.getInstancia().ListaCategoria(Mercado.getInstance().getUserJefeWithToken(user)));
                        ctx.render("/public/dashboard/inventary.html",contexto);




                    });
                    post(ctx -> {

                        String codigo = ctx.formParam("codigo");
                        String referencia = ctx.formParam("referencia");
                        String descripcion = ctx.formParam("descripcion");
                        String marcaSelect = ctx.formParam("marcaSelect") ;
                        String photoResize = ctx.formParam("photoResize");
                        String photoOri = ctx.formParam("photoOri");
                        String namePhoto = ctx.formParam("namePhoto");
                        String mimetype = ctx.formParam("mimetype");
                        boolean disponible = false;
                        if (ctx.formParam("disponible")!=null){
                            disponible = true;
                        }
                        List<Modelo> modeloSelect = new ArrayList<Modelo>();
//                        "modeloSelect"

                        if (codigo==null || codigo.equalsIgnoreCase("")){

                        }else {

                            Producto producto = new Producto();
                            producto.setCodigo(codigo);
                            producto.setReferencia(referencia);
                            producto.setNombre(descripcion);
                            producto.setMarca(marcaSelect);
                            producto.setDisponible(disponible);
                            producto = (Producto) ProductoServicios.getInstancia().createAndReturnObjectWithUniqueId(producto);
                            producto =  ProductoServicios.getInstancia().find(codigo);
                            for (String s : ctx.formParams("modeloSelect")) {
                                long idModel = Long.parseLong(s);
                                producto.addModelo(ModeloServicios.getInstancia().find(idModel));
                            }

                            if (mimetype != null || namePhoto != null || photoResize != null || !mimetype.equalsIgnoreCase("") || !namePhoto.equalsIgnoreCase("") || !photoResize.equalsIgnoreCase("") ){

                                Foto foto= new Foto(namePhoto, mimetype, photoResize);
                                Foto fotoOri= new Foto(namePhoto, mimetype, photoOri);
                                foto = (Foto) FotoServicios.getInstancia().crear(foto);
                                fotoOri = (Foto) FotoServicios.getInstancia().crear(fotoOri);
                                producto.addFoto(foto);
                                producto.addFotoOri(fotoOri);
                                producto = (Producto) ProductoServicios.getInstancia().editar(producto);
                            }else{
                                Foto foto= new Foto(null,null,null);
                                Foto fotoOri= new Foto(null,null,null);
                                foto = (Foto) FotoServicios.getInstancia().crear(foto);
                                fotoOri = (Foto) FotoServicios.getInstancia().crear(fotoOri);
                                producto.addFoto(foto);
                                producto.addFotoOri(fotoOri);
                                producto = (Producto) ProductoServicios.getInstancia().editar(producto);
                            }



                            ctx.redirect("/dashboard/inventory");
                        }

////                        Claims user = decodeJWT(Mercado.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
////                        System.out.println("\n\n\nusuario"+user);
////                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
//                        Map<String, Object> contexto = new HashMap<>();
////                        contexto.put("user", user.getId());
////                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
////                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
////                        ) {
////                            contexto.put(politica.getKey(), politica.getValue());
////                        }
////                        contexto.put("categoria", CategoriaServicios.getInstancia().ListaCategoria(Mercado.getInstance().getUserJefeWithToken(user)));
//                        ctx.render("/public/dashboard/listaProducto.html",contexto);




                    });
                });

                path("/userCreate", () -> {

                    get(ctx -> {
                        Claims user = decodeJWT(Odaca.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
                        Map<String, Object> contexto = new HashMap<>();
                        contexto.put("user", user.getId());
//                        contexto.put("listaMarca", MarcaServicios.getInstancia().ListadoCompleto());
//                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
//                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
//                        ) {
//                            contexto.put(politica.getKey(), politica.getValue());
//                        }
//                        contexto.put("categoria", CategoriaServicios.getInstancia().ListaCategoria(Mercado.getInstance().getUserJefeWithToken(user)));
                        ctx.render("/public/dashboard/user.html",contexto);




                    });
                    post(ctx -> {
                        Claims user = decodeJWT(Odaca.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
                        if (UsuarioServicios.getInstancia().existe(ctx.formParam("user"))==false){
                            Usuario usuario = new Usuario(ctx.formParam("user"), ctx.formParam("name"));
                            usuario.setApellido(ctx.formParam("last"));
                            usuario.setEmail(ctx.formParam("email"));
                            usuario.setPerfil(ctx.formParam("perfil"));
                            usuario.setMunicipio(ctx.formParam("city"));
                            usuario.setDireccion(ctx.formParam("direccion"));
                            usuario.setTelefono(ctx.formParam("telefono"));
                            usuario.setNombreCompania("Importadora Odaca");
                            usuario.setDocumento(ctx.formParam("documento"));
                            Usuario aux = Odaca.getInstance().RegistrarVendedor(usuario, ctx.formParam("email"), "admin1234");


                            ctx.redirect("/dashboard/user");
                        }else {
                            ctx.render("/public/dashboard/error404.html");
                        }

//




                    });
                });




                path("/marca", () -> {

                    get(ctx -> {
                        Claims user = decodeJWT(Odaca.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
                        Map<String, Object> contexto = new HashMap<>();
                        contexto.put("user", user.getId());
                        contexto.put("listaMarca", MarcaServicios.getInstancia().ListadoCompleto());
//                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
//                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
//                        ) {
//                            contexto.put(politica.getKey(), politica.getValue());
//                        }
//                        contexto.put("categoria", CategoriaServicios.getInstancia().ListaCategoria(Mercado.getInstance().getUserJefeWithToken(user)));
                        ctx.render("/public/dashboard/marcaLista.html",contexto);




                    });
                });
                path("/productoAction", () -> {

                    get(ctx -> {
                        String action = ctx.queryParam("action");
                        if (action!= null){
                                                    Claims user = decodeJWT(Odaca.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
                            Map<String, Object> contexto = new HashMap<>();
                            contexto.put("listaProducto", ProductoActionServicios.getInstancia().listProductoConFotoResizeTipo(action));
                        contexto.put("user", user.getId());
                            contexto.put("tittle", Odaca.getInstance().tittleAction(action));
                            contexto.put("action", action);
                            contexto.put("nuevo", ProductoActionServicios.getInstancia().cantProductoAction("nuevo"));
                            contexto.put("destacado", ProductoActionServicios.getInstancia().cantProductoAction("destacado"));
                            contexto.put("oferta", ProductoActionServicios.getInstancia().cantProductoAction("oferta"));
                            contexto.put("vendpop", ProductoActionServicios.getInstancia().cantProductoAction("vendpop"));
//                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
//                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
//                        ) {
//                            contexto.put(politica.getKey(), politica.getValue());
//                        }
//                        contexto.put("categoria", CategoriaServicios.getInstancia().ListaCategoria(Mercado.getInstance().getUserJefeWithToken(user)));
                            ctx.render("/public/dashboard/productoAction.html",contexto);
                        }





                    });
                });
                path("/productoActionAdd", () -> {

                    get(ctx -> {
                        String action = ctx.queryParam("action");
                        if (action!= null){
                                                    Claims user = decodeJWT(Odaca.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));

                            long cant = ProductoActionServicios.getInstancia().cantProductoAction(action);
                            long cant1 = ProductoServicios.getInstancia().cantProducto("");
                            Map<String, Object> contexto = new HashMap<>();
                            if (cant ==0){

                                contexto.put("listaProducto", ProductoActionServicios.getInstancia().listProductoConFotoResizeTipoAvailable(action,2));
                            }else if(cant == cant1){
                                contexto.put("listaProducto", new ArrayList<Producto>());

                            }else {
                                contexto.put("listaProducto", ProductoActionServicios.getInstancia().listProductoConFotoResizeTipoAvailable(action,1));

                            }
                        contexto.put("user", user.getId());
                            contexto.put("tittle", Odaca.getInstance().tittleAction(action));
                            contexto.put("action", action);
//                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
//                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
//                        ) {
//                            contexto.put(politica.getKey(), politica.getValue());
//                        }
//                        contexto.put("categoria", CategoriaServicios.getInstancia().ListaCategoria(Mercado.getInstance().getUserJefeWithToken(user)));
                            ctx.render("/public/dashboard/addproductoaction.html",contexto);
                        }





                    });
                    post(ctx -> {
                        String action = ctx.formParam("action");
                        String process = ctx.formParam("process");
                        String codigo = ctx.formParam("codigo");
                        String id = ctx.formParam("id");

                        switch (process){
                            case "add":
                                if (action!= null){

                                    ProductoAction productoAction = new ProductoAction();
                                    productoAction.setCodigoProducto(id);
                                    productoAction.setTipo(action);

                                    ProductoActionServicios.getInstancia().crear(productoAction);

                                    ctx.redirect("/dashboard/productoAction?action="+action);
                                }
                                break;
                            case "delete":
                                if (action!= null){
                                    ProductoActionServicios.getInstancia().borrarProductoActiono(codigo,action);


                                    ctx.redirect("/dashboard/productoAction?action="+action);
                                }
                                break;
                            default:
                                break;
                        }






                    });
                });
                path("/addubicacion", () -> {

                    get(ctx -> {
                        String codigo = ctx.queryParam("codigo");
                        String href = ctx.queryParam("href");
                        Claims user = decodeJWT(Odaca.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
                        Map<String, Object> contexto = new HashMap<>();
                        contexto.put("user", user.getId());
                        contexto.put("codigo", codigo);
                        contexto.put("href", href);
//                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
//                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
//                        ) {
//                            contexto.put(politica.getKey(), politica.getValue());
//                        }
//                        contexto.put("categoria", CategoriaServicios.getInstancia().ListaCategoria(Mercado.getInstance().getUserJefeWithToken(user)));
                        ctx.render("/public/dashboard/ubicacionRegister.html",contexto);




                    });

                    post(ctx -> {

                        String action = ctx.formParam("action");

                        switch (action){
                            case "add":

                                String fila = ctx.formParam("fila");
                                String columna = ctx.formParam("columna");
                                String rack = ctx.formParam("rack");
                                String nave = ctx.formParam("nave");
                                String codigo = ctx.formParam("codigo");
                                Ubicacion ubicacion = new Ubicacion(nave,Integer.parseInt(rack),columna,Integer.parseInt(fila));
                                if (ctx.formParam("disponible")!= null){
                                    ubicacion.setDisponible(true);
                                }

                                ubicacion = (Ubicacion) UbicacionServicios.getInstancia().crear(ubicacion);
                                Producto producto = ProductoServicios.getInstancia().getProductoSinFoto(codigo);
                                producto.addUbicacion(ubicacion);
                                if (ctx.formParam("ubiprincipal")!= null){
                                    producto.setUbicacionPrincipal(ubicacion.getUbicacionNow());
                                }
                                ProductoServicios.getInstancia().editar(producto);
                                ctx.redirect(ctx.formParam("href")+codigo);
                                break;
                            case "selectUbi":
                                String codigo1 = ctx.formParam("codigo");
                                String ubication = ctx.formParam("ubication");
                                UbicacionServicios.getInstancia().updateUbiPrincipal(codigo1,ubication);

                                ctx.redirect("/dashboard/inventoryEdit?id="+codigo1);

                                break;

                            case "disponible":
                                String codigo2 = ctx.formParam("codigo");
                                String id = ctx.formParam("id");
                                boolean disponible = false;
                                if(ctx.formParam("disponible").equalsIgnoreCase("true")){
                                    disponible = true;
                                }
                                UbicacionServicios.getInstancia().updateDisponible(disponible,Integer.parseInt(id));

                                ctx.redirect("/dashboard/inventoryEdit?id="+codigo2);

                                break;
                            default:
                                break;
                        }





////                        Claims user = decodeJWT(Mercado.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
////                        System.out.println("\n\n\nusuario"+user);
////                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
//                        Map<String, Object> contexto = new HashMap<>();
////                        contexto.put("user", user.getId());
////                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
////                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
////                        ) {
////                            contexto.put(politica.getKey(), politica.getValue());
////                        }
////                        contexto.put("categoria", CategoriaServicios.getInstancia().ListaCategoria(Mercado.getInstance().getUserJefeWithToken(user)));
//                        ctx.render("/public/dashboard/listaProducto.html",contexto);




                    });

                });
                path("/marcaCreate", () -> {

                    get(ctx -> {
                        Claims user = decodeJWT(Odaca.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));

                        Map<String, Object> contexto = new HashMap<>();

                        contexto.put("user", user.getId());
//                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
//                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
//                        ) {
//                            contexto.put(politica.getKey(), politica.getValue());
//                        }
//                        contexto.put("categoria", CategoriaServicios.getInstancia().ListaCategoria(Mercado.getInstance().getUserJefeWithToken(user)));
                        ctx.render("/public/dashboard/marca.html",contexto);




                    });
                    post(ctx -> {
                        String marcastr = ctx.formParam("marca");
                        if (marcastr==null || marcastr.equalsIgnoreCase("")){

                        }else {
                            Marca marca = new Marca(marcastr);
                            MarcaServicios.getInstancia().crear(marca);
                            ctx.redirect("/dashboard/marca");
                        }

////                        Claims user = decodeJWT(Mercado.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
////                        System.out.println("\n\n\nusuario"+user);
////                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
//                        Map<String, Object> contexto = new HashMap<>();
////                        contexto.put("user", user.getId());
////                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
////                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
////                        ) {
////                            contexto.put(politica.getKey(), politica.getValue());
////                        }
////                        contexto.put("categoria", CategoriaServicios.getInstancia().ListaCategoria(Mercado.getInstance().getUserJefeWithToken(user)));
//                        ctx.render("/public/dashboard/listaProducto.html",contexto);




                    });

                });
                path("/modelo", () -> {

                    get(ctx -> {
                        Claims user = decodeJWT(Odaca.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
                        Map<String, Object> contexto = new HashMap<>();
                        contexto.put("user", user.getId());
                        contexto.put("listaModelo", ModeloServicios.getInstancia().ListadoCompleto());
//                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
//                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
//                        ) {
//                            contexto.put(politica.getKey(), politica.getValue());
//                        }
//                        contexto.put("categoria", CategoriaServicios.getInstancia().ListaCategoria(Mercado.getInstance().getUserJefeWithToken(user)));
                        ctx.render("/public/dashboard/modeloLista.html",contexto);




                    });
                });

                path("/modeloCreate", () -> {

                    get(ctx -> {
                        Claims user = decodeJWT(Odaca.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
                        Map<String, Object> contexto = new HashMap<>();
                        contexto.put("user", user.getId());
//                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
//                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
//                        ) {
//                            contexto.put(politica.getKey(), politica.getValue());
//                        }
//                        contexto.put("categoria", CategoriaServicios.getInstancia().ListaCategoria(Mercado.getInstance().getUserJefeWithToken(user)));
                        ctx.render("/public/dashboard/modelo.html",contexto);




                    });
                    post(ctx -> {
                        String modelostr = ctx.formParam("modelo");
                        if (modelostr==null || modelostr.equalsIgnoreCase("")){

                        }else {
                            Modelo modelo = new Modelo(modelostr);
                            ModeloServicios.getInstancia().crear(modelo);
                            ctx.redirect("/dashboard/modelo");
                        }

////                        Claims user = decodeJWT(Mercado.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
////                        System.out.println("\n\n\nusuario"+user);
////                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
//                        Map<String, Object> contexto = new HashMap<>();
////                        contexto.put("user", user.getId());
////                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
////                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
////                        ) {
////                            contexto.put(politica.getKey(), politica.getValue());
////                        }
////                        contexto.put("categoria", CategoriaServicios.getInstancia().ListaCategoria(Mercado.getInstance().getUserJefeWithToken(user)));
//                        ctx.render("/public/dashboard/listaProducto.html",contexto);




                    });

                });

                path("/showProducto", () -> {

                    post(ctx -> {

//                        Claims user = decodeJWT(Mercado.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        String idProducto = ctx.formParam("idProducto");
//                        Producto producto = ProductoServicios.getInstancia().getProductoConFoto(Long.parseLong(idProducto));
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
//                        Map<String, Object> contexto = new HashMap<>();
//                        contexto.put("user", user.getId());
//                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
//                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
//                        ) {
//                            contexto.put(politica.getKey(), politica.getValue());
//                        }
//                        contexto.put("categoria", CategoriaServicios.getInstancia().ListaCategoria(Mercado.getInstance().getUserJefeWithToken(user)));
//                        contexto.put("producto", producto);
//                        ctx.render("/public/dashboardPlantilla/showProducto.html",contexto);




                    });
                });

                path("/crearVentas", () -> {
                    get(ctx -> {
//                        String idFact = ctx.sessionAttribute("idFactura");
//                        if (idFact ==null){
//                            idFact = "";
//                        }else{
//                            ctx.sessionAttribute("idFactura",null);
//                            ctx.req.removeAttribute("idFactura");
//                        }
//                        Claims user = decodeJWT(Mercado.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario" + user);
//                        ctx.res.addHeader("Authorization", ctx.cookie("User"));
//                        Map<String, Object> contexto = new HashMap<>();
//                        contexto.put("user", user.getId());
//                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
//
//                        for (Politica politica : UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
//                        ) {
//                            contexto.put(politica.getKey(), politica.getValue());
//
//                        }
//                        contexto.put("idFactura", idFact);
//                        ctx.render("/public/dashboardPlantilla/crearNuevaVenta.html", contexto);


                    });



                        });
                path("/ventasActivas", () -> {
                            get(ctx -> {
//                                String idFact = ctx.sessionAttribute("idFactura");
//                                if (idFact ==null){
//                                    idFact = "";
//                                }else{
//                                    ctx.sessionAttribute("idFactura",null);
//                                    ctx.req.removeAttribute("idFactura");
//                                }
//                                Claims user = decodeJWT(Mercado.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                                System.out.println("\n\n\nusuario" + user);
//                                ctx.res.addHeader("Authorization", ctx.cookie("User"));
//                                Map<String, Object> contexto = new HashMap<>();
//                                contexto.put("user", user.getId());
//                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
//
//                                for (Politica politica : UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
//                                ) {
//                                    contexto.put(politica.getKey(), politica.getValue());
//                                }
//
//                                ctx.render("/public/dashboardPlantilla/facturaActiva.html", contexto);


                            });
                            post(ctx -> {
//                                String idFact = ctx.sessionAttribute("idFactura");
//                                if (idFact ==null){
//                                    idFact = "";
//                                }else{
//                                    ctx.req.removeAttribute("idFactura");
//                                }
//                                Claims user = decodeJWT(Mercado.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                                String idFac = ctx.formParam("idFactura");
//                                if (idFac != null){
//                                    ctx.sessionAttribute("idFactura",idFac);
//
//
//                                    ctx.redirect("/dashboard/crearVentas");
//                                }



                            });
                        });

                path("/categoria", () -> {

                    get(ctx -> {
//                        Claims user = decodeJWT(Mercado.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
//                        Map<String, Object> contexto = new HashMap<>();
//                        contexto.put("user", user.getId());
//                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
//                        contexto.put("categoria", CategoriaServicios.getInstancia().ListaCategoria(Mercado.getInstance().getUserJefeWithToken(user)));
//                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
//                        ) {
//                            contexto.put(politica.getKey(), politica.getValue());
//                        }
//
//                        ctx.render("/public/dashboardPlantilla/categoria.html",contexto);
//



                    });
                    post(ctx -> {
//                        String user = decodeJWT(Mercado.getInstance().getUserEncryptor().decrypt(ctx.cookie("User"))).getId();
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
//                        switch (ctx.formParam("action")){
//                            case "add":
//                                String categoria = ctx.formParam("nuevaCategoria");
//                                Mercado.getInstance().addCategoria(user,categoria);
//                                break;
//                            case "eliminar":
//                                long id = Long.parseLong(ctx.formParam("categoria"));
//                                CategoriaServicios.getInstancia().delete(id);
//                                break;
//                        }
//
//
//
//                        ctx.redirect("/dashboard/categoria");
//



                    });
                });


                path("/administrarVentas", () -> {

                    get(ctx -> {
//                        Claims user = decodeJWT(Mercado.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
//                        Map<String, Object> contexto = new HashMap<>();
//                        contexto.put("user", user.getId());
//                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
//                        contexto.put("factura", FacturaClienteServicios.getInstancia().ListFacturaClienteCerradaVendedor(Mercado.getInstance().getUserJefeWithToken(user)));
//                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
//                        ) {
//                            contexto.put(politica.getKey(), politica.getValue());
//                        }
//
//                        ctx.render("/public/dashboardPlantilla/administrarVentas.html",contexto);




                    });

                });


                path("/impuesto", () -> {

                    get(ctx -> {
//                        Claims user = decodeJWT(Mercado.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
//                        Map<String, Object> contexto = new HashMap<>();
//                        contexto.put("user", user.getId());
//                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
//                        contexto.put("impuesto", ImpuestoServicios.getInstancia().listaImpuesto(Mercado.getInstance().getUserJefeWithToken(user)));
//                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
//                        ) {
//                            contexto.put(politica.getKey(), politica.getValue());
//                        }
//
//                        ctx.render("/public/dashboardPlantilla/impuesto.html",contexto);
//
//


                    });
                    post(ctx -> {
//                        String user = decodeJWT(Mercado.getInstance().getUserEncryptor().decrypt(ctx.cookie("User"))).getId();
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
//                        switch (ctx.formParam("action")){
//                            case "add":
//                                Impuesto impuesto = new Impuesto(ctx.formParam("nombre"),ctx.formParam("nuevoTributo"),Double.parseDouble(ctx.formParam("valor")));
//                                try {
//                                    if (ctx.formParam("aplicarTodos").equalsIgnoreCase("true")){
//                                        impuesto.setAplicarATodos(true);
//                                        impuesto = Mercado.getInstance().addImpuesto(Mercado.getInstance().getUserJefeWithToken(decodeJWT(Mercado.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")))), impuesto);
//                                        Mercado.getInstance().addImpuestoToAllProducto(impuesto.getId(),Mercado.getInstance().getUserJefeWithToken(decodeJWT(Mercado.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")))));
//
//                                    }else{
//                                        impuesto.setAplicarATodos(false);
//                                        Mercado.getInstance().addImpuesto(Mercado.getInstance().getUserJefeWithToken(decodeJWT(Mercado.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")))),impuesto);
//
//                                    }
//                                }catch (NullPointerException E){
//                                    impuesto.setAplicarATodos(false);
//                                    Mercado.getInstance().addImpuesto(Mercado.getInstance().getUserJefeWithToken(decodeJWT(Mercado.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")))),impuesto);
//
//                                }
//                                break;
//                            case "eliminar":
//                                long id = Long.parseLong(ctx.formParam("impuesto"));
//                                ImpuestoServicios.getInstancia().delete(id);
//                                break;
//                        }
//
//
//
//
//
//                        ctx.redirect("/dashboard/impuesto");
//



                    });
                });

                path("/cliente", () -> {

                    get(ctx -> {

//                        Claims user = decodeJWT(Mercado.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
//                        Map<String, Object> contexto = new HashMap<>();
//                        contexto.put("user", user.getId());
//                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
//                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
//                        ) {
//                            contexto.put(politica.getKey(), politica.getValue());
//                        }
//
//
//
//                        contexto.put("cliente",ClienteServicios.getInstancia().listaCliente(Mercado.getInstance().getUserJefeWithToken(user)));
//
//                        ctx.render("/public/dashboardPlantilla/Cliente.html",contexto);
//
//


                    });
                    post(ctx -> {

//                        Claims user = decodeJWT(Mercado.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
//
//
//                        String nombre = ctx.formParam("nombre");
//                        String apellido = ctx.formParam("apellido");
//                        String tipoDocumento = ctx.formParam("tipoDocumento");
//                        String documentoID = ctx.formParam("documentoID");
//                        String nuevoEmail = ctx.formParam("nuevoEmail");
//                        String nuevoTelefono = ctx.formParam("nuevoTelefono");
//                        String pais = ctx.formParam("pais");
//                        String Municipio = ctx.formParam("Municipio");
//                        String nuevaDireccion = ctx.formParam("nuevaDireccion");
//
//
//                        Vendedor otro = VendedorServicios.getInstancia().getVendedor(Mercado.getInstance().getUserJefeWithToken(user));
//
//                        Usuario usuarioCliente = new Usuario();
//                        usuarioCliente.setNombre(nombre);
//                        usuarioCliente.setApellido(apellido);
//                        usuarioCliente.setPerfil("Cliente");
//                        usuarioCliente.setPais(pais);
//                        usuarioCliente.setMunicipio(Municipio);
//                        usuarioCliente.setDireccion(nuevaDireccion);
//                        usuarioCliente.setTelefono(nuevoTelefono);
//                        usuarioCliente.setDocumento(documentoID);
//                        usuarioCliente.setTipoDocumento(tipoDocumento);
//                        usuarioCliente.setEmail(nuevoEmail);
//                        usuarioCliente = (Usuario) new UsuarioServicios().crear(usuarioCliente);
//                        System.out.println("\n\n\nusua"+usuarioCliente.getUsuario());
//                        usuarioCliente = UsuarioServicios.getInstancia().buscar(usuarioCliente.getUsuario());
//                        Cliente cliente = new Cliente();
//                        cliente = usuarioCliente.addCliente(cliente);
//                        cliente = (Cliente) ClienteServicios.getInstancia().crear(cliente);
//                        usuarioCliente = (Usuario) UsuarioServicios.getInstancia().editar(usuarioCliente);
//
//                        otro.addCliente(cliente);
//                        otro = (Vendedor) VendedorServicios.getInstancia().editar(otro);
//
//
//                        ctx.redirect("/dashboard/cliente");




                    });
                });


                path("/perfil", () -> {

                    get(ctx -> {


//                        Claims user = decodeJWT(Mercado.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
//                        Map<String, Object> contexto = new HashMap<>();
//                        contexto.put("user", user.getId());
//                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
//                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
//                        ) {
//                            contexto.put(politica.getKey(), politica.getValue());
//                        }
//
//
//
//                        contexto.put("usuario",UsuarioServicios.getInstancia().getUsuario(user.getId()));
//                        contexto.put("dirigir","/dashboard/perfil");
//
//                        ctx.render("/public/dashboardPlantilla/perfil.html",contexto);
//
//


                    });


                    post(ctx -> {


//                        String user = decodeJWT(Mercado.getInstance().getUserEncryptor().decrypt(ctx.cookie("User"))).getId();
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
//                        Usuario usuario = UsuarioServicios.getInstancia().getUsuario(ctx.formParam("user"));
//                        switch (ctx.formParam("action")){
//                            case "editDireccion":
//
//                                usuario.setPais(ctx.formParam("pais"));
//                                usuario.setMunicipio(ctx.formParam("municipio"));
//                                usuario.setDireccion(ctx.formParam("direccion"));
//                                UsuarioServicios.getInstancia().editar(usuario);
//                                break;
//                            case "EditInfo":
//                                usuario = UsuarioServicios.getInstancia().getUsuario(ctx.formParam("user"));
//                                usuario.setNombre(ctx.formParam("nombre"));
//                                usuario.setApellido(ctx.formParam("apellido"));
//                                usuario.setNombreCompania(ctx.formParam("nombreCompania"));
//                                usuario.setEmail(ctx.formParam("email"));
//                                usuario.setTelefono(ctx.formParam("telefono"));
//                                UsuarioServicios.getInstancia().editar(usuario);
//                                break;
//
//                            case "changePassword":
//                                usuario = UsuarioServicios.getInstancia().getUsuario(user);
//                                String perfil = Mercado.getInstance().verificar_user(user,ctx.formParam("passwordOld"));
//                                if (perfil!=null){
//                                    if (ctx.formParam("password").equalsIgnoreCase(ctx.formParam("passwordRetry"))){
//                                        usuario.getVendedor().setPassword(Mercado.getInstance().getPasswordEncryptor().encrypt(ctx.formParam("password")));
//                                        UsuarioServicios.getInstancia().editar(usuario);
//                                    }
//                                }else {
//
//                                }
//
//                        }
//
//
//
//
//
//                        ctx.redirect("/dashboard/perfil");


                    });

                });






                path("/empleado", () -> {

                    get(ctx -> {
//                        Claims user = decodeJWT(Mercado.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario"+user.getId());
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
//                        Map<String, Object> contexto = new HashMap<>();
//                        contexto.put("user", user.getId());
//                        contexto.put("nameComplete", (String) user.get("nombreCompleto")+"-"+user.getAudience());
//                        List<Usuario> list = new ArrayList<Usuario>();
//
//                        contexto.put("empleado", EmpleadoServicios.getInstancia().listaEmpleado(user.getId()));
//                        for (Politica politica: UsuarioServicios.getInstancia().getUsuario(user.getId()).getPoliticaList()
//                        ) {
//                            contexto.put(politica.getKey(), politica.getValue());
//                        }
//
//                        ctx.render("/public/dashboardPlantilla/usuarioDashboard.html",contexto);
//
//


                    });
                    post(ctx -> {

//                        Claims user = decodeJWT(Mercado.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
//                        System.out.println("\n\n\nusuario"+user);
//                        ctx.res.addHeader("Authorization",ctx.cookie("User"));
//                        String nombre = ctx.formParam("nombre");
//                        String apellido = ctx.formParam("apellido");
//                        String tipoDocumento = ctx.formParam("tipoDocumento");
//                        String documentoID = ctx.formParam("documentoID");
//                        String nuevoEmail = ctx.formParam("nuevoEmail");
//                        String nuevoTelefono = ctx.formParam("nuevoTelefono");
//                        String pais = ctx.formParam("pais");
//                        String Municipio = ctx.formParam("Municipio");
//                        String nuevaDireccion = ctx.formParam("nuevaDireccion");
//                        String idUsuario = ctx.formParam("id");
//                        String password = ctx.formParam("password");
//                        int privilegio = Integer.parseInt(ctx.formParam("privilegio"));
//                        if (privilegio>2){
//                            privilegio = 2;
//                        }
//
//
//                        Usuario empleado = new Usuario();
//                        empleado.setNombre(nombre);
//                        empleado.setApellido(apellido);
//                        empleado.setPerfil("Empleado");
//                        empleado.setPais(pais);
//                        empleado.setTipoDocumento(tipoDocumento);
//                        empleado.setDocumento(documentoID);
//                        empleado.setMunicipio(Municipio);
//                        empleado.setDireccion(nuevaDireccion);
//                        empleado.setTelefono(nuevoTelefono);
//                        empleado.setUsuario(idUsuario);
//                        empleado.setEmail(nuevoEmail);
//                        Mercado.getInstance().registrarEmpleado(Mercado.getInstance().getUserJefeWithToken(user),empleado,password,privilegio);
//
//
//
//
//                        ctx.redirect("/dashboard/empleado");




                    });
                });



            });


        });

        path("/catalogo", () -> {

                    app.routes(() -> {

                        before(ctx -> {


                            System.out.println("\n\nAcceso: "+ctx.req.getPathInfo());
                            System.out.println("\n\nAcceso1: "+ctx.path());

                            String headerAuth = ctx.req.getHeader("Authorization");
                            System.out.println(headerAuth);
                            String user = ctx.cookie("User");
                            String session = ctx.sessionAttribute("User");
                            System.out.println("este es el add:"+ctx.path());
//                    if (ctx.path().contains("/dashboardPlantilla/")==true  || ctx.path().contains("/webPage")==true ||ctx.path().contains("/js")==true ||ctx.path().contains("/bd")==true || ctx.path().contains("/assets")==true ){


                            if (ctx.path().contains("/home")==true  || ctx.path().contains("/producto")==true
                                    || ctx.path().contains("/configuracion")==true
                                    || ctx.path().contains("/inventory")==true
                            ){
                                if (user==null || session == null){

                                    System.out.println(Odaca.getInstance().getUserEncryptor().decrypt(user));
                                    ctx.redirect("/login");

                                }else{
                                    System.out.println("\n\n\n\nverifico");

                                    if(Odaca.getInstance().getUserEncryptor().decrypt(user).equalsIgnoreCase(session)){
                                        try {
                                            if(isExpirate(decodeJWT(session))==false){



                                                Claims claims = decodeJWT(session);


                                                    String header = "Authorization";
                                                    String use = claims.getId();
                                                    Map<String, Object> map = new HashMap<String, Object>();
                                                    map.put("user",claims.get("user"));
                                                    map.put("direccion",claims.get("direccion"));
                                                    map.put("telefono",claims.get("telefono"));
                                                    map.put("compania",claims.get("compania"));
                                                    map.put("ciudadPais",claims.get("ciudadPais"));
                                                    map.put("nombreCompleto",claims.get("nombreCompleto"));

                                                    String jwt = createJWT(use,claims.getAudience(), map);
                                                    ctx.header(header,jwt);
                                                    ctx.sessionAttribute("User",jwt);
                                                    ctx.cookie("User",Odaca.getInstance().getUserEncryptor().encrypt(jwt),2147483647);
                                                    String mensaje = String.format("Manejador before aplicando a todas las llamadas: %s, Contexto: %s, Metodo: %s",
                                                            ctx.req.getRemoteHost(),
                                                            ctx.req.getServletPath(),
                                                            ctx.req.getMethod());
                                                    //
                                                    System.out.println(mensaje);
                                                    Odaca.getInstance().getLogins().get(use).setJwt(claims);
                                                    Odaca.getInstance().getLogins().get(use).setSession(ctx.req.getSession());








                                            }else{

                                                ctx.redirect("/logout");
                                            }

                                        }catch (ExpiredJwtException e){

                                            ctx.redirect("/logout");
                                        }catch (NullPointerException e){

                                            ctx.redirect("/login");
                                        }
                                    }else{

                                        ctx.redirect("/login");
                                    }


                                }

                            }else{
                                System.out.println("entro");

                            }

                        });


                        path("/", () -> {
                            get(ctx -> {

                                ctx.redirect("/catalogo/home");


                            });
                        });
                        path("/home", () -> {
                            get(ctx -> {
                                Claims user = decodeJWT(Odaca.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
                                Map<String, Object> contexto = new HashMap<>();
                                contexto.put("user", user.getId());
                                contexto.put("listaPaqueteProducto", "");
                                contexto.put("offline", "/templates/sinconexion.appcache");
                                ctx.render("/public/catalogo/index.html", contexto);
//                                ctx.redirect("/dashboard/home");


                            });
                        });
                        path("/producto", () -> {
                            get(ctx -> {
                                Claims user = decodeJWT(Odaca.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
                                Map<String, Object> contexto = new HashMap<>();
                                contexto.put("user", user.getId());
//                                contexto.put("offline", "/templates/sinconexion.appcache");
                                ctx.render("/public/catalogo/catalogo.html", contexto);
//                                ctx.redirect("/dashboard/home");


                            });
                        });
                        path("/configuracion", () -> {
                            get(ctx -> {
                                Claims user = decodeJWT(Odaca.getInstance().getUserEncryptor().decrypt(ctx.cookie("User")));
                                Map<String, Object> contexto = new HashMap<>();
                                contexto.put("user", user.getId());
//                                contexto.put("offline", "/templates/sinconexion.appcache");
                                ctx.render("/public/catalogo/configuration.html", contexto);
//                                ctx.redirect("/dashboard/home");


                            });
                        });
                    });

        });

        app.routes(() -> {
            /*
            path("/editar/:id", () -> {

                get(ctx -> {


                    String id_cliente = ctx.sessionAttribute("carroCompra");

                    Producto producto = Mercado.getInstance().getProductoServicios().getProducto(ctx.pathParam("id", Integer.class).getOrNull());
                    int aux = Mercado.getInstance().cant_product(Long.parseLong(id_cliente));
                    Map<String, Object> modelo = new HashMap<>();
                    String userenc = userEncryptor.decrypt(ctx.cookie("Login"));
                    if (userenc != null) {
                        modelo.put("user", userenc + " - Salir");
                        modelo.put("log", "logout");
                    } else {
                        userenc = "Iniciar Seccion";
                        modelo.put("user", userenc);
                        modelo.put("log", "login");
                    }
                    modelo.put("cant", aux);
                    modelo.put("producto", producto);
                    ctx.render("/publico/EditarProducto.html",modelo);
                });
        });*/
//            path("/producto", () -> {
//                get(ctx -> {
//
//
//
//                });
//            });
//
//            path("/venta_producto", () -> {
//
//                get(ctx -> {
//                    if (ctx.cookie("Login") != null) {
//
//
//
//                    } else {
//                        ctx.redirect("/");
//                    }
//                });
//            });




//
//
//
//
//            path("/process", () -> {
//
//                get(ctx -> {
//                    ctx.render("/publico/successfully.html");
//                });
//                post(ctx -> {
//                    if(ctx.formParam("status").equalsIgnoreCase("COMPLETED")){
//                        Factura factura = new Factura(ctx.formParam("id_order"),ctx.formParam("status"),ctx.formParam("name"),ctx.formParam("last"),ctx.formParam("email"),ctx.formParam("payer_id"),ctx.formParam("address_line_1"),ctx.formParam("address_line_2"),
//                                ctx.formParam("admin_area_2"),ctx.formParam("admin_area_1"),ctx.formParam("postal_code"),ctx.formParam("country_code"));
//                        if(ctx.formParam("id_paquete")!=null){
//                            factura.setPack(true);
//                            factura.setIdPaqueteProducto(Long.parseLong(ctx.formParam("id_paquete")));
//                            PaqueteProducto aux = PaqueteProductoServicios.getInstance().find(Long.parseLong(ctx.formParam("id_paquete")));
//                            for (Producto ax: aux.getProductoList()
//                                 ) {
//                                factura.addProducto(ax);
//                            }
//
//                        }
//                        FacturaServicios.getInstance().crear(factura);
//                        ctx.redirect("/process");
//
//                    }
//                });
//            });
//            path("/checkout", () -> {
//
//                /**
//                 * http://localhost:7000/thymeleaf/
//                 */
//                post(ctx -> {
//                    PaqueteProducto aux = PaqueteProductoServicios.getInstance().find(Long.parseLong(ctx.formParam("id")));
//                    System.out.println(aux.getFees());
//
//
//                    Map<String, Object> contexto = new HashMap<>();

//                    contexto.put("aux", aux);
//                    ctx.render("/publico/checkout.html", contexto);
//                });
//            });
//            path("/", () -> {
//                get(ctx -> {
//
//                    Map<String, Object> contexto = new HashMap<>();
//                    contexto.put("listaPaqueteProducto", PaqueteProductoServicios.getInstance().ListadoCompleto());
//                    ctx.render("/publico/index.html", contexto);
//
//
//                });
//            });




        });

    }

    public static boolean isSessionAvailable(String user, String sessionID){
        boolean available = true;
        String posi = "ocupado";
        try {
            if (Odaca.getInstance().getLogins().get(user).getId().equals(user)){
                System.out.println("\n\n ididid"+Odaca.getInstance().getLogins().get(user).getId()+"\notro: "+sessionID+"\notro1: "+Odaca.getInstance().getLogins().get(user).getSession().getId());
                if (isExpirate(Odaca.getInstance().getLogins().get(user).getJwt())==true ){
                    posi = "disponible";

                }else if(Odaca.getInstance().getLogins().get(user).getSession().getId().equals(sessionID)){
                    posi = "disponible";
                }
                if (posi.equalsIgnoreCase("disponible")){
                    Odaca.getInstance().getLogins().remove(user);
                    return true;
                }else{
                    return false;
                }
            }
        }catch (NullPointerException e){
            e.printStackTrace();
            return true;
        }

//        }
        return available;

    }

    public static String createJWT(String username, String perfil, Map<String, Object> map) {

        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder;
        builder = Jwts.builder().setClaims(map).setId(username)
                .setIssuedAt(now)
                .setSubject("CashSuite")
                .setIssuer((String) map.get("user"))
                .setAudience(perfil)
                .signWith(signatureAlgorithm, signingKey);

        // 5 minutes para expiracion
        long expMillis = nowMillis + Odaca.getInstance().getTimeSessionMinute() * 1000 * 60;
        Date exp = new Date(expMillis);
        builder.setExpiration(exp);
        System.out.println("fecha" +now +exp);
        System.out.println("Expiro: "+isExpirate(decodeJWT(builder.compact())));
        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

    public static boolean isExpirate(Claims jwt){
        boolean expire = true;
        if (jwt != null){
            if (new  Date(System.currentTimeMillis()).after(jwt.getExpiration())){
                return expire;
            }

        }
        return false;
    }

    public static Claims decodeJWT(String jwt) {

        //This line will throw an exception if it is not a signed JWS (as expected)
        try {

            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                    .parseClaimsJws(jwt).getBody();

            return claims;
        }catch (ExpiredJwtException e){
            return null;
    }    }
}
