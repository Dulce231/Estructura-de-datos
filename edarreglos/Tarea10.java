package com.mycompany.edarreglos;
import javax.swing.JOptionPane;
public class Tarea10 {
      //EL PRIMER NUMERO QUE ENTRA ESELPRIMER NUMERO QUE SE ELIMINA
    
 int cola[], inicio, fin, max;
    
  public Tarea10(int max) {
            inicio = fin = 0;
            this.max = max;
            this.cola = new int[this.max + 1];
        }

        public boolean vacia() {
            return inicio == fin;
        }

        public boolean llena() {
            return (fin + 1) % max == inicio;
        }

        public void insertar() {
            int elemento;
            elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa un valor", "ENTRADA", JOptionPane.QUESTION_MESSAGE));
            if (!llena()) {
                cola[fin] = elemento;
                fin = (fin + 1) % max;
            } else {
                JOptionPane.showMessageDialog(null, "La cola esta llena, no se pudo insertar el valor [ " + elemento + " ]", "ENTRADA", JOptionPane.ERROR_MESSAGE);
            }
        }

        public void borrar() {
            if (!vacia()) {
                JOptionPane.showMessageDialog(null, "Se ha borrado el elemento [" + cola[inicio] + " ]", "BORRAR", JOptionPane.OK_OPTION);
                inicio = (inicio + 1) % max;
            } else {
                JOptionPane.showMessageDialog(null, "La cola esta vacia", "BORRAR", JOptionPane.WARNING_MESSAGE);
            }
        }

        public void imprimirCola() {
            if (!vacia()) {
                int e = inicio;
                String mostrar = "";
                while (e != fin) {
                    mostrar += "[ " + cola[e] + " ]\n";
                    e = (e + 1) % max;
                }
                JOptionPane.showMessageDialog(null, "Elementos de la cola :\n" + mostrar);
            } else {
                JOptionPane.showMessageDialog(null, "La cola esta vacia", "IMPRIMIR", JOptionPane.WARNING_MESSAGE);
            }
        }

        public void imprimirPrimer() {
            if (!vacia()) {
                JOptionPane.showMessageDialog(null, "El primer elemento es [ " + cola[inicio] + " ]", "PRIMER ELEMENTO", JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "La cola esta vacia", "PRIMER ELEMENTO", JOptionPane.WARNING_MESSAGE);
            }
        }

        public void imprimirUltimo() {
            if (!vacia()) {
                int i = (fin - 1 + max) % max;
                JOptionPane.showMessageDialog(null, "El ultimo elemento es [ " + cola[i] + " ]", "ULTIMO ELEMENTO", JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "La cola esta vacia", "ULTIMO ELEMENTO", JOptionPane.WARNING_MESSAGE);
            }
        }

        public void cantidad() {
            int cantidad = (fin - inicio + max) % max;
            JOptionPane.showMessageDialog(null, "La cantidad de elementos es [ " + cantidad + " ]");
        }

          public static void main(String[] args) {
            int MAX=Integer.parseInt(JOptionPane.showInputDialog("Ingresa el tamaño de la memoria"));
            Tarea10 c = new Tarea10(MAX);
            int opcion;

            do {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                            1.- INSERTAR ELEMENTOS
                                                                            2.- MOSTRAR COLA
                                                                            3.- ULTIMO ELEMENTO
                                                                            4.- PRIMER ELEMENTO
                                                                            5.- ELMILIMINAR ELEMENTO
                                                                            6.- LA COLA CONTIENE ELEMENTOS?
                                                                            7.- CANTIDAD DE ELEMENTOS
                                                                            8.- SALIR DEL PROGRAMA""", JOptionPane.QUESTION_MESSAGE));
                switch(opcion){
                    case 1 -> c.insertar();
                    case 2 -> c.imprimirCola();
                    case 3 -> c.imprimirUltimo();
                    case 4 -> c.imprimirPrimer();
                    case 5 -> c.borrar();
                    case 6 -> {
                        if (!c.llena()) {
                            JOptionPane.showMessageDialog(null, "La cola contienen elementos");
                        }else{
                            JOptionPane.showMessageDialog(null, "La cola aun esta vacia");
                        };
                    }
                    case 7 -> c.cantidad();
                    case 8 -> JOptionPane.showMessageDialog(null, "FIN DEL PROGRAMA");
                    default -> JOptionPane.showMessageDialog(null, "INGRESE UNA OPCION VALIDA \n", "ERROR OPCION", JOptionPane.WARNING_MESSAGE);
                }
            } while (opcion!=8);
        }

    }

