package ar.edu.unlp.info.escenario09;

public class CuentaBancaria {
    private double saldo;
    private double costoMantenimiento;

    public CuentaBancaria(double saldoInicial, double costoMantenimiento) {
        this.saldo = saldoInicial;
        this.costoMantenimiento = costoMantenimiento;
    }

    public boolean cobrarMantenimiento() {
        if (this.costoMantenimiento > this.saldo) {
            throw new IllegalArgumentException("Fondos insuficientes");
        }
        this.saldo -= costoMantenimiento;
        return true;
    }

    public double getSaldo() {
        return this.saldo;
    }
}