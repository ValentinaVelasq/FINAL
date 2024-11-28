package gestioninventario;

public class Usuario {
    public enum Rol {
    ADMINISTRADOR, AUXILIAR; 
}
          private int id;
          private String nombre;
          private String apellido;
          private String tipoidentificacion;
          private String numerodocumento;
          private String direccion;
          private String telefono;
          private String email;
          private boolean estadoactivo;
          private String Password;
          private Rol rol;

        public Usuario(int id, String nombre, String apellido, String tipoidentificacion, String numerodocumento, String direccion, String telefono, String email, boolean estadoactivo, String password, Rol rol){
            this.id = id;
            this.nombre = nombre;
            this.apellido = apellido;
            this.tipoidentificacion = tipoidentificacion;
            this.numerodocumento = numerodocumento;
            this.direccion = direccion;
            this.telefono = telefono;
            this.email = email;
            this.estadoactivo = estadoactivo;
            this.Password = password;
            this.rol= rol; 
        }

           public int getId() {
            return id;}

            public void setId(int id) {
            this.id = id;}
    
           public String getNombre(){
               return nombre;}
    
           public void setNombre(String nombre){
               this.nombre =nombre;}
           
            public String getApellido(){
               return apellido;}
    
           public void setApellido(String apellido){
               this.apellido =apellido;}
           
             public String gettipoidentificacion(){
               return tipoidentificacion;}
    
           public void settipoidentificacion(String tipoidentificacion){
               this.tipoidentificacion =tipoidentificacion;}
           
            public String getnumerodocumento(){
               return numerodocumento;}
    
           public void setnumerodocumento(String numerodocumento){
               this.numerodocumento =numerodocumento;}
           
           public String getdireccion(){
               return direccion;}
    
           public void setdireccion(String direccion){
               this.direccion = direccion;}
           
            public String gettelefono(){
               return telefono;}
    
           public void settelefono(String telefono){
               this.telefono = telefono;}
           
           public String getEmail(){
               return email;}
    
           public void setEmail(String email){
               this.email = email;}
           
           public boolean getEstadoActivo(){
               return estadoactivo;}
    
           public void setEstadoActivo(boolean estadoactivo){
               this.estadoactivo = estadoactivo;}

            public String getPassword() {
                return Password; }

            public void setPassword(String Password) {
                this.Password = Password;}

            public Rol getRol() {
                 return rol;
                 }

             public void setRol(Rol rol) {
                this.rol = rol;
    }     
            
            @Override
                public String toString() {
                    return "Nombre: " + nombre + ", Correo: " + email+ ", Teléfono: " + telefono + ", Dirección: " + direccion + ", ID: " + id + ", Apellido" + apellido + ", Tipo de identificacion" + tipoidentificacion + ", Contraseña" + Password + ", Numero de identificacion" + numerodocumento  + ", Estado activo" + estadoactivo + ", Rol" + rol;}
}
