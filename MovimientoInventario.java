package gestioninventario;
import java.util.Date;

public class MovimientoInventario {
     private Date fecha;
    private String tipoMovimiento; // "ADICION" o "DISMINUCION"
    private int cantidad;
    private String motivo;
    private Producto producto; 

    public MovimientoInventario(Date fecha, String tipoMovimiento, int cantidad, String motivo, Producto producto) {
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidad = cantidad;
        this.motivo = motivo;
        this.producto = producto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
        @Override
    public String toString() {
        return "MovimientoInventario{" +
                "Fecha=" + fecha +
                ", Tipo de Movimiento='" + tipoMovimiento + '\'' +
                ", Cantidad=" + cantidad +
                ", Motivo='" + motivo + '\'' +
                ", Producto='" + producto.getNombre() + '\'' +
                '}';
    }
}
