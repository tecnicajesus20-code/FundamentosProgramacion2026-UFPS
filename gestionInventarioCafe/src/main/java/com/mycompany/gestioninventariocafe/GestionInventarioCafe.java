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

// Importamos Scanner para poder leer lo que el usuario escribe por teclado
import java.util.Scanner;

public class GestionInventarioCafe {
    /**
     * Método de entrada de la aplicación.
     * Inicia la ejecución del sistema de gestión.
     *
     * @param args los argumentos de la línea de comandos (opcional)
     */
    public static void main(String[] args) {

        // ===================================================================
        // 1. INICIALIZACIÓN DE INVENTARIO Y VARIABLES
        // ===================================================================

        // Objeto Scanner: lee los datos que digita el usuario
        Scanner input = new Scanner(System.in);

        // Inventario inicial en kg: 50 de Bourbon Rosado y 80 de Castilla
        // (byte alcanza porque guarda valores hasta 127)
        byte cantidadTotalCafe1 = 50;   // Stock actual de Bourbon Rosado
        byte cantidadTotalCafe2 = 80;   // Stock actual de Castilla

        String nombreCafe = "N/a";      // Nombre de la variedad elegida en el momento
        double precio = 0;              // Precio por kg de la variedad elegida
        byte contadorMenu = 3;          // Controla el ciclo interno del menú (3 intentos; en 0 el ciclo termina)
        int opcion = 0;                 // Opción que el usuario digita en el menú (1, 2 o 3)
        byte opcionPago = 0;            // Respuesta a "¿Deseas pagar ya?" (1 = sí, 2 = no)

        // Banderas que indican si cada variedad ya se agotó
        boolean AgotadoCafe1 = false;
        boolean AgotadoCafe2 = false;

        byte tipoCafe = 0;              // Recuerda qué variedad se está comprando (1 o 2)
        int totalReunido = 0;           // Dinero total recaudado en la jornada
        int cantidadActual = 0;         // Stock disponible de la variedad elegida
        int totalCafe1 = 0;             // Dinero recaudado solo por Bourbon Rosado
        int totalCafe2 = 0;             // Dinero recaudado solo por Castilla

        // ===================================================================
        // 2. JORNADA DE VENTAS (ciclo principal)
        // Se repite mostrando el menú hasta que el usuario elija 3 (Salir)
        // ===================================================================
        do {
            // Cada vez que se vuelve al menú, se reinician los 3 intentos
            contadorMenu = 3;

            // ---- Menú de bienvenida y opciones ----
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

            // ===============================================================
            // 3. REGISTRO DEL PEDIDO - selección de variedad
            // Este ciclo lee la opción del menú. Se repite mientras contadorMenu
            // sea distinto de 0 (se pone en 0 para salir de él; o se llega a 0
            // por restar 1 con cada opción inválida).
            // ===============================================================
            while (contadorMenu != 0) {
                opcion = input.nextInt();   // Lee la opción del menú

                // Variables locales que se reinician en cada lectura de opción
                int cantidad = 0;           // Kg que el cliente quiere comprar
                int validar = 0;            // Bandera: 1 = se eligió un café válido y con stock, entra al ciclo de compra
                double TotalPagar = 0;      // Total a pagar de la compra actual

                // Según la opción digitada se ejecuta un caso
                switch (opcion) {

                    // ---------- Opción 1: Bourbon Rosado ----------
                    case 1:
                        nombreCafe = "Bourbon Rosado";
                        precio = 45000.00;                  // Precio base por kg
                        if (!AgotadoCafe1) {                // Si todavía hay stock...
                            cantidadActual = cantidadTotalCafe1;    // Guarda el stock disponible
                            tipoCafe = 1;                           // Marca que se compra la variedad 1

                            System.out.println("Quedan " + cantidadActual + "kg de este producto");

                            validar = 1;                    // Habilita el ciclo de compra
                        } else {                            // Si ya se agotó...
                            System.out.println("El café " + nombreCafe + " se agotó");
                            contadorMenu = 0;               // Sale del ciclo y vuelve a mostrar el menú
                        }
                        break;

                    // ---------- Opción 2: Castilla (misma lógica que la 1) ----------
                    case 2:
                        nombreCafe = "Castilla";
                        precio = 32000.00;                  // Precio base por kg
                        if (!AgotadoCafe2) {
                            cantidadActual = cantidadTotalCafe2;
                            tipoCafe = 2;                   // Marca que se compra la variedad 2

                            System.out.println("Quedan " + cantidadActual + "kg de este producto");

                            validar = 1;
                        } else {
                            System.out.println("El café " + nombreCafe + " se agotó");
                            contadorMenu = 0;
                        }
                        break;

                    // ---------- Opción 3: Salir (valor centinela) ----------
                    case 3:
                        contadorMenu = 0;   // Termina el ciclo interno; el do-while se detiene porque opcion == 3
                        break;

                    // ---------- Cualquier otro valor: inválido ----------
                    default:
                        System.out.println("--Valores invalidos, digite solo numeros entre (1-3)");
                        contadorMenu--;     // Gasta un intento; al llegar a 0 sale del ciclo
                        break;

                }

                // ===========================================================
                // REGISTRO DE LA CANTIDAD Y VALIDACIONES
                // Solo entra si se eligió un café con stock (validar = 1).
                // Se repite hasta que haya una compra, el usuario regrese (0)
                // o decida no pagar; en esos casos se sale con "break".
                // ===========================================================
                while (validar > 0) {
                    System.out.println("Si desea regresar seleccione 0");
                    System.out.print("-- Digite la cantidad en kg que desea comprar: ");
                    cantidad = input.nextInt();     // Kg que desea comprar

                    // Caso 1: cantidad negativa -> inválida, vuelve a pedir
                    if (cantidad < 0) {
                        System.out.println("Cantidad invalida, digite numeros mayores a 0");

                    // Caso 2: cantidad 0 -> el usuario quiere regresar al menú
                    } else if (cantidad == 0) {
                        System.out.println("Regresando a menu...");
                        contadorMenu = 0;           // Termina el ciclo interno del menú
                        break;                      // Sale del ciclo de compra

                    // Caso 3: cantidad positiva -> se valida contra el stock
                    } else {
                        // No se puede vender más de lo que hay en inventario
                        if (cantidad > cantidadActual) {
                            System.out.println("Una disculpa, no hay sufiente stock de " + nombreCafe + " para cubrir esta peticion \n-- Cantidad disponible: " + cantidadActual + "Kg");
                        } else {
                            // =================================================
                            // 4. CÁLCULO DE PRECIOS Y DESCUENTOS
                            // =================================================

                            // Total sin descuento = precio por kg * kilos
                            TotalPagar = (precio * cantidad);
                            double descuento = 0;           // Porcentaje de descuento
                            double valorDescuento = 0;      // Dinero que se descuenta

                            // Descuento solo si compra más de 5 kg
                            if (cantidad > 5) {
                                // 2% por cada kilo por encima de 5, con tope máximo del 15% (Math.min)
                                descuento = Math.min((cantidad - 5) * 2, 15);
                                // Convierte el porcentaje en dinero
                                valorDescuento = TotalPagar * descuento / 100;
                                System.out.println("Felicidades, acabas de recibir un descuento de : " + descuento + "% por añadir mas de 5 kg para comprar de: " + Math.round(valorDescuento) + " COP");
                            }

                            // Resta el descuento (si no hubo, valorDescuento es 0 y no cambia nada)
                            TotalPagar -= valorDescuento;
                            System.out.println("Haz seleccionado: " + cantidad + "kg  de " + nombreCafe);
                            // Math.round redondea el total para no mostrar decimales
                            System.out.println("Total a pagar: " + Math.round(TotalPagar) + " COP");

                            // ---- Confirmación del pago ----
                            System.out.println("-- ¿Deseas pagar ya? : ");
                            System.out.print("1. Si, deseo pagar \n2.No, Deseo regresar al menu\n--");
                            opcionPago = input.nextByte();

                            // ---------- El cliente paga ----------
                            if (opcionPago == 1) {
                                System.out.println("Felicidades has pagado : " + Math.round(TotalPagar) + " COP");

                                // Actualiza inventario y recaudo de la variedad comprada
                                if (tipoCafe == 1) {
                                    cantidadTotalCafe1 -= (byte) cantidad;  // Descuenta kg del stock
                                    totalCafe1 += (int) TotalPagar;         // Suma lo recaudado de Bourbon
                                    if (cantidadTotalCafe1 == 0) {          // Si queda en 0, se agotó
                                        AgotadoCafe1 = true;
                                    }
                                } else {
                                    cantidadTotalCafe2 -= (byte) cantidad;
                                    totalCafe2 += (int) TotalPagar;         // Suma lo recaudado de Castilla
                                    if (cantidadTotalCafe2 == 0) {
                                        AgotadoCafe2 = true;
                                    }
                                }

                                System.out.println("Regresando a menu...");
                                contadorMenu = 0;       // Termina el ciclo interno para volver al menú

                                // Suma al recaudo total de la jornada
                                totalReunido += (int) TotalPagar;

                                break;                  // Sale del ciclo de compra

                            // ---------- El cliente no quiere pagar: regresa al menú ----------
                            } else if (opcionPago == 2) {
                                System.out.println("Regresando a menu...");
                                contadorMenu = 0;
                                break;

                            // ---------- Respuesta inválida: vuelve a pedir la cantidad ----------
                            } else {
                                System.out.println("valor invalido, digite solo numeros entre el 1-2");
                            }


                        }
                    }

                }

            }

            // ===============================================================
            // 5. CIERRE DE JORNADA
            // Si el usuario eligió 3 (Salir), se imprime el reporte del día
            // ===============================================================
            if (opcion == 3) {
                // Si ambas variedades se agotaron, se avisa en el encabezado
                if (AgotadoCafe1 && AgotadoCafe2) {
                    System.out.println("================== Inventario agotado ==================");
                    System.out.println("==================  REPORTE DEL DIA   ==================");
                } else {
                    System.out.println("================== REPORTE DEL DIA ==================");
                }

                // Total de dinero recaudado en el día
                System.out.println("En toda la jornada se ha reunido: $" + totalReunido + " COP");
                // Kilos vendidos = inventario inicial - inventario restante, y dinero por variedad
                System.out.println("El cafe Bourbon Rosado vendio: " + (50 - cantidadTotalCafe1) + "kg en esta jornada \n--Se recaudo : $" + totalCafe1);
                System.out.println("El cafe Castillo vendio: " + (80 - cantidadTotalCafe2) + "kg en esta jornada \n--Se recaudo : $" + totalCafe2);
            }
        } while (opcion != 3);  // El ciclo principal se repite hasta que se elija "Salir"

        // Mensaje final del programa
        System.out.println("================ PROGRAMA FINALIZADO ================");


    }
}