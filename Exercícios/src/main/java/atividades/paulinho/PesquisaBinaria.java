package atividades.paulinho;

public class PesquisaBinaria {
    public String pesquisar(int[] lista, int valor) {
        int inicio = 0;
        int fim = lista.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (lista[meio] == valor) {
                return Integer.toString(meio); 
            } else if (lista[meio] < valor) {
                inicio = meio + 1; 
            } else {
                fim = meio - 1; 
            }
        }

        return "Não foi encontrado o elemento informado."; 
    }
}
