package atividades.paulinho;

public class PesquisaLinear {
    public String pesquisar(int[] lista, int valor) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == valor) {
                return String.valueOf(i);
            }
        }
        return "Não foi encontrado o elemento informado.";
    }
}

