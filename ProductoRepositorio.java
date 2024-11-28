package gestioninventario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductoRepositorio {
 private static final List<Producto> productos = new ArrayList<>();
 private static final List<MovimientoInventario> movimientos = new ArrayList<>();

    public static void crearProducto(Producto producto) {
        productos.add(producto);
        System.out.println("Producto agregado: " + producto.getNombre());
    }

    public static Producto obtenerProductoPorId(int id) {
        return productos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static List<Producto> obtenerTodosLosProductos() {
        return null;
    }

    public static void actualizarProducto(Producto productoActualizado) {
        Producto productoExistente = obtenerProductoPorId(productoActualizado.getId());
        if (productoExistente != null) {
            productos.set(productos.indexOf(productoExistente), productoActualizado);
            System.out.println("Producto actualizado: " + productoActualizado.getNombre());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public static void eliminarProducto(int id) {
        productos.removeIf(p -> p.getId() == id);
        System.out.println("Producto con ID " + id + " eliminado.");
    }
    
    public static void adicionarExistencias(int idProducto, int cantidad, String motivo) {
        Producto producto = obtenerProductoPorId(idProducto);
        if (producto != null) {
            producto.setCantidad(producto.getCantidad() + cantidad);
            MovimientoInventario movimiento = new MovimientoInventario(new Date(), "ADICION", cantidad, motivo, producto);
            movimientos.add(movimiento);
            System.out.println("Existencias añadidas: " + cantidad + " al producto " + producto.getNombre());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public static void disminuirExistencias(int idProducto, int cantidad, String motivo) {
        Producto producto = obtenerProductoPorId(idProducto);
        if (producto != null && producto.getCantidad() >= cantidad) {
            producto.setCantidad(producto.getCantidad() - cantidad);
            MovimientoInventario movimiento = new MovimientoInventario(new Date(), "DISMINUCION", cantidad, motivo, producto);
            movimientos.add(movimiento);
            System.out.println("Existencias disminuidas: " + cantidad + " del producto " + producto.getNombre());
        } else {
            System.out.println("Producto no encontrado o cantidad insuficiente.");
        }
    }

    public static List<MovimientoInventario> obtenerMovimientos() {
        return new ArrayList<>(movimientos);
    }
    public static void mostrarMovimientos() {
    obtenerMovimientos().forEach(System.out::println);
}
}   
