package com.mycompany.edarreglos;
import java.util.Stack;
import javax.swing.JOptionPane;

public class Tarea6 {

    static Stack<Integer> pila = new Stack<>();

    public static void push(int o) {
        pila.push(o);
    }

    public static void pop() {
        if (pila.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pila vacía.");
        } else {
            JOptionPane.showMessageDialog(null, "Se eliminó el numero: " + pila.pop());
        }
    }

    public static void peek() {
        if (pila.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pila vacía.");
        } else {
            JOptionPane.showMessageDialog(null, "Ultimo numero insertado: " + pila.peek());
        }
    }

    public static void size() {
        if (pila.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pila vacía.");
        } else {
            JOptionPane.showMessageDialog(null, "Tamaño de la pila: " + pila.size());
        }
    }

    public static void muestraPila(Stack<Integer> pila) {
        if (pila.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pila vacía.");
        } else {
            StringBuilder elementos = new StringBuilder("Numeros en la pila: \n");
            for (Integer elemento : pila) {
                elementos.append(elemento).append("\n");
            }
            JOptionPane.showMessageDialog(null, elementos.toString());
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            String menu = """
                          1. Insertar numeros
                          2. Tamaño de la pila
                          3. Ultimo numero
                          4. Mostrar todos los elementos de la pila
                          5. Eliminar
                          6. Salir
                          Elige una opci\u00f3n:"""; 
            choice = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (choice) {
                case 1 -> {
                    int num = Integer.parseInt(JOptionPane.showInputDialog("Inserta el número que deseas agregar:"));
                    push(num);
                }
                case 2 -> size();
                case 3 -> peek();
                case 4 -> muestraPila(pila);
                case 5 -> pop();
                case 6 -> JOptionPane.showMessageDialog(null, "Saliendo...");
                default -> JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (choice != 6);
    }
}
