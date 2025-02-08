package com.mycompany.edarreglos;

import javax.swing.JOptionPane;

public class Tarea17 {

    // Clase Nodo
    public class Nodo {
        int cveart;
        String nomart;
        float precio;
        Nodo next;
        Nodo prev;
        
        public Nodo(int cveart, String nomart, float precio) {
            this.cveart = cveart;
            this.nomart = nomart;
            this.precio = precio;
            this.next = null;
            this.prev = null;
        }
    }


    Nodo first;

    
    public Tarea17() {
        first = null;
    }

   
    public boolean estaVacia() {
        return first == null;
    }

    // Insertar un elemento ordenado por CVEART de menor a mayor
    public void insertarOrden(int cveart, String nomart, float precio) {
        Nodo nvonodo = new Nodo(cveart, nomart, precio); // Nuevo nodo
        if (estaVacia()) {
            first = nvonodo; 
        } else if (cveart < first.cveart) {
            nvonodo.next = first;
            first.prev = nvonodo; 
            first = nvonodo;
        } else {
            Nodo temp = first;
            Nodo ant = null;

            while (temp != null && temp.cveart < cveart) {
                ant = temp;
                temp = temp.next;
            }

            if (temp == null) { 
                ant.next = nvonodo;
                nvonodo.prev = ant;
            } else { 
                nvonodo.next = temp;
                nvonodo.prev = ant;
                ant.next = nvonodo;
                temp.prev = nvonodo;
            }
        }
    }

    // Borrar un nodo por CVEART
    public void borrar(int cveart) {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La lista está vacía", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Nodo temp = first;

        // Buscar el nodo con el CVEART dado
        while (temp != null && temp.cveart != cveart) {
            temp = temp.next;
        }

        if (temp == null) { 
            JOptionPane.showMessageDialog(null, "No se encontró el artículo con clave " + cveart, "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (temp == first) { 
            first = first.next;
            if (first != null) {
                first.prev = null;
            }
        } else if (temp.next == null) { 
            temp.prev.next = null;
        } else { 
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        JOptionPane.showMessageDialog(null, "Nodo con clave " + cveart + " eliminado.");
    }

    // Imprimir todos los elementos de la lista
    public void imprimir() {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La lista está vacía", "Lista de Artículos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Nodo temp = first;
        StringBuilder lista = new StringBuilder();
        while (temp != null) {
            lista.append("-------------------------------\nClave: ").append(temp.cveart).append("\nNombre: ").append(temp.nomart).append("\nPrecio: ").append(temp.precio).append("\n-------------------------------\n");
            temp = temp.next;
        }
        JOptionPane.showMessageDialog(null, lista.toString(), "Lista de Artículos", JOptionPane.INFORMATION_MESSAGE);
    }

    // Imprimir los nodos con un precio mayor o igual a X
    public void imprimirPrecioMayorIgual(float x) {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La lista está vacía", "Precio >= X", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Nodo temp = first;
        StringBuilder lista = new StringBuilder();

        while (temp != null) {
            if (temp.precio >= x) {
                lista.append("-------------------------------\nClave: ").append(temp.cveart).append("\nNombre: ").append(temp.nomart).append("\nPrecio: ").append(temp.precio).append("\n-------------------------------\n");
            }
            temp = temp.next;
        }

        if (!lista.toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, lista.toString(), "Precio >= " + x, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay artículos con precio mayor o igual a " + x, "Precio >= X", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Imprimir el primer elemento de la lista
    public void imprimirPrimerElemento() {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La lista está vacía", "Primer elemento", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Clave: " + first.cveart + "\nNombre: " + first.nomart + "\nPrecio: " + first.precio, "Primer elemento", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Contar el número de nodos en la lista
    public int tamaño() {
        if (estaVacia()) {
            return 0;
        }

        Nodo temp = first;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Método principal para probar la lista
    public static void main(String[] args) {
    Tarea17 lde = new Tarea17();
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    1.- Insertar elemento.
                    2.- Verificar si la lista está vacía.
                    3.- Borrar elemento por CVEART.
                    4.- Imprimir todos los elementos.
                    5.- Imprimir los nodos con precio >= X.
                    6.- Imprimir el primer elemento.
                    7.- Imprimir el tamaño de la lista.
                    8.- Salir del programa.
                    Seleccione una opción:
                    """, "Menú", JOptionPane.PLAIN_MESSAGE));

            switch (opcion) {
                case 1 -> {
                    int cveart = Integer.parseInt(JOptionPane.showInputDialog("Clave del artículo: "));
                    String nomart = JOptionPane.showInputDialog("Nombre del artículo: ");
                    float precio = Float.parseFloat(JOptionPane.showInputDialog("Precio del artículo: "));
                    lde.insertarOrden(cveart, nomart, precio);
                }
                case 2 -> {
                    if (lde.estaVacia()) {
                        JOptionPane.showMessageDialog(null, "La lista está vacía", "Vacío", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "La lista tiene " + lde.tamaño() + " elemento(s)", "Vacío", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                case 3 -> {
                    int cveart = Integer.parseInt(JOptionPane.showInputDialog("Clave del artículo a borrar: "));
                    lde.borrar(cveart);
                }
                case 4 -> lde.imprimir();
                case 5 -> {
                    float x = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio mínimo: "));
                    lde.imprimirPrecioMayorIgual(x);
                }
                case 6 -> lde.imprimirPrimerElemento();
                case 7 -> JOptionPane.showMessageDialog(null, "La lista tiene " + lde.tamaño() + " elemento(s)", "Tamaño", JOptionPane.INFORMATION_MESSAGE);
                case 8 -> JOptionPane.showMessageDialog(null, "FIN DEL PROGRAMA");
                default -> JOptionPane.showMessageDialog(null, "Ingrese una opción válida", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } while (opcion != 8);
    }
}
