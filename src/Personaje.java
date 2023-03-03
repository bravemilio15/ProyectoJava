
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Personaje {

    ColoreadoLaberinto lab = new ColoreadoLaberinto();//Sirve para Obtener la Matriz del laberinto

    private int x = 40;
    private int y = 40;
    private final int ancho = 40;
    private final int alto = 40;
    private final int movimiento = 40;

    public void paint(Graphics grafico) {//El Circulo su Color y su Tamaño

        grafico.setColor(Color.blue);
        grafico.fillOval(x, y, ancho, alto);
        grafico.setColor(Color.black);
        grafico.drawOval(x, y, ancho, alto);

        //Ojos
        grafico.setColor(Color.white);
        grafico.fillOval(x + 7, y + 9, 13, 13);
        grafico.fillOval(x + 21, y + 9, 13, 13);
        grafico.setColor(Color.black);
        grafico.fillOval(x + 11, y + 12, 5, 5);
        grafico.fillOval(x + 25, y + 12, 5, 5);

        //Boca
        grafico.setColor(Color.black);
        grafico.fillOval(x + 7, y + 24, 27, 7);

    }

    /*El X Funcionaria para alterar el movimiento hacia la izquierda y la derecha
     Al igual que en un Plano Carteasiao y de Igual Forma la Y serviria con arriba
     y Abajo
     */
    public void Movimiento(KeyEvent evento) {//detecta las TeclasPresionadas 

        int[][] laberinto = lab.generarLaberintos.obtieneLaberinto();

        int tecla = evento.getKeyCode();

        if (evento.getKeyCode() == 37) { //La Tecla 37 Equivale a la Izquierda
            if (laberinto[y / 40][(x / 40) - 1] != 1) {
                x = x - movimiento;
            }
        }
        if (evento.getKeyCode() == 39) { //La Tecla 39 Equivale a la  Derecha
            if (laberinto[y / 40][(x / 40) + 1] != 1) {
                x = x + movimiento;
            }

        }
        if (evento.getKeyCode() == 40) { //La Tecla 40 Equivale a la  Abajo
            if (laberinto[(y / 40) + 1][x / 40] != 1) {
                y = y + movimiento;
            }
        }
        if (evento.getKeyCode() == 38) { //La Tecla 38 Equivale a la  Arriba
            if (laberinto[(y / 40) - 1][x / 40] != 1) {
                y = y - movimiento;
            }
        }

        //si llega al final
        if (x == 840 && y == 440) {
            Juego.cambiaNivel();
            x = 40;
            y = 40;

        }

    }

}
