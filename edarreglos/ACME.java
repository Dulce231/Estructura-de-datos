//DULCE MARIA MUÑIZ LOPEZ
package com.mycompany.edarreglos;
import java.util.LinkedList;
import java.util.Stack;
import javax.swing.JOptionPane;

public class ACME {

    static Stack<Integer> pila1 = new Stack<>();
    static Stack<Integer> pila2 = new Stack<>();
    static Stack<Integer> pilatemp = new Stack<>();
    static LinkedList<Integer> cola1 = new LinkedList<>();
    static LinkedList<Integer> cola2 = new LinkedList<>();

    public void Imprimirpila1() {
        if (pila1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La PILA 1 está vacía", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            StringBuilder mostrar = new StringBuilder();
            for (Integer i : pila1) {
                mostrar.append(i).append("\n");
            }
            JOptionPane.showMessageDialog(null, "Elementos de la pila 1:\n" + mostrar);
        }
    }

    public void Imprimirpila2() {
        if (pila2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La PILA 2 está vacía", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            StringBuilder mostrar = new StringBuilder();
            for (Integer i : pila2) {
                mostrar.append(i).append("\n");
            }
            JOptionPane.showMessageDialog(null, "Elementos de la pila 2:\n" + mostrar);
        }
    }

    public void Imprimirpilatemp() {
        if (pilatemp.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La PILA TEMPORAL está vacía", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            StringBuilder mostrar = new StringBuilder();
            for (Integer i : pilatemp) {
                mostrar.append(i).append("\n");
            }
            JOptionPane.showMessageDialog(null, "Elementos de la PILA TEMPORAL:\n" + mostrar);
        }
    }

