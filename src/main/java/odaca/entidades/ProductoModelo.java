package odaca.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ProductoModelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    @EmbeddedId
//    private ImpuestoProductoEnVentaId id;

    @ManyToOne()
//    @MapsId("idImpuesto")
    @JoinColumn(name = "idProducto")
    private Producto idProducto;


    @ManyToOne
//    @MapsId("idProductoEnVenta")
    @JoinColumn(name = "idModelo")
    private Modelo idModelo;


    public ProductoModelo() {
    }/*PostTag postTag = new PostTag(this, tag);
        tags.add(postTag);
        tag.getPosts().add(postTag);*/

    public ProductoModelo(Producto idProducto, Modelo idModelo) {
        this.idProducto = idProducto;
        this.idModelo = idModelo;
    }


    //    public BigDecimal getTotal(){
//        double tot = producto.getPrecio().doubleValue() * cantidad;
//        BigDecimal total = BigDecimal.valueOf(tot).setScale(2);
//        return total;
//    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


//    public ImpuestoProductoEnVentaId getId() {
//        return id;
//    }
//
//    public void setId(ImpuestoProductoEnVentaId id) {
//        this.id = id;
//    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Modelo getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelo idModelo) {
        this.idModelo = idModelo;
    }
}

