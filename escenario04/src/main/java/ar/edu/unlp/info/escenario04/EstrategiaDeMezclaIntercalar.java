package ar.edu.unlp.info.escenario04;

import java.util.ArrayList;
import java.util.Arrays;

public class EstrategiaDeMezclaIntercalar implements EstrategiaDeMezcla {

    @Override
    public ArrayList<String> mezclar(ArrayList<String> coleccion1, ArrayList<String> coleccion2) {
    	if (coleccion1.size() != coleccion2.size() || coleccion1.size() <= 5) {
    		return new ArrayList<>(Arrays.asList("-1"));
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