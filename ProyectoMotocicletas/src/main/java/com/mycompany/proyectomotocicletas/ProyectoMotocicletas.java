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
        String motoSeleccionada = "No has seleccionado aun ninguna moto";
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
        
        
        int opcion = 0; 

        do{
            opcion = input.nextInt();
        switch(opcion){
            case 1:  
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
                            System.out.println("Felicidades haz seleccionado correctamente la " + motoSeleccionada);
                            opcionMoto = 3;
                            System.out.println("Regresando...");
                            break;
                       
                        case 2:
                            motoSeleccionada = "Honda XL750 Transalp";
                            System.out.println("Felicidades haz seleccionado correctamente la " + motoSeleccionada);
                            opcionMoto = 3;
                            System.out.println("Regresando...");
                            break;
                        case 3: 
                            System.out.println("Regresando...");
                            break;
                        default : 
                            System.out.println("Opcion invalida, solo puedes digitar, un numero en el rango asignado (1-2)");
                        }
                }while(opcionMoto != 3);
                break;
                
            case 2: 
                System.out.println("");
                break;
            default : 
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
       }
       } while (opcion != 4);
    }
}