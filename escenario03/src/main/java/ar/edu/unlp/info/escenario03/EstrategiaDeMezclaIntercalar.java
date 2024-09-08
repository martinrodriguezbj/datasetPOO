package ar.edu.unlp.info.escenario03;

import java.util.ArrayList;

public class EstrategiaDeMezclaIntercalar implements EstrategiaDeMezcla {

    @Override
    public ArrayList<String> mezclar(ArrayList<String> coleccion1, ArrayList<String> coleccion2) {
    	if (coleccion1.size() != coleccion2.size()) {
    		throw new IllegalArgumentException("Las colecciones deben tener la misma longitud");
    	} else if (coleccion1.size() <= 5) {
    		throw new IllegalArgumentException("Las colecciones deben tener longitud mayor a 5");
    	}
    	
    	ArrayList<String> listaMezclada = new ArrayList<>();
        int tamano = coleccion1.size();

        for (int i = 0; i < tamano; i++) {
            listaMezclada.add(coleccion1.get(i));
            listaMezclada.add(coleccion2.get(i));
        }
        return listaMezclada;
    }
}
