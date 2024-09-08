package ar.edu.unlp.info.escenario02;

public class LongitudMinimaStrategy implements ContraseñaStrategy {

    @Override
    public boolean esValida(String contraseña) {
        return contraseña.length() >= 10;
    }
}