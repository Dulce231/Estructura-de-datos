package com.mycompany.edarreglos;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Tarea3 {

    int array[], tamaño;

 
    public Tarea3(int tamaño) {
        this.tamaño = tamaño;
        array = new int[tamaño];
    }

    public void Llenar() {
        for (int i = 0; i < tamaño; i++) {
            String input = JOptionPane.showInputDialog(null, "Inserte número " + (i + 1) + ": ");
            array[i] = Integer.parseInt(input);
        }
        JOptionPane.showMessageDialog(null, "Arreglo llenado correctamente.");
    }

   
    public int[] clonarArreglo() {
        return array.clone();
    }

   
    public void modificarValor(int[] arr, int posicion, int nuevoValor) {
        if (posicion >= 0 && posicion < arr.length) {
            arr[posicion] = nuevoValor;
        }
    }

   
    public void igualarArreglos(int[] arr1, int[] arr2) {
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
    }

    
    public void imprimirArreglo(String nombreArreglo, int[] arr) {
        StringBuilder sb = new StringBuilder(nombreArreglo + " : ");
        for (int i : arr) {
            sb.append("[").append(i).append("]");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    
    public void OrdenarMenorMayor() {
        Arrays.sort(array);
        imprimirArreglo("Ordenado de Menor a Mayor", array);
    }

    
    public void Promedio() {
        int prom = 0;
        for (int i = 0; i < tamaño; i++) {
            prom += array[i];
        }
        JOptionPane.showMessageDialog(null, "Promedio: " + (prom / array.length));
    }

       public void Moda() {
        int mayor = 0;
        int numero = 0;

        for (int i = 0; i < array.length; i++) {
            int contador = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) {
                    contador++;
                }
            }
            if (contador > mayor) {
                mayor = contador;
                numero = array[i];
            }
        }
        JOptionPane.showMessageDialog(null, "Moda: [" + numero + "]");
    }

   
    public void Mediana() {
        int[] clon = array.clone();
        Arrays.sort(clon);
        int mitad = clon.length / 2;
        int mediana = clon[mitad];
        JOptionPane.showMessageDialog(null, "Mediana: [" + mediana + "]");
    }

    
    public void posicionCero() {
        JOptionPane.showMessageDialog(null, "Posición cero: [" + array[0] + "]");
    }

    
    public void posicionN() {
        String input = JOptionPane.showInputDialog(null, "Ingrese una posición del 0 hasta el " + (tamaño - 1) + ": ");
        int nPosicion = Integer.parseInt(input);
        JOptionPane.showMessageDialog(null, "Número de la posición " + nPosicion + " : [" + array[nPosicion] + "]");
    }

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog(null, "Ingrese el tamaño del arreglo:");
        int tamaño = Integer.parseInt(input);
        Tarea3 a = new Tarea3(tamaño);

        int opcion;
        do {
            String menu = """
                             Menu Opciones 
                             1.- Llenar
                             2.- Leer
                             3.- Ordenar de Menor a Mayor
                             4.- Promedio 
                             5.- Moda 
                             6.- Mediana
                             7.- Posición Cero
                             8.- Posición N
                             9.- Clonar Arreglo
                             10.- Modificar Valor
                             11.- Imprimir Arreglo
                             12.- Fin de programa
                             Enter Opcion:""";
            input = JOptionPane.showInputDialog(null, menu);
            opcion = Integer.parseInt(input);

            switch (opcion) {
                case 1 ->
                    a.Llenar();
                case 2 ->
                    a.imprimirArreglo("Arreglo", a.array);
                case 3 ->
                    a.OrdenarMenorMayor();
                case 4 ->
                    a.Promedio();
                case 5 ->
                    a.Moda();
                case 6 ->
                    a.Mediana();
                case 7 ->
                    a.posicionCero();
                case 8 ->
                    a.posicionN();
                case 9 -> {
                    int[] clon = a.clonarArreglo();
                    a.imprimirArreglo("Arreglo Clonado", clon);
                }
                case 10 -> {
                    input = JOptionPane.showInputDialog(null, "Ingrese la posición a modificar:");
                    int pos = Integer.parseInt(input);
                    input = JOptionPane.showInputDialog(null, "Ingrese el nuevo valor:");
                    int valor = Integer.parseInt(input);
                    a.modificarValor(a.array, pos, valor);
                    a.imprimirArreglo("Arreglo Modificado", a.array);
                }
                case 11 ->
                    a.imprimirArreglo("Arreglo", a.array);
                case 12 ->
                    JOptionPane.showMessageDialog(null, "Fin de Programa");
                default ->
                    JOptionPane.showMessageDialog(null, "Opción Inválida");
            }
        } while (opcion != 12);
    }
}
