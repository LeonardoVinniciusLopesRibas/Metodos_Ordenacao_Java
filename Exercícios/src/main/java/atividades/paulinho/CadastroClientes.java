package atividades.paulinho;

import atividades.paulinho.modalcliente.Cliente;
import java.util.Arrays;
import java.util.Scanner;

public class CadastroClientes {
    private static final int CAPACIDADE_MAXIMA = 100;

    private int quantidadeClientes;
    private Cliente[] clientes;

    public CadastroClientes() {
        clientes = new Cliente[CAPACIDADE_MAXIMA];
        quantidadeClientes = 0;
    }

    public void executarCadastroClientes() {
        Scanner scanner = new Scanner(System.in);

        boolean sair = false;
        while (!sair) {
            System.out.println("\n\n\nOpções de Cadastro de Clientes:");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Buscar cliente");
            System.out.println("3 - Listar clientes");
            System.out.println("4 - Voltar");

            System.out.print("Informe a opção desejada: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner);
                    break;
                case 2:
                    buscarCliente(scanner);
                    break;
                case 3:
                    listarClientes();
                    break;
                case 4:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
                    break;
            }
        }

        scanner.close();
    }

    private void cadastrarCliente(Scanner scanner) {
        if (quantidadeClientes >= CAPACIDADE_MAXIMA) {
            System.out.println("Limite máximo de clientes atingido.");
            return;
        }

        System.out.print("\nInforme o código do cliente: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Informe o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Informe a data de nascimento do cliente (formato: dd/mm/aaaa): ");
        String dataNascimento = scanner.nextLine();

        System.out.print("Informe o CPF do cliente: ");
        String cpf = scanner.nextLine();

        Cliente cliente = new Cliente(codigo, nome, dataNascimento, cpf);
        clientes[quantidadeClientes] = cliente;
        quantidadeClientes++;

        Arrays.sort(clientes, 0, quantidadeClientes); 
        System.out.println("\nCliente cadastrado com sucesso!");
    }

    private void buscarCliente(Scanner scanner) {
        System.out.print("\nInforme o código do cliente: ");
        int codigo = scanner.nextInt();

        int posicao = buscaBinariaClientes(codigo);
        if (posicao != -1) {
            Cliente cliente = clientes[posicao];
            System.out.println("\nDados do cliente:");
            System.out.println("Código: " + cliente.getCodigo());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
            System.out.println("CPF: " + cliente.getCpf());
        } else {
            System.out.println("\nCliente não encontrado.");
        }
    }

    private int buscaBinariaClientes(int codigo) {
        int esquerda = 0;
        int direita = quantidadeClientes - 1;

        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            if (clientes[meio].getCodigo() == codigo) {
                return meio; 
            } else if (clientes[meio].getCodigo() < codigo) {
                esquerda = meio + 1; 
            } else {
                direita = meio - 1; 
            }
        }

        return -1; 
    }

    private void listarClientes() {
        System.out.println("\nLista de Clientes:");

        if (quantidadeClientes == 0) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        for (int i = 0; i < quantidadeClientes; i++) {
            Cliente cliente = clientes[i];
            System.out.println("Código: " + cliente.getCodigo());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println();
        }
    }
}
