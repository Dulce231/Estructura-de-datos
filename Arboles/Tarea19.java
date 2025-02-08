package Arboles;

import javax.swing.JOptionPane;

public class Tarea19 {

    public class NodoArbol {
        NodoArbol izq;
        NodoArbol der;
        char estatus;
        int expediente;
        String nombre;

        public NodoArbol(int expediente, String nombre) {
            this.expediente = expediente;
            this.nombre = nombre;
            this.izq = null;
            this.der = null;
            this.estatus = 'A';
        }
    }

    NodoArbol raiz, padre;
    int tam = 0;

    public Tarea19() {
        raiz = null;
    }

    public void ingresar(int expediente, String nombre) {
        tam++;
        NodoArbol nuevo = new NodoArbol(expediente, nombre);
        NodoArbol aux;
        
        if (raiz == null) {
            raiz = nuevo;
        } else {
            aux = raiz;
            while (true) {
                padre = aux;
                if (expediente < aux.expediente) {
                    aux = aux.izq;
                    if (aux == null) {
                        padre.izq = nuevo;
                        return;
                    }
                } else {
                    aux = aux.der;
                    if (aux == null) {
                        padre.der = nuevo;
                        return;
                    }
                }
            }
        }
    }

    public void bajaLogica(NodoArbol n, int expediente) {
        if (n != null) {
            if (n.expediente == expediente) {
                n.estatus = 'B';
                tam--;
                return;
            }
            bajaLogica(n.izq, expediente);
            bajaLogica(n.der, expediente);
        }
    }

    public static void main(String[] args) {
        Tarea19 arbol = new Tarea19();
        int opcion;

        do {
            String menu = """
                --- Menú del Árbol Binario ---
                1. Ingresar nuevo nodo
                2. Realizar baja lógica
                3. Mostrar tamaño del árbol
                4. Salir
                """;

            String opcionStr = JOptionPane.showInputDialog(menu + "Seleccione una opción:");
            opcion = Integer.parseInt(opcionStr);

            switch (opcion) {
                case 1 -> {
                    String expedienteStr = JOptionPane.showInputDialog("Ingrese el expediente:");
                    int expediente = Integer.parseInt(expedienteStr);

                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
                    arbol.ingresar(expediente, nombre);
                    JOptionPane.showMessageDialog(null, "Nodo ingresado con éxito.");
                }

                case 2 -> {
                    String expedienteBajaStr = JOptionPane.showInputDialog("Ingrese el expediente a dar de baja:");
                    int expedienteBaja = Integer.parseInt(expedienteBajaStr);
                    arbol.bajaLogica(arbol.raiz, expedienteBaja);
                    JOptionPane.showMessageDialog(null, "Baja lógica realizada.");
                }

                case 3 -> JOptionPane.showMessageDialog(null, "Tamaño actual del árbol: " + arbol.tam);

                case 4 -> JOptionPane.showMessageDialog(null, "Saliendo del programa.");

                default -> JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }
}
