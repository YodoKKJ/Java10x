package Desafio5;

public interface Conta {

    void depositar(double valorDeposito);

    void saque(double valorSaque);

    void transferir(double valorTransf, Conta destino);
}
