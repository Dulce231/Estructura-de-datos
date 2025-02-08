package Arboles;

import javax.swing.*;
import java.util.LinkedList;

public class examen {
    static class NodoAB {
        int cveart;
        String descripcion;
        int existencia;
        int depto;
        float precio;
        char estatus;
        NodoAB izq, der;

        public NodoAB(int cveart, String descripcion, int existencia, int depto, float precio) {
            this.cveart = cveart;
            this.descripcion = descripcion;
            this.existencia = existencia;
            this.depto = depto;
            this.precio = precio;
            this.estatus = 'A';
            this.izq = null;
            this.der = null;
        }
    }

    static class NodoLes {
        int cveart;
        String descripcion;
        int existencia;
        int depto;
        float precio;
        NodoLes next;

        public NodoLes(int cveart, String descripcion, int existencia, int depto, float precio) {
            this.cveart = cveart;
            this.descripcion = descripcion;
            this.existencia = existencia;
            this.depto = depto;
            this.precio = precio;
            this.next = null;
        }
    }

    static class ArbolBinario {
        NodoAB raiz;
        int contador = 0;

        public void insertar(int cveart, String descripcion, int existencia, int depto, float precio) {
            NodoAB nuevoNodo = new NodoAB(cveart, descripcion, existencia, depto, precio);
            contador++;
            if (raiz == null) {
                raiz = nuevoNodo;
            } else {
                NodoAB actual = raiz;
                NodoAB padre;
                while (true) {
                    padre = actual;
                    if (cveart < actual.cveart) {
                        actual = actual.izq;
                        if (actual == null) {
                            padre.izq = nuevoNodo;
                            return;
                        }
                    } else {
                        actual = actual.der;
                        if (actual == null) {
                            padre.der = nuevoNodo;
                            return;
                        }
                    }
                }
            }
        }

        public void bajalogica(NodoAB nodo, int cveart) {
            if (nodo != null) {
                if (nodo.cveart == cveart) {
                    nodo.estatus = 'B';
                    contador--;
                    JOptionPane.showMessageDialog(null, "Nodo eliminado: " + cveart);
                } else {
                    bajalogica(nodo.izq, cveart);
                    bajalogica(nodo.der, cveart);
                }
            }
        }

        public void inorder(NodoAB nodo, ListaCircular listaCircular) {
            if (nodo != null) {
                inorder(nodo.izq, listaCircular);
                if (nodo.estatus == 'A') {
                    listaCircular.insertar(nodo.cveart, nodo.descripcion, nodo.existencia, nodo.depto, nodo.precio);
                }
                inorder(nodo.der, listaCircular);
            }
        }

        public void inorder(NodoAB nodo, LinkedList<NodoAB> stack) {
            if (nodo != null) {
                inorder(nodo.der, stack);
                if (nodo.estatus == 'A') {
                    stack.push(nodo);
                }
                inorder(nodo.izq, stack);
            }
        }

        public void preorder(NodoAB nodo) {
            if (nodo != null) {
                if (nodo.estatus == 'A') {
                    JOptionPane.showMessageDialog(null, nodo.cveart + ", " + nodo.descripcion + ", " + nodo.existencia + ", " + nodo.depto + ", " + nodo.precio);
                }
                preorder(nodo.izq);
                preorder(nodo.der);
            }
        }

        public void postorder(NodoAB nodo) {
            if (nodo != null) {
                postorder(nodo.izq);
                postorder(nodo.der);
                if (nodo.estatus == 'A') {
                    JOptionPane.showMessageDialog(null, nodo.cveart + ", " + nodo.descripcion + ", " + nodo.existencia + ", " + nodo.depto + ", " + nodo.precio);
                }
            }
        }

        public void buscar(int cveart) {
            NodoAB actual = raiz;
            while (actual != null) {
                if (cveart == actual.cveart) {
                    if (actual.estatus == 'A') {
                        JOptionPane.showMessageDialog(null, "Nodo encontrado: " + actual.cveart + ", " + actual.descripcion + ", " + actual.existencia + ", " + actual.depto + ", " + actual.precio);
                        return;
                    }
                    break;
                } else if (cveart < actual.cveart) {
                    actual = actual.izq;
                } else {
                    actual = actual.der;
                }
            }
            JOptionPane.showMessageDialog(null, "Nodo no encontrado o dado de baja.");
        }

