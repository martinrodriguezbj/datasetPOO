package ar.edu.unlp.info.escenario03;

import java.util.ArrayList;

public class ContextoDeMezcla {
    private EstrategiaDeMezcla estrategia;

    public ContextoDeMezcla() {
        this.estrategia = new EstrategiaDeMezclaIntercalar();
    }

    public ArrayList<String> mezclarColecciones(ArrayList<String> coleccion1, ArrayList<String> coleccion2) {
        return this.estrategia.mezclar(coleccion1, coleccion2);
    }
}