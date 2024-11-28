package gestioninventario;

import java.util.ArrayList;
import java.util.List;

public class InventarioServicio {
    private final ProductoServicio productoServicio;
    private final MovimientoServicio movimientoServicio;

    public InventarioServicio(ProductoServicio productoServicio, MovimientoServicio movimientoServicio) {
        this.productoServicio = productoServicio;
        this.movimientoServicio = movimientoServicio;
    }

    public List<Producto> consultarPorNombre(String nombre) {
        List<Producto> productos = productoServicio.obtenerTodosLosProductos();
        List<Producto> productosFiltrados = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }

    public List<Producto> consultarPorCategoria(String categoria) {
        List<Producto> productos = productoServicio.obtenerTodosLosProductos();
        List<Producto> productosFiltrados = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }

    public List<Producto> consultarTodoElInventario() {
        return productoServicio.obtenerTodosLosProductos();
    }
    // Método para calcular la cantidad disponible de un producto
    public List<String> consultarTodoElInventarioConCantidades() {
    List<String> inventarioConCantidades = new ArrayList<>();
    for (Producto producto : productoServicio.obtenerTodosLosProductos()) {
        int cantidadDisponible = calcularCantidadDisponible(producto);
        inventarioConCantidades.add(
            String.format("Producto: %s, Cantidad Disponible: %d", producto.getNombre(), cantidadDisponible)
        );
    }
    return inventarioConCantidades;
}

    private int calcularCantidadDisponible(Producto producto) {
        int cantidadEntradas = movimientoServicio.obtenerEntradasPorProducto(producto);
        int cantidadSalidas = movimientoServicio.obtenerSalidasPorProducto(producto);
        return cantidadEntradas - cantidadSalidas;
    }
}
