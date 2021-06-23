package odaca.entidades;

import javax.persistence.*;

@Entity
public class Ubicacion {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(length=2)
    private String nave;
    private int session;
    @Column(length=2)
    private String sesion;
    private int piso;
    private int rack;
    @Column(length=2)
    private String columna;
    private int fila;
    private String ubicacionNow;
    @ManyToOne()
//    @MapsId("idImpuesto")
    @JoinColumn(name = "idProducto")
    private Producto idProducto;
    private boolean disponible = false;

    public Ubicacion() {
    }

    public Ubicacion(String nave, int rack, String columna, int fila) {
        this.nave = nave;
        this.rack = rack;
        this.columna = columna;
        this.fila = fila;
        saveUbicacionNow();
    }

    public String getUbicacionNow(){

        return ubicacionNow;
    }

    public void setUbicacionNow(String ubicacionNow) {
        this.ubicacionNow = ubicacionNow;
    }

    private void saveUbicacionNow(){
        StringBuilder sb = new StringBuilder();
        sb.append(nave);
        sb.append(Integer.toString(rack));
        sb.append(columna);
        sb.append(Integer.toString(fila));
        this.ubicacionNow = sb.toString();
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNave() {
        return nave;
    }

    public void setNave(String nave) {
        this.nave = nave;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    public String getSesion() {
        return sesion;
    }

    public void setSesion(String sesion) {
        this.sesion = sesion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getRack() {
        return rack;
    }

    public void setRack(int rack) {
        this.rack = rack;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }
}
