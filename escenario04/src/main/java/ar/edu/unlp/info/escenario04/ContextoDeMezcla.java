package ar.edu.unlp.info.escenario04;

import java.util.ArrayList;

public class ContextoDeMezcla {
    private EstrategiaDeMezcla estrategia;

    public void establecerEstrategia(EstrategiaDeMezcla estrategia) {
        this.estrategia = estrategia;
    }

    public ArrayList<String> mezclarColecciones(ArrayList<String> coleccion1, ArrayList<String> coleccion2) {
        return this.estrategia.mezclar(coleccion1, coleccion2);
    }
}