    public void Imprimircola1() {
        if (cola1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La COLA 1 está vacía.", "IMPRIMIR TODOS LOS ELEMENTOS",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            String mostrar = cola1.toString() + "\n";
            JOptionPane.showMessageDialog(null, "Contenido de COLA 1: " + mostrar, "IMPRIMIR TODOS LOS ELEMENTOS",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void Imprimircola2() {
        if (cola2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La COLA 2 está vacía.", "IMPRIMIR TODOS LOS ELEMENTOS",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            String mostrar = cola2.toString() + "\n";
            JOptionPane.showMessageDialog(null, "Contenido de COLA 2: " + mostrar, "IMPRIMIR TODOS LOS ELEMENTOS",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void LlegadaClientesACola1(int llegaCliente) {
        JOptionPane.showMessageDialog(null, "El cliente " + llegaCliente + " se ha formado", "CONFIRMACION", JOptionPane.PLAIN_MESSAGE);
        cola1.add(llegaCliente);
    }

    public void BorraCola1insertarPILA1() {
        if (cola1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La COLA 1 está vacía", "BORRAR DE COLA 1", JOptionPane.WARNING_MESSAGE);
        } else {
            int cliente = cola1.poll(); // Se saca el cliente de cola1
            pila1.push(cliente); // Se inserta en pila1
            JOptionPane.showMessageDialog(null, "El cliente " + cliente + " se ha movido a la PILA 1", "MOVIENDO A PILA", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void BorrarDePila() {
        if (pila1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La PILA 1 está vacía", "BORRAR DE PILA", JOptionPane.WARNING_MESSAGE);
        } else {
            StringBuilder mostrarPILA = new StringBuilder();
            for (Integer i : pila1) {
                mostrarPILA.append(i).append("\n");
            }

            int sacar = Integer.parseInt(JOptionPane.showInputDialog(null, "Elementos de la PILA 1:\n" + mostrarPILA + "\n¿Qué elemento deseas sacar?", "SACAR", JOptionPane.QUESTION_MESSAGE));
            if (pila1.contains(sacar)) {
                while (!pila1.peek().equals(sacar)) {
                    pilatemp.push(pila1.pop());
                }
                cola2.add(pila1.pop());
                JOptionPane.showMessageDialog(null, "El cliente " + sacar + " se ha pasado a COLA 2", "ELIMINANDO CLIENTE", JOptionPane.WARNING_MESSAGE);

                while (!pilatemp.isEmpty()) {
                    pila1.push(pilatemp.pop());
                }
            } else {
                JOptionPane.showMessageDialog(null, "El elemento no existe", "BORRAR DE PILA", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void BorrarCOLA2pasePILA2() {
        if (cola2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La COLA 2 está vacía", "BORRAR DE COLA2", JOptionPane.WARNING_MESSAGE);
        } else {
            int elemento = cola2.pollFirst();
            JOptionPane.showMessageDialog(null, "Borrando de COLA2: " + elemento, "EL ELEMENTO SE BORRÓ DE LA COLA 2", JOptionPane.INFORMATION_MESSAGE);
            pila2.push(elemento);
            JOptionPane.showMessageDialog(null, "El elemento " + elemento + " ha sido movido a PILA2", "EL ELEMENTO SE CAMBIÓ A PILA 2", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void BorrarDePILA2() {
        if (pila2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La PILA 2 está vacía", "BORRAR DE PILA2", JOptionPane.WARNING_MESSAGE);
        } else {
            int elemento = pila2.pop();
            JOptionPane.showMessageDialog(null, "El elemento " + elemento + " ha sido borrado de PILA2", "ELEMENTO BORRADO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void imprimirPilas() {
        if (pila1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La PILA 1 está vacía.", "IMPRIMIR PILA 1", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder contenidoPila1 = new StringBuilder("ELEMENTOS EN LA PILA 1:\n");
            for (Integer vehiculo : pila1) {
                contenidoPila1.append(vehiculo).append("\n");
            }
            JOptionPane.showMessageDialog(null, contenidoPila1.toString(), "IMPRIMIR PILA 1", JOptionPane.INFORMATION_MESSAGE);
        }

        if (pila2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La PILA 2 está vacía.", "IMPRIMIR PILA 2", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder contenidoPila2 = new StringBuilder("ELEMENTOS EN LA PILA 2:\n");
            for (Integer vehiculo : pila2) {
                contenidoPila2.append(vehiculo).append("\n");
            }
            JOptionPane.showMessageDialog(null, contenidoPila2.toString(), "IMPRIMIR PILA 2", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void imprimirColas() {
        if (cola1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La COLA 1 está vacía.", "IMPRIMIR COLA 1", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder contenidoCola1 = new StringBuilder("ELEMENTOS EN LA COLA 1:\n");
            for (Integer vehiculo : cola1) {
                contenidoCola1.append(vehiculo).append("\n");
            }
            JOptionPane.showMessageDialog(null, contenidoCola1.toString(), "IMPRIMIR COLA 1", JOptionPane.INFORMATION_MESSAGE);
        }

        if (cola2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La COLA 2 está vacía.", "IMPRIMIR COLA 2", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder contenidoCola2 = new StringBuilder("ELEMENTOS EN LA COLA 2:\n");
            for (Integer vehiculo : cola2) {
                contenidoCola2.append(vehiculo).append("\n");
            }
            JOptionPane.showMessageDialog(null, contenidoCola2.toString(), "IMPRIMIR COLA 2", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        ACME sistema = new ACME();
        int opcion;

        do {
            String menu = "1. Llegada de cliente a COLA 1\n" +
                          "2. Mover cliente de COLA 1 a PILA 1\n" +
                          "3. Sacar cliente de PILA 1\n" +
                          "4. Mover cliente de COLA 2 a PILA 2\n" +
                          "5. Borrar de PILA 2\n" +
                          "6. Imprimir PILA 1\n" +
                          "7. Imprimir PILA 2\n" +
                          "8. Imprimir COLA 1\n" +
                          "9. Imprimir COLA 2\n" +
                          "10. Salir";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1:
                    int llegaCliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente que llega:"));
                    LlegadaClientesACola1(llegaCliente);
                    break;
                case 2:
                    sistema.BorraCola1insertarPILA1();
                    break;
                case 3:
                    sistema.BorrarDePila();
                    break;
                case 4:
                    sistema.BorrarCOLA2pasePILA2();
                    break;
                case 5:
                    sistema.BorrarDePILA2();
                    break;
                case 6:
                    sistema.Imprimirpila1();
                    break;
                case 7:
                    sistema.Imprimirpila2();
                    break;
                case 8:
                    sistema.Imprimircola1();
                    break;
                case 9:
                    sistema.Imprimircola2();
                    break;
                case 10:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema", "CERRANDO", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Inténtalo de nuevo.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (opcion != 10);
    }
}