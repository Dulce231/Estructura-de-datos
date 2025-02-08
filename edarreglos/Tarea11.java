
package com.mycompany.edarreglos;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Tarea11 {
  
    
LinkedList<Integer> cola = new LinkedList<>();
        int elemento;

       
        public boolean VerificarSiEstaVacia() {
    return !cola.isEmpty();
        }

       
        public void insertarElementroAlFinal() {
            elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa un elemento : "));
            JOptionPane.showMessageDialog(null, "Se ha añadido [ " + elemento + " ] a la cola.", "INSERTAR ELEMENTO",
                    JOptionPane.INFORMATION_MESSAGE);
            cola.add(elemento);
        }

        public void BorrarElementoDelInicio() {
            if (!VerificarSiEstaVacia()) {
                JOptionPane.showMessageDialog(null, "La cola esta vacia.", "BORRAR PRIMER ELEMENTO",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Se ha eliminado [ " + cola.pollFirst() + " ] de la cola.",
                        "BORRAR PRIMER ELEMENTO", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        public void ImprimirTodosElementos() {
            if (!VerificarSiEstaVacia()) {
                JOptionPane.showMessageDialog(null, "La cola esta vacia.", "IMPRIMIR TODOS LOS ELEMENTOS",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                String mostrar;
                mostrar = "";
                mostrar = cola + "\n";
                JOptionPane.showMessageDialog(null, "Contenido : " + mostrar, "IMPRIMIR TODOS LOS ELEMENTOS",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }

        public void ImprimirPrimerInsertado() {
            if (!VerificarSiEstaVacia()) {
                JOptionPane.showMessageDialog(null, "La cola esta vacia.", "IMPRIMIR PRIMER ELEMENTO INSERTADO",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Primer elemento de la cola[ " + cola.getFirst() + " ].",
                        "IMPRIMIR PRIMER ELEMENTO INSERTADO", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        public void ImprimirUltimoInsertado() {
            if (!VerificarSiEstaVacia()) {
                JOptionPane.showMessageDialog(null, "La cola esta vacia.", "IMPRIMIR ULTIMO ELEMENTO INSERTADO",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Utimo elemento de la cola [ " + cola.getLast() + " ].",
                        "IMPRIMIR ULTIMO ELEMENTO INSERTADO", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        public void ImprimirCantidadElementos() {
            if (!VerificarSiEstaVacia()) {
                JOptionPane.showMessageDialog(null, "La cola esta vacia.", "IMPRIMIR TAMAÑO", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Se ha eliminado [ " + cola.size() + " ] de la cola.",
                        "IMPRIMIR TAMAÑO", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        public void Contains() {
            if (!VerificarSiEstaVacia()) {
                JOptionPane.showMessageDialog(null, "La cola esta vacia.", "BUSCAR ELEMENTO", JOptionPane.WARNING_MESSAGE);
            } else {
                int buscado = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un elemento a buscar : "));
                if (cola.contains(buscado)) {
                    JOptionPane.showMessageDialog(null, "Se ha encontrado el valor  [ " + buscado + " ] en la cola.",
                            "BUSCAR ELEMENTO", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No ha encontrado el valor  [ " + buscado + " ] en la cola.",
                            "BUSCAR ELEMENTO", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

       
        public void BorrarCola() {
            if (!VerificarSiEstaVacia()) {
                JOptionPane.showMessageDialog(null, "La cola esta vacia.", "BORRAR COLA", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "La cola se ha vaciado.", "BORRAR COLA", JOptionPane.WARNING_MESSAGE);
                cola.clear();
            }
        }
        public static void main(String[] args) {
            int opcion;
            Tarea11 c = new Tarea11();

            do{
                opcion=Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                          Seleccione un opcion.
                                                                          1.- Insertar elemento.
                                                                          2.- Borrar elemento del inicio.
                                                                          3.- Verifica si esta vacia. 
                                                                          4.- Imprimir todos los elementos. 
                                                                          5.- Imprimir el primer elemento. 
                                                                          6.- Imprimir el ultimo elemento. 
                                                                          7.- Imprimir el tamaño de la cola. 
                                                                          8.- Buscar un elemento en la cola. 
                                                                          9.- Eliminar cola. 
                                                                          10.- Fin del programa.
                                                                          
                                                                          """, "MENU", JOptionPane.QUESTION_MESSAGE));

                switch(opcion){
                    case 1 -> c.insertarElementroAlFinal();
                    case 2 -> c.BorrarElementoDelInicio();

                    case 3 -> {
                        if (c.VerificarSiEstaVacia()) {
                            JOptionPane.showMessageDialog(null, "La cola no esta vacia.", "VERIFICANDO", JOptionPane.PLAIN_MESSAGE);
                        } else {JOptionPane.showMessageDialog(null, "La cola esta vacia.", "VERIFICANDO", JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                    case 4 -> c.ImprimirTodosElementos();
                    case 5 -> c.ImprimirPrimerInsertado();
                    case 6 -> c.ImprimirUltimoInsertado();
                    case 7 -> c.ImprimirCantidadElementos();
                    case 8 -> c.Contains();
                    case 9 -> c.BorrarCola();
                    case 10 -> JOptionPane.showMessageDialog(null, "Fin del programa.", "FIN", JOptionPane.WARNING_MESSAGE);
                    default -> JOptionPane.showMessageDialog(null, "Ingrese una opcion valida. \n", "ERROR OPCION", JOptionPane.WARNING_MESSAGE);
                }
            }while(opcion!=10);
        }

    }