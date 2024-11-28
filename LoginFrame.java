package gestioninventario;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends javax.swing.JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;
    private final UsuarioServicio usuarioServicio;

    public LoginFrame(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;

        setTitle("Login");// Configuracion del JFrame
        setSize(350, 250);
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));// Panel principal

        JLabel emailLabel = new JLabel("Correo:");  // Componentes de la interfaz
        emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Ingresar");

        panel.add(emailLabel);    // Añadir componentes al panel
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());  // Espacio vacío
        panel.add(loginButton);

        add(panel);

        // Accion del boton "Ingresar"
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                Usuario usuario = usuarioServicio.obtenerUsuarioPorEmail(email);
                if (usuario != null && usuarioServicio.validarUsuario(usuario, password)) {
                    // Usuario validado correctamente
                    MainFrame mainFrame = new MainFrame(usuario);
                    mainFrame.setVisible(true);
                    dispose();  // Cierra ventana del login
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    }
   