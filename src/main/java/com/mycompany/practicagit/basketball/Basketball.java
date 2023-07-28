package com.mycompany.practicagit.basketball;

import java.util.Random;
import java.util.Scanner;

public class Basketball {

    private Jugador jugador1;
    private Jugador jugador2;
    private Scanner leer;
    private Random ran;
    private int probabilidad;
    private int turnos;

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
        
        System.out.println("Bienvenidos!!!\n" +jugador1.getNombre() + " y "+jugador2.getNombre());
        generarTurnos();
        System.out.println("Este juego consiste en simular un partido de basketbal por turnos"+"\nLa cantidad de turnos es: "+turnos);
        
        
    }
    
    private void generarTurnos() {
        turnos = ran.nextInt(5,20);
    }
}
