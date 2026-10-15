/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestioninventariocafe;

/**
 * Clase principal que gestiona el inventario de café.
 * Controla el flujo de ejecución de la aplicación.
 *
 * @author camper
 */

import java.util.Scanner;

public class GestionInventarioCafe {
    /**
     * Método de entrada de la aplicación.
     * Inicia la ejecución del sistema de gestión.
     *
     * @param args los argumentos de la línea de comandos (opcional)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte cantidadTotalCafe1 = 50;
        byte cantidadTotalCafe2 = 80;
        String nombreCafe = "N/a";
        double precio = 0;
        byte contadorMenu = 3;
        int opcion = 0;
        byte opcionPago = 0;
        boolean AgotadoCafe1 = false;
        boolean AgotadoCafe2 = false;
        byte tipoCafe = 0;
        int totalReunido = 0;
        int cantidadActual = 0;
        int totalCafe1 = 0;
        int totalCafe2 = 0;

        do {
            contadorMenu = 3;
            System.out.println("|=============|==================================|=============|");
            System.out.println("|=============|    Bienvenido a el sistema de    |=============|");
            System.out.println("|=============|         Gestion de ventas        |=============|");
            System.out.println("|=============|     para Cafe de especialidad    |=============|");
            System.out.println("|=============|==================================|=============|\n");
            System.out.println("|-- Seleccione la opcion que desea de cafe:                    |\n");
            System.out.println("|1. Cafe Bourbon Rosado ($ 45.000/kg)                          |");
            System.out.println("|2. Cafe Castilla ($ 32.000/kg)                                |");
            System.out.println("|3. Salir                                                      |");
            System.out.println("|=============|==================================|=============|\n");

            while (contadorMenu != 0) {
                opcion = input.nextInt();
                int cantidad = 0;
                int validar = 0;
                double TotalPagar = 0;
                switch (opcion) {
                    case 1:
                        nombreCafe = "Bourbon Rosado";
                        precio = 45000.00;
                        if (!AgotadoCafe1) {
                            cantidadActual = cantidadTotalCafe1;
                            tipoCafe = 1;

                            System.out.println("Quedan " + cantidadActual + "kg de este producto");

                            validar = 1;
                        } else {
                            System.out.println("El café " + nombreCafe + " se agotó");
                            contadorMenu = 0;
                        }
                        break;

                    case 2:
                        nombreCafe = "Castilla";
                        precio = 32000.00;
                        if (!AgotadoCafe2) {
                            cantidadActual = cantidadTotalCafe2;
                            tipoCafe = 2;

                            System.out.println("Quedan " + cantidadActual + "kg de este producto");

                            validar = 1;
                        } else {
                            System.out.println("El café " + nombreCafe + " se agotó");
                            contadorMenu = 0;
                        }
                        break;

                    case 3:
                        contadorMenu = 0;
                        break;

                    default:
                        System.out.println("--Valores invalidos, digite solo numeros entre (1-3)");
                        contadorMenu--;
                        break;

                }
                while (validar > 0) {
                    System.out.println("Si desea regresar seleccione 0");
                    System.out.print("-- Digite la cantidad en kg que desea comprar: ");
                    cantidad = input.nextInt();

                    if (cantidad < 0) {
                        System.out.println("Cantidad invalida, digite numeros mayores a 0");
                    } else if (cantidad == 0) {
                        System.out.println("Regresando a menu...");
                        contadorMenu = 0;
                        break;
                    } else {
                        if (cantidad > cantidadActual) {
                            System.out.println("Una disculpa, no hay sufiente stock de " + nombreCafe + " para cubrir esta peticion \n-- Cantidad disponible: " + cantidadActual + "Kg");
                        } else {
                            TotalPagar = (precio * cantidad);
                            double descuento = 0;
                            double valorDescuento = 0;
                            if (cantidad > 5) {
                                descuento = Math.min((cantidad - 5) * 2, 15);
                                valorDescuento = TotalPagar * descuento / 100;
                                System.out.println("Felicidades, acabas de recibir un descuento de : " + descuento + "% por añadir mas de 5 kg para comprar de: " + Math.round(valorDescuento) + " COP");
                            }

                            TotalPagar -= valorDescuento;
                            System.out.println("Haz seleccionado: " + cantidad + "kg  de " + nombreCafe);
                            System.out.println("Total a pagar: " + Math.round(TotalPagar) + " COP");
                            System.out.println("-- ¿Deseas pagar ya? : ");
                            System.out.print("1. Si, deseo pagar \n2.No, Deseo regresar al menu\n--");
                            opcionPago = input.nextByte();

                            if (opcionPago == 1) {
                                System.out.println("Felicidades has pagado : " + Math.round(TotalPagar) + " COP");
                                if (tipoCafe == 1) {
                                    cantidadTotalCafe1 -= (byte) cantidad;
                                    totalCafe1 += (int) TotalPagar;
                                    if (cantidadTotalCafe1 == 0) {
                                        AgotadoCafe1 = true;
                                    }
                                } else {
                                    cantidadTotalCafe2 -= (byte) cantidad;
                                    totalCafe2 += (int) TotalPagar;
                                    if (cantidadTotalCafe2 == 0) {
                                        AgotadoCafe2 = true;
                                    }
                                }

                                System.out.println("Regresando a menu...");
                                contadorMenu = 0;

                                totalReunido += (int) TotalPagar;

                                break;
                            } else if (opcionPago == 2) {
                                System.out.println("Regresando a menu...");
                                contadorMenu = 0;
                                break;
                            } else {
                                System.out.println("valor invalido, digite solo numeros entre el 1-2");
                            }


                        }
                    }

                }

            }
            if (opcion == 3) {
                if (AgotadoCafe1 && AgotadoCafe2) {
                    System.out.println("================== Inventario agotado ==================");
                    System.out.println("==================  REPORTE DEL DIA   ==================");
                } else {
                    System.out.println("================== REPORTE DEL DIA ==================");
                }

                System.out.println("En toda la jornada se ha reunido: $" + totalReunido + " COP");
                System.out.println("El cafe Bourbon Rosado vendio: " + (50 - cantidadTotalCafe1) + "kg en esta jornada \n--Se recaudo : $" + totalCafe1);
                System.out.println("El cafe Castillo vendio: " + (80 - cantidadTotalCafe2) + "kg en esta jornada \n--Se recaudo : $" + totalCafe2);
            }
        } while (opcion != 3);

        System.out.println("================ PROGRAMA FINALIZADO ================");


    }
}
