package gestioninventario;
import java.util.Date;

public class Movimiento {
      private Producto producto;
    private int cantidad;
    private String tipoMovimiento; // "entrada" o "salida"
    private String motivo;
    private Date fecha;

    public Movimiento(Producto producto, int cantidad, String tipoMovimiento, String motivo, Date fecha) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.tipoMovimiento = tipoMovimiento;
        this.motivo = motivo;
        this.fecha = new Date();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    

    @Override
    public String toString() {
        return "Movimiento{" +
                "producto=" + producto.getNombre() +
                ", cantidad=" + cantidad +
                ", tipoMovimiento='" + tipoMovimiento + '\'' +
                ", motivo='" + motivo + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
