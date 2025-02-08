package com.mycompany.edarreglos;
import java.util.LinkedList;
import java.util.Stack;
import javax.swing.JOptionPane;

public class Tarea13 {

    static LinkedList<Integer> cola1 = new LinkedList<>();
    static LinkedList<Integer> cola2 = new LinkedList<>();
    static Stack<Integer> pila = new Stack<>();
    static Stack<Integer> pilaTemp = new Stack<>();

    //Agregar cliente a COLA1
    public static void llegadaClienteCola1() {
        int cliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el número del cliente:"));
        cola1.add(cliente);
        JOptionPane.showMessageDialog(null, "Cliente [" + cliente + "] ha sido añadido a COLA1.");
    }

    //Pasar el cliente de COLA1 a COLA2
    public static void salidaClienteCola1() {
        if (cola1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "COLA 1 está vacía.");
            return;
        }
        int cliente = cola1.poll();
        cola2.add(cliente);
        JOptionPane.showMessageDialog(null, "Cliente [" + cliente + "] ha sido transferido de COLA1 a COLA 2.");
    }
 
    //Pasar el cliente de COLA2 a PILA
    public static void salidaClienteCola2() {
        if (cola2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "COLA2 está vacía.");
            return;
        }
        int cliente = cola2.poll();
        pila.push(cliente);
        JOptionPane.showMessageDialog(null, "Cliente [" + cliente + "] ha sido transferido de COLA2 a PILA.");
    }

    //Eliminar un cliente de PILA
    public static void salidaClientePila() {
        if (pila.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La PILA está vacía.");
            return;
        }

        int clienteAEliminar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el número del cliente que saldrá de la PILA:"));
        boolean encontrado = false;

        // Pasar elementos a pilaTemp hasta encontrar al cliente
        while (!pila.isEmpty()) {
            int cliente = pila.pop();
            if (cliente == clienteAEliminar) {
                JOptionPane.showMessageDialog(null, "Cliente [" + clienteAEliminar + "] ha sido eliminado de la PILA.");
                encontrado = true;
                break;
            } else {
                pilaTemp.push(cliente);
            }
        }

        // Regresar los elementos de pilaTemp a pila
        while (!pilaTemp.isEmpty()) {
            pila.push(pilaTemp.pop());
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Cliente [" + clienteAEliminar + "] no encontrado en la PILA.");
        }
    }

    //Imprimir el contenido de COLA1, COLA2 y PILA
    public static void imprimirCola1() {
        if (cola1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "COLA 1 está vacía.");
        } else {
            StringBuilder contenido = new StringBuilder("Clientes en COLA 1:\n");
            for (int cliente : cola1) {
                contenido.append(cliente).append("\n");
            }
            JOptionPane.showMessageDialog(null, contenido.toString());
        }
    }

    public static void imprimirCola2() {
        if (cola2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "COLA2 está vacía.");
        } else {
            StringBuilder contenido = new StringBuilder("Clientes en COLA 2:\n");
            for (int cliente : cola2) {
                contenido.append(cliente).append("\n");
            }
            JOptionPane.showMessageDialog(null, contenido.toString());
        }
    }

    public static void imprimirPila() {
        if (pila.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La PILA está vacía.");
        } else {
            StringBuilder contenido = new StringBuilder("Clientes en la PILA:\n");
            for (int cliente : pila) {
                contenido.append(cliente).append("\n");
            }
            JOptionPane.showMessageDialog(null, contenido.toString());
        }
    }

    //Cantidad de elementos en COLA1, COLA2 y PILA
    public static void cantidadCola1() {
        JOptionPane.showMessageDialog(null, "Cantidad de clientes en COLA1: " + cola1.size());
    }

    public static void cantidadCola2() {
        JOptionPane.showMessageDialog(null, "Cantidad de clientes en COLA2: " + cola2.size());
    }

    public static void cantidadPila() {
        JOptionPane.showMessageDialog(null, "Cantidad de clientes en la PILA: " + pila.size());
    }

    //Da el primer o último cliente en COLA1, COLA2 y PILA
    public static void primerClienteCola1() {
        if (cola1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "COLA1 está vacía.");
        } else {
            JOptionPane.showMessageDialog(null, "Primer cliente en COLA1: " + cola1.peek());
        }
    }

    public static void primerClienteCola2() {
        if (cola2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "COLA2 está vacía.");
        } else {
            JOptionPane.showMessageDialog(null, "Primer cliente en COLA2: " + cola2.peek());
        }
    }

    public static void ultimoClientePila() {
        if (pila.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La PILA está vacía.");
        } else {
            JOptionPane.showMessageDialog(null, "Último cliente en la PILA: " + pila.peek());
        }
    }

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                        1. Llegada cliente a COLA 1
                                                                        2. Transferir cliente de COLA 1 a COLA 2
                                                                        3. Transferir cliente de COLA 2 a PILA
                                                                        4. Baja cliente de PILA
                                                                        5. Imprimir COLA1
                                                                        6. Imprimir COLA2
                                                                        7. Imprimir PILA
                                                                        8. Cantidad de clientes en COLA 1
                                                                        9. Cantidad de clientes en COLA 2
                                                                        10. Cantidad de clientes en PILA
                                                                        11. Primer cliente en COLA 1
                                                                        12. Primer cliente en COLA 2
                                                                        13. Último cliente en PILA
                                                                        14. Salir
                                                                        """, "Menú", JOptionPane.QUESTION_MESSAGE));

            switch (opcion) {
                case 1 -> llegadaClienteCola1();
                case 2 -> salidaClienteCola1();
                case 3 -> salidaClienteCola2();
                case 4 -> salidaClientePila();
                case 5 -> imprimirCola1();
                case 6 -> imprimirCola2();
                case 7 -> imprimirPila();
                case 8 -> cantidadCola1();
                case 9 -> cantidadCola2();
                case 10 -> cantidadPila();
                case 11 -> primerClienteCola1();
                case 12 -> primerClienteCola2();
                case 13 -> ultimoClientePila();
                case 14 -> JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                default -> JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (opcion != 14);
    }
}
