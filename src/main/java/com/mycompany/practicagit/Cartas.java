package com.mycompany.practicagit;

import java.util.Random;
import java.util.Scanner;

public class Cartas {

    private int dinero;
    private int apuesta;
    private int eleccion;
    private int probabilidad;
    private Scanner leer;
    private Random ran;
    private boolean gano1;

    public Cartas() {
        leer = new Scanner(System.in);
        ran = new Random();
    }

    public void motorDeJuegoCartas() {
        System.out.println("Bienvenido al juego CARTAS");
        System.out.println("Indica cuanto dinero quieres apostar $$$");
        dinero = leer.nextInt();
        if (dinero > 0) {
            do {
                System.out.println("¿Selecciona a que carta quieres apostar?" + "\n[1] Carta 1" + "\n[2] Carta 2");
                eleccion = leer.nextInt();
                if (eleccion > 0 && eleccion < 3) {
                    System.out.println("Indica el monto a apostar..." + "\nDinero actual = " + dinero);
                    apuesta = leer.nextInt();
                    if (apuesta <= dinero) {
                        generarProbabilidad();
                        generarGanador();
                        if (gano1 = true) {
                            System.out.println("Gano la carta 1");
                            if (eleccion == 1) {
                                dinero += apuesta;
                                System.out.println("Felicidades, acabas de ganar: " + apuesta);
                            } else {
                                dinero -= apuesta;
                                System.out.println("PERDISTE");
                            }
                            System.out.println("Tienes = " + dinero);
                        } else {
                            if (eleccion == 2) {
                                dinero += apuesta;
                                System.out.println("Felicidades, acabas de ganar: " + apuesta);
                            } else {
                                dinero -= apuesta;
                                System.out.println("PERDISTE");
                            }
                            System.out.println("Tienes = " + dinero);
                        }
                    } else {
                        System.out.println("No puedes apostar mas del dinero que tienes");
                    }
                } else {
                    System.out.println("Tienes que elegir entre CARTA 1 y CARTA 2");
                }
            } while (dinero > 0);
            System.out.println("Te has quedado sin dinero");
        } else {
            System.out.println("Debes ingresar una cantidad positiva");
        }
    }

    private void generarProbabilidad() {
        probabilidad = ran.nextInt(100);
    }

    private void generarGanador() {
        if (probabilidad >= 50) {
            gano1 = true;
        } else {
            gano1 = false;
        }
    }
}