        public void cantidad_de_nodos() {
            JOptionPane.showMessageDialog(null, "Cantidad de nodos activos: " + contador);
        }
    }

    static class ListaCircular {
        NodoLes inicio;

        public void insertar(int cveart, String descripcion, int existencia, int depto, float precio) {
            NodoLes nuevo = new NodoLes(cveart, descripcion, existencia, depto, precio);
            if (inicio == null) {
                inicio = nuevo;
                nuevo.next = inicio;
            } else {
                NodoLes actual = inicio;
                while (actual.next != inicio) {
                    actual = actual.next;
                }
                actual.next = nuevo;
                nuevo.next = inicio;
            }
        }

        public void imprimir() {
            if (inicio == null) {
                JOptionPane.showMessageDialog(null, "La lista circular está vacía.");
                return;
            }
            NodoLes actual = inicio;
            StringBuilder contenido = new StringBuilder();
            do {
                contenido.append(actual.cveart).append(", ").append(actual.descripcion).append(", ").append(actual.existencia).append(", ").append(actual.depto).append(", ").append(actual.precio).append("\n");
                actual = actual.next;
            } while (actual != inicio);
            JOptionPane.showMessageDialog(null, contenido.toString());
        }
    }

    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        ListaCircular listaCircular = new ListaCircular();
        LinkedList<NodoAB> stack = new LinkedList<>();

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                     ESQUEMA DE AMAZON
                    DULCE MARIA MUÑIZ LOPEZ
                    Seleccione una opción:
                    0. Salir
                    1. Insertar en Árbol
                    2. Eliminar Lógicamente del Árbol
                    3. Copiar a Lista Circular
                    4. Recorrido Preorder
                    5. Recorrido Postorder
                    6. Buscar Nodo
                    7. Contar Nodos Activos
                    8. Copiar a LinkedList
                    9. Imprimir Lista Circular
                    10. Imprimir LinkedList
                    """));
            switch (opcion) {
                case 0 -> JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                case 1 -> {
                    int cveart = Integer.parseInt(JOptionPane.showInputDialog("CVE del artículo:"));
                    String descripcion = JOptionPane.showInputDialog("Descripción:");
                    int existencia = Integer.parseInt(JOptionPane.showInputDialog("Existencia:"));
                    int depto = Integer.parseInt(JOptionPane.showInputDialog("Departamento:"));
                    float precio = Float.parseFloat(JOptionPane.showInputDialog("Precio:"));
                    arbol.insertar(cveart, descripcion, existencia, depto, precio);
                }
                case 2 -> {
                    int cveart = Integer.parseInt(JOptionPane.showInputDialog("Número de artículo a eliminar:"));
                    arbol.bajalogica(arbol.raiz, cveart);
                }
                case 3 -> arbol.inorder(arbol.raiz, listaCircular);
                case 4 -> arbol.preorder(arbol.raiz);
                case 5 -> arbol.postorder(arbol.raiz);
                case 6 -> {
                    int cveart = Integer.parseInt(JOptionPane.showInputDialog("Número de artículo a buscar:"));
                    arbol.buscar(cveart);
                }
                case 7 -> arbol.cantidad_de_nodos();
                case 8 -> {
                    stack.clear();
                    arbol.inorder(arbol.raiz, stack);
                }
                case 9 -> listaCircular.imprimir();
                case 10 -> {
                    if (stack.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "La pila está vacía.");
                    } else {
                        StringBuilder contenido = new StringBuilder();
                        for (NodoAB nodo : stack) {
                            contenido.append(nodo.cveart).append(", ").append(nodo.descripcion).append(", ").append(nodo.existencia).append(", ").append(nodo.depto).append(", ").append(nodo.precio).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, contenido.toString());
                    }
                }
                default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } while (opcion != 0);
    }
}
