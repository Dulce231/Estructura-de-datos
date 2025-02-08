package Arboles;
import javax.swing.*;
import java.util.LinkedList;

public class Tarea20 {
    
    // Nodo para el Árbol Binario
    class NodoAB {
        int matricula;
        String nomAlum;
        int calif;
        NodoAB lChild;
        NodoAB rChild;

        public NodoAB(int matricula, String nomAlum, int calif) {
            this.matricula = matricula;
            this.nomAlum = nomAlum;
            this.calif = calif;
            this.lChild = null;
            this.rChild = null;
        }
    }

    // Nodo para la Lista Encadenada Simple Circular
    class NodoLSC {
        int matricula;
        String nomAlum;
        int calif;
        NodoLSC siguiente;

        public NodoLSC(int matricula, String nomAlum, int calif) {
            this.matricula = matricula;
            this.nomAlum = nomAlum;
            this.calif = calif;
            this.siguiente = null;
        }
    }

    // Atributos del árbol y lista
    NodoAB raiz = null;
    
    NodoLSC cabeza = null; // Cabeza de la lista circular
    static int contadorLista = 0; 
    static String com = ""; 

    // Método para insertar en el Árbol Binario
    public void insertarArbol() {
        String nombre = JOptionPane.showInputDialog(null, "Inserte el nombre:");
        int matricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Matrícula:"));
        int calif = Integer.parseInt(JOptionPane.showInputDialog(null, "Calificación:"));
        NodoAB nodoNuevo = new NodoAB(matricula, nombre, calif);

        if (raiz == null) {
            raiz = nodoNuevo;
        } else {
            NodoAB aux = raiz;
            NodoAB padre;
            while (true) {
                padre = aux;
                if (matricula < aux.matricula) {
                    aux = aux.lChild;
                    if (aux == null) {
                        padre.lChild = nodoNuevo;
                        return;
                    }
                } else {
                    aux = aux.rChild;
                    if (aux == null) {
                        padre.rChild = nodoNuevo;
                        return;
                    }
                }
            }
        }
    }

    // Método para insertar en Lista Encadenada Simple Circular
    public void insertarListaEncadenadaSimple() {
        String nombre = JOptionPane.showInputDialog(null, "Inserte el nombre:");
        int matricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Matrícula:"));
        int calif = Integer.parseInt(JOptionPane.showInputDialog(null, "Calificación:"));
        NodoLSC nodoNuevo = new NodoLSC(matricula, nombre, calif);

        if (cabeza == null) {
            cabeza = nodoNuevo;
            cabeza.siguiente = cabeza; // Apunta a sí misma para ser circular
        } else {
            NodoLSC temp = cabeza;
            while (temp.siguiente != cabeza && temp.siguiente.matricula < matricula) {
                temp = temp.siguiente;
            }
            contadorLista++;
            nodoNuevo.siguiente = temp.siguiente;
            temp.siguiente = nodoNuevo;
        }
    }

    // Método para mostrar la lista encadenada simple circular
    public void mostrarListaEncadenadaSimple() {
        if (cabeza == null) {
            JOptionPane.showMessageDialog(null, "La lista encadenada circular está vacía.");
            return;
        }
        NodoLSC temp = cabeza;
        StringBuilder datos = new StringBuilder();
        do {
            datos.append("\nMatrícula: ").append(temp.matricula).append("\nNombre: ").append(temp.nomAlum).append("\nCalificación: ").append(temp.calif).append("\n");
            temp = temp.siguiente;
        } while (temp != cabeza);
        JOptionPane.showMessageDialog(null, datos.toString());
    }

    // Método para eliminar la lista encadenada y pasar el árbol a la lista
    public void eliminarListaYArbolaLista() {
        cabeza = null; // Borra la lista encadenada
        arbolaLista(raiz);
    }

    // Pasar datos del Árbol Binario a la Lista Encadenada Simple Circular
    public void arbolaLista(NodoAB n) {
        if (n != null) {
            arbolaLista(n.lChild);
            insertarListaEncadenadaSimple(n.matricula, n.nomAlum, n.calif);
            arbolaLista(n.rChild);
        }
    }

    // Insertar en Lista Encadenada Simple Circular desde el árbol
    public void insertarListaEncadenadaSimple(int matricula, String nomAlum, int calif) {
        NodoLSC nodoNuevo = new NodoLSC(matricula, nomAlum, calif);

        if (cabeza == null) {
            cabeza = nodoNuevo;
            cabeza.siguiente = cabeza; // Apunta a sí misma para ser circular
        } else {
            NodoLSC temp = cabeza;
            while (temp.siguiente != cabeza && temp.siguiente.matricula < matricula) {
                temp = temp.siguiente;
            }
            contadorLista++;
            nodoNuevo.siguiente = temp.siguiente;
            temp.siguiente = nodoNuevo;
        }
    }

