package com.mycompany.edarreglos;
import java.util.Stack;
import javax.swing.JOptionPane;

public class Tarea7 {

    Stack<String> PILAPRINCIPAL, PILATEMPORAL;
    String placa;

    public Tarea7() {
        this.PILAPRINCIPAL = new Stack<>();
        this.PILATEMPORAL = new Stack<>();
    }

    public boolean pilaPRINCIPALVacia() {
        return PILAPRINCIPAL.isEmpty();
    }

    public boolean pilaTEMPORALVacia() {
        return PILATEMPORAL.isEmpty();
    }

    public void insertarPRINCIPAL() {
        placa = JOptionPane.showInputDialog("Escribe la placa a ingresar");
        PILAPRINCIPAL.push(placa);
    }

    public void insertarTEMPORAL() {
        PILATEMPORAL.push(PILAPRINCIPAL.pop());
    }

    public void regresarTEMPORALaPRINCIPAL() {
        while (!PILATEMPORAL.isEmpty()) {
            PILAPRINCIPAL.push(PILATEMPORAL.pop());
        }
    }

    public void eliminaElementoPRINCIPAL() {
        PILAPRINCIPAL.pop();
    }

    public void mostrarEstacionamientoPrincipal() {
        if (pilaPRINCIPALVacia()) {
            JOptionPane.showMessageDialog(null, "El estacionamiento principal está vacío", "ESTACIONAMIENTO PRINCIPAL", JOptionPane.WARNING_MESSAGE);
        } else {
            String mostrarPlacas = "";
            for (int i = 0; i < PILAPRINCIPAL.size(); i++) {
                mostrarPlacas += PILAPRINCIPAL.get(i) + "\n";
            }
            JOptionPane.showMessageDialog(null, "Autos en el estacionamiento principal : \n" + mostrarPlacas);
        }
    }

    public void mostrarEstacionamientoTemporal() {
        if (pilaTEMPORALVacia()) {
            JOptionPane.showMessageDialog(null, "El estacionamiento temporal está vacío", "ESTACIONAMIENTO TEMPORAL", JOptionPane.WARNING_MESSAGE);
        } else {
            String mostrarPlacas = "";
            for (int i = 0; i < PILATEMPORAL.size(); i++) {
                mostrarPlacas += PILATEMPORAL.get(i) + "\n";
            }
            JOptionPane.showMessageDialog(null, "Autos en el estacionamiento temporal : \n" + mostrarPlacas);
        }
    }

    public void cuantosElementos() {
        JOptionPane.showMessageDialog(null, "Hay " + PILAPRINCIPAL.size() + " carro(s).");
    }

    public void ultimoAuto() {
        JOptionPane.showMessageDialog(null, "El último auto ingresado es " + PILAPRINCIPAL.peek());
    }

    public void sacarAuto() {
        if (pilaPRINCIPALVacia()) {
            JOptionPane.showMessageDialog(null, "El estacionamiento principal está vacío", "ESTACIONAMIENTO PRINCIPAL", JOptionPane.WARNING_MESSAGE);
        } else {
            String mostrarPlacas = "";
            for (int i = 0; i < PILAPRINCIPAL.size(); i++) {
                mostrarPlacas += PILAPRINCIPAL.get(i) + "\n";
            }

            placa = JOptionPane.showInputDialog("Autos guardados: \n" + mostrarPlacas + "\nEscribe las placas del auto que desea sacar:");

            while (!PILAPRINCIPAL.peek().equalsIgnoreCase(placa)) {
                insertarTEMPORAL();
            }
            eliminaElementoPRINCIPAL();
            JOptionPane.showMessageDialog(null, "Vehículo con placa : " + placa + "  ha salido del estacionamiento principal.");
            regresarTEMPORALaPRINCIPAL();
        }
    }

    public static void main(String[] args) {
        Tarea7 e = new Tarea7();
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                        1.- INGRESAR AUTO
                                                                        2.- SACAR AUTO
                                                                        3.- MOSTRAR VEHÍCULOS ESTACIONADOS
                                                                        4.- CUANTOS VEHÍCULOS HAY
                                                                        5.- MOSTRAR ÚLTIMO VEHÍCULO ESTACIONADO
                                                                        6.- SALIR DEL PROGRAMA
                                                                        SELECCIONA UNA OPCIÓN
                                                                        """, JOptionPane.QUESTION_MESSAGE));

            switch (opcion) {
                case 1 -> e.insertarPRINCIPAL();
                case 2 -> e.sacarAuto();
                case 3 -> e.mostrarEstacionamientoPrincipal();
                case 4 -> e.cuantosElementos();
                case 5 -> e.ultimoAuto();
                case 6 -> JOptionPane.showMessageDialog(null, "FIN DEL PROGRAMA");
                default -> JOptionPane.showMessageDialog(null, "INGRESE UNA OPCIÓN VÁLIDA", "ERROR OPCIÓN", JOptionPane.WARNING_MESSAGE);
            }
        } while (opcion != 6);
    }
}
