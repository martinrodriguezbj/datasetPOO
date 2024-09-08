package ar.edu.unlp.info.escenario06;

public class EnRango{
    private int valor;

    public EnRango(int valor){
        this.valor = valor;
    }

    public boolean estaEnRango(){
        return (this.valor >= 50 && this.valor <= 100);
    }

}