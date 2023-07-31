package com.mycompany.practicagit.basketball;

import com.mycompany.practicagit.Menu;
import java.util.Random;
import java.util.Scanner;

public class Basketball {

    private Jugador jugador1;
    private Jugador jugador2;
    private Scanner leer;
    private Random ran;
    private int probabilidad;
    private int cantidadTurnos;
    private boolean turno;

    public Basketball() {
        jugador1 = new Jugador();
        jugador2 = new Jugador();
        leer = new Scanner(System.in);
        ran = new Random();
    }

    public void motorJuegoBasketball() {
        System.out.println("Bienvenido a Basketball");

        System.out.println("Ingresa tu nombre Jugador 1...");
        jugador1.setNombre(leer.nextLine());

        System.out.println("Ingresa tu nombre Jugador 2...");
        jugador2.setNombre(leer.nextLine());

        System.out.println("Bienvenidos!!!\n" + jugador1.getNombre() + " y " + jugador2.getNombre() + "\n");
        generarTurnos();
        System.out.println("Este juego consiste en simular un partido de basketball por turnos"
                + "\nLa cantidad de turnos es: " + cantidadTurnos);

        definirJugadorInicial();
        if (turno == true) {
            System.out.println("El jugador que inicia lanzando es: " + jugador1.getNombre());
        } else if (turno == false) {
            System.out.println("El jugador que inicia lanzando es: " + jugador2.getNombre());
        }
        System.out.println("------------------------Partida Iniciada------------------------");
        do {
            System.out.println("Turnos Restantes: " + cantidadTurnos);
            if (esTurnoJugador1()) {
                System.out.println("Es tu turno de lanzar " + jugador1.getNombre() + "\n");
                mostrarOpcionesLanzamientoJugador();
                int lanzamiento = leer.nextInt();
                System.out.println("Es tu turno de defender " + jugador2.getNombre() + "\n");
                mostrarOpcionesDefensaJugador();
                int defensa = leer.nextInt();
                jugador1.ejecutarLanzamiento(lanzamiento, defensa);
            } else {
                System.out.println("Es tu turno de lanzar " + jugador2.getNombre() + "\n");
                mostrarOpcionesLanzamientoJugador();
                int lanzamiento = leer.nextInt();
                System.out.println("Es tu turno de defender " + jugador1.getNombre() + "\n");
                mostrarOpcionesDefensaJugador();
                int defensa = leer.nextInt();
                jugador2.ejecutarLanzamiento(lanzamiento, defensa);
            }

            cambiarTurno();
            cantidadTurnos--;
            System.out.println("Puntuaciones:\n"
                    + jugador1.getNombre() + " = " + jugador1.getPuntos() + "\n"
                    + jugador2.getNombre() + " = " + jugador2.getPuntos() + "\n");
        } while (cantidadTurnos > 0);
        System.out.println("------------------------Partida Terminada------------------------");
        if (jugador1.getPuntos() > jugador2.getPuntos()) {
            System.out.println("Felicidades, " + jugador1.getNombre() + " ganaste");
        } else if (jugador1.getPuntos() < jugador2.getPuntos()) {
            System.out.println("Felicidades, " + jugador2.getNombre() + " ganaste");
        } else if (jugador1.getPuntos() == jugador2.getPuntos()) {
            System.out.println("Empate...");
        }

        System.out.println("Puntuaciones:\n"
                + jugador1.getNombre() + " = " + jugador1.getPuntos() + "\n"
                + jugador2.getNombre() + " = " + jugador2.getPuntos() + "\n\n");
        Menu menu = new Menu();
        menu.MenuPrincipal();
    }

    private void generarTurnos() {
        cantidadTurnos = ran.nextInt(5, 20);
    }

    private void definirJugadorInicial() {
        int val = ran.nextInt(100);
        if (val <= 50) {
            turno = true;
        } else if (val >= 50) {
            turno = false;
        }
    }

    private void mostrarOpcionesLanzamientoJugador() {
        System.out.println("Elige uno de los siguientes lanzamientos"
                + "\n[1] Salto largo desde 5 metros, vale 3 puntos y la probabilidad de anotar es de 65%"
                + "\n[2] Salto corto desde 3 metros, vale 2 puntos y la probabilidad de anotar es de 80%");
    }

    private void mostrarOpcionesDefensaJugador() {
        System.out.println("Elige uno de los siguientes movimientos de defensa"
                + "\n[1] Defensa cuerpo a cuerpo, reduce la probabilidad de anotar en un 15% y la probabilidad de hacer falta del 35%"
                + "\n[2] Defensa fuerte, reduce la probabildad de anotar en un 30% y la probabilidad de hacer falta del 65%");
    }

    private boolean esTurnoJugador1() {
        return turno;
    }

    private void cambiarTurno() {
        turno = !turno;
    }
}
