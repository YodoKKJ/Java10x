package Desafio5;

import java.util.Scanner;

public class Main {

    static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ContaPoupanca contaPoup = null;
        ContaCorrente contaCorr = null;
        int i = 0;

        while (true){

            i++;

            ContaBancaria contaSelecionada = null;



            boolean poderCriarConta = contaPoup == null || contaCorr == null;


            System.out.println("\n=========================================");
            System.out.println("|-Voce ja passou nessa tela " + i + "x veze(s)--|");
            System.out.println("|--Seja Bem vindo ao Sistema Bancariio--|");
            System.out.println("|-----O que voce deseja fazer?----------|");
            if (poderCriarConta) System.out.println("|-----1->Criar uma conta!---------------|");
            System.out.println("|-----2->Movimentar saldo---------------|");
            System.out.println("|-----3->Sair do Sistema----------------|");
            if (contaPoup != null || contaCorr != null) System.out.println("|-----999->Acessar Conta----------------|");
            if (contaPoup != null && contaCorr != null) System.out.println("|-----900->Transferencia entre Contas---|");
            System.out.println("=========================================");

            String resposta = scan.nextLine();


            switch (resposta){

                case "1":
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
                            System.out.println("Valor invalido! Digite um numero. (Tente usar pontos para numeros quebrados: 1.2)");
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
                            System.out.println("Valor invalido! Digite um numero. (Tente usar pontos para numeros quebrados: 1.2)");
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


                case "2":

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
                    String escolha = scan.nextLine();



                    if (escolha.equals("1") || (escolha.equals("2"))) {

                        System.out.println("Voce deseja fazer um Saque ou um Deposito? (S = saque/D = Deposito)");
                        String awnser = scan.nextLine().toUpperCase();




                        if (awnser.equals("D")) {

                            if (escolha.equals("1")) {
                                if (contaPoup == null) {
                                    System.out.println("Conta nao cadastrada voltando para o menu");
                                    break;
                                }
                                contaSelecionada = contaPoup;
                            } else if (escolha.equals("2")) {
                                if (contaCorr == null) {
                                    System.out.println("Conta nao cadastrada voltando para o menu");
                                    break;
                                }
                                contaSelecionada = contaCorr;
                            } else {
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
                                System.out.println("Valor invalido! Digite um numero. (Tente usar pontos para numeros quebrados: 1.2)");
                                scan.nextLine(); // descarta a entrada errada
                            }


                        } else if (awnser.equals("S")) {

                            if (escolha.equals("1")) {
                                if (contaPoup == null) {
                                    System.out.println("Conta nao cadastrada voltando para o menu");
                                    break;
                                }
                                contaSelecionada = contaPoup;
                            } else if (escolha.equals("2")) {
                                if (contaCorr == null) {
                                    System.out.println("Conta nao cadastrada voltando para o menu");
                                    break;
                                }
                                contaSelecionada = contaCorr;
                            } else {
                                System.out.println("Opcao invalida voltando para o menu");
                                break;
                            }

                            System.out.println("Quanto voce deseja sacar? ");

                            if (scan.hasNextDouble()) {
                                contaSelecionada.valorSaque = scan.nextDouble();
                                scan.nextLine(); // limpa o buffer

                                contaSelecionada.saque(contaSelecionada.valorSaque);


                            } else {
                                System.out.println("Valor invalido! Digite um numero. (Tente usar pontos para numeros quebrados: 1.2)");
                                scan.nextLine(); // descarta a entrada errada
                            }

                        }
                    }
                    break;

                case "999":

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
                        System.out.println("Nenhuma conta cadastrada, voltando ao menu");
                        break;
                    }

                    System.out.println("Qual conta deseja acessar?");
                    escolha = scan.nextLine();

                    if (escolha.equals("1")) {
                        if (contaPoup == null) {
                            System.out.println("Conta nao cadastrada.");
                            break;
                        }
                        contaSelecionada = contaPoup;
                    }
                    else if (escolha.equals("2")) {
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

                    break;

                case "900":
                    if (contaPoup == null || contaCorr == null) {
                        System.out.println("É necessário ter as duas contas criadas para realizar transferências.");
                        break;
                    }

                    System.out.println("\n===== ÁREA DE TRANSFERÊNCIA =====");
                    System.out.println("Qual conta será a ORIGEM (de onde sai o dinheiro)?");
                    System.out.println("1 -> Poupanca (" + contaPoup.nomeConta + ")");
                    System.out.println("2 -> Corrente (" + contaCorr.nomeConta + ")");

                    String escolhaOrigem = scan.nextLine();

                    ContaBancaria contaOrigem = null;
                    ContaBancaria contaDestino = null;
                    
                    if (escolhaOrigem.equals("1")) {
                        contaOrigem = contaPoup;
                        contaDestino = contaCorr;
                        System.out.println("Origem: Poupança >> Destino: Corrente");
                    } else if (escolhaOrigem.equals("2")) {
                        contaOrigem = contaCorr;
                        contaDestino = contaPoup;
                        System.out.println("Origem: Corrente >> Destino: Poupança");
                    } else {
                        System.out.println("Opção inválida.");
                        break;
                    }

                    System.out.println("Qual valor deseja transferir?");
                    if (scan.hasNextDouble()) {
                        double valorTransf = scan.nextDouble();
                        scan.nextLine();

                        contaOrigem.transferir(valorTransf, contaDestino);

                    } else {
                        System.out.println("Valor inválido.");
                        scan.nextLine();
                    }
                    break;

                case "4":

                    System.out.println("Vini... eu imaginei que voce tentaria isso muhehehe");

                default:
                    System.out.println("Opcao invalida");
                    // case em cima dessa linha
                    }

                }
            }
        }


