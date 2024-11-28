package gestioninventario;
import java.util.List;

public class ProveedorServicio {
private ProveedorRepositorio proveedorRepositorio;

    // Constructor
    public ProveedorServicio() {
        this.proveedorRepositorio = new ProveedorRepositorio();
    }

    // Agregar proveedor
    public void agregarProveedor(Proveedor proveedor) {
        proveedorRepositorio.agregarProveedor(proveedor);
    }

    // Obtener proveedor por ID
    public Proveedor obtenerProveedor(int id) {
        return proveedorRepositorio.obtenerProveedor(id);
    }

    // Obtener todos los proveedores
    public List<Proveedor> obtenerTodosLosProveedores() {
        return proveedorRepositorio.obtenerTodosLosProveedores();
    }

    // Actualizar proveedor
    public void actualizarProveedor(Proveedor proveedor) {
        proveedorRepositorio.actualizarProveedor(proveedor);
    }

    // Eliminar proveedor
    public void eliminarProveedor(int id) {
        proveedorRepositorio.eliminarProveedor(id);
    }    
}
