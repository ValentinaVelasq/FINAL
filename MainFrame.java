package gestioninventario;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame {

    private Usuario usuario;

    public MainFrame(Usuario usuario) {
        this.usuario = usuario;

        // Configuración del JFrame
        setTitle("Bienvenido");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel(new BorderLayout());

        // Mensaje de bienvenida
        JLabel welcomeLabel = new JLabel("Bienvenido, " + usuario.getNombre() + " " + usuario.getApellido(), SwingConstants.CENTER);
        panel.add(welcomeLabel, BorderLayout.CENTER);

        // Botón de cerrar sesión
        JButton logoutButton = new JButton("Cerrar sesión");
        panel.add(logoutButton, BorderLayout.SOUTH);

        // Añadir panel al JFrame
        add(panel);

        // Acción del botón "Cerrar sesión"
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFrame loginFrame = new LoginFrame(new UsuarioServicio());
                loginFrame.setVisible(true);
                dispose();  // Cerrar ventana principal
            }
        });
    }
}