    // Pasar la lista encadenada simple circular al árbol binario
    public void listaaArbol() {
        if (cabeza == null) return; // Si la lista está vacía, no se puede pasar

        NodoLSC temp = cabeza;
        do {
            insertarArbolDesdeLista(temp.matricula, temp.nomAlum, temp.calif);
            temp = temp.siguiente;
        } while (temp != cabeza);
    }

    // Insertar en el árbol desde la lista encadenada
    public void insertarArbolDesdeLista(int matricula, String nomAlum, int calif) {
        NodoAB nodoNuevo = new NodoAB(matricula, nomAlum, calif);

        if (raiz == null) {
            raiz = nodoNuevo;
        } else {
            NodoAB aux = raiz;
            NodoAB padre;
            while (true) {
                padre = aux;
                if (matricula < aux.matricula) {
                    aux = aux.lChild;
                    if (aux == null) {
                        padre.lChild = nodoNuevo;
                        return;
                    }
                } else {
                    aux = aux.rChild;
                    if (aux == null) {
                        padre.rChild = nodoNuevo;
                        return;
                    }
                }
            }
        }
    }

    // Métodos de recorrido de Árbol Binario
    public void inOrder(NodoAB n) {
        if (n != null) {
            inOrder(n.lChild);
            com += "\nMatrícula: " + n.matricula + "\nNombre: " + n.nomAlum + "\nCalificación: " + n.calif + "\n";
            inOrder(n.rChild);
        }
    }

    public void preOrder(NodoAB n) {
        if (n != null) {
            com += "\nMatrícula: " + n.matricula + "\nNombre: " + n.nomAlum + "\nCalificación: " + n.calif + "\n";
            preOrder(n.lChild);
            preOrder(n.rChild);
        }
    }

    public void postOrder(NodoAB n) {
        if (n != null) {
            postOrder(n.lChild);
            postOrder(n.rChild);
            com += "\nMatrícula: " + n.matricula + "\nNombre: " + n.nomAlum + "\nCalificación: " + n.calif + "\n";
        }
    }

    // Cantidad de nodos en Árbol Binario
    public int contarNodosArbol(NodoAB nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + contarNodosArbol(nodo.lChild) + contarNodosArbol(nodo.rChild);
    }

    // Profundidad del Árbol Binario
    public int profundidad(NodoAB nodo) {
        if (nodo == null) {
            return 0;
        }
        int profundidadIzquierda = profundidad(nodo.lChild);
        int profundidadDerecha = profundidad(nodo.rChild);
        return 1 + Math.max(profundidadIzquierda, profundidadDerecha);
    }

    // Menú principal
    public static void main(String[] args) {
        Tarea20 arbol = new Tarea20();
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte una opción:\n"
                    + "0. Salir del programa\n"
                    + "1. Insertar en Árbol\n"
                    + "2. Insertar en Lista Encadenada Simple Circular\n"
                    + "3. Recorridos del Árbol\n"
                    + "4. Mostrar Lista Encadenada Simple Circular\n"
                    + "5. Número de Nodos en Árbol\n"
                    + "6. Profundidad del Árbol\n"
                    + "7. Eliminar Lista y pasar Árbol a Lista\n"
                    + "8. Pasar Lista a Árbol"));

            switch (op) {
                case 0 -> JOptionPane.showMessageDialog(null, "Saliendo del programa");
                case 1 -> arbol.insertarArbol();
                case 2 -> arbol.insertarListaEncadenadaSimple();
                case 3 -> {
                    com = "\nIn-Orden:\n";
                    arbol.inOrder(arbol.raiz);
                    JOptionPane.showMessageDialog(null, com);
                    com = "\nPre-Orden:\n";
                    arbol.preOrder(arbol.raiz);
                    JOptionPane.showMessageDialog(null, com);
                    com = "\nPost-Orden:\n";
                    arbol.postOrder(arbol.raiz);
                    JOptionPane.showMessageDialog(null, com);
                }
                case 4 -> arbol.mostrarListaEncadenadaSimple();
                case 5 -> JOptionPane.showMessageDialog(null, "Nodos en árbol: " + arbol.contarNodosArbol(arbol.raiz));
                case 6 -> JOptionPane.showMessageDialog(null, "Profundidad del árbol: " + arbol.profundidad(arbol.raiz));
                case 7 -> {
                    arbol.eliminarListaYArbolaLista();
                    JOptionPane.showMessageDialog(null, "Lista eliminada y árbol pasado a la lista.");
                }
                case 8 -> {
                    arbol.listaaArbol();
                    JOptionPane.showMessageDialog(null, "Lista pasada al árbol.");
                }
            }
        } while (op != 0);
    }
}

