package ar.edu.unlp.info.escenario01;

public class Contexto {
	private ParidadStrategy strategy;

	public Contexto() {
		this.strategy = new ValidadorDeNumero();
	}

	public Boolean EsPar(int numero) {
		return this.strategy.esPar(numero);
	}
}