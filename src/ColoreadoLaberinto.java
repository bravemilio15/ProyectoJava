
import java.awt.Color;
import java.awt.Graphics;

public class ColoreadoLaberinto {

    Laberintos generarLaberintos  = new Laberintos();
    
    private int fila = 0;
    private int columna = 0;
    private final int nFilas = 13;
    private final int nColumnas = 23;
    private final int anchoBloque = 40;
    private final int altoBloque = 40;



    public void paint(Graphics grafico) { //Pinta todo el mapa segun la informacion recibida.
        int[][] laberinto = generarLaberintos.obtieneLaberinto();

        for (fila = 0; fila < nFilas; fila++) {
            for (columna = 0; columna < nColumnas; columna++) {
                if (laberinto[fila][columna] == 1) {
                    if (Juego.obtieneNivel() == 1) {
                        grafico.setColor(Color.darkGray);
                    }
                    if (Juego.obtieneNivel() == 2) {
                        grafico.setColor(Color.pink);
                    }
                    if (Juego.obtieneNivel() == 3) {
                        grafico.setColor(Color.green);
                    }
                    if (Juego.obtieneNivel() == 4) {
                        grafico.setColor(Color.red);
                    }

                    grafico.fillRect(columna * 40, fila * 40, anchoBloque, altoBloque);
                    grafico.setColor(Color.black);
                    grafico.drawRect(columna * 40, fila * 40, anchoBloque, altoBloque);
                }
            }
        }
        grafico.drawString("inicio", 5, 62);
        grafico.drawString("Fin", 850, 462);
    }


}
