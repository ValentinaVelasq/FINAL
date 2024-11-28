package gestioninventario;

public class Pedido {
    private int idProducto;
    private int idProveedor;
    private int cantidad;
    private boolean procesado;

   public Pedido(int idProducto, String proveedor, int cantidad) {
        this.idProducto = idProducto;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
        this.procesado = false; 
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
    // Método para obtener el ID del proveedor según el nombre
private int obtenerIdProveedor(String nombreProveedor) {
    // Lógica para buscar el ID en base al nombre (puede ser un mapa o una consulta a la base de datos)
    if (nombreProveedor.equals("Proveedor A")) return 1;
    if (nombreProveedor.equals("Proveedor B")) return 2;
    return 0; // ID por defecto o no encontrado
}

// Llamada al constructor
Pedido pedido = new Pedido(producto.getId(), obtenerIdProveedor(producto.getProveedor()), cantidad);
}