package com.mycompany.edarreglos;
import java.util.LinkedList;
import java.util.Stack;
import javax.swing.JOptionPane;

public class estacionamiento {

    LinkedList<String> cola = new LinkedList<>();
    Stack<String> pila = new Stack<>();
    String e;

    public boolean verificarSiEstaVaciaCola() {
        return cola.isEmpty();
    }

    public boolean verificarSiEstaVaciaPila() {
        return pila.isEmpty();
    }

    public void AltaCola() {
        e = JOptionPane.showInputDialog(null, "Ingresa la placa del carro:");
        cola.add(e);
        JOptionPane.showMessageDialog(null, "Carro con placa [" + e + "] ha sido añadido a la cola.", "ALTA PLACA", JOptionPane.INFORMATION_MESSAGE);
    }

    public void borrarCola() {
        if (verificarSiEstaVaciaCola()) {
            JOptionPane.showMessageDialog(null, "La cola está vacía.", "BORRAR PLACA", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String placaABorrar = JOptionPane.showInputDialog(null, "Ingresa la placa del carro a retirar:");
        if (cola.peekFirst().equals(placaABorrar)) {
            JOptionPane.showMessageDialog(null, "Se ha eliminado el carro con placa [" + cola.pollFirst() + "] de la cola.", "BORRAR PLACA", JOptionPane.INFORMATION_MESSAGE);
        } else {

            while (!cola.isEmpty() && !cola.peekFirst().equals(placaABorrar)) {
                pila.push(cola.pollFirst());
            }

            if (!cola.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Se ha eliminado el carro con placa [" + cola.pollFirst() + "] de la cola.", "BORRAR PLACA", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Carro con placa [" + placaABorrar + "] no encontrado en la cola.", "BORRAR PLACA", JOptionPane.WARNING_MESSAGE);
            }

            while (!pila.isEmpty()) {
                cola.addFirst(pila.pop());
            }
        }
    }

    public void imprimirCola() {
        if (verificarSiEstaVaciaCola()) {
            JOptionPane.showMessageDialog(null, "La cola está vacía.", "IMPRIMIR COLA", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder contenido = new StringBuilder("Carros en la cola:\n");
            for (String vehiculo : cola) {
                contenido.append(vehiculo).append("\n");
            }
            JOptionPane.showMessageDialog(null, contenido.toString(), "IMPRIMIR COLA", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void imprimirPila() {
        if (verificarSiEstaVaciaPila()) {
            JOptionPane.showMessageDialog(null, "La pila está vacía.", "IMPRIMIR PILA", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder contenido = new StringBuilder("Carros en la pila:\n");
            for (String vehiculo : pila) {
                contenido.append(vehiculo).append("\n");
            }
            JOptionPane.showMessageDialog(null, contenido.toString(), "IMPRIMIR PILA", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        estacionamiento p = new estacionamiento();

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                        1. Alta placa en cola
                                                                        2. Baja placa de cola
                                                                        3. Imprimir cola
                                                                        4. Imprimir pila
                                                                        5. Salir
                                                                        DULCE MARIA MUÑIZ LOPEZ 
                                                                        Elige una opcion:""", "Menú", JOptionPane.QUESTION_MESSAGE));

            switch (opcion) {
                case 1 ->
                    p.AltaCola();
                case 2 ->
                    p.borrarCola();
                case 3 ->
                    p.imprimirCola();
                case 4 ->
                    p.imprimirPila();
                case 5 ->
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.", "SALIR", JOptionPane.INFORMATION_MESSAGE);
                default ->
                    JOptionPane.showMessageDialog(null, "Opción inválida.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 5);
    }
}
