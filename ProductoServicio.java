package gestioninventario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ProductoServicio {
    private List<Producto> productos;
    private final ProductoRepositorio repositorio;

    public ProductoServicio() {
        this.repositorio = new ProductoRepositorio();
    }

    public void agregarProducto(Producto producto) {
        repositorio.crearProducto(producto);
    }

    public Producto obtenerProductoPorId(int id) {
        return repositorio.obtenerProductoPorId(id);
    }

    public void listarProductos() {
        repositorio.obtenerTodosLosProductos().forEach(System.out::println);
    }

    public void actualizarProducto(Producto producto) {
        repositorio.actualizarProducto(producto);
    }

    public void eliminarProducto(int id) {
        repositorio.eliminarProducto(id);
    }
    
    public List<Producto> obtenerTodosLosProductos() {
    return new ArrayList<>(productos);}

    public void vincularProveedor(int idProducto, String proveedor) {
        Producto producto = obtenerProductoPorId(idProducto);
        if (producto != null) {
            producto.setProveedor(proveedor);
            System.out.println("Proveedor vinculado al producto: " + producto.getNombre());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
    public void exportarInventarioACSV(String nombreArchivo) {
    try (FileWriter writer = new FileWriter(nombreArchivo)) {
        // Escribir encabezados
        writer.write("id,nombre,categoria,cantidad,precioUnitario,fechaExpiracion,proveedor,costoPromedio,costoTotal\n");

        // Escribir los datos de cada producto
        for (Producto producto : productos) { // Asegúrate de que `productos` sea la lista en tu clase ProductoServicio
            String linea = String.format("%d,%s,%s,%d,%.2f,%s,%s,%.2f,%.2f\n",
                producto.getId(),
                producto.getNombre(),
                producto.getCategoria(),
                producto.getCantidad(),
                producto.getPrecioUnitario(),
                producto.getFechaExpiracion(),
                producto.getProveedor(),
                producto.getCostoPromedio(),
                producto.getCantidad() * producto.getCostoPromedio());
            writer.write(linea);
        }
        System.out.println("Inventario exportado exitosamente a " + nombreArchivo);
    } catch (IOException e) {
        System.err.println("Error al exportar el inventario: " + e.getMessage());
    }
}
public void verificarStock() {
        for (Producto producto : productos) {
            if (producto.getCantidad() < producto.getStockMinimo()) {
                System.out.println("Alerta: El stock del producto " + producto.getNombre() + " está por debajo del mínimo.");
                generarPedidoAutomatico(producto);
            }
        }
    }

   private void generarPedidoAutomatico(Producto producto) {
    // Calcular cantidad necesaria
    int cantidadNecesaria = producto.getStockMaximo() - producto.getCantidad();
    System.out.println("Generando pedido automático para " + producto.getNombre() + " por " + cantidadNecesaria + " unidades.");

    // Crear un nuevo pedido
    Pedido pedido = new Pedido(producto.getId(), producto.getProveedor(), cantidadNecesaria);
    // Registrar el pedido utilizando el servicio adecuado
    PedidoServicio.registrarPedido(pedido);
}
public void recibirPedido(Pedido pedido) {
    Producto producto = buscarProductoPorId(pedido.getIdProducto());
    if (producto != null) {
        producto.setCantidad(producto.getCantidad() + pedido.getCantidad());
        // Llamada corregida a registrarMovimiento
        MovimientoServicio movimientoServicio = new MovimientoServicio();
        movimientoServicio.registrarMovimiento(producto, cantidad, "compra proveedor", "Recepción de pedido");
        PedidoServicio.marcarPedidoProcesado(pedido);
        System.out.println("Pedido recibido y procesado.");
    }
}
}