package odaca.entidades;

import com.fasterxml.jackson.databind.ObjectMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import odaca.servicios.*;
import io.jsonwebtoken.Claims;
import org.jasypt.util.text.AES256TextEncryptor;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.awt.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.List;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Odaca {
    //    private static ProductoServicios productoServicios = new ProductoServicios();
//    private static UsuarioServicios usuarioServicios = new UsuarioServicios();
//    private static VentasProductosServicios ventasProductosServicios = new VentasProductosServicios();
//    private static CarroCompraServicios carroCompraServicios = new CarroCompraServicios();
//    private static CarroCompra_ProductoServicios carroCompra_productoServicios = new CarroCompra_ProductoServicios();
    private static Odaca odaca;
    private AES256TextEncryptor userEncryptor = new AES256TextEncryptor();
    private AES256TextEncryptor passwordEncryptor = new AES256TextEncryptor();
    private Map<String, Login> logins = new HashMap<String, Login>();
    private long timeSessionMinute = 10;
//    public  List<VentasSession> listaSseUsuario = new ArrayList<VentasSession>();

    public Odaca() {
    }

    public static Odaca getInstance() {
        if (odaca == null)
            odaca = new Odaca();
        return odaca;
    }

    public void loadDataBase() throws UnsupportedEncodingException {
        userEncryptor.setPassword("admin");
        passwordEncryptor.setPassword("admin");
//        FacturaCliente facturaCliente = new FacturaCliente();
//        facturaCliente.setIdQuienLoRealizo("admin");
//        FacturaClienteServicios.getInstancia().crearFacturaCliente(facturaCliente,"admin","CLI-000001");

        try {
//            if (verificar_user("admin", "admin") != null) {


            if (UsuarioServicios.getInstancia().existe("admin")){

            }else {
                Usuario usuario = new Usuario("admin", "Admin");
                usuario.setEmail("admin@odaca.com.do");
                usuario.setPerfil("Admin");
                usuario.setMunicipio("Moca");
                usuario.setDireccion("Paso de moca");
                usuario.setTelefono("8098230775");
                usuario.setNombreCompania("Importadora Odaca");
                usuario.setDocumento("125562");
                Usuario aux = RegistrarVendedor(usuario, "admin@odaca.com.do", "admin1234");
            }
            if (UsuarioServicios.getInstancia().existe("david")){

            }else {
                Usuario usuario = new Usuario("david", "David");
                usuario.setApellido("Almonte");
                usuario.setEmail("venta@odaca.com.do");
                usuario.setPerfil("Oficina");
                usuario.setMunicipio("Moca");
                usuario.setDireccion("Paso de moca");
                usuario.setTelefono("");
                usuario.setNombreCompania("Importadora Odaca");
                usuario.setDocumento("");
                Usuario aux = RegistrarVendedor(usuario, "venta@odaca.com.do", "admin1234");
            }

            if (UsuarioServicios.getInstancia().existe("delvin")){

            }else {
                Usuario usuario = new Usuario("delvin", "Delvin");
                usuario.setApellido("Bencosme");
                usuario.setEmail("gerencia@odaca.com.do");
                usuario.setPerfil("Oficina");
                usuario.setMunicipio("Moca");
                usuario.setDireccion("Paso de moca");
                usuario.setTelefono("");
                usuario.setNombreCompania("Importadora Odaca");
                usuario.setDocumento("");
                Usuario aux = RegistrarVendedor(usuario, "gerencia@odaca.com.do", "admin1234");
            }
            if (UsuarioServicios.getInstancia().existe("sadiel")){

            }else {
                Usuario usuario = new Usuario("sadiel", "Sadiel");
                usuario.setApellido("Bencosme");
                usuario.setEmail("compra@odaca.do");
                usuario.setPerfil("Oficina");
                usuario.setMunicipio("Moca");
                usuario.setDireccion("Paso de moca");
                usuario.setTelefono("");
                usuario.setNombreCompania("Importadora Odaca");
                usuario.setDocumento("");
                Usuario aux = RegistrarVendedor(usuario, "compra@odaca.do", "admin1234");
            }
            if (UsuarioServicios.getInstancia().existe("odeisa")){

            }else {
                Usuario usuario = new Usuario("odeisa", "Odeisa");
                usuario.setApellido("Bencosme");
                usuario.setEmail("contabilidad@odaca.com.do");
                usuario.setPerfil("Oficina");
                usuario.setMunicipio("Moca");
                usuario.setDireccion("Paso de moca");
                usuario.setTelefono("");
                usuario.setNombreCompania("Importadora Odaca");
                usuario.setDocumento("");
                Usuario aux = RegistrarVendedor(usuario, "contabilidad@odaca.com.do", "admin1234");
            }
            if (UsuarioServicios.getInstancia().existe("jlopez")){

            }else {
                Usuario usuario = new Usuario("jlopez", "John");
                usuario.setApellido("Lopez");
                usuario.setEmail("johncarlos1943.odaca@gmail.com");
                usuario.setPerfil("Oficina");
                usuario.setMunicipio("Moca");
                usuario.setDireccion("Paso de moca");
                usuario.setTelefono("");
                usuario.setNombreCompania("Importadora Odaca");
                usuario.setDocumento("");
                Usuario aux = RegistrarVendedor(usuario, "johncarlos1943.odaca@gmail.com", "admin1234");
            }

            if (UsuarioServicios.getInstancia().existe("venta")){

            }else {
                Usuario usuario = new Usuario("venta", "Venta");
                usuario.setApellido("");
                usuario.setEmail("ventaprueba@gmail.com");
                usuario.setPerfil("Vendedor");
                usuario.setMunicipio("Moca");
                usuario.setDireccion("Paso de moca");
                usuario.setTelefono("");
                usuario.setNombreCompania("Importadora Odaca");
                usuario.setDocumento("");
                Usuario aux = RegistrarVendedor(usuario, "johncarlos1943.odaca@gmail.com", "Odac@8230775");
            }



//                for (Impuesto impuesto : ImpuestoServicios.getInstancia().impuestoProductoNotAdded(1)) {
//                    System.out.println("\n\nEso es:"+impuesto.getNombre());
//                }


//                ClienteServicios.getInstancia().getCliente("CLI-000001");
//                ImpuestoClienteServicios.getInstancia().ListaImpuestoFacturaCliente("FAC-00000003");
//                discountProductoInFactura("FAC-00000003", 1, 6);
//                    addProductoInFactura("FAC-00000004", 1, 4);
//                //agregando para la factura lista producto
//                long id = 1;
//                Producto va = (Producto) new ProductoServicios().find(id);
//                Almacen almacen1 = new Almacen("Flores",10,0,250,600);
//                almacen1 = va.addAlmacen(almacen1);
//                va = (Producto) new ProductoServicios().editar(va);
//
//                facturarOnlyProducto(va, 13);


//                for (Usuario usuario : UsuarioServicios.getInstancia().listaUsuario()) {
//                    if (usuario.getPerfil().equalsIgnoreCase("Admin") && !usuario.getUsuario().equalsIgnoreCase("admin") ){
//                        crearClienteAlContado(usuario.getUsuario());
//                    }
//                }

//                for (ProductoJSON productoJSON : ProductoServicios.getInstancia().getListaProductoJson("admin")) {
//                    System.out.println("\n\nImpuesto"+productoJSON.getImpuesto()+"precioNeto"+productoJSON.getPrecioLista());
//                }

//                Usuario usuario = new Usuario("admin", "Admin");
//                usuario.setEmail("admin@cashsuite.com");
//                usuario.setPerfil("Admin");
//                Usuario aux = new UsuarioServicios().crearUsuario(usuario);
//
//                Producto producto = new Producto();
//                producto.setNombre("Huevo");
//                producto.setDescripcion("Son bueno");
//                producto.setCodigo_local("144533");
//                Producto producto1 = new Producto();
//                producto1.setNombre("Pan");
//                producto1.setDescripcion("Son malo");
//                producto1.setCodigo_local("1445833");
//
//
//                Vendedor vendedor = new Vendedor();
//                vendedor.setEmail("admin@cashsuite.com");
//                vendedor.setPassword(passwordEncryptor.encrypt("admin"));
//                Vendedor otro = aux.addVendedor(vendedor);
//                VendedorServicios.getInstancia().crear(otro);
//                UsuarioServicios.getInstancia().editar(aux);
//
//                producto.CrearProductoVenta();
//                producto1.CrearProductoVenta();
//                producto = ProductoServicios.getInstancia().crearProducto(producto);
//                producto1 = ProductoServicios.getInstancia().crearProducto(producto1);
//                otro.addProducto(producto);
//                otro.addProducto(producto1);
////            VendedorServicios.getInstancia().editar(otro);
//                Producto va = ((Vendedor) VendedorServicios.getInstancia().editar(otro)).getProductoList().get(0);
//
//                Almacen almacen = new Almacen("Don Lindo",10,10,200,500);
//                va.addAlmacen(almacen);
//                va = (Producto) new ProductoServicios().editar(va);
//                almacen = new Almacen("Endy",10,1,300,600);
//                va.addAlmacen(almacen);
//                va = (Producto) new ProductoServicios().editar(va);


//            }
        } catch (NullPointerException e) {
//            runMuestra();
        }


    }


    public Usuario RegistrarVendedor(Usuario usuario, String email, String password) throws UnsupportedEncodingException {

        usuario.setContrasena(passwordEncryptor.encrypt(password));
        usuario.setEmail(email);
        usuario = new UsuarioServicios().crearUsuario(usuario);
        usuario = (Usuario) UsuarioServicios.getInstancia().editar(usuario);

        return usuario;
    }




    public Map<String, String> JsonStringToMap(String json){
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = null;


        try {

            // convert JSON string to Map
            map = mapper.readValue(json, Map.class);

            // it works
            //Map<String, String> map = mapper.readValue(json, new TypeReference<Map<String, String>>() {});

            System.out.println(map);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }




    public String tittleAction(String action){
        String val = null;
        switch (action){
            case "nuevo":
                val = "Producto Nuevo";
                break;
            case "destacado":
                val = "Producto Destacado";
                break;
            case "oferta":
                val = "Oferta De La Semana";
                break;
            case "vendpop":
                val = "Producto Mas Vendido y Popular";
                break;
            default:
                break;
        }
        return val;
    }


    public Map<String, Object> getUserJefe(String user) {
        Map<String, Object> map = new HashMap<String, Object>();
        Usuario aux = UsuarioServicios.getInstancia().getUsuario(user);
        String se = null;
        switch (aux.getPerfil()) {
            case "Admin":
                se = user;
                map.put("user",user);
                map.put("nombreCompleto",aux.getNombre()+" "+aux.getApellido());
                map.put("direccion",aux.getDireccion());
                map.put("telefono",aux.getTelefono());
                map.put("compania",aux.getNombreCompania());
                if (aux.getMunicipio() != null && aux.getPais()== null){
                    map.put("ciudadPais",aux.getMunicipio());
                }else if (aux.getMunicipio() == null && aux.getPais()!= null){
                    map.put("ciudadPais",aux.getPais());
                }else{
                    map.put("ciudadPais",aux.getMunicipio() + ", "+aux.getPais());
                }


                break;

            case "Oficina":

                se = user;
                Usuario aux1 = UsuarioServicios.getInstancia().getUsuario(se);
                map.put("user",se);
                map.put("nombreCompleto",aux.getNombre()+" "+aux.getApellido());
                map.put("direccion",aux1.getDireccion());
                map.put("telefono",aux1.getTelefono());
                map.put("compania",aux1.getNombreCompania());
                if (aux1.getMunicipio() != null && aux1.getPais()== null){
                    map.put("ciudadPais",aux1.getMunicipio());
                }else if (aux.getMunicipio() == null && aux.getPais()!= null){
                    map.put("ciudadPais",aux1.getPais());
                }else{
                    map.put("ciudadPais",aux1.getMunicipio() + ", "+aux1.getPais());
                }
                break;
            case "Vendedor":
                se = user;
                map.put("user",se);
                map.put("nombreCompleto",aux.getNombre()+" "+aux.getApellido());
                map.put("direccion",aux.getDireccion());
                map.put("telefono",aux.getTelefono());
                map.put("compania",aux.getNombreCompania());

                if (aux.getMunicipio() != null && aux.getPais()== null){

                    map.put("ciudadPais",aux.getMunicipio());
                }else if (aux.getMunicipio() == null && aux.getPais()!= null){
                    map.put("ciudadPais",aux.getPais());
                }else{
                    map.put("ciudadPais",aux.getMunicipio() + ", "+aux.getPais());
                }
                break;
            default:
                se = user;
                break;
        }
        return map;
    }


    public  String getRandomNumberString() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }


    public Map<String, Login> getLogins() {
        return logins;
    }

    public void setLogins(Map<String, Login> logins) {
        this.logins = logins;
    }

    public long getTimeSessionMinute() {
        return timeSessionMinute;
    }

    public void setTimeSessionMinute(long timeSessionMinute) {
        this.timeSessionMinute = timeSessionMinute;
    }

    public String generateID(){
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();

        System.out.println("Your UUID is: " + uuidAsString);
        return uuidAsString;
    }

    public AES256TextEncryptor getUserEncryptor() {
        return userEncryptor;
    }

    public void setUserEncryptor(AES256TextEncryptor userEncryptor) {
        this.userEncryptor = userEncryptor;
    }

    public AES256TextEncryptor getPasswordEncryptor() {
        return passwordEncryptor;
    }

    public void setPasswordEncryptor(AES256TextEncryptor passwordEncryptor) {
        this.passwordEncryptor = passwordEncryptor;
    }


    public String verificar_user(String user, String password) {


        Usuario aux = UsuarioServicios.getInstancia().getUsuario(user);
        switch (aux.getPerfil()) {
            case "Oficina":

                System.out.println("Esto sale" + aux.getContrasena());
                if (passwordEncryptor.decrypt(aux.getContrasena()).equals(password)) {
                    return "Oficina";
                }

                break;

            case "Admin":

                System.out.println("Esto sale" + aux.getContrasena());
                if (passwordEncryptor.decrypt(aux.getContrasena()).equals(password)) {
                    return "Admin";
                }

                break;
            case "Vendedor":

                System.out.println("Esto sale" + aux.getContrasena());
                if (passwordEncryptor.decrypt(aux.getContrasena()).equals(password)) {
                    return "Vendedor";
                }

                break;
            default:
                break;


        }


        return null;
    }

    public String getUserJefeWithToken(Claims claims) {
//        Usuario aux = UsuarioServicios.getInstancia().getUsuario(user);
        String se = null;
//        System.out.println("\n\nPerfil" + claims.getAudience() + "-" + claims.getIssuer());

        switch (claims.getAudience()) {
            case "Admin":

                se = claims.getIssuer();
                break;

            case "Oficina":

                se = claims.getIssuer();
                break;
            case "Vendedor":
                se = claims.getIssuer();
                break;
            default:
                se = null;
                break;
        }
        return se;
    }




    public boolean send_correo_online(String correo, String mensaje, String asunto) {
        Properties propiedad = new Properties();
//        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
//        propiedad.setProperty("mail.smtp.starttls.enable", "true");
//        propiedad.setProperty("mail.smtp.port", "587");
//        propiedad.setProperty("mail.smtp.auth", "true");


        propiedad.setProperty("mail.smtp.host", "smtp.zoho.com");
        propiedad.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        propiedad.setProperty("mail.smtp.socketFactory.fallback", "false");
        propiedad.setProperty("mail.smtp.port", "465");
        propiedad.setProperty("mail.smtp.socketFactory.port", "465");
        propiedad.put("mail.smtp.starttls.enable", "true");
        propiedad.put("mail.smtp.auth", "true");
        propiedad.put("mail.debug", "true");
        propiedad.put("mail.store.protocol", "pop3");
        propiedad.put("mail.transport.protocol", "smtp");
        propiedad.put("mail.debug.auth", "true");
        propiedad.setProperty( "mail.pop3.socketFactory.fallback", "false");

        Session sesion = Session.getDefaultInstance(propiedad);
        String correoEnvia = "log@odaca.do";
        String contrasena = "Odac@8230775";
        String receptor = correo;


        Message mail = new MimeMessage(sesion);
        try {
            mail.setFrom(new InternetAddress(correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
            mail.setSubject(asunto);

            MimeMultipart multipart = new MimeMultipart("related");


            // first part (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(mensaje, "text/html");
            // add it
            multipart.addBodyPart(messageBodyPart);

            // second part (the image)
            if (asunto.equalsIgnoreCase("Error del servidor")) {
                messageBodyPart = new MimeBodyPart();
                DataSource fds = new FileDataSource(
                        "/home/ubuntu/CSUITE/build/libs/error.txt");
                messageBodyPart.setDataHandler(new DataHandler(fds));
                messageBodyPart.setFileName("error.txt");

                multipart.addBodyPart(messageBodyPart);

            }

            // put everything together
            mail.setContent(multipart);
//            mail.setContent(mensaje,"text/html");


            Transport transportar = sesion.getTransport("smtp");
            transportar.connect(correoEnvia, contrasena);
            transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transportar.close();

            return true;

        } catch (AddressException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }


}
