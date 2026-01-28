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
        this.saldoTotal = saldoInicial;
        this.tipo = tipo;
    }



    @Override
    public String toString() {
        return "\nAqui estao os dados da sua conta\n"
                + "Nome da conta: " + nomeConta + "\n"
                + "Saldo inicial da conta: " + saldoInicial + "\n"
                + "Saldo atual da conta: " + saldoTotal + "\n"
                + "Tipo da Conta: " + tipo + "\n";
    }

    @Override
    public void transferir(double valorTransf, Conta contaDestino) {
        // Verifica se o valor é válido e se tem saldo
        if (valorTransf <= 0) {
            System.out.println("Valor inválido para transferência.");
            return;
        }

        if (this.saldoTotal < valorTransf) {
            System.out.println("Saldo insuficiente para realizar a transferência.");
            return;
        }

        // Realiza o saque na conta atual (this)
        this.saldoTotal -= valorTransf;

        // Realiza o depósito na conta de destino
        contaDestino.depositar(valorTransf);

        System.out.println("Transferência de R$ " + valorTransf + " realizada com sucesso!");
    }

    @Override
    public void depositar(double valorDeposito) {
        if (valorDeposito <= 0) {
            System.out.println("Valor invalido para deposito.");
            return;
        }

        saldoTotal += valorDeposito;
    }


    @Override
    public void saque(double valorSaque) {
        if (valorSaque <= 0) {
            System.out.println("Valor invalido para saque.");
            return;
        }

        if (saldoTotal < valorSaque) {
            System.out.println("Saldo insuficiente.");
            return;
        }

        saldoTotal -= valorSaque;
        System.out.println("Saque Realizado Com Sucesso!");
    }
}
