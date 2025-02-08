package com.mycompany.edarreglos;
import javax.swing.JOptionPane;

public class Tarea16 {

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
        }
    }

  
    Nodo first;

    public Tarea16() {
        first = null; 
    }

    // Verifica si la lista está vacía
    public boolean estaVacia() {
        return first == null;
    }

   
    public void inicializarLDEC() {
        first = null;
    }

    // Insertar un elemento en la lista ordenado por CVEART
    public void insertarOrden(int cveart, String nomart, float precio) {
        Nodo nvonodo = new Nodo(cveart, nomart, precio);
        Nodo temp = first, ant = null;

        if (estaVacia()) {
            first = nvonodo;
            nvonodo.next = first;
            nvonodo.prev = first; 
        } else if (cveart < first.cveart) {
          
            while (temp.next != first) {
                temp = temp.next; 
            }
            temp.next = nvonodo;
            nvonodo.prev = temp;
            nvonodo.next = first;
            first.prev = nvonodo;
            first = nvonodo;
        } else {
            
            temp = first;
            do {
                ant = temp;
                temp = temp.next;
            } while (temp != first && cveart > temp.cveart);

            nvonodo.next = temp;
            nvonodo.prev = ant;
            ant.next = nvonodo;
            temp.prev = nvonodo;
        }
    }

    // Borrar un nodo por CVEART
    public void borrar(int cveart) {
        if (estaVacia()) {
            return; 
        }

        Nodo temp = first;

        if (first.cveart == cveart) {
 
            if (first.next == first) {
                first = null; 
            } else {
                Nodo ultimo = first.prev;
                first = first.next;
                first.prev = ultimo;
                ultimo.next = first;
            }
        } else {
         do {
                temp = temp.next;
            } while (temp != first && temp.cveart != cveart);

            if (temp != first) {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
        }
    }

    // Imprimir todos los elementos de la lista
    public void imprimir() {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La lista está vacía", "Lista", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Nodo temp = first;
        String lista = "";
        do {
            lista += "-------------------------------\nClave: " + temp.cveart + "\nNombre: " + temp.nomart + "\nPrecio: " + temp.precio + "\n-------------------------------\n";
            temp = temp.next;
        } while (temp != first); // Recorrer hasta volver al inicio

        JOptionPane.showMessageDialog(null, lista, "Lista de Artículos", JOptionPane.INFORMATION_MESSAGE);
    }

    // Imprimir los nodos con un precio mayor o igual a X
    public void imprimirPrecioMayorIgual(float x) {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La lista está vacía", "Precio >= X", JOptionPane.WARNING_MESSAGE);
        } else {
            Nodo temp = first;
            String lista = "";

            do {
                if (temp.precio >= x) {
                    lista += "-------------------------------\nClave: " + temp.cveart + "\nNombre: " + temp.nomart + "\nPrecio: " + temp.precio + "\n-------------------------------\n";
                }
                temp = temp.next;
            } while (temp != first);

            if (!lista.isEmpty()) {
                JOptionPane.showMessageDialog(null, lista, "Precio >= " + x, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No hay artículos con precio mayor o igual a " + x, "Precio >= X", JOptionPane.WARNING_MESSAGE);
            }
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
        if (estaVacia()) return 0;

        Nodo temp = first;
        int count = 0;
        do {
            count++;
            temp = temp.next;
        } while (temp != first);

        return count;
    }

    public static void main(String[] args) {
        Tarea16 t = new Tarea16 ();
        int opcion;
        int cveart;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                1.- Insertar elemento.
                2.- Verificar si la lista está vacía.
                3.- Borrar elemento por CVEART.
                4.- Imprimir todos los elementos.
                5.- Imprimir los nodos con precio >= X.
                6.- Imprimir el primer elemento.
                7.- Imprimir el tamaño de la lista.
                8.- Inicializar la lista (vaciar).
                9.- Salir del programa.
                Seleccione una opción
                """, "Menú", JOptionPane.PLAIN_MESSAGE));

            switch (opcion) {
                case 1 -> {
                    cveart = Integer.parseInt(JOptionPane.showInputDialog("Clave del artículo: "));
                    String nomart = JOptionPane.showInputDialog("Nombre del artículo: ");
                    float precio = Float.parseFloat(JOptionPane.showInputDialog("Precio del artículo: "));
                    t.insertarOrden(cveart, nomart, precio);
                }
                case 2 -> {
                    if (t.estaVacia()) {
                        JOptionPane.showMessageDialog(null, "La lista está vacía", "Vacío", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "La lista tiene " + t.tamaño() + " elemento(s)", "Vacío", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                case 3 -> {
                    cveart = Integer.parseInt(JOptionPane.showInputDialog("Clave del artículo a borrar: "));
                    t.borrar(cveart);
                }
                case 4 -> t.imprimir();
                case 5 -> {
                    float x = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio mínimo: "));
                    t.imprimirPrecioMayorIgual(x);
                }
                case 6 -> t.imprimirPrimerElemento();
                case 7 -> JOptionPane.showMessageDialog(null, "La lista tiene " + t.tamaño() + " elemento(s)", "Tamaño", JOptionPane.INFORMATION_MESSAGE);
                case 8 -> t.inicializarLDEC();
                case 9 -> JOptionPane.showMessageDialog(null, "FIN DEL PROGRAMA");
                default -> JOptionPane.showMessageDialog(null, "Ingrese una opción válida", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } while (opcion != 9);
    }
}
