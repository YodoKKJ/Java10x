package Desafio5;

import java.util.Scanner;

public class Main {

    static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ContaPoupanca contaPoup = null;
        ContaCorrente contaCorr = null;

        while (true){


            boolean poderCriarConta = contaPoup == null || contaCorr == null;

            System.out.println("\n=========================================");
            System.out.println("|--Seja Bem vindo ao Sistema Bancariio--|");
            System.out.println("|-----O que voce deseja fazer?----------|");
            if (poderCriarConta) System.out.println("|-----1->Criar uma conta!---------------|");
            System.out.println("|-----2->Movimentar saldo---------------|");
            System.out.println("|-----3->Sair do Sistema----------------|");
            if (contaPoup != null || contaCorr != null) System.out.println("|-----4->Acessar Conta------------------|");
            if (contaPoup != null && contaCorr != null) System.out.println("|-----5->Transferencia entre Contas-----|");
            System.out.println("=========================================");

            int resposta = scan.nextInt();
            scan.nextLine();

            switch (resposta){

                case 1:
                    System.out.println("Voce escolheu criar um conta, ok!");
                    System.out.println("Qual o tipo de conta que voce deseja criar? (P = Poupanca / C = Corrente): ");
                    String tipoContaStr = scan.nextLine().toUpperCase();

                    if (tipoContaStr.equals("P")){

                        if (contaPoup != null){
                            System.out.println("Voce ja possui uma conta Poupanca Criada!");
                            break;
                        }

                        tipoConta contaTipo = tipoConta.POUPANCA;

                        System.out.println("Qual o nome da sua conta? ");
                        String nomeConta = scan.nextLine();

                        System.out.println("Qual o Saldo inicial da sua conta? ");

                        if (!scan.hasNextDouble()) {
                            System.out.println("Valor invalido! Digite um numero. (Use ponto: 1.2)");
                            scan.nextLine();
                            break;
                        }

                        double saldoInicial = scan.nextDouble();
                        scan.nextLine();

                        System.out.println("Conta criada com sucesso, seja bem-vindo ao sistema bancario!");

                        contaPoup = new ContaPoupanca(nomeConta, saldoInicial, contaTipo);
                    }
                    else if (tipoContaStr.equals("C")) {

                        if (contaCorr != null) {
                            System.out.println("Voce ja possui uma conta Corrente criada!");
                            break;
                        }

                        tipoConta contaTipo = tipoConta.CORRENTE;

                        System.out.println("Qual o nome da sua conta? ");
                        String nomeConta = scan.nextLine();

                        System.out.println("Qual o Saldo inicial da sua conta? ");

                        if (!scan.hasNextDouble()) {
                            System.out.println("Valor invalido! Digite um numero. (Use ponto: 1.2)");
                            scan.nextLine();
                            break;
                        }

                        double saldoIncial = scan.nextDouble();
                        scan.nextLine();

                        System.out.println("Conta criada com sucesso, seja bem-vindo ao sistema bancario!");

                        contaCorr = new ContaCorrente(nomeConta, saldoIncial, contaTipo);
                    }
                    else {
                        System.out.println("Opcao de Conta Invalida Retornando para o menu!");
                    }

                    break;
                case 2:

                    boolean booleantemp = false;

                    if (contaPoup != null) {
                        System.out.println("1 -> Conta Poupanca de Nome: " + contaPoup.nomeConta);
                        booleantemp = true;
                    } else {
                        System.out.println("Conta Poupanca ainda nao cadastrada.");
                    }

                    if (contaCorr != null) {
                        System.out.println("2 -> Conta Corrente de Nome: "+ contaCorr.nomeConta);
                        booleantemp = true;
                    } else {
                        System.out.println("Conta Corrente ainda nao cadastrada.");
                    }

                    if (!booleantemp) {
                        System.out.println("Voltando para o Menu para Cadastro de Contas!");
                        break;
                    }

                    System.out.println("Qual conta deseja escolher? ");
                    int escolha = scan.nextInt();
                    scan.nextLine();

                    System.out.println("Voce deseja fazer um Saque ou um Deposito? (S = saque/D = Deposito)");
                    String awnser = scan.nextLine().toUpperCase();


                    ContaBancaria contaSelecionada = null;

                    if (awnser.equals("D")){

                        if (escolha == 1){
                            if (contaPoup == null){
                                System.out.println("Conta nao cadastrada voltando para o menu");
                                break;
                            }
                            contaSelecionada = contaPoup;
                        }
                        else if (escolha == 2){
                            if (contaCorr == null) {
                                System.out.println("Conta nao cadastrada voltando para o menu");
                                break;
                            }
                            contaSelecionada = contaCorr;
                        }
                        else {
                            System.out.println("Opcao invalida voltando para o menu");
                            break;
                        }

                        System.out.println("Quanto voce deseja depositar? ");

                        if (scan.hasNextDouble()) {
                            contaSelecionada.valorDeposito = scan.nextDouble();
                            scan.nextLine(); // limpa o buffer

                            contaSelecionada.depositar(contaSelecionada.valorDeposito);
                            System.out.println("Deposito realizado com sucesso!");


                        } else {
                            System.out.println("Valor invalido. Digite um numero valido.");
                            scan.nextLine(); // descarta a entrada errada
                        }


                    }
                    else if (awnser.equals("S")){

                        if (escolha == 1){
                            if (contaPoup == null){
                                System.out.println("Conta nao cadastrada voltando para o menu");
                                break;
                            }
                            contaSelecionada = contaPoup;
                        }
                        else if (escolha == 2){
                            if (contaCorr == null) {
                                System.out.println("Conta nao cadastrada voltando para o menu");
                                break;
                            }
                            contaSelecionada = contaCorr;
                        }
                        else {
                            System.out.println("Opcao invalida voltando para o menu");
                            break;
                        }

                        System.out.println("Quanto voce deseja sacar? ");

                        if (scan.hasNextDouble()) {
                            contaSelecionada.valorSaque = scan.nextDouble();
                            scan.nextLine(); // limpa o buffer

                            contaSelecionada.saque(contaSelecionada.valorSaque);
                            System.out.println("Saque realizado com sucesso!");


                        } else {
                            System.out.println("Valor invalido. Digite um numero valido.");
                            scan.nextLine(); // descarta a entrada errada
                        }
                        
                    }
                    break;

                case 4:

                    boolean existeAlgumaConta = false;

                    if (contaPoup != null) {
                        System.out.println("1 -> Conta Poupanca Nome da Conta: " + contaPoup.nomeConta);
                        existeAlgumaConta = true;
                    } else {
                        System.out.println("Conta Poupanca ainda nao cadastrada.");
                    }

                    if (contaCorr != null) {
                        System.out.println("2 -> Conta Corrente Nome da Conta: " + contaCorr.nomeConta);
                        existeAlgumaConta = true;
                    } else {
                        System.out.println("Conta Corrente ainda nao cadastrada.");
                    }

                    if (!existeAlgumaConta) {
                        System.out.println("Nenhuma conta cadastrada.");
                        break;
                    }

                    System.out.println("Qual conta deseja acessar?");
                    escolha = scan.nextInt();
                    scan.nextLine();

                    contaSelecionada = null;

                    if (escolha == 1) {
                        if (contaPoup == null) {
                            System.out.println("Conta nao cadastrada.");
                            break;
                        }
                        contaSelecionada = contaPoup;
                    }
                    else if (escolha == 2) {
                        if (contaCorr == null) {
                            System.out.println("Conta nao cadastrada.");
                            break;
                        }
                        contaSelecionada = contaCorr;
                    }
                    else {
                        System.out.println("Opcao invalida.");
                        break;
                    }

                    System.out.println("\n===== DADOS DA CONTA =====");
                    System.out.println(contaSelecionada);

                }
            }
        }
    }

