package gestioninventario;

public class Pedido {
    private int idProducto;
    private int idProveedor;
    private int cantidad;
    private boolean procesado;

    public Pedido(int cantidad, int idProducto, int idProveedor, boolean procesado) {
        this.cantidad = cantidad;
        this.idProducto = idProducto;
        this.idProveedor = idProveedor;
        this.procesado = procesado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isProcesado() {
        return procesado;
    }

    public void setProcesado(boolean procesado) {
        this.procesado = procesado;
    }
}