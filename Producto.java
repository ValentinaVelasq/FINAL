package gestioninventario;

public class Producto {
    private int id;
    private String nombre;
    private String categoria;
    private int cantidad;
    private double precioUnitario;
    private String fechaExpiracion;
    private String proveedor;
    private final double costoPromedio;
    private final double costoTotal;
    private int stockMinimo;
    private int stockMaximo;
    private int IdProveedor;

    public Producto(int id, String nombre, String categoria, int cantidad, double precioUnitario, String fechaExpiracion, double costoPromedio, int stockMinimo, int stockMaximo, int IdProveedor) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.fechaExpiracion = fechaExpiracion;
        this.costoPromedio = costoPromedio;
        this.costoTotal = cantidad * costoPromedio;
        this.stockMaximo = stockMaximo;
        this.stockMinimo = stockMinimo;
        this.IdProveedor = IdProveedor; 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public double getCostoPromedio() {
    return costoPromedio;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

     public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(int stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public int getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.IdProveedor = idProveedor;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "ID=" + id +
                ", Nombre='" + nombre + '\'' +
                ", Categoría='" + categoria + '\'' +
                ", Cantidad=" + cantidad +
                ", Precio Unitario=" + precioUnitario +
                ", Fecha de Expiración=" + fechaExpiracion +
                ", Proveedor='" + proveedor + '\'' +
                ", costoTotal='" + costoTotal + '\'' +
                ", costoPromedio='" + costoPromedio +
                ", StockMinimo='" + stockMinimo + '\'' +
                ", StockMaximo='" + stockMaximo;
    }
}
