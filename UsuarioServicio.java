package gestioninventario;

import java.util.regex.Pattern;

public class UsuarioServicio {

    private UsuarioRepositorio usuarioRepositorio;
    //Constructor

    public UsuarioServicio() {
        this.usuarioRepositorio = new UsuarioRepositorio();
    }
    //Validar usuario

    public boolean validarUsuario(Usuario usuario, String password) {
        // Validar el formato del correo
        if (!validarEmail(usuario.getEmail())) {
            System.out.println("Correo electrónico no es válido.");
            return false;
        }
        //Validar contraseña
        if (!validarPassword(password)) {
            System.out.println("Contraseña no cumple con los requisitos.");
            return false;
        }

        System.out.println("Usuario validado correctamente.");
        return true;
    }

    private boolean validarEmail(String email) {
        // validar el formato del correo
        String regexEmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(regexEmail);
        return pattern.matcher(email).matches();
    }

    //validar la contraseña
    private boolean validarPassword(String password) {
        String regexPassword = "^.{6,}$";  // Al menos 6 caracteres de cualquier tipo
        Pattern pattern = Pattern.compile(regexPassword);
        return pattern.matcher(password).matches();
    }
    
    public Usuario obtenerUsuarioPorEmail(String email) {
        return UsuarioRepositorio.obtenerUsuarioPorEmail(email);
    }
}
