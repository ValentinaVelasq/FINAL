package gestioninventario;

public class UsuarioRepositorio {
        
         private static Usuario[] usuarios = new Usuario[100];  // Array estático
         private static int contador = 0; 
         static  {
         Usuario user= new Usuario();
         user.setApellido("Velasquez");
         user.setEmail("valentina@gmail.com");
         user.setEstadoActivo(true);
         user.setId(1);
         user.setNombre("Valentina");
         user.setdireccion("15hg");
         user.settelefono("35");
         user.settipoidentificacion("14d");
         user.setnumerodocumento("4");
         user.setPassword("Valentina16");
         
         crearUsuario(user);
                 
}
         
        //CREAR NUEVO USUARIO
        public static void crearUsuario(Usuario usuario) {
        if (contador < usuarios.length) {
            usuarios[contador] = usuario;
            contador++;
            System.out.println("Usuario creado correctamente.");
        } else {
            System.out.println("No se pueden agregar más usuarios, el array está lleno.");
        }
    }
        //MODIFICAR EL USUARIO
        public static void modificarUsuario(Usuario usuarioModificado) {
        for (int i = 0; i < contador; i++) {
            if (usuarios[i].getEmail().equals(usuarioModificado.getEmail())) {
                usuarios[i] = usuarioModificado;
                System.out.println("Usuario modificado correctamente.");
                return;
            }
        }
        System.out.println("Usuario no encontrado.");
    }
        //Usuario por correo electronico
        public static Usuario obtenerUsuarioPorEmail(String email) {
        for (int i = 0; i < contador; i++) {
            if (usuarios[i].getEmail().equals(email)) {
                return usuarios[i];
            }
        }
        return null;  // Usuario no encontrado
    }
        //Lista de usuarios
        public static Usuario[] obtenerListadoUsuarios() {
        Usuario[] usuariosListado = new Usuario[contador];
        System.arraycopy(usuarios, 0, usuariosListado, 0, contador);// Copiar los usuarios agregados en el array statico
        return usuariosListado;
    }
        //Activar un usuario
        public static void activarUsuario(String email) {
        Usuario usuario = obtenerUsuarioPorEmail(email);
        if (usuario != null) {
            usuario.setEstadoActivo(true);
            System.out.println("Usuario activado.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }
            //Inactivar un usuario
        public static void inactivarUsuario(String email) {
        Usuario usuario = obtenerUsuarioPorEmail(email);
        if (usuario != null) {
            usuario.setEstadoActivo(false);
            System.out.println("Usuario inactivado.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }
}  

