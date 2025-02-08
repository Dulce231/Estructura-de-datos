package com.mycompany.edarreglos;

import javax.swing.JOptionPane;

public class Tarea5 {

    int[] pila;
    int top = -1;

    public Tarea5(int tamaño) {
        this.pila = new int[tamaño];
    }

    public boolean vacia() {
        return top == -1;
    }

    public boolean llena() {
        return top == (pila.length - 1);
    }

    public void insertar(int elem) {
        if (!llena()) {
            top++;
            pila[top] = elem;
            JOptionPane.showMessageDialog(null, "Elemento insertado: " + elem);
        } else {
            JOptionPane.showMessageDialog(null, "La pila está llena.");
        }
    }

    public void eliminar() {
        if (!vacia()) {
            int elem = pila[top];
            top--;
            JOptionPane.showMessageDialog(null, "Elemento eliminado: " + elem);
        } else {
            JOptionPane.showMessageDialog(null, "La pila está vacía.");
        }
    }

    public void imprimir() {
        if (!vacia()) {
            StringBuilder elementos = new StringBuilder("Estos son los elementos de la pila:\n");
            for (int i = top; i >= 0; i--) {
                elementos.append(pila[i]).append("\n");
            }
            JOptionPane.showMessageDialog(null, elementos.toString());
        } else {
            JOptionPane.showMessageDialog(null, "La pila está vacía.");
        }
    }

    public void imprimirtop() {
        if (!vacia()) {
            JOptionPane.showMessageDialog(null, "Último número insertado: " + pila[top]);
        } else {
            JOptionPane.showMessageDialog(null, "La pila está vacía.");
        }
    }

    public void Tamañopila() {
        if (!vacia()) {
            JOptionPane.showMessageDialog(null, "Tamaño de la pila: " + (top + 1));
        } else {
            JOptionPane.showMessageDialog(null, "La pila está vacía.");
        }
    }

    public static void main(String[] args) {
        int tamaño = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el tamaño de la pila:"));
        Tarea5 pila = new Tarea5(tamaño);

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                        1.- INSERTAR ELEMENTOS
                                                                        2.- MOSTRAR PILA
                                                                        3.- ULTIMO ELEMENTO
                                                                        4.- ELIMINAR ELEMENTO
                                                                        5.- CANTIDAD DE ELEMENTOS
                                                                        6.- SALIR DEL PROGRAMA""", "Menú Principal", JOptionPane.QUESTION_MESSAGE));
            switch (opcion) {
                case 1 -> {
                    int elemento = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el elemento a insertar:"));
                    pila.insertar(elemento);
                }
                case 2 ->
                    pila.imprimir();
                case 3 ->
                    pila.imprimirtop();
                case 4 ->
                    pila.eliminar();
                case 5 ->
                    pila.Tamañopila();
                case 6 ->
                    JOptionPane.showMessageDialog(null, "FIN DEL PROGRAMA");
                default ->
                    JOptionPane.showMessageDialog(null, "INGRESE UNA OPCIÓN VÁLIDA", "ERROR OPCIÓN", JOptionPane.WARNING_MESSAGE);
            }
        } while (opcion != 6);
    }
}
