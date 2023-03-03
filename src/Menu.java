
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu extends JFrame {

    
    //Creo instancias de los botones del Menu 
    private static Menu instance;
    private JButton btnStart;
    private JButton btnSalir;
    private Puntuacion puntuacion;

    public Menu() {
        super("ProyectoU3");
        instance = this;

        // Crear los componentes
        btnStart = new JButton("Start");
        btnSalir = new JButton("Exit");

        // Crear un JLabel para mostrar la imagen del laberinto
        ImageIcon imagenLaberinto = new ImageIcon("C:\\Users\\brave\\Documents\\NetBeansProjects\\ProyectoFuncionalU3JavaLaberinto\\src\\Imagenes\\fondo.png");
        JLabel labelLaberinto = new JLabel(imagenLaberinto);

        // Crear un JLabel para mostrar la segunda imagen
        ImageIcon imagenSegunda = new ImageIcon("C:\\Users\\brave\\Documents\\NetBeansProjects\\ProyectoFuncionalU3JavaLaberinto\\src\\Imagenes\\laberinto.png");
        JLabel labelSegunda = new JLabel(imagenSegunda);

        // Agregar los componentes al panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); // Establecer el layout como horizontal
        panel.add(Box.createHorizontalGlue()); // Agregar un filler a la izquierda para empujar los botones al centro
        panel.add(btnStart);
        panel.add(Box.createHorizontalGlue()); // Agregar un filler a la derecha para empujar los botones al centro
        panel.add(btnSalir);
        panel.add(Box.createHorizontalGlue()); // Agregar otro filler al final para mantener los botones centrados si se redimensiona el frame

        // Agregar los componentes al frame
        add(labelLaberinto, BorderLayout.CENTER);
        add(labelSegunda, BorderLayout.NORTH);
        add(panel, BorderLayout.SOUTH);

        puntuacion = new Puntuacion();

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                puntuacion.iniciar();
            }
        });

        // Configurar el tamaño y la posición del frame
        setSize(new Dimension(400, 400)); // Cambiar el tamaño para acomodar las imágenes
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addStartButtonActionListener(ActionListener listener) {
        btnStart.addActionListener(listener);
    }

    public void addExitButtonActionListener(ActionListener listener) {
        btnSalir.addActionListener(listener);
    }

    public static Menu getInstance() {
        return instance;
    }

    public String solicitarNombre() {
        return JOptionPane.showInputDialog(this, "Ingrese su nombre:", "Felicidades", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        Menu frame = new Menu();
        JFrame ventana = new JFrame("Laberinto");
        Juego juego = new Juego();
        PostgresConnection conex = new PostgresConnection();

        // Agregar comportamiento al botón Start
        frame.addStartButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.add(juego);
                ventana.setSize(920, 540);
                ventana.setLocation(300, 100);
                ventana.setVisible(true);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(false);

            }
        });

        // Agregar comportamiento al botón Exit
        frame.addExitButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            ventana.repaint();

            if (juego.obtieneNivel() > 1) {
                int puntuacionActual = Menu.getInstance().puntuacion.calcularPuntuacion();
                int tiempoActual = Menu.getInstance().puntuacion.getTiempo();
                String nombre = frame.solicitarNombre();

                conex.conexion(puntuacionActual, tiempoActual, nombre);

                JOptionPane.showMessageDialog(null, "Gracias por Jugar\nTu puntuación lograda  es: " + puntuacionActual);

                System.exit(0);
            }
        }

    }
}
