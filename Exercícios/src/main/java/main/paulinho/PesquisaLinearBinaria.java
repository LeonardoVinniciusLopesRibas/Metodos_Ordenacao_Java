package main.paulinho;

import atividades.paulinho.CadastroClientes;
import atividades.paulinho.CalcularFatorial;
import atividades.paulinho.FibonacciRecursivo;
import atividades.paulinho.PesquisaBinaria;
import atividades.paulinho.PesquisaLinear;
import atividades.paulinho.PesquisaOrdenada;
import atividades.paulinho.SomaRecursiva;
import java.util.Arrays;
import java.util.Scanner;

public class PesquisaLinearBinaria {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean troca = false;
        boolean troca2 = false;
        int opcao = 0;

        while (!troca) {
            System.out.println("\n\n\nEscolha os métodos abaixo!!!");
            System.out.println("1 - Pesquisa Binária ou Pesquisa Linear");
            System.out.println("2 - Soma Recursiva");
            System.out.println("3 - Calcular Fatorial");
            System.out.println("4 - Fibonacci Recursivo");
            System.out.println("5 - Pesquisa Linear ou Pesquisa Binária em ordem crescente");
            System.out.println("6 - Cadastro de Clientes");
            System.out.println("9 - Sair");
            System.out.print("Informe a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    while (!troca2) {
                        System.out.println("Informe o tamanho do array: ");
                        int tamanho = scanner.nextInt();
                        int[] lista = new int[tamanho];

                        System.out.println("Informe os números do array:");
                        for (int i = 0; i < tamanho; i++) {
                            lista[i] = scanner.nextInt();
                        }

                        System.out.println("Informe o número a ser pesquisado: ");
                        int valor = scanner.nextInt();
                        System.out.print("Escolha o método de pesquisa (1 - Linear, 2 - Binária, 3 - SAIR): ");
                        int metodo = scanner.nextInt();

                        long inicio = System.currentTimeMillis();

                        String resultado = "";
                        switch (metodo) {
                            case 1:
                                PesquisaLinear pl = new PesquisaLinear();
                                resultado = pl.pesquisar(lista, valor);
                                break;
                            case 2:
                                PesquisaBinaria pb = new PesquisaBinaria();
                                resultado = pb.pesquisar(lista, valor);
                                break;
                            case 3:
                                troca2 = true;
                                break;
                            default:
                                resultado = "Método inválido.";
                                break;
                        }

                        long fim = System.currentTimeMillis();
                        long tempoExecucao = fim - inicio;

                        System.out.println("Tempo de execução: " + tempoExecucao + " ms");
                        System.out.println("\nO valor " + valor + " está na posição " + resultado);
                    }
                    break;

                case 2:
                    SomaRecursiva sr = new SomaRecursiva();
                    int resultadoSomaRecursiva = sr.calcularSoma(50);
                    System.out.println("\n\nA soma de 0 a 50 é: " + resultadoSomaRecursiva + "\n\n");
                    break;

                case 3:
                    CalcularFatorial cf = new CalcularFatorial();
                    System.out.print("\n\nDigite um número inteiro: ");
                    int numero = scanner.nextInt();
                    int resultadoCalcularFatorial = cf.calcularFatorial(numero);
                    System.out.println("\n\nO fatorial de " + numero + " é: " + resultadoCalcularFatorial + "\n\n");
                    break;

                case 4:
                    FibonacciRecursivo fr = new FibonacciRecursivo();
                    System.out.print("\n\nDigite um número inteiro: ");
                    int numeroFibonacci = scanner.nextInt();
                    System.out.println("Sequência Fibonacci até " + numeroFibonacci + ":");
                    fr.mostrarSequenciaFibonacci(numeroFibonacci);
                    break;

                case 5:
                    System.out.println("Informe a quantidade de números a cadastrar: ");
                    int quantidade = scanner.nextInt();
                    int[] numeros = new int[quantidade];

                    System.out.println("Informe os números a serem cadastrados:");
                    for (int i = 0; i < quantidade; i++) {
                        numeros[i] = scanner.nextInt();
                    }

                    Arrays.sort(numeros);

                    System.out.println("Informe o número a ser pesquisado: ");
                    int numeroPesquisado = scanner.nextInt();

                    System.out.println("Escolha o método de pesquisa (1 - Linear, 2 - Binária): ");
                    int metodoPesquisa = scanner.nextInt();

                    PesquisaOrdenada pesquisa = new PesquisaOrdenada();
                    String resultadoPesquisa = pesquisa.pesquisar(numeros, numeroPesquisado, metodoPesquisa);

                    System.out.println("O valor " + numeroPesquisado + " está na posição " + resultadoPesquisa);
                    break;

                case 6:
                    CadastroClientes cadastro = new CadastroClientes();
                    cadastro.executarCadastroClientes();
                    break;

                case 9:
                    troca = true;
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
                    break;
            }
        }
        scanner.close();
    }
}
