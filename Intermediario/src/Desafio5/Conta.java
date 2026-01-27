package Desafio5;

public interface Conta {

    void depositar(double valorDeposito);

    double consultarSaldo();

    void saque(double valorSaque);

    void transferir(double valorTrasnf, ContaBancaria destino);
}
