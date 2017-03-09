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
                    while (!verem.isEmpty() && !verem.peek().equals("(")) {
                        ki += verem.pop() + " ";
                    }
                    verem.pop();
                } else {
                    while (!verem.isEmpty() && prec(verem.peek()) >= prec(operator) && !(verem.peek().equals("(") || verem.peek().equals(")"))) {
                        ki += verem.pop() + " ";

                    }
                    verem.add(operator);
                }

            }
        }
            
        while (!verem.isEmpty()) {
            String end = verem.pop();
            if (end.equals("(")||end.equals(")")) {
                throw new RuntimeException("hibás kifejezés ellenőrizze a zárojeleket");
            }
            ki += end + " ";
        }

        return ki;
    }

    public static int evaluate(String polishnotation) {
        Scanner sc = new Scanner(polishnotation);
        Stack<Integer> verem = new Stack<>();
        while (sc.hasNext()) {
            Scanner validator = new Scanner(sc.next());

            if (validator.hasNextInt()) {
                verem.add(validator.nextInt());
            } else {
                if (verem.size()<2) {
                    throw new RuntimeException("hibás kifejezés! \n ellenőrizze az operandusok számát");
                }
                int arg1 = verem.pop();
                int arg2 = verem.pop();
                String operator=validator.next();
                switch(operator)
                {
                    case "+":verem.add(arg1+arg2);break;
                    case "-":verem.add(arg2-arg1);break;
                    case "*":verem.add(arg1*arg2);break;
                    case "/":verem.add(arg2/arg1);break;
                }
                
            }
        }
        if (verem.size()>1) {
            throw new RuntimeException("Híbás kifejezés!");
        }
        return verem.pop();
    }
}
