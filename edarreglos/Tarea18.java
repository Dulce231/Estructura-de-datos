package com.mycompany.edarreglos;
import javax.swing.JOptionPane;

public class Tarea18 {
    
    // Clase Nodo
    public class Node {
        Node next;
        int numemp;
        String nombre;
        int depto;
        float salario;
        Node prev;
        
        public Node(int numemp, String nombre, int depto, float salario) {
            this.numemp = numemp;
            this.nombre = nombre;
            this.depto = depto;
            this.salario = salario;
            this.next = null;
            this.prev = null;
        }
    }

 
    Node firstLDEC;

   
    Node firstLESC;

    public Tarea18() {
        firstLDEC = null;
        firstLESC = null;
    }

   
    public boolean estaVaciaLDEC() {
        return firstLDEC == null;
    }

    
    public boolean estaVaciaLESC() {
        return firstLESC == null;
    }

    
    public void inicializarLDEC() {
        firstLDEC = null;
    }

   
    public void insertarOrdenadoLDEC(int numemp, String nombre, int depto, float salario) {
        Node nuevoNodo = new Node(numemp, nombre, depto, salario);
        
        if (estaVaciaLDEC()) {
            firstLDEC = nuevoNodo;
            nuevoNodo.next = nuevoNodo;
            nuevoNodo.prev = nuevoNodo;
        } else {
            Node temp = firstLDEC;
            do {
                if (depto < temp.depto || (depto == temp.depto && numemp < temp.numemp)) {
                    if (temp == firstLDEC) {
                  
                        Node ultimo = firstLDEC.prev;
                        nuevoNodo.next = firstLDEC;
                        nuevoNodo.prev = ultimo;
                        ultimo.next = nuevoNodo;
                        firstLDEC.prev = nuevoNodo;
                        firstLDEC = nuevoNodo;
                    } else {
                     
                        Node anterior = temp.prev;
                        nuevoNodo.next = temp;
                        nuevoNodo.prev = anterior;
                        anterior.next = nuevoNodo;
                        temp.prev = nuevoNodo;
                    }
                    return;
                }
                temp = temp.next;
            } while (temp != firstLDEC);

            Node ultimo = firstLDEC.prev;
            nuevoNodo.next = firstLDEC;
            nuevoNodo.prev = ultimo;
            ultimo.next = nuevoNodo;
            firstLDEC.prev = nuevoNodo;
        }
    }

    
    public void eliminarLDEC(int numemp) {
        if (estaVaciaLDEC()) return;

        Node temp = firstLDEC;
        do {
            if (temp.numemp == numemp) {
                if (temp == firstLDEC && temp.next == firstLDEC) {
                    firstLDEC = null;
                } else {
                    Node anterior = temp.prev;
                    Node siguiente = temp.next;
                    anterior.next = siguiente;
                    siguiente.prev = anterior;
                    if (temp == firstLDEC) {
                        firstLDEC = siguiente;
                    }
                }
                return;
            }
            temp = temp.next;
        } while (temp != firstLDEC);
    }

   
    public void imprimirCantidadLDEC() {
        if (estaVaciaLDEC()) {
            JOptionPane.showMessageDialog(null, "La LDEC está vacía.");
        } else {
            Node temp = firstLDEC;
            int count = 0;
            do {
                count++;
                temp = temp.next;
            } while (temp != firstLDEC);
            JOptionPane.showMessageDialog(null, "Cantidad de nodos en LDEC: " + count);
        }
    }

    
    public void imprimirLDECHaciaAdelante() {
        if (estaVaciaLDEC()) {
            JOptionPane.showMessageDialog(null, "La LDEC está vacía.");
            return;
        }
        StringBuilder datos = new StringBuilder();
        Node temp = firstLDEC;
        do {
            datos.append("\nNumero de Empleado: ").append(temp.numemp).append("\n Nombre: ").append(temp.nombre)
                    .append("\n Departamento: ").append(temp.depto).append("\n Salario:").append(temp.salario).append("\n");
            temp = temp.next;
        } while (temp != firstLDEC);
        JOptionPane.showMessageDialog(null, datos.toString(), "LDEC hacia adelante", JOptionPane.INFORMATION_MESSAGE);
    }

