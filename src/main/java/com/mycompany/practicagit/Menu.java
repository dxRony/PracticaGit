/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicagit;

import com.mycompany.practicagit.ahorcado.Ahorcado;
import com.mycompany.practicagit.basketball.Basketball;
import java.util.Scanner;

/**
 *
 * @author herberthreyes
 */
public class Menu {

    public void MenuPrincipal() {
        Scanner escaner = new Scanner(System.in);
        System.out.println("--------------------------------   Menu principal   ---------------------------------");
        System.out.println("(1) Ahorcado ---------- (2) Basketball ---------- (3) Cartas ---------- (4) Salir");
        System.out.println("Porfavor elija alguna de las opciones anteriores ingresando el numero de dicha opción:");
        boolean salir = false;
        while (salir != true) {
            System.out.print("Opción # ");
            int opcionMenuPrincipal = Integer.parseInt(escaner.nextLine());
            switch (opcionMenuPrincipal) {
                case 1:
                    Ahorcado juego1 = new Ahorcado();
                    juego1.juegoAhorcado();
                    salir = true;
                    break;
                case 2:
                    Basketball juego2 = new Basketball();
                    juego2.motorJuegoBasketball();
                    salir = true;
                    break;
                case 3:
                    Cartas juego3 = new Cartas();
                    juego3.motorDeJuegoCartas();
                    salir = true;
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Solo puede ingresar numeros del 1 al 4, "
                            + "porfavor ingrese una opcion del menu valida");
            }
        }
    }
}
