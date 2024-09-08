package ar.edu.unlp.info.escenario08;

public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public boolean retirar(double monto) {
        if (monto > this.saldo) {
            return false;
        }
        else
            this.saldo -= monto;
            return true;
    }

    public double getSaldo() {
        return this.saldo;
    }
}