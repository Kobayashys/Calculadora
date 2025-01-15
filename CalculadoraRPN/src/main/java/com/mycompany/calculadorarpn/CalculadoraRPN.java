/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculadorarpn;

/**
 *
 * @author henrique
 */
import java.util.Stack;
import java.util.Scanner;

public class CalculadoraRPN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a expressão em notação pós-fixa: ");
        String expressao = scanner.nextLine();

        System.out.println("Resultado: " + avaliarExpressao(expressao));
    }

    public static double avaliarExpressao(String expressao) {
        Stack<Double> pilha = new Stack<>();

        
        for (char c : expressao.toCharArray()) {
            if (Character.isDigit(c)) {
               
                pilha.push(Double.parseDouble(String.valueOf(c)));
            } else {
               
                double b = pilha.pop();
                double a = pilha.pop();
                double resultado = realizarOperacao(a, b, c);
                pilha.push(resultado);
            }
        }

        return pilha.pop();
    }

    public static double realizarOperacao(double a, double b, char operador) {
        switch (operador) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
            default: throw new IllegalArgumentException("Operador inválido");
        }
    }
}
