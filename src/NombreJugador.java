
public class NombreJugador {

    private String nombreAct;

    public void setNombre(String nombre) {
        nombreAct = nombre;
    }

    public String obtenerNombre() {
        if (nombreAct != "") {
            return nombreAct;
        } else {
            return "abc451";
        }

    }

}
