/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestioninventariocafe;

/**
 *
 * @author salxmc
 */
import java.util.Scanner; 
public class GestionInventarioCafe {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tipoCafe = 0 ;
        byte cantidadTotal = 0 ; 
        String nombreCafe = "N/a";
        double precio = 0; 
        byte contadorMenu = 3;
        int opcion = 0 ; 
        
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
            
            while (contadorMenu != 0){
                opcion = input.nextInt();
                int cantidad = 0;
                int validar = 0 ; 
                double TotalPagar = 0; 
                switch (opcion){
                    case 1 : 
                        cantidadTotal = 50 ;
                        nombreCafe = "Variedad Bourbon Rosado";
                        precio = 45000.00; 
                        tipoCafe = 1 ;
                        validar = 1 ; 
                        
                        
                    case 2: 
                        cantidadTotal = 80 ;
                        nombreCafe = "Variedad Castilla";
                        precio = 32000.00; 
                        tipoCafe = 2 ; 
                        validar = 1 ; 

                        break ;
                       
                    case 3: 
                        System.out.println("============PROGRAMA FINALIZADO============");
                        opcion = 3; 
                        contadorMenu = 0 ; 
                        break ; 
                    
                    default : 
                        System.out.println("--Valores invalidos, digite solo numeros entre (1-3)");
                        contadorMenu --; 
                        break; 
                        
                }
                while (validar > 0 ){
                            System.out.println("Si desea regresar seleccione 0");
                        System.out.print("-- Digite la cantidad en kg que desea comprar: ");
                        cantidad = input.nextInt();
                        
                        if (cantidad < 0){
                            System.out.println("Cantidad invalida, digite numeros mayores a 0");
                        }
                        else  if (cantidad == 0){
                                System.out.println("Regresando a menu...");
                                contadorMenu = 0 ; 
                                break;
                        }
                        else{
                            if (cantidad > cantidadTotal){
                                System.out.println("Una disculpa, no hay sufiente stock de " + nombreCafe + " para cubrir esta peticion \n-- Cantidad disponible: " + cantidadTotal +"Kg");
                            }
                            else {
                                TotalPagar += precio * cantidad;
                                System.out.println("Haz seleccionado: "+ cantidad +"kg  de " + nombreCafe +" Debes pagar: " + TotalPagar +" COP");
                                cantidadTotal -= cantidad; 
                            }
                        }
                        
                        }
            }
        
        } while (opcion != 3 );
        
        
        
       
        
        
    }
}
