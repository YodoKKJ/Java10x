package Desafio5;

public abstract class ContaBancaria implements Conta {

    double valorTrasnf;
    double valorSaque;
    double valorDeposito;
    double saldoTotal;
    String nomeConta;
    double saldoInicial;
    tipoConta tipo;


    public ContaBancaria(String nomeConta, double saldoInicial, tipoConta tipo) {
        this.nomeConta = nomeConta;
        this.saldoInicial = saldoInicial;
        this.tipo = tipo;
    }



    @Override
    public String toString() {
        return "\nAqui estao os dados da sua conta\n"
                + "Nome da conta: " + nomeConta + "\n"
                + "Saldo inicial da conta: " + saldoInicial + "\n"
                + "Saldo atual da conta: " + ((valorDeposito + saldoInicial) - valorSaque) + "\n"
                + "Tipo da Conta: " + tipo + "\n";
    }

}
