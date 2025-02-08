package com.mycompany.edarreglos;
import javax.swing.JOptionPane;

public class Tarea15 {

    // Clase Nodo
    public class Nodo {
        int cveart;
        String nomart;
        float precio;
        Nodo next; 

        public Nodo(int cveart, String nomart, float precio) {
            this.cveart = cveart;
            this.nomart = nomart;
            this.precio = precio;
        }
    }

    // Puntero al primer nodo
    Nodo first;

    public Tarea15() {
        first = null; 
    }

    // Verifica si la lista está vacía
    public boolean estaVacia() {
        return first == null;
    }

    // Vacia la lista 
    public void inicializarLESC() {
        first = null;
    }

    // Ingresa un elemento en la lista ordenado por CVEART
    public void insertarOrden(int cveart, String nomart, float precio) {
        Nodo nvonodo = new Nodo(cveart, nomart, precio);
        Nodo temp = first, ant = null;

        if (estaVacia()) {
            first = nvonodo;
            nvonodo.next = first; 
        } else if (cveart < first.cveart) {
         
            while (temp.next != first) {
                temp = temp.next; 
            }
            temp.next = nvonodo;
            nvonodo.next = first;
            first = nvonodo;
        } else {
          
            temp = first;
            do {
                ant = temp;
                temp = temp.next;
            } while (temp != first && cveart > temp.cveart);
            
            nvonodo.next = temp;
            ant.next = nvonodo;
        }
    }

    // Borrar un nodo por CVEART
    public void borrar(int cveart) {
        if (estaVacia()) {
            return; 
        }

        Nodo temp = first;
        Nodo ant = null;

        if (first.cveart == cveart) {
         
            if (first.next == first) {
                first = null; 
            } else {
               
                while (temp.next != first) {
                    temp = temp.next;
                }
                temp.next = first.next;
                first = first.next; 
            }
        } else {
            
            do {
                ant = temp;
                temp = temp.next;
            } while (temp != first && temp.cveart != cveart);

            if (temp != first) {
                ant.next = temp.next; 
            }
        }
    }

    // Imprime todos los elementos de la lista
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
        } while (temp != first);

        JOptionPane.showMessageDialog(null, lista, "Lista de Artículos", JOptionPane.INFORMATION_MESSAGE);
    }

    // Imprime los nodos con un precio mayor o igual a X
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

    // Imprime el primer elemento de la lista
    public void imprimirPrimerElemento() {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La lista está vacía", "Primer elemento", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Clave: " + first.cveart + "\nNombre: " + first.nomart + "\nPrecio: " + first.precio, "Primer elemento", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Cuenta el tamaño de nados
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
        Tarea14 t = new Tarea14();
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
                case 8 -> t.inicializarLESC();
                case 9 -> JOptionPane.showMessageDialog(null, "FIN DEL PROGRAMA");
                default -> JOptionPane.showMessageDialog(null, "Ingrese una opción válida", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } while (opcion != 9);
    }
}
