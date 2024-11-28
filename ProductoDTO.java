package gestioninventario;

public class ProductoDTO {
    private String nombre;
    private String categoria;
    private int cantidadDisponible;
    private double precio;

    public ProductoDTO(String nombre, String categoria, int cantidadDisponible, double precio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidadDisponible = cantidadDisponible;
        this.precio = precio;
    }
    @Override
    public String toString() {
        return String.format("Producto: %s | Categoría: %s | Cantidad disponible: %d | Precio: %.2f", 
                             nombre, categoria, cantidadDisponible, precio);
    }
}
