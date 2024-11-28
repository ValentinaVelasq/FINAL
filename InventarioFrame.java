package gestioninventario;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class InventarioFrame extends JFrame {
    private final ArrayList<Producto> productos; // Lista para almacenar productos
    private final ArrayList<String> movimientos; // Lista para almacenar movimientos

    public InventarioFrame() {
        productos = new ArrayList<>();
        movimientos = new ArrayList<>();
        setTitle("Gestión de Inventario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear botones para acciones de inventario
        JButton btnAgregarExistencias = new JButton("Agregar Existencias");
        JButton btnDisminuirExistencias = new JButton("Disminuir Existencias");
        JButton btnVerMovimientos = new JButton("Ver Movimientos");
        JButton btnVerInventario = new JButton("Ver Inventario");

        // Panel para los botones
        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(btnAgregarExistencias);
        panel.add(btnDisminuirExistencias);
        panel.add(btnVerMovimientos);
        panel.add(btnVerInventario);
        
        add(panel);

        btnAgregarExistencias.addActionListener(e -> mostrarFormularioAgregarProducto());

        btnDisminuirExistencias.addActionListener(e -> mostrarFormularioDisminuirExistencias());

        btnVerMovimientos.addActionListener(e -> mostrarMovimientos());

        btnVerInventario.addActionListener(e -> mostrarInventario());
    }

    private void mostrarFormularioAgregarProducto() {
        JFrame frame = new JFrame("Agregar Producto");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(this);
        
        // Crear campos de entrada
        JTextField txtNombre = new JTextField();
        JTextField txtCategoria = new JTextField();
        JTextField txtCantidad = new JTextField();
        JTextField txtPrecio = new JTextField();
        
        // Crear un botón para agregar el producto
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String categoria = txtCategoria.getText();
            int cantidad = Integer.parseInt(txtCantidad.getText());
            double precio = Double.parseDouble(txtPrecio.getText());

            productos.add(new Producto(nombre, categoria, cantidad, precio));
            movimientos.add("Agregado: " + nombre + ", Cantidad: " + cantidad);
            frame.dispose();
            mostrarInventario();
        });
        
        // Panel para los campos
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Categoría:"));
        panel.add(txtCategoria);
        panel.add(new JLabel("Cantidad Disponible:"));
        panel.add(txtCantidad);
        panel.add(new JLabel("Precio:"));
        panel.add(txtPrecio);
        panel.add(new JLabel("")); // Espacio vacío
        panel.add(btnAgregar);
        
        frame.add(panel);
        frame.setVisible(true);
    }

    private void mostrarFormularioDisminuirExistencias() {
        JFrame frame = new JFrame("Disminuir Existencias");
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(this);
        
        JTextField txtNombre = new JTextField();
        JTextField txtCantidad = new JTextField();
        
        JButton btnDisminuir = new JButton("Disminuir");
        btnDisminuir.addActionListener(e -> {
            String nombre = txtNombre.getText();
            int cantidad = Integer.parseInt(txtCantidad.getText());
            for (Producto producto : productos) {
                if (producto.getNombre().equals(nombre)) {
                    producto.disminuirExistencias(cantidad);
                    movimientos.add("Disminuido: " + nombre + ", Cantidad: " + cantidad);
                    break;
                }
            }
            frame.dispose();
            mostrarInventario();
        });
        
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Nombre del Producto:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Cantidad a Disminuir:"));
        panel.add(txtCantidad);
        panel.add(new JLabel("")); // Espacio vacío
        panel.add(btnDisminuir);
        
        frame.add(panel);
        frame.setVisible(true);
    }

    private void mostrarMovimientos() {
        JFrame frame = new JFrame("Ver Movimientos");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(this);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        
        for (String movimiento : movimientos) {
            textArea.append(movimiento + "\n");
        }

        frame.add(new JScrollPane(textArea));
        frame.setVisible(true);
    }

    private void mostrarInventario() {
        JFrame frame = new JFrame("Inventario");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(this);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        
        for (Producto producto : productos) {
            textArea.append(producto.toString() + "\n");
        }

        frame.add(new JScrollPane(textArea));
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InventarioFrame inventarioFrame = new InventarioFrame();
            inventarioFrame.setVisible(true);
        });
    }

    private static class Producto {
        private final String nombre;
        private final String categoria;
        private int cantidadDisponible;
        private final double precio;

        public Producto(String nombre, String categoria, int cantidadDisponible, double precio) {
            this.nombre = nombre;
            this.categoria = categoria;
            this.cantidadDisponible = cantidadDisponible;
            this.precio = precio;
        }

        public String getNombre() {
            return nombre;
        }

        public void disminuirExistencias(int cantidad) {
            if (cantidadDisponible >= cantidad) {
                cantidadDisponible -= cantidad;
            } else {
                JOptionPane.showMessageDialog(null, "No hay suficientes existencias para disminuir.");
            }
        }

        @Override
        public String toString() {
            return String.format("Nombre: %s, Categoría: %s, Cantidad: %d, Precio: %.2f", 
                nombre, categoria, cantidadDisponible, precio);
        }
    }
}