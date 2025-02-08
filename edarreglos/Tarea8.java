
package com.mycompany.edarreglos;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Stack;
public class Tarea8 {
        static Scanner s = new Scanner(System.in);

        //CONDICIONES
        public static int ISP(char ch) {
            switch (ch) {
                case '+', '-' -> {
                    return 1;
                }
                case '*', '/' -> {
                    return 2;
                }
                case '&', '(' -> {
                    return 0;
                }
                case '^' -> {
                    return 3;
                }
                default -> {
                }
            }
            return -1;
        }

        //CONDICIONES
        public static int ICP(char ch) {
            switch (ch) {
                case '+', '-' -> {
                    return 1;
                }
                case '*', '/' -> {
                    return 2;
                }
                case '&' -> {
                    return 0;
                }
                case '^' -> {
                    return 4;
                }
                case '(' -> {
                    return 4;
                }
                default -> {
                }
            }
            return -1;
        }

        //CONVERSION
        public static String InfijoAPostfijo(String guardado) {//llego de la  expresion es el primer lugar donde llega
            String resultado = "";//creop un string donde se depositaran el resultado de la expresion postfija
            Stack<Character> guardar = new Stack<>();
            guardar.push('&');//pone un caracter para que tenga algo y no este vacio
            for (int i = 0; i < guardado.length(); i++) {

                if (Character.isLetterOrDigit(guardado.charAt(i))) {

                    resultado += guardado.charAt(i);
                } else if (guardado.charAt(i) == ')') {
                    while (!guardar.isEmpty() && guardar.peek() != '(') {
                        resultado = resultado + guardar.pop();
                    }

                    if (!guardar.isEmpty() && guardar.peek() != '(') {
                        return "expresion invalida";
                    } else {
                        guardar.pop();
                    }
                } else 
                {
                   
                    while (!guardar.isEmpty() && ICP(guardado.charAt(i)) <= ISP(guardar.peek())) {
                        if (guardar.peek() == '(') {
                            return "expresion erronea";
                        }

                        resultado = resultado + guardar.pop();
                    }

                    guardar.push(guardado.charAt(i));
                }

            }

          
            while (guardar.peek() != '&') {
                if (guardar.peek() == '(') {
                    return "expresion invalida";

                }
                resultado = resultado + guardar.pop();
            }

            return resultado;

        }


        public static float EvaluePostfijo(String expresion) {

            int temp1, temp2, resultado = 0, expLetra;
            Stack<Integer> pila2 = new Stack<>();
            for (int i = 0; i < expresion.length(); i++) {
                char revisar = expresion.charAt(i);
                if (Character.isLetterOrDigit(revisar)) {
                    if (Character.isLetter(revisar)) {
                        System.out.println("dame el valor de " + revisar);
                        expLetra = s.nextInt();
                        pila2.push(expLetra);

                    } else {
                        pila2.push(Integer.valueOf(String.valueOf(revisar)));
                    }


                } else {
                    temp2 = pila2.pop();
                    temp1 = pila2.pop();
                    switch (revisar) {
                        case '+' -> resultado = temp1 + temp2;
                        case '-' -> resultado = temp1 - temp2;
                        case '*' -> resultado = temp1 * temp2;
                        case '/' -> resultado = temp1 / temp2;
                        case '^' -> resultado = (int) Math.pow(temp1, temp2);
                        default -> {
                        }
                    }
                    pila2.push(resultado);
                }
            }
            if (pila2.size() == 1) {
                return (pila2.peek());
            } else {
                return -1;
            }
        }

        public static void main(String[] args) {
            String exp = JOptionPane.showInputDialog(null,"Ingrese una operacion", "INGRESA", JOptionPane.QUESTION_MESSAGE);//aqui es donde se escribe la expresion
            //exp=exp.replace(" ", "");
            exp = exp.trim();
            JOptionPane.showMessageDialog(null, "Expresion postfijo : " + InfijoAPostfijo(exp) + "\nEl resultado es es : " + EvaluePostfijo(InfijoAPostfijo(exp)));
        }
    }


    

