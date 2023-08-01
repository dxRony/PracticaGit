/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicagit.ahorcado;

import com.mycompany.practicagit.Menu;
import java.util.Scanner;

/**
 *
 * @author herberthreyes
 */
public class Ahorcado {

    private int contadorFallos = 0;

    public void juegoAhorcado() {
        System.out.println("Bienvenido a Ahorcado\n\n");
        System.out.println("Instrucciones:");
        System.out.println("Ahorcado es un juego simple en el que un jugador trata de adivinar una palabra\n"
                + "ingresando una letra o directamente una palabra, si el jugador falla al adivinar cualquier\n"
                + "opción mencionada, se ira dibujando un hombre ahorcado parte por parte, por lo que si se\n"
                + "completa el dibujo, se pierde el juego. Ten en cuenta que solo se puede fallar 7 veces\n\n");
        System.out.println("Porfavor ingrese una palabra para iniciar el juego: ");
        Scanner escaner = new Scanner(System.in);
        String palabra = escaner.nextLine();
        char[] letras = palabra.toCharArray();
        char[] letrasEncontradas = new char[letras.length];
        boolean palabraEncontrada = false;
        int contadorLetrasEncontradas = 0;
        System.out.print("   \n\n\n");
        for (int i = 0; i < letras.length; i++) {
            System.out.print("___ ");
            letrasEncontradas[i] = ' ';
        }

        System.out.println("\n\n\n\nSeleccione con el número correspondiente una las siguientes opciones para empezar el juego: ");
        while (true) {
            System.out.println("\n\n1. Ingresar una letra");
            System.out.println("2. Ingresar una palabra");
            System.out.print("\nOpción: ");
            int opcionElegida = Integer.parseInt(escaner.nextLine());
            boolean letraEncontrada = false;
            switch (opcionElegida) {
                case 1:
                    System.out.print("Letra: ");
                    String letraIngresada = escaner.nextLine()/*.charAt(0)*/;
                    for (int i = 0; i < letras.length; i++) {
                        String letraArreglo = String.valueOf(letras[i]);
                        if (letraIngresada.equalsIgnoreCase(letraArreglo) /*==letras[i]*/) {
                            if (letrasEncontradas[i] == ' ') {
                                letrasEncontradas[i] = letras[i];
                                contadorLetrasEncontradas++;
                            } else {
                                System.out.println("Ya encontro esa letra, porfavor ingrese otra");
                            }
                            letraEncontrada = true;
                        }
                    }
                    if (letraEncontrada == false) {
                        controladorFallos();
                    }
                    if (contadorLetrasEncontradas == letras.length) {
                        palabraEncontrada = true;
                    }
                    break;
                case 2:
                    System.out.print("Palabra: ");
                    String palabraIngresada = escaner.nextLine();
                    if (palabraIngresada.equalsIgnoreCase(palabra)) {
                        palabraEncontrada = true;
                    } else {
                        controladorFallos();
                    }
                    break;
            }
            System.out.println("");
            System.out.print("   ");
            if (palabraEncontrada) {
                System.out.println("Felicidades has ganado!");
                break;
            } else {
                if (contadorFallos == 7) {
                    System.out.println("Perdiste, suerte para la próxima");
                    break;
                }
            }

            for (int i = 0; i < letrasEncontradas.length; i++) {
                if (letrasEncontradas[i] == ' ') {
                    System.out.print("___ ");
                } else {
                    System.out.print(letrasEncontradas[i] + " ");
                }
            }
        }

        System.out.println("La palabra es: " + palabra + "\n\n");
        Menu menu = new Menu();
        menu.MenuPrincipal();
    }

    public void controladorFallos() {
        contadorFallos++;
        System.out.println("\nHas fallado");
        System.out.println("Fallos: " + contadorFallos + "\n\n");
        Dibujo dibujo = new Dibujo();
        dibujo.dibujoAhorcado(contadorFallos);
    }
}
