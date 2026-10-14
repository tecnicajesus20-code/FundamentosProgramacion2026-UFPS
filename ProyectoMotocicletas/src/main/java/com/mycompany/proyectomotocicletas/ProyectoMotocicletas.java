/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectomotocicletas;

/**
 *
 * @author camper
 */

import java.util.Scanner;

public class ProyectoMotocicletas {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        int motoSeleccionada = 0;
        double combustibleMoto = 0;
        int distanciaRecorrida = 0;
        byte contadorMenu = 2 ;
        int opcion = 0;
        int cantidadKm = 0 ;
       
        do {
            distanciaRecorrida = 0;
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

            while (contadorMenu != 0) {

                opcion = input.nextInt();

                switch(opcion){
                 

                    case 1:
                        boolean seleccion = false;
                        int opcionMoto = 0;
                        do {
                            contadorMenu = 3;
                            System.out.println("=============|==================================|============= ");
                            System.out.println("=============|            Inventario            |============= ");
                            System.out.println("=============|                de                |============= ");
                            System.out.println("=============|           motocicletas           |============= ");
                            System.out.println("=============|==================================|============= \n");
                            System.out.println("1.- Suzuki V-Strom 1000 (Consumo: 20 km/galón, Tanque: 5.3 galones)");
                            System.out.println("2.- Honda XL750 Transalp (Consumo: 25 km/galón, Tanque: 4.4 galones)");
                            System.out.println("3. Regresar a menu principal\n");

                            do {
                                System.out.print("Seleccione la opcion que desea\n-- ");
                                opcionMoto = input.nextInt();

                                switch (opcionMoto) {
                                    case 1:
                                        motoSeleccionada = 1;
                                        seleccion = true;
                                        break;

                                    case 2:
                                        motoSeleccionada = 2;
                                        seleccion = true;
                                        break;

                                    case 3:
                                        seleccion = true;
                                        break;

                                    default:
                                            System.out.println("-- Opcion invalida, solo puedes digitar un numero en el rango asignado (1-3)");
                                            contadorMenu--;
                                            break;
                                }

                                if (seleccion) {
                                    if (opcionMoto != 3) {
                                        System.out.println("Felicidades, has seleccionado la " +
                                            (motoSeleccionada == 1 ? "Suzuki V-Strom 1000" :
                                             motoSeleccionada == 2 ? "Honda XL750 Transalp" : "ninguna moto") + "\n");
                                    }
                                    break;
                                }

                            } while (contadorMenu != 0);
                        } while (!seleccion);
                        combustibleMoto = (motoSeleccionada == 1 )? 5.3 :
                                          (motoSeleccionada == 2 )? 4.4 :
                                           0;


                        System.out.println("Regresando al menú principal...");
                        contadorMenu = 0;
                        break;

                    case 2:
                        System.out.println("=============|==================================|============= ");
                        System.out.println("=============|     CONFIGURACION DE LA RUTA     |============= ");
                        System.out.println("=============|==================================|============= \n");

                        do {
                            System.out.println("Si desea regresar presione el 0 \n-- Ingresa la distancia total (Km) de la ruta que deseas realizar ");
                            cantidadKm = input.nextInt();

                            if (cantidadKm < 0 ){
                                System.out.println("Debes ingresar solo numeros positivos (Mayores a 0)");
                            }

                            else if (cantidadKm ==0 ){
                                System.out.println("Regresando...");
                               
                                contadorMenu = 0;
                                break;
                            }

                            else {
                                System.out.println("Felicidades, acabaste de registrar " + cantidadKm +"Km  correctamente en la ruta. ");
                                contadorMenu = 0 ;
                                break;
                            }

                        } while (cantidadKm != 0);
                        break;

                    case 3:
                        int iniciarSimulacion;
                       
                        do {
                            if(motoSeleccionada  == 0  || cantidadKm == 0 ) {
                                if (motoSeleccionada  == 0 ){
                                       System.out.println("Antes de iniciar la simulacion debes seleccionar una moto");
                                   }
                                if (cantidadKm == 0 ){
                                       System.out.println("Antes de iniciar la simulacion debes registrar una ruta");
                                   }
                                contadorMenu = 0;
                                break;
                            }
                                   
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

                            if (iniciarSimulacion < 0 || iniciarSimulacion > 2 ){
                                System.out.println("Valores invalidos, ingrese solo 1 para SI y 2 para NO");
                            }
                            else if (iniciarSimulacion == 2){
                                System.out.println("Regresando...");
                                contadorMenu = 0;
                            }
                            else {
                                while (distanciaRecorrida < cantidadKm && combustibleMoto > 0){
                                if ((motoSeleccionada == 1 && combustibleMoto < 2.5) || (motoSeleccionada == 2 && combustibleMoto < 2.0)) {
                                    int Total = Math.abs(cantidadKm - distanciaRecorrida);
                                    System.out.println("Viaje fallido por falta de combustible te sobro " + combustibleMoto +" combustible antes de llegar a tu destino y te quedo por recorrer " + Total + "Kilometros" );
                                    contadorMenu = 0 ;
                                    break;
                                }
                                else{
                                    int evento = (int)(Math.random() * 2);
                                   
                                    if (evento == 0  ){
                                        System.out.println("El clima esta despejado, esta vez tuviste suerte ...");
                                       
                                    }
                                    else if (evento == 1){
                                        System.out.println("Empezo a llover muy fuerte, tu rendimiento de combustible disminuyo un 15%");
                                        combustibleMoto -= combustibleMoto * 0.15 ;
                                       
                                    }
                                    combustibleMoto -= (motoSeleccionada == 1 )? 2.5 : (motoSeleccionada == 2)? 2 : 0;
                   
                                    distanciaRecorrida += 50 ;
                                    System.out.println("haz avanzado "+ distanciaRecorrida + " Aun te queda " + combustibleMoto + " combustible para terminar el recorido");
                                    if (distanciaRecorrida == cantidadKm ){
                                        System.out.println("FELICIDADES HAS LLEGADO A TU DESTINO");
                                       
                                    }
                                    }
                               

                                }
                                contadorMenu = 0 ;
                                break;
                            }
                        }
                        }while (iniciarSimulacion != 2);
                       break;
                    case 4 :  
                        System.out.println("============PROGRAMA FINALIZADO============");
                        contadorMenu= 0 ;
                        break;
                    default:
                        System.out.println("Ingresa solo el rango de numeros del menu (1-4)");
                        contadorMenu --;
                        break;
               
                }
            }
        } while (opcion != 4);
    }
}