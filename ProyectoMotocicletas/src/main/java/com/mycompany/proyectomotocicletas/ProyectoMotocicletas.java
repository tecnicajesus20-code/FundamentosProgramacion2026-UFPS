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
        String motoSeleccionada = "";
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
        byte contadorMenu = 2 ; 
        byte menu = 0;
        int opcion = 0; 
        int cantidadKm = 0 ; 
        do{
            if (menu == 1) {
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
                        System.out.println("Felicidades haz seleccionado correctamente la " + motoSeleccionada + "\n");
                        System.out.print("-- Selecciona lo que quiere hacer (1-4)\n--");
                        menu = 0 ;
                        
                    }
            else if (menu == 2){
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
                        System.out.print("-- Selecciona lo que quiere hacer (1-4)\n--");
                        menu = 0 ;
            }
            opcion = input.nextInt();
        switch(opcion){
            case 1:  
                contadorMenu = 2 ; 
                int opcionMoto = 0;
                System.out.println("=============|==================================|============= ");
                System.out.println("=============|            Inventario            |============= ");
                System.out.println("=============|                de                |============= ");
                System.out.println("=============|           motocicletas           |============= ");
                System.out.println("=============|==================================|============= \n");    
                System.out.println("1.- Suzuki V-Strom 1000 (Consumo: 20 km/galón, Tanque: 5.3 galones)");
                System.out.println("2.- Honda XL750 Transalp (Consumo: 25 km/galón, Tanque: 4.4 galones)");
                System.out.println("3. Regresar a menu principal\n");
                do {
                    System.out.print("Seleccione una opcion\n--");
                    opcionMoto = input.nextInt();
                        switch (opcionMoto){
                        case 1 : 
                            motoSeleccionada = "Suzuki V-Strom 1000"; 
                            opcionMoto = 3;
                            menu = 1 ;
                            System.out.println("Regresando...");
                            break;
                       
                        case 2:
                            motoSeleccionada = "Honda XL750 Transalp";
                            opcionMoto = 3;
                            menu = 1 ; 
                            System.out.println("Regresando...");
                            break;
                        case 3: 
                            System.out.println("Regresando...");
                            menu = 2 ; 
                            break;
                        default : 
                            if (contadorMenu != 0){
                                System.out.println("Opcion invalida, solo puedes digitar, un numero en el rango asignado (1-2)");
                                contadorMenu -- ;
                            }
                            else {
                                System.out.println("=============|==================================|============= ");
                                System.out.println("=============|            Inventario            |============= ");
                                System.out.println("=============|                de                |============= ");
                                System.out.println("=============|           motocicletas           |============= ");
                                System.out.println("=============|==================================|============= \n");    
                                System.out.println("1.- Suzuki V-Strom 1000 (Consumo: 20 km/galón, Tanque: 5.3 galones)");
                                System.out.println("2.- Honda XL750 Transalp (Consumo: 25 km/galón, Tanque: 4.4 galones)");
                                System.out.println("3. Regresar a menu principal\n");
                                System.out.println("-- Opcion invalida, solo puedes digitar, un numero en el rango asignado (1-2)\nSeleccione la opcion que desea: ");
                            }
                        }
                }while(opcionMoto != 3);
                break;
                
            case 2: 
                    System.out.println("=============|==================================|============= ");
                    System.out.println("=============|     CONFIGURACION DE LA RUTA     |============= ");
                    System.out.println("=============|==================================|============= \n");  
                    do{
                        System.out.println("Si desea regresar presione el 0 \n-- Ingresa la distancia total (Km) de la ruta que deseas realizar ");
                        cantidadKm = input.nextInt();
                        if (cantidadKm < 0 ){
                            System.out.println("Debes ingresar solo numeros pusitivos (Mayores a 0)");
                        }
                        else if (cantidadKm ==0 ){
                            System.out.println("Regresando...");
                            menu = 2; 
                        }
                        else {
                            System.out.println("Felicidades, acabaste de registrar " + cantidadKm +"Km  correctamente en la ruta. ");
                            menu = 2;
                            break;
                        }
                        
                    } while (cantidadKm > 0);
                break;
            default :
                if (contadorMenu != 0 ){
                    System.out.println("Ingresa solo el rango de numeros del menu (1-4)");
                    contadorMenu --;
                }
                else {
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
                        System.out.println("Ingresa solo el rango de numeros del menu (1-4)");
                        contadorMenu = 0; 
                }
       }
       } while (opcion != 4);
    }
}
