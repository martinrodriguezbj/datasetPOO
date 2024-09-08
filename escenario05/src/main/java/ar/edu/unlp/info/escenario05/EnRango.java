package ar.edu.unlp.info.escenario05;

public class EnRango{
    private int valor;

    public EnRango(int valor){
        this.valor = valor;
    }

    public boolean estaEnRango(){
        if(this.valor >= 50 && this.valor <= 100){
            return true;
        }else{
            throw new IllegalArgumentException("El valor no está en el rango");
        }
    }
}