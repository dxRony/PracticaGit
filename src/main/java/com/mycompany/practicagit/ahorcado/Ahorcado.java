/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicagit.ahorcado;

import java.util.Scanner;

/**
 *
 * @author herberthreyes
 */
public class Ahorcado {

    private /*static*/ int contadorFallos = 0;

    public void juegoAhorcado() {
        System.out.println("Porfavor ingrese una palabra para iniciar el juego: ");
        Scanner escaner = new Scanner(System.in);
        String palabra = escaner.nextLine();
        char[] letras = palabra.toCharArray();
        char[] letrasEncontradas = new char[letras.length];
        boolean palabraEncontrada = false;
        int contadorLetrasEncontradas = 0;

        for (int i = 0; i < letras.length; i++) {
            System.out.print("___ ");
            letrasEncontradas[i] = ' ';
        }

        System.out.println("\n\n\n\nSeleccione con el número correspondiente una las siguientes opciones para empezar el juego: ");
        while (true) {
            System.out.println("");
            System.out.println("");
            System.out.println("1. Ingresar una letra");
            System.out.println("2. Ingresar una palabra");
            System.out.print("\nOpción: ");
            int opcionElegida = Integer.parseInt(escaner.nextLine());
            boolean letraEncontrada = false;
            switch (opcionElegida) {
                case 1:
                    System.out.print("Letra: ");
                    /*char*/ String letraIngresada = escaner.nextLine()/*.charAt(0)*/;
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

        System.out.println("La palabra es: " + palabra);
    }

    public /*static*/ void controladorFallos() {
        contadorFallos++;
        System.out.println("Has fallado");
        System.out.println("Fallos: " + contadorFallos);
        Dibujo dibujo = new Dibujo();
        dibujo.dibujoAhorcado(contadorFallos);
    }
}
