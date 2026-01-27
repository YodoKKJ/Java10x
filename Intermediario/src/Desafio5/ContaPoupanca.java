package Desafio5;



public class ContaPoupanca extends ContaBancaria {



    @Override
    public double consultarSaldo() {
        saldoTotal = valorDeposito + saldoInicial;
        return saldoTotal;
    }

    @Override
    public void depositar(double valorDeposito) {
        if (valorDeposito <= 0) {
            saldoTotal =  saldoInicial + valorDeposito;
            System.out.println("Valor invalido para deposito.");
            return;
        }
    }


    public ContaPoupanca(String nomeConta, double saldoInicial, tipoConta tipo) {
        super(nomeConta, saldoInicial, tipo);
    }


    @Override
    public void saque(double valorSaque) {
        if (valorDeposito <= 0) {
            saldoTotal = (saldoInicial + valorDeposito) - valorSaque ;
            System.out.println("Valor invalido para saque.");
            return;
        }
    }
}
