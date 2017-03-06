/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lengyelforma;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Suli
 */
public class PolishNotation {

    private static int prec(String operator) {
        switch (operator) {
            case "+":
                return 0;
            case "-":
                return 0;
            case "*":
                return 1;
            case "/":
                return 1;
            case "(":
                return 2;
            case ")":
                return 2;
            default:
                return -1;
        }
    }

    public static String to(List<String> tokens) {
        String ki = "";
        Stack<String> verem = new Stack<>();
        for (int i = 0; i < tokens.size(); i++) {
            Scanner sc = new Scanner(tokens.get(i));

            if (sc.hasNextInt()) {
                ki += sc.nextInt() + " ";
            } else {
                String operator = sc.next();

                if (operator.equals("(")) {
                    verem.add(operator);
                } else if (operator.equals(")")) {
                    while (!verem.isEmpty()&&!verem.peek().equals("(")) {
                        ki += verem.pop() + " ";
                    }
                    verem.pop();
                } else {
                    while (!verem.isEmpty() && prec(verem.peek()) <= prec(operator)) {
                        ki += verem.pop() + " ";

                    }
                    verem.add(operator);
                }

            }
        }

        while (!verem.isEmpty()) {
            ki += verem.pop() + " ";
        }

        return ki;
    }

    public static int evaluate(String polishnotation) {
        return 0;
    }
}
