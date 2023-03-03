
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class Puntuacion {

    private int tiempo;
    private Timer timer;

    public Puntuacion() {
        tiempo = 0;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tiempo++;
            }
        });
    }

    public int getTiempo() {
        return tiempo;
    }

    public void iniciar() {
        tiempo = 0;
        timer.start();
    }

    public void detener() {
        timer.stop();
    }

    public  int calcularPuntuacion() {
        return tiempo * tiempo;
    }
}
