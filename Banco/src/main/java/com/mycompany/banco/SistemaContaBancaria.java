package com.mycompany.banco;


import java.util.Arrays;
import java.util.Scanner;

public class SistemaContaBancaria {
    private static ContaBancaria[] contas;
    private static int numContas;
    private static Scanner scanner;

    public static void main(String[] args) {
        contas = new ContaBancaria[100];
        numContas = 0;
        scanner = new Scanner(System.in);

        boolean sair = false;

        while (!sair) {
            System.out.println("\n=== Sistema de Conta Bancária ===");
            System.out.println("1. Cadastrar nova conta bancária");
            System.out.println("2. Exibir contas bancárias ordenadas");
            System.out.println("3. Realizar depósito");
            System.out.println("4. Realizar saque");
            System.out.println("5. Calcular saldo total do banco");
            System.out.println("6. Verificar saldo negativo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarConta();
                    break;
                case 2:
                    exibirContasOrdenadas();
                    break;
                case 3:
                    realizarDeposito();
                    break;
                case 4:
                    realizarSaque();
                    break;
                case 5:
                    calcularSaldoTotal();
                    break;
                case 6:
                    verificarSaldoNegativo();
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        System.out.println("Encerrando o programa...");
    }

    private static void cadastrarConta() {
        System.out.print("\nNúmero da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome do titular: ");
        String nomeTitular = scanner.nextLine();
        System.out.print("Saldo inicial: R$");
        double saldoInicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria(numeroConta, nomeTitular, saldoInicial);
        contas[numContas] = conta;
        numContas++;

        System.out.println("Conta bancária cadastrada com sucesso!");
    }

    private static void exibirContasOrdenadas() {
        System.out.println("\n=== Exibir contas bancárias ordenadas ===");
        System.out.println("1. Por número da conta");
        System.out.println("2. Por saldo");
        System.out.print("Escolha um critério de ordenação: ");
        int criterio = scanner.nextInt();

        ContaBancaria[] contasOrdenadas = Arrays.copyOf(contas, numContas);
        switch (criterio) {
            case 1:
                Arrays.sort(contasOrdenadas, (c1, c2) -> c1.getNumeroConta() - c2.getNumeroConta());
                break;
            case 2:
                Arrays.sort(contasOrdenadas, (c1, c2) -> Double.compare(c1.getSaldo(), c2.getSaldo()));
                break;
            default:
                System.out.println("Opção inválida! Retornando ao menu principal.");
                return;
        }

        System.out.println("\n=== Contas bancárias ordenadas ===");
        for (ContaBancaria conta : contasOrdenadas) {
            System.out.println(conta);
        }
    }

    private static void realizarDeposito() {
        System.out.print("\nDigite o número da conta ou o nome do titular: ");
        String termoPesquisa = scanner.next();
        boolean encontrada = false;

        for (int i = 0; i < numContas; i++) {
            ContaBancaria conta = contas[i];
            if (String.valueOf(conta.getNumeroConta()).equals(termoPesquisa) || conta.getNomeTitular().equalsIgnoreCase(termoPesquisa)) {
                System.out.print("Valor do depósito: R$");
                double valor = scanner.nextDouble();
                conta.deposito(valor);
                System.out.println("Depósito realizado com sucesso!");
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("Conta não encontrada!");
        }
    }

    private static void realizarSaque() {
        System.out.print("\nNúmero da conta: ");
        int numeroConta = scanner.nextInt();
        boolean encontrada = false;

        int posicao = buscaBinariaContasOrdenadas(numeroConta);

        if (posicao >= 0) {
            ContaBancaria conta = contas[posicao];
            System.out.print("Valor do saque: R$");
            double valor = scanner.nextDouble();

            conta.saque(valor);
            System.out.println("Saque realizado com sucesso!");

            encontrada = true;
        }

        if (!encontrada) {
            System.out.println("Conta não encontrada!");
        }
    }

    private static int buscaBinariaContasOrdenadas(int numeroConta) {
        int inicio = 0;
        int fim = numContas - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            ContaBancaria conta = contas[meio];

            if (conta.getNumeroConta() == numeroConta) {
                return meio;
            } else if (conta.getNumeroConta() < numeroConta) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }

    private static void calcularSaldoTotal() {
        double saldoTotal = calcularSaldoTotalRecursivo(0);
        System.out.println("\nSaldo total do banco: R$" + saldoTotal);
    }

    private static double calcularSaldoTotalRecursivo(int indice) {
        if (indice == numContas) {
            return 0;
        }

        ContaBancaria conta = contas[indice];
        return conta.getSaldo() + calcularSaldoTotalRecursivo(indice + 1);
    }

    private static void verificarSaldoNegativo() {
        System.out.println("\n=== Verificação de saldo negativo ===");
        verificarSaldoNegativoRecursivo(0);
    }

    private static void verificarSaldoNegativoRecursivo(int indice) {
        if (indice == numContas) {
            return;
        }

        ContaBancaria conta = contas[indice];
        if (conta.getSaldo() < 0) {
            System.out.println("Saldo negativo encontrado na conta: " + conta);
        } else{
            System.out.println("Nenhum saldo encontrado!");
        }

        verificarSaldoNegativoRecursivo(indice + 1);
    }
}