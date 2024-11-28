package gestioninventario;

import gestioninventario.Usuario.Rol;
import java.util.List;
import javax.swing.SwingUtilities;

public class GestionInventario {

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de gestión de inventario");

        // Crear un usuario con todos los parámetros requeridos
        Usuario admin = new Usuario(1, "Nombre", "Apellido", "CC", "12345678", "Dirección", "1234567890", "admin@example.com", true, "admin123", Rol.ADMINISTRADOR);
        Usuario auxiliar = new Usuario(2, "Nombre", "Apellido", "CC", "12345678", "Dirección", "1234567890", "auxiliar@example.com", true, "auxiliar123", Rol.AUXILIAR);

        // Crear servicios
        UsuarioServicio usuarioServicio = new UsuarioServicio();
        ProductoServicio productoServicio = new ProductoServicio();
        MovimientoServicio movimientoServicio = new MovimientoServicio();
        InventarioServicio inventarioServicio = new InventarioServicio(productoServicio, movimientoServicio);
        ProveedorServicio proveedorServicio = new ProveedorServicio();

        SwingUtilities.invokeLater(() -> {
            // Mostrar la pantalla de login
            LoginFrame login = new LoginFrame(usuarioServicio);
            login.setVisible(true);

            // Crear productos
            Producto producto1 = new Producto(1, "Llantas", "Automotriz", 250, 143000, "2024-12-31", 1,1,1,1);
            Producto producto2 = new Producto(2, "Rines", "Automotriz", 12, 150000, "2025-01-15", 2,2,2,2);

            // Agregar productos al inventario
            productoServicio.agregarProducto(producto1);
            productoServicio.agregarProducto(producto2);

            // Exportar todo el inventario a un archivo CSV
            productoServicio.exportarInventarioACSV("inventario.csv");

            // Registrar un movimiento (entrada) para un producto
            movimientoServicio.registrarMovimiento(producto1, 4, "entrada", "Se ingresan 4 unidades de llantas.");
            System.out.println("Movimiento registrado: Entrada de 4 llantas");

            // Consultar inventario por nombre
            System.out.println("\nConsulta por nombre: Llantas");
            List<Producto> productosPorNombre = inventarioServicio.consultarPorNombre("Llantas");
            productosPorNombre.forEach(producto -> System.out.println(producto.getNombre() + ", Cantidad: " + producto.getCantidad()));

            // Consultar inventario por categoría
            System.out.println("\nConsulta por categoría: Automotriz");
            List<Producto> productosPorCategoria = inventarioServicio.consultarPorCategoria("Automotriz");
            productosPorCategoria.forEach(producto -> System.out.println(producto.getNombre() + ", Cantidad: " + producto.getCantidad()));

            // Consultar todo el inventario
            System.out.println("\nTodo el inventario:");
            List<Producto> todosLosProductos = inventarioServicio.consultarTodoElInventario();
            todosLosProductos.forEach(producto -> System.out.println(producto.getNombre() + ", Cantidad: " + producto.getCantidad()));

            // Crear y agregar proveedores
            Proveedor proveedor1 = new Proveedor(1, "Proveedor A", "Calle 1", "123456789");
            Proveedor proveedor2 = new Proveedor(2, "Proveedor B", "Calle 2", "987654321");
            proveedorServicio.agregarProveedor(proveedor1);
            proveedorServicio.agregarProveedor(proveedor2);

            // Consultar todos los proveedores
            System.out.println("\nProveedores:");
            proveedorServicio.obtenerTodosLosProveedores().forEach(System.out::println);

            // Actualizar un proveedor
            proveedor1.setNombre("Proveedor A Actualizado");
            proveedorServicio.actualizarProveedor(proveedor1);

            // Consultar un proveedor por ID
            Proveedor proveedorConsultado = proveedorServicio.obtenerProveedor(1);
            System.out.println("\nProveedor consultado:");
            System.out.println(proveedorConsultado);

            // Eliminar un proveedor
            proveedorServicio.eliminarProveedor(2);
            System.out.println("\nProveedores después de eliminar:");
            proveedorServicio.obtenerTodosLosProveedores().forEach(System.out::println);
        });
    }
}