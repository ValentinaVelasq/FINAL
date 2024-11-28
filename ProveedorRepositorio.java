package gestioninventario;
import java.util.ArrayList;
import java.util.List;

public class ProveedorRepositorio {
 private List<Proveedor> proveedores;

    public ProveedorRepositorio() {
        this.proveedores = new ArrayList<>();
    }
    
    public void agregarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    // Leer proveedor por ID
    public Proveedor obtenerProveedor(int id) {
        return proveedores.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    // Leer todos los proveedores
    public List<Proveedor> obtenerTodosLosProveedores() {
        return new ArrayList<>(proveedores);
    }

    // Actualizar proveedor
    public void actualizarProveedor(Proveedor proveedorActualizado) {
        Proveedor proveedor = obtenerProveedor(proveedorActualizado.getId());
        if (proveedor != null) {
            proveedor.setNombre(proveedorActualizado.getNombre());
            proveedor.setDireccion(proveedorActualizado.getDireccion());
            proveedor.setTelefono(proveedorActualizado.getTelefono());
        }
    }

    // Eliminar proveedor
    public void eliminarProveedor(int id) {
        proveedores.removeIf(p -> p.getId() == id);
    }
}