    public void imprimirLDECHaciaAtras() {
        if (estaVaciaLDEC()) {
            JOptionPane.showMessageDialog(null, "La LDEC está vacía.");
            return;
        }
        StringBuilder datos = new StringBuilder();
        Node temp = firstLDEC.prev;
        do {
            datos.append("\nNumero Empleado: ").append(temp.numemp).append("\n Nombre: ").append(temp.nombre)
                    .append("\n Departamento: ").append(temp.depto).append("\nSalario: ").append(temp.salario).append("\n");
            temp = temp.prev;
        } while (temp != firstLDEC.prev);
        JOptionPane.showMessageDialog(null, datos.toString(), "LDEC hacia atrás", JOptionPane.INFORMATION_MESSAGE);
    }

    
    public void imprimirNodosPorDeptoLDEC(int depto) {
        if (estaVaciaLDEC()) {
            JOptionPane.showMessageDialog(null, "La LDEC está vacía.");
            return;
        }
        StringBuilder datos = new StringBuilder();
        Node temp = firstLDEC;
        do {
            if (temp.depto == depto) {
                datos.append("\nNumero de Empleado: ").append(temp.numemp).append("\n Nombre: ").append(temp.nombre)
                        .append("\nDepartamento: ").append(temp.depto).append("\n Salario: ").append(temp.salario).append("\n");
            }
            temp = temp.next;
        } while (temp != firstLDEC);
        JOptionPane.showMessageDialog(null, datos.toString(), "Empleados del depto " + depto, JOptionPane.INFORMATION_MESSAGE);
    }

 
    public void copiarDeptoALESC(int depto) {
        if (estaVaciaLDEC()) return;

        Node temp = firstLDEC;
        do {
            if (temp.depto == depto) {
                Node nuevoNodo = new Node(temp.numemp, temp.nombre, temp.depto, temp.salario);
                if (estaVaciaLESC()) {
                    firstLESC = nuevoNodo;
                    nuevoNodo.next = firstLESC;
                } else {
                    Node tempLESC = firstLESC;
                    while (tempLESC.next != firstLESC) {
                        tempLESC = tempLESC.next;
                    }
                    tempLESC.next = nuevoNodo;
                    nuevoNodo.next = firstLESC;
                }
            }
            temp = temp.next;
        } while (temp != firstLDEC);
    }

   
    public void imprimirLESC() {
        if (estaVaciaLESC()) {
            JOptionPane.showMessageDialog(null, "La LESC está vacía.");
            return;
        }
        StringBuilder datos = new StringBuilder();
        Node temp = firstLESC;
        do {
            datos.append("\nNumero de Empleado: ").append(temp.numemp).append("\nNombre: ").append(temp.nombre)
                    .append("\nDepartamento: ").append(temp.depto).append("\nSalario: ").append(temp.salario).append("\n");
            temp = temp.next;
        } while (temp != firstLESC);
        JOptionPane.showMessageDialog(null, datos.toString(), "Empleados en LESC", JOptionPane.INFORMATION_MESSAGE);
    }

    
    public void imprimirCantidadLESC() {
        if (estaVaciaLESC()) {
            JOptionPane.showMessageDialog(null, "La LESC está vacía.");
        } else {
            Node temp = firstLESC;
            int count = 0;
            do {
                count++;
                temp = temp.next;
            } while (temp != firstLESC);
            JOptionPane.showMessageDialog(null, "Cantidad de nodos en LESC: " + count);
        }
    }

    // Método principal
    public static void main(String[] args) {
     Tarea18 listas = new Tarea18();
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    1.- Insertar empleado en LDEC.
                    2.- Eliminar empleado de LDEC por NUMEMP.
                    3.- Imprimir cantidad de empleados en LDEC.
                    4.- Imprimir empleados de LDEC hacia adelante.
                    5.- Imprimir empleados de LDEC hacia atrás.
                    6.- Imprimir empleados de un depto en LDEC.
                    7.- Copiar empleados de un depto a LESC.
                    8.- Imprimir empleados de LESC.
                    9.- Imprimir cantidad de empleados en LESC.
                    10.- Salir.""", "Menú", JOptionPane.QUESTION_MESSAGE));
            switch (opcion) {
                case 1 -> {
                    int numemp = Integer.parseInt(JOptionPane.showInputDialog("Número de empleado:"));
                    String nombre = JOptionPane.showInputDialog("Nombre:");
                    int depto = Integer.parseInt(JOptionPane.showInputDialog("Departamento:"));
                    float salario = Float.parseFloat(JOptionPane.showInputDialog("Salario:"));
                    listas.insertarOrdenadoLDEC(numemp, nombre, depto, salario);
                }
                case 2 -> {
                    int numemp = Integer.parseInt(JOptionPane.showInputDialog("Número de empleado a eliminar:"));
                    listas.eliminarLDEC(numemp);
                }
                case 3 -> listas.imprimirCantidadLDEC();
                case 4 -> listas.imprimirLDECHaciaAdelante();
                case 5 -> listas.imprimirLDECHaciaAtras();
                case 6 -> {
                    int depto = Integer.parseInt(JOptionPane.showInputDialog("Departamento a buscar:"));
                    listas.imprimirNodosPorDeptoLDEC(depto);
                }
                case 7 -> {
                    int depto = Integer.parseInt(JOptionPane.showInputDialog("Departamento a copiar:"));
                    listas.copiarDeptoALESC(depto);
                }
                case 8 -> listas.imprimirLESC();
                case 9 -> listas.imprimirCantidadLESC();
            }
        } while (opcion != 10);
    }
}

