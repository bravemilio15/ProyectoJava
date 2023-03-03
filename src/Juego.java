
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class Juego extends JPanel {

    ColoreadoLaberinto laberinto = new ColoreadoLaberinto();
    Personaje personaje = new Personaje();
    
    public static int nivel = 1;

    public Juego() { //Su Funcion es Detectar las teclas en todo momento 
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
               personaje.Movimiento(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        setFocusable(true);//Para que podamos seguir corriendolo
    }

    public void paint(Graphics grafico) { //pinta todo
        laberinto.paint(grafico);
        personaje.paint(grafico);
    }

    public static int cambiaNivel() {
        return nivel++;

    }

    public static int obtieneNivel() {
        return nivel;
    }
    



}
