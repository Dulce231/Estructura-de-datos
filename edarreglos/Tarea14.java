
/*Efectuar un programa en JAVA que maneje una LISTA ENCADENADA SIMPLE (LES)
usando memoria dinámica CON OBJETOS PUNTERO  con la clase NODO  
CON LOS DATOS DE INT CVEART, STRING NOMART, FLOAT PRECIO; NODO  NEXT; 
USAR LOS APUNTADORES FIRST,ANT,TEMP,NVONODO 
    Y los métodos de: 
Crear la LES --
Verificar si esta vacia --
Insertar un elemento ORDENADO DE MENOR  MAYOR POR CVEART --
Borrar un elemento BUSCANDODOLO POR EL CAMPO DE CVEART ---
Imprimir todos los elementos de LES --
Imprimir los nodos con el PRECIO mayor o igual a X --
Imprimir el primer elemento de la  LES ---
Imprimir el tamaño (cantidad de nodos)de la LES --
 */
package com.mycompany.edarreglos;
import javax.swing.text.StyledEditorKit;
import javax.swing.*;

public class Tarea14 {

    void inicializarLESC() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

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

    // Puntero para el primer nodo de la lista
    Nodo first;

    
    public Tarea14() {
        first = null;
    }

    // verifica si la lista está vacía
    public boolean estaVacia() {
        return first == null;
    }

   //Insertar un elemento en la lista ordenado por CVEART
    public void insertarOrden(int cveart, String nomart, float precio) {
        Nodo nvonodo = new Nodo(cveart, nomart, precio);
        if (estaVacia()) {
            first = nvonodo; 
        } else if (cveart < first.cveart) { 
            nvonodo.next = first;
            first = nvonodo;
        } else {
            Nodo ant = null;
            Nodo temp = first;
            
            while (temp != null && temp.cveart < cveart) {
                ant = temp;
                temp = temp.next;
            }
            nvonodo.next = temp; 
            ant.next = nvonodo;
        }
    }

   

    //Borrar un nodo por CVEART
    public void borrar(int cveart) {
        if (estaVacia()) {
            return; 
        }

        Nodo temp = first;
        Nodo ant = null;

        // Recorre la lista buscando el nodo con la clave cveart
        while (temp != null && temp.cveart != cveart) {
            ant = temp;
            temp = temp.next;
        }

        if (temp == null) {
            return ;
                           }

        if (ant == null) {
            first = temp.next; 
        } else {
            ant.next = temp.next; 
        }
    }

    //Imprimir todos los elementos de la lista 
    public void imprimir() {
        Nodo temp = first;
        String lista = "";
        while (temp != null) {
            lista += "-------------------------------\nClave: " + temp.cveart + "\nNombre: " + temp.nomart + "\nPrecio: " + temp.precio + "\n-------------------------------\n";
            temp = temp.next;
        }
        JOptionPane.showMessageDialog(null, lista, "Lista de Artículos", JOptionPane.INFORMATION_MESSAGE);
    }

    //Imprimir los nodos con un precio mayor o igual a X
    public void imprimirPrecioMayorIgual(float x) {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La lista está vacía", "Precio >= X", JOptionPane.WARNING_MESSAGE);
        } else {
            Nodo temp = first;
            String lista = "";

            while (temp != null) {
                if (temp.precio >= x) {
                    lista += "-------------------------------\nClave: " + temp.cveart + "\nNombre: " + temp.nomart + "\nPrecio: " + temp.precio + "\n-------------------------------\n";
                }
                temp = temp.next;
            }

            if (!lista.isEmpty()) {
                JOptionPane.showMessageDialog(null, lista, "Precio >= " + x, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No hay artículos con precio mayor o igual a " + x, "Precio >= X", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    //Imprimir el primer elemento de la lista
    public void imprimirPrimerElemento() {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La lista está vacía", "Primer elemento", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Clave: " + first.cveart + "\nNombre: " + first.nomart + "\nPrecio: " + first.precio, "Primer elemento", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Contar el número de nodos en la lista
    public int tamaño() {
        Nodo temp = first;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
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
                8.- Salir del programa.
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
                case 8 -> JOptionPane.showMessageDialog(null, "FIN DEL PROGRAMA");
                default -> JOptionPane.showMessageDialog(null, "Ingrese una opción válida", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } while (opcion != 8);
    }
}
