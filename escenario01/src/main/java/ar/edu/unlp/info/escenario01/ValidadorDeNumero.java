package ar.edu.unlp.info.escenario01;

public class ValidadorDeNumero implements ParidadStrategy {

	@Override
	public Boolean esPar(int numero) {
		if (numero < 0) {
			throw new IllegalArgumentException("Número negativo no permitido");
		}
		return numero % 2 == 0;
	}
}