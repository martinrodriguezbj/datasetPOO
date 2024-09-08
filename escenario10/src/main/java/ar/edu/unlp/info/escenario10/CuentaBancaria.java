package ar.edu.unlp.info.escenario10;

public class CuentaBancaria {
    private double saldo;
    private double costoMantenimiento;

    public CuentaBancaria(double saldoInicial, double costoMantenimiento) {
        this.saldo = saldoInicial;
        this.costoMantenimiento = costoMantenimiento;
    }

    public boolean cobrarMantenimiento() {
        if (this.costoMantenimiento > saldo) {
            return false;
        }
        this.saldo -= costoMantenimiento;
        return true;
        }

    public double getSaldo() {
        return this.saldo;
    }
}