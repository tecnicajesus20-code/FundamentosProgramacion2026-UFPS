/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author camper
 */

import java.util.Scanner;

public class ProyectoMotocicletas {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=============|==================================|============= ");
        System.out.println("=============|      Bienvenido a el sistema     |============= ");
        System.out.println("=============| simulador de rutas y rendimiento |============= ");
        System.out.println("=============|        para motocicletas         |============= ");
        System.out.println("=============|==================================|============= \n");
        System.out.println("-- Seleccione una opcion: \n");
        System.out.println("1. Seleccionar una motocicleta");
        System.out.println("2. Configurar una ruta");
        System.out.println("3. Iniciar Simulacion");
        System.out.println("4. Salir");
        int opcion = input.nextInt();
       
    }
}