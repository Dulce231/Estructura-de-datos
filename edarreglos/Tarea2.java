
package com.mycompany.EDarreglos;
import java.util.Arrays;
import java.util.Scanner;

public class Tarea2 {

    private int nelem;
    private int[] vector;

    public static void main(String[] args) {
        Tarea2 programa = new Tarea2();
        programa.mostrarMenu();
    }

    public void tamanoNelem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tamano del arreglo: ");
        nelem = scanner.nextInt();
        vector = new int[nelem]; 
    }

    public void llenarArreglo() {
        if (vector == null) {
            System.out.println("Primero debe ingresar el tamano del arreglo.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < nelem; i++) {
            System.out.print("Ingrese el valor para la posicion " + (i + 1) + ": ");
            vector[i] = scanner.nextInt();
        }
        System.out.println("Arreglo lleno.");
    }
    
     public void OrdenarMenorMayor() {
        Arrays.sort(vector);
        System.out.print("\nOrdenado de Menor a Mayor :");
        for (int i = 0; i < nelem; i++) {
            System.out.print("[" + vector[i] + "]");
        }
        System.out.println("\n");
    }
     
      public void Promedio() {
        int prom = 0;
        for (int i = 0; i < nelem; i++) {
            prom += vector[i];
        }
        System.out.println("Promedio :" + (prom / vector.length) + "\n");
    }
      
       public void Moda() {
        int mayor = 0;
        int numero = 0;

        for (int i = 0; i < vector.length; i++) {
            int contador = 0;
            for (int j = 0; j < vector.length; j++) {
                if (vector[i] == vector[j]) {
                    contador++;
                }
            }
            if (contador > mayor) {
                mayor = contador;
                numero = vector[i];
            }
        }
        System.out.println("Moda : [" + numero + "]\n");
    }
          public void Mediana() {
        int[] clon = vector.clone();
        Arrays.sort(clon);
        int mitad = (int) clon.length / 2;
        int mediana = clon[mitad];
        System.out.println("Mediana : [" + mediana + "]\n");
    }

          public void posicionCero() {
        System.out.println("Posición cero :[" + vector[0] + "]\n");
    }
           public void posicionN() {
        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese una posición (int) hasta el " + (nelem- 1));
        int nPosicion = s.nextInt();
        System.out.print("Número de la posición " + nPosicion + " : [" + vector[nPosicion] + "]\n");
    }
    public void leerValores() {
        if (vector == null || nelem == 0) {
            System.out.println("El arreglo esta vacio");
            return;
        }

        System.out.println("Valores del arreglo:");
        for (int i = 0; i < nelem; i++) {
            System.out.println("Posicion " + (i + 1) + ": " + vector[i]);
        }
    }

    public void encontrarMaximo() {
        if (nelem == 0) {
            System.out.println("El arreglo esta vacio.");
            return;
        }

        int maximo = vector[0];
        int posicion = 0;

        for (int i = 1; i < nelem; i++) {
            if (vector[i] > maximo) {
                maximo = vector[i];
                posicion = i;
            }
        }

        System.out.println("El valor maximo es " + maximo + " y se encuentra en la posicion " + (posicion + 1));
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Ingresa el tamano del arreglo");
            System.out.println("2. Ingresa los valores del arreglo");
            System.out.println("3. Leer los valores del arreglo");
            System.out.println("4. Encontrar el valor maximo en el arreglo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 ->
                    tamanoNelem();
                case 2 ->
                    llenarArreglo();
                case 3 ->
                    leerValores();
                case 4 ->
                    encontrarMaximo();
                case 5 ->
                    System.out.println("Saliendo del programa...");
                default ->
                    System.out.println("Seleccione nuevamente.");
            }
        } while (opcion != 4);
    }
}
