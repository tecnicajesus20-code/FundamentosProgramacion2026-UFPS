/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectomotocicletas;

/**
 *
 * @author camper
 */

// Scanner permite leer por teclado lo que digita el usuario
import java.util.Scanner;

/**
 * SIMULADOR DE RUTAS Y RENDIMIENTO PARA MOTOCICLETAS
 *
 * El programa permite:
 *   1. Seleccionar una motocicleta (Suzuki V-Strom 1000 u Honda XL750 Transalp).
 *   2. Configurar la distancia total de una ruta (en km).
 *   3. Simular el viaje por tramos de 50 km. En cada tramo puede haber un evento
 *      climático aleatorio (despejado o lluvia) que afecta el combustible.
 *   4. Salir del programa.
 *
 * Estructura general:
 *   - do-while exterior: muestra el menú principal hasta que se elija 4.
 *   - while interior (contadorMenu): lee la opción y la envía al switch.
 *   - switch: ejecuta la opción elegida (cada case es un módulo del programa).
 */
public class ProyectoMotocicletas {

    public static void main(String[] args) {
        // Objeto para leer datos del teclado
        Scanner input = new Scanner(System.in);


        // ===================================================================
        // MÓDULO 1: VARIABLES DE ESTADO
        // Guardan los datos del programa mientras el usuario navega el menú.
        // ===================================================================

        // Moto elegida: 0 = ninguna, 1 = Suzuki V-Strom 1000, 2 = Honda XL750 Transalp
        int motoSeleccionada = 0;
        // Galones de combustible disponibles. Se llena (capacidad del tanque) al
        // seleccionar una moto y se va gastando durante la simulación.
        double combustibleMoto = 0;
        // Kilómetros acumulados en la simulación actual
        int distanciaRecorrida = 0;
        // Contador de control del while interior del menú: el ciclo se repite mientras
        // sea distinto de 0. Se pone en 0 para salir de ese ciclo (volver a mostrar el
        // menú), y se resta 1 cada vez que el usuario digita una opción inválida.
        byte contadorMenu = 2 ;
        // Opción elegida en el menú principal (1-4)
        int opcion = 0;
        // Distancia total de la ruta configurada. 0 significa "aún no hay ruta".
        int cantidadKm = 0 ;
       
        // ===================================================================
        // MÓDULO 2: MENÚ PRINCIPAL
        // El do-while garantiza que el menú se muestre al menos una vez y se
        // repita hasta que el usuario elija la opción 4 (Salir).
        // ===================================================================
        do {
            // Cada vez que se vuelve al menú, la distancia recorrida se reinicia a 0.
            // Ojo: el combustible, la moto y la ruta NO se reinician aquí.
            distanciaRecorrida = 0;
            // Se reinician los 3 intentos del menú
            contadorMenu = 3;
            System.out.println("|=============|==================================|=============|");
            System.out.println("|=============|      Bienvenido a el sistema     |=============|");
            System.out.println("|=============| simulador de rutas y rendimiento |=============|");
            System.out.println("|=============|        para motocicletas         |=============|");
            System.out.println("|=============|==================================|=============|\n");
            System.out.println("|-- Seleccione una opcion:                                     |\n");
            System.out.println("|1. Seleccionar una motocicleta                                |");
            System.out.println("|2. Configurar una ruta                                        |");
            System.out.println("|3. Iniciar Simulacion                                         |");
            System.out.println("|4. Salir                                                      |");
            System.out.println("|=============|==================================|=============|\n");

            // Ciclo de lectura de la opción. Termina cuando contadorMenu llega a 0:
            //  - porque una opción válida lo puso en 0 (después de ejecutar su módulo), o
            //  - porque el usuario se equivocó 3 veces seguidas (el menú se vuelve a imprimir).
            while (contadorMenu != 0) {

                // Lee la opción del menú principal
                opcion = input.nextInt();

                // El switch envía el programa al módulo correspondiente
                switch(opcion){
                 

                    // =======================================================
                    // MÓDULO 3: SELECCIÓN DE MOTOCICLETA
                    // =======================================================
                    case 1:
                        // seleccion = true cuando el usuario ya eligió una moto
                        // o decidió regresar (opción 3 del inventario)
                        boolean seleccion = false;
                        // Opción elegida dentro del inventario de motos
                        int opcionMoto = 0;
                        // Ciclo externo: vuelve a mostrar el inventario mientras no
                        // se haya hecho una selección (ocurre tras 3 intentos inválidos)
                        do {
                            // Se reinician los 3 intentos para este inventario
                            contadorMenu = 3;
                            System.out.println("=============|==================================|============= ");
                            System.out.println("=============|            Inventario            |============= ");
                            System.out.println("=============|                de                |============= ");
                            System.out.println("=============|           motocicletas           |============= ");
                            System.out.println("=============|==================================|============= \n");
                            System.out.println("1.- Suzuki V-Strom 1000 (Consumo: 20 km/galón, Tanque: 5.3 galones)");
                            System.out.println("2.- Honda XL750 Transalp (Consumo: 25 km/galón, Tanque: 4.4 galones)");
                            System.out.println("3. Regresar a menu principal\n");

                            // Ciclo interno: pide la opción hasta que sea válida
                            // (1, 2 o 3) o se agoten los 3 intentos (contadorMenu == 0)
                            do {
                                System.out.print("Seleccione la opcion que desea\n-- ");
                                opcionMoto = input.nextInt();

                                switch (opcionMoto) {
                                    // Suzuki V-Strom 1000
                                    case 1:
                                        motoSeleccionada = 1;
                                        seleccion = true;
                                        break;

                                    // Honda XL750 Transalp
                                    case 2:
                                        motoSeleccionada = 2;
                                        seleccion = true;
                                        break;

                                    // Regresar: no cambia motoSeleccionada, solo marca
                                    // la selección como terminada para salir del inventario
                                    case 3:
                                        seleccion = true;
                                        break;

                                    // Opción inválida: gasta un intento
                                    default:
                                            System.out.println("-- Opcion invalida, solo puedes digitar un numero en el rango asignado (1-3)");
                                            contadorMenu--;
                                            break;
                                }

                                // Si ya hubo selección (moto o regresar), se sale del ciclo
                                if (seleccion) {
                                    // Solo confirma la moto si no eligió "regresar"
                                    if (opcionMoto != 3) {
                                        System.out.println("Felicidades, has seleccionado la " +
                                            (motoSeleccionada == 1 ? "Suzuki V-Strom 1000" :
                                             motoSeleccionada == 2 ? "Honda XL750 Transalp" : "ninguna moto") + "\n");
                                    }
                                    break;
                                }

                            } while (contadorMenu != 0);
                        } while (!seleccion);
                        // Operador ternario: asigna el tanque lleno según la moto
                        // (Suzuki 5.3 galones, Honda 4.4 galones, ninguna = 0).
                        // También se ejecuta si el usuario eligió "regresar": en ese caso
                        // se recalcula con la moto que ya estuviera seleccionada.
                        combustibleMoto = (motoSeleccionada == 1 )? 5.3 :
                                          (motoSeleccionada == 2 )? 4.4 :
                                           0;


                        System.out.println("Regresando al menú principal...");
                        // contadorMenu = 0 hace que termine el while interior del menú
                        contadorMenu = 0;
                        break;

                    // =======================================================
                    // MÓDULO 4: CONFIGURACIÓN DE LA RUTA
                    // =======================================================
                    case 2:
                        System.out.println("=============|==================================|============= ");
                        System.out.println("=============|     CONFIGURACION DE LA RUTA     |============= ");
                        System.out.println("=============|==================================|============= \n");

                        // Se repite solo cuando el usuario digita un número negativo:
                        // en los otros dos casos (0 o positivo) se sale con break.
                        do {
                            System.out.println("Si desea regresar presione el 0 \n-- Ingresa la distancia total (Km) de la ruta que deseas realizar ");
                            // La distancia se guarda directamente en cantidadKm
                            cantidadKm = input.nextInt();

                            // Distancia negativa: inválida, vuelve a pedir el dato
                            if (cantidadKm < 0 ){
                                System.out.println("Debes ingresar solo numeros positivos (Mayores a 0)");
                            }

                            // 0 = regresar al menú. Como cantidadKm queda en 0, la ruta
                            // se considera "no registrada" (borra una ruta anterior).
                            else if (cantidadKm ==0 ){
                                System.out.println("Regresando...");
                               
                                contadorMenu = 0;
                                break;
                            }

                            // Distancia positiva: ruta registrada correctamente
                            else {
                                System.out.println("Felicidades, acabaste de registrar " + cantidadKm +"Km  correctamente en la ruta. ");
                                contadorMenu = 0 ;
                                break;
                            }

                        } while (cantidadKm != 0);
                        break;

                    // =======================================================
                    // MÓDULO 5: INICIO Y SIMULACIÓN DEL VIAJE
                    // =======================================================
                    case 3:
                        // Respuesta del usuario a "¿Desea iniciar la simulación?"
                        int iniciarSimulacion;
                       
                        // Este do-while repite la pregunta si el usuario digita un valor
                        // inválido; se sale con break (faltan datos o se simuló) o cuando
                        // el usuario responde 2 (No).
                        do {
                            // Verificación previa: se necesita una moto Y una ruta.
                            // || (O lógico): basta que falte uno de los dos para no iniciar.
                            if(motoSeleccionada  == 0  || cantidadKm == 0 ) {
                                // Avisa específicamente qué es lo que falta
                                if (motoSeleccionada  == 0 ){
                                       System.out.println("Antes de iniciar la simulacion debes seleccionar una moto");
                                   }
                                if (cantidadKm == 0 ){
                                       System.out.println("Antes de iniciar la simulacion debes registrar una ruta");
                                   }
                                contadorMenu = 0;
                                break;
                            }
                                   
                        // Si ya hay moto y ruta: se pide confirmación
                        else {
                            System.out.println("=============|==================================|============= ");
                            System.out.println("=============|   ¿DESEA INICIAR LA SIMULACION?  |============= ");
                            System.out.println("=============|==================================|============= \n");
                            System.out.println("Haz seleccionado la " + (motoSeleccionada == 1 ? "Suzuki V-Strom 1000" :
                                                                         motoSeleccionada == 2 ? "Honda XL750 Transalp" : "ninguna moto"));
                            System.out.println("En esta ruta pretendes recorrer: " + cantidadKm + " Kilometros");
                            System.out.println("1. Si");
                            System.out.println("2. No");
                            iniciarSimulacion = input.nextInt();

                            // Valores menores que 0 o mayores que 2 son inválidos
                            // (el 0 no entra en esta condición, por lo que pasa al else y
                            // también inicia la simulación). Vuelve a preguntar.
                            if (iniciarSimulacion < 0 || iniciarSimulacion > 2 ){
                                System.out.println("Valores invalidos, ingrese solo 1 para SI y 2 para NO");
                            }
                            // 2 = No: regresa al menú principal
                            else if (iniciarSimulacion == 2){
                                System.out.println("Regresando...");
                                contadorMenu = 0;
                            }
                            else {
                                // -------------------------------------------
                                // CICLO PRINCIPAL DE LA SIMULACIÓN
                                // Cada vuelta simula un tramo de 50 km. Continúa mientras
                                // falte distancia por recorrer Y todavía haya combustible.
                                // -------------------------------------------
                                while (distanciaRecorrida < cantidadKm && combustibleMoto > 0){
                                // Se revisa ANTES de cada tramo si el combustible alcanza.
                                // Los umbrales son el consumo de 50 km de cada moto:
                                //   Suzuki: 50 km / 20 km por galón = 2.5 galones
                                //   Honda:  50 km / 25 km por galón = 2.0 galones
                                if ((motoSeleccionada == 1 && combustibleMoto < 2.5) || (motoSeleccionada == 2 && combustibleMoto < 2.0)) {
                                    // Kilómetros que faltan para llegar. Math.abs devuelve
                                    // el valor absoluto (aquí la resta ya es positiva).
                                    int Total = Math.abs(cantidadKm - distanciaRecorrida);
                                    System.out.println("Viaje fallido por falta de combustible te sobro " + combustibleMoto +" combustible antes de llegar a tu destino y te quedo por recorrer " + Total + "Kilometros" );
                                    contadorMenu = 0 ;
                                    // Sale del while de la simulación (el viaje terminó mal)
                                    break;
                                }
                                // Si el combustible alcanza, se simula el tramo
                                else{
                                    // Evento aleatorio: Math.random() da un decimal en [0, 1);
                                    // al multiplicarlo por 2 y convertirlo a int el resultado
                                    // es 0 o 1, cada uno con 50 % de probabilidad.
                                    int evento = (int)(Math.random() * 2);
                                   
                                    // Evento 0: clima despejado, sin efecto en el combustible
                                    if (evento == 0  ){
                                        System.out.println("El clima esta despejado, esta vez tuviste suerte ...");
                                       
                                    }
                                    // Evento 1: lluvia fuerte. Se descuenta el 15 % del
                                    // combustible que queda en el tanque en ese momento.
                                    else if (evento == 1){
                                        System.out.println("Empezo a llover muy fuerte, tu rendimiento de combustible disminuyo un 15%");
                                        combustibleMoto -= combustibleMoto * 0.15 ;
                                       
                                    }
                                    // Consumo base del tramo de 50 km (se resta siempre,
                                    // después del posible descuento por lluvia):
                                    //   Suzuki: 2.5 galones | Honda: 2 galones
                                    // Si el resultado queda en 0 o menos, el while termina
                                    // en la siguiente comprobación sin mostrar el mensaje de falla.
                                    combustibleMoto -= (motoSeleccionada == 1 )? 2.5 : (motoSeleccionada == 2)? 2 : 0;
                   
                                    // Cada tramo avanza 50 km
                                    distanciaRecorrida += 50 ;
                                    System.out.println("haz avanzado "+ distanciaRecorrida + " Aun te queda " + combustibleMoto + " combustible para terminar el recorido");
                                    // Mensaje de llegada: solo sale si la distancia recorrida
                                    // es EXACTAMENTE igual a la ruta (rutas múltiplo de 50 km).
                                    // Si la ruta no es múltiplo de 50, el contador la sobrepasa
                                    // y este mensaje no aparece.
                                    if (distanciaRecorrida == cantidadKm ){
                                        System.out.println("FELICIDADES HAS LLEGADO A TU DESTINO");
                                       
                                    }
                                    }
                               

                                }
                                // Terminada la simulación (con éxito o por falta de combustible)
                                // se sale del do-while y se vuelve al menú principal
                                contadorMenu = 0 ;
                                break;
                            }
                        }
                        // Repite mientras la respuesta no haya sido 2 (No)
                        }while (iniciarSimulacion != 2);
                       break;

                    // =======================================================
                    // MÓDULO 6: SALIR
                    // =======================================================
                    case 4 :  
                        System.out.println("============PROGRAMA FINALIZADO============");
                        // Termina el while interior; el do-while exterior se detiene
                        // porque opcion == 4
                        contadorMenu= 0 ;
                        break;

                    // Cualquier otro número: opción inválida, gasta un intento
                    // (con 3 errores seguidos se vuelve a imprimir el menú)
                    default:
                        System.out.println("Ingresa solo el rango de numeros del menu (1-4)");
                        contadorMenu --;
                        break;
               
                }
            }
        // El menú principal se repite hasta que el usuario elija 4 (Salir)
        } while (opcion != 4);
    }
}