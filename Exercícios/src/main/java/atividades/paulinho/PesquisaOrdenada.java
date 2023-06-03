/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package atividades.paulinho;


public class PesquisaOrdenada {
    public String pesquisar(int[] lista, int valor, int metodo) {
        int esquerda = 0;
        int direita = lista.length - 1;

        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;

            if (lista[meio] == valor) {
                return Integer.toString(meio);
            }

            if (lista[meio] < valor) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        return "Não encontrado";
    }
}

