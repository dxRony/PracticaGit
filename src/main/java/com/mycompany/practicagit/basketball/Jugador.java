package com.mycompany.practicagit.basketball;

import java.util.Random;
import java.util.Scanner;

public class Jugador {

    private String nombre;
    private int puntos;
    private int probabilidadAnotar;
    private int probabilidadFalta;
    private int probabilidadTiroLibre;
    private Random ran;
    private Scanner leer;

    public Jugador() {
        ran = new Random();
        leer = new Scanner(System.in);
    }

    public void ejecutarLanzamiento(int lanzamiento, int defensa) {
        generarProbabilidadAnotar();
        generarProbabilidadFalta();
        generarProbabilidadTiroLibre();

        if (lanzamiento == 1 && defensa == 1) {
            probabilidadAnotar -= 15;
            if (probabilidadFalta <= 35) {
                System.out.println("¡FALTA!\nEl jugador tiene un tiro libre...");
                System.out.println("Preparando para ejecutar el tiro...(vale 2 puntos y la probabilidad de anotar es de 90%)"
                        + "\nPresiona enter para continuar");
                leer.nextLine();
                if (probabilidadTiroLibre >= 10) {
                    System.out.println("¡ANOTACIONNN!");
                    System.out.println("Jugador lanzador +2 puntos");
                    this.puntos += 2;
                } else {
                    System.out.println("Tiro libre FALLADO");
                }
            } else if (probabilidadAnotar <= 50) {
                System.out.println("¡ANOTACIONNN!");
                System.out.println("Jugador lanzador +3 puntos");
                this.puntos += 3;
            } else if (probabilidadAnotar > 50) {
                System.out.println("Se bloqueo el lanzamiento");
            }
        } else if (lanzamiento == 1 && defensa == 2) {
            probabilidadAnotar -= 30;
            if (probabilidadFalta <= 65) {
                System.out.println("¡FALTA!\nEl jugador tiene un tiro libre...");
                System.out.println("Preparando para ejecutar el tiro...(vale 2 puntos y la probabilidad de anotar es de 90%)"
                        + "\nPresiona enter para continuar");
                leer.nextLine();
                if (probabilidadTiroLibre >= 10) {
                    System.out.println("¡ANOTACIONNN!");
                    System.out.println("Jugador lanzador +2 puntos");
                    this.puntos += 2;
                } else {
                    System.out.println("Tiro libre FALLADO");
                }
            } else if (probabilidadAnotar <= 30) {
                System.out.println("¡ANOTACIONNN!");
                System.out.println("Jugador lanzador +3 puntos");
                this.puntos += 3;
            } else if (probabilidadAnotar > 30) {
                System.out.println("Se bloqueo el lanzamiento");
            }
        } else if (lanzamiento == 2 && defensa == 1) {
            probabilidadAnotar -= 15;
            if (probabilidadFalta <= 35) {
                System.out.println("¡FALTA!\nEl jugador tiene un tiro libre...");
                System.out.println("Preparando para ejecutar el tiro...(vale 2 puntos y la probabilidad de anotar es de 90%)"
                        + "\nPresiona enter para continuar");
                leer.nextLine();
                if (probabilidadTiroLibre >= 10) {
                    System.out.println("¡ANOTACIONNN!");
                    System.out.println("Jugador lanzador +2 puntos");
                    this.puntos += 2;
                } else {
                    System.out.println("Tiro libre FALLADO");
                }
            } else if (probabilidadAnotar <= 65) {
                System.out.println("¡ANOTACIONNN!");
                System.out.println("Jugador lanzador +2 puntos");
                this.puntos += 2;
            } else if (probabilidadAnotar > 65) {
                System.out.println("Se bloqueo el lanzamiento");
            }
        } else if (lanzamiento == 2 && defensa == 2) {
            probabilidadAnotar -= 30;
            if (probabilidadFalta <= 65) {
                System.out.println("¡FALTA!\nEl jugador tiene un tiro libre...");
                System.out.println("Preparando para ejecutar el tiro...(vale 2 puntos y la probabilidad de anotar es de 90%)"
                        + "\nPresiona enter para continuar");
                leer.nextLine();
                if (probabilidadTiroLibre >= 10) {
                    System.out.println("¡ANOTACIONNN!");
                    System.out.println("Jugador lanzador +2 puntos");
                    this.puntos += 2;
                } else {
                    System.out.println("Tiro libre FALLADO");
                }
            } else if (probabilidadAnotar <= 50) {
                System.out.println("¡ANOTACIONNN!");
                System.out.println("Jugador lanzador +2 puntos");
                this.puntos += 2;
            } else if (probabilidadAnotar > 50) {
                System.out.println("Se bloqueo el lanzamiento");
            }
        } else {
            System.out.println("Se ingresaron valores incorrectos...");
        }
    }

    private void generarProbabilidadAnotar() {
        probabilidadAnotar = ran.nextInt(100);
    }

    private void generarProbabilidadFalta() {
        probabilidadFalta = ran.nextInt(100);
    }

    private void generarProbabilidadTiroLibre() {
        probabilidadTiroLibre = ran.nextInt(100);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
