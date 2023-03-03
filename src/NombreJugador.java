
public class NombreJugador {

    private String nombreAct;

    public void setNombre(String nombre) {
        nombreAct = nombre;
    }

    public String obtenerNombre() { //SI es Nulo Nombra un default
        if (nombreAct != "") {
            return nombreAct;
        } else {
            return "abc451";
        }

    }

}
