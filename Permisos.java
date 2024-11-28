import gestioninventario.Usuario;
import gestioninventario.Usuario.Rol;
public class Permisos {

    // Método para verificar si el usuario puede realizar una acción
    public static boolean puedeRealizarAccion(String accion, Usuario usuario) {
        if (usuario.getRol() == Usuario.Rol.ADMINISTRADOR) {
            return true; // Los administradores tienen acceso a todo
        }
        // Crear un usuario con todos los parámetros requeridos
        Usuario admin = new Usuario(1, "Nombre", "Apellido", "CC", "12345678", "Dirección", "1234567890", "admin@example.com", true, "admin123", Rol.ADMINISTRADOR);
        Usuario auxiliar = new Usuario(2, "Nombre", "Apellido", "CC", "12345678", "Dirección", "1234567890", "admin@example.com", true, "auxiliar123", Rol.AUXILIAR);


        if (admin.getRol() == Rol.ADMINISTRADOR) {
             System.out.println("El usuario es un Administrador.");
            }
        if (auxiliar.getRol() == Rol.AUXILIAR) {
    System.out.println("El usuario es un Auxiliar.");
}
        // Definir permisos para auxiliares
        if (usuario.getRol() == Usuario.Rol.AUXILIAR) {
            switch (accion) {
                case "CREAR_PRODUCTO":
                case "CREAR_PROVEEDOR":
                case "CREAR_MOVIMIENTO":
                case "EXPORTAR":
                    return true; // Acciones permitidas para auxiliares
                case "EDITAR_PRODUCTO":
                case "ELIMINAR_PRODUCTO":
                case "EDITAR_PROVEEDOR":
                case "ELIMINAR_PROVEEDOR":
                    return false; // Acciones restringidas para auxiliares
                default:
                    return false; // Acción desconocida, denegada por defecto
            }
        }

        return false; // Rol desconocido
    }
}