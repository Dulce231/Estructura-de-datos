package practica;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Stack;

public class pra {
    static String mostrar = "";
    Stack<String> PILA = new Stack<>();
    LinkedList<String> COLA = new LinkedList<>();
    int placa;
    pra izq, der, raiz = null;
    static int ArbolCount = 0;
    char estatus = 'a';

    public pra(char estatus, int placa) {
        this.placa = placa;
        this.estatus = estatus;
    }

    public pra() {
    }

    public boolean pila() {
        return !PILA.isEmpty();
    }

    public void LlegadaApila() {
        String p = JOptionPane.showInputDialog(null, "Ingrese el número de placa", "Ingresar Placa a PILA", JOptionPane.QUESTION_MESSAGE);
        if (p != null && !p.trim().isEmpty()) {
            PILA.push(p.trim());
            JOptionPane.showMessageDialog(null, "Placa agregada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "La placa no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void SacarPilapasarCola() {
        if (PILA.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La PILA está vacía.", "PILA VACÍA", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String mostrarPlacas = String.join("\n", PILA);
        String sacar = JOptionPane.showInputDialog(null, "Autos estacionados:\n" + mostrarPlacas + "\nIngresa una placa.", "BAJA DEL VEHÍCULO", JOptionPane.QUESTION_MESSAGE);

        if (sacar != null && PILA.contains(sacar.trim())) {
            while (!PILA.peek().equalsIgnoreCase(sacar.trim())) {
                COLA.add(PILA.pop());
            }
            JOptionPane.showMessageDialog(null, "El auto con placa [" + PILA.pop() + "] ha salido.", "Vehículo Retirado", JOptionPane.PLAIN_MESSAGE);

            while (!COLA.isEmpty()) {
                PILA.push(COLA.pollFirst());
            }
        } else {
            JOptionPane.showMessageDialog(null, "La placa [" + sacar + "] no se ha encontrado.");
        }
    }

    public void imprimirPila() {
        if (PILA.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El estacionamiento temporal está vacío.", "PILA VACÍA", JOptionPane.WARNING_MESSAGE);
        } else {
            String mostrarPlacas = String.join("\n", PILA);
            JOptionPane.showMessageDialog(null, "Autos en el estacionamiento temporal:\n" + mostrarPlacas);
        }
    }

    public void tamañoPila() {
        JOptionPane.showMessageDialog(null, "Hay " + PILA.size() + " auto(s) en la PILA.");
    }

    public void InsertarArbol() {
        ArbolCount++;
        int placa = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte la placa:"));
        pra nodo_nuevo = new pra('a', placa);

        if (raiz == null) {
            raiz = nodo_nuevo;
        } else {
            pra auxiliar = raiz;
            pra padre;
            while (true) {
                padre = auxiliar;
                if (placa < auxiliar.placa) {
                    auxiliar = auxiliar.izq;
                    if (auxiliar == null) {
                        padre.izq = nodo_nuevo;
                        return;
                    }
                } else {
                    auxiliar = auxiliar.der;
                    if (auxiliar == null) {
                        padre.der = nodo_nuevo;
                        return;
                    }
                }
            }
        }
    }

    public void PREORDER(pra n) {
        if (n != null && n.estatus != 'b') {
            mostrar += "Placa: " + n.placa + "\n";
            PREORDER(n.izq);
            PREORDER(n.der);
        }
    }

    public void INORDER(pra n) {
        if (n != null && n.estatus != 'b') {
            INORDER(n.izq);
            mostrar += "Placa: " + n.placa + "\n";
            INORDER(n.der);
        }
    }

    public void post_orden(pra n) {
        if (n != null && n.estatus != 'b') {
            post_orden(n.izq);
            post_orden(n.der);
            mostrar += "Placa: " + n.placa + "\n";
        }
    }

    public void ImprimirCola() {
        if (COLA.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La COLA está vacía.", "COLA VACÍA", JOptionPane.WARNING_MESSAGE);
        } else {
            String mostrarPlacas = String.join("\n", COLA);
            JOptionPane.showMessageDialog(null, "Contenido de la COLA:\n" + mostrarPlacas);
        }
    }

    public void ImprimirPrimerInsertadoCOLA() {
        if (COLA.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La COLA está vacía.", "COLA VACÍA", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Primer elemento de la COLA: [" + COLA.getFirst() + "]");
        }
    }

    public void ImprimirUltimoInsertadoCOLA() {
        if (COLA.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La COLA está vacía.", "COLA VACÍA", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Último elemento de la COLA: [" + COLA.getLast() + "]");
        }
    }

    public void cantidadNodos() {
        JOptionPane.showMessageDialog(null, "Cantidad de nodos activos en el árbol: " + ArbolCount);
    }

    public void EliminarNodo() {
        int placaEliminar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la placa del nodo a eliminar:", "Eliminar Nodo", JOptionPane.QUESTION_MESSAGE));
        pra actual = raiz, padre = null;

        while (actual != null && actual.placa != placaEliminar) {
            padre = actual;
            if (placaEliminar < actual.placa) actual = actual.izq;
            else actual = actual.der;
        }

        if (actual == null) {
            JOptionPane.showMessageDialog(null, "Placa no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (actual.izq == null && actual.der == null) { // Nodo hoja
            if (actual == raiz) raiz = null;
            else if (padre.izq == actual) padre.izq = null;
            else padre.der = null;
        } else if (actual.izq == null || actual.der == null) { // Nodo con un hijo
            pra hijo = (actual.izq != null) ? actual.izq : actual.der;
            if (actual == raiz) raiz = hijo;
            else if (padre.izq == actual) padre.izq = hijo;
            else padre.der = hijo;
        } else { // Nodo con dos hijos
            pra sucesor = actual.der, sucesorPadre = actual;
            while (sucesor.izq != null) {
                sucesorPadre = sucesor;
                sucesor = sucesor.izq;
            }
            actual.placa = sucesor.placa;
            if (sucesorPadre.izq == sucesor) sucesorPadre.izq = sucesor.der;
            else sucesorPadre.der = sucesor.der;
        }

        ArbolCount--;
        JOptionPane.showMessageDialog(null, "Nodo eliminado correctamente.");
    }

    public void pasar_De_arbol_a_cola(pra n) {
        mostrar = "";
        INORDER(n);
        String[] placas = mostrar.split("\n");
        for (String placa : placas) {
            if (!placa.trim().isEmpty()) {
                COLA.add(placa.replace("Placa: ", "").trim());
            }
        }
        JOptionPane.showMessageDialog(null, "Los elementos del árbol han sido transferidos a la COLA.");
    }

    public static void main(String[] args) {
        pra arbol = new pra();
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    Menú:
                    1) Agregar auto a PILA
                    2) Sacar auto de PILA
                    3) Imprimir contenido de PILA
                    4) Insertar nodo en árbol binario
                    5) Recorrer árbol (Preorden, Inorden, Postorden)
                    6) Eliminar nodo de árbol
                    7) Contar nodos en árbol
                    8) Pasar recorrido Inorden a COLA
                    9) Imprimir COLA
                    10) Imprimir primer y último elemento de COLA
                    11) Tamaño de PILA
                    0) Salir
                    """));
            switch (opcion) {
                case 1 -> arbol.LlegadaApila();
                case 2 -> arbol.SacarPilapasarCola();
                case 3 -> arbol.imprimirPila();
                case 4 -> arbol.InsertarArbol();
                case 5 -> {
                    mostrar = "";
                    arbol.PREORDER(arbol.raiz);
                    JOptionPane.showMessageDialog(null, "Preorden:\n" + mostrar);

                    mostrar = "";
                    arbol.INORDER(arbol.raiz);
                    JOptionPane.showMessageDialog(null, "Inorden:\n" + mostrar);

                    mostrar = "";
                    arbol.post_orden(arbol.raiz);
                    JOptionPane.showMessageDialog(null, "Postorden:\n" + mostrar);
                }
                case 6 -> arbol.EliminarNodo();
                case 7 -> arbol.cantidadNodos();
                case 8 -> arbol.pasar_De_arbol_a_cola(arbol.raiz);
                case 9 -> arbol.ImprimirCola();
                case 10 -> {
                    arbol.ImprimirPrimerInsertadoCOLA();
                    arbol.ImprimirUltimoInsertadoCOLA();
                }
                case 11 -> arbol.tamañoPila();
                case 0 -> JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                default -> JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (opcion != 0);
    }
}
