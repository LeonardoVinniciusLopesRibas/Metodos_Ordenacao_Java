/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package atividades.paulinho;

public class SomaRecursiva {
    public int calcularSoma(int n){
        if (n <= 1) {
            return n;
        } else {
            return n + calcularSoma(n - 1);
        }
    }
}
