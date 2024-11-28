package gestioninventario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovimientoServicio {
     private final List<Movimiento> movimientos;

    public MovimientoServicio() {
        this.movimientos = new ArrayList<>();
    }

    public void registrarMovimiento(Producto producto, int cantidad, String tipoMovimiento, String motivo) {
        Movimiento movimiento = new Movimiento(producto, cantidad, tipoMovimiento, motivo, new Date());
        movimientos.add(movimiento);
        System.out.println("Movimiento registrado: " + movimiento);
    }

    public List<Movimiento> obtenerMovimientos() {
        return movimientos;
    }
    public int obtenerEntradasPorProducto(Producto producto) {
    // Lógica para contar las entradas de este producto desde los movimientos registrados
    int entradas = 0;
    for (Movimiento movimiento : movimientos) {
        if (movimiento.getProducto().equals(producto) && movimiento.getTipoMovimiento().equals("entrada")) {
            entradas += movimiento.getCantidad();
        }
    }
    return entradas;
}

public int obtenerSalidasPorProducto(Producto producto) {
    // Lógica para contar las salidas de este producto desde los movimientos registrados
    int salidas = 0;
    for (Movimiento movimiento : movimientos) {
        if (movimiento.getProducto().equals(producto) && movimiento.getTipoMovimiento().equals("salida")) {
            salidas += movimiento.getCantidad();
        }
    }
    return salidas;
}
}
