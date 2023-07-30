/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado;

/**
 *
 * @author herberthreyes
 */
public class Dibujo {
    public void dibujoAhorcado(int fallos) {
        int contadorTrazado = 0;
        int contadorDistancia = 1;
        for (int i = 0; i < 15; i++) {
            if (fallos == 1 && i == 0) {
                System.out.println("+");
            } else {
                if (fallos >= 2 && i == 0) {
                    System.out.print("+");
                    for (int j = 0; j < 15; j++) {
                        System.out.print("_");
                    }
                    System.out.println("+");
                }
            }
            if (fallos <= 2) {
                System.out.println("|");
            } else {
                if (fallos >= 3 && (i == 1 || i == 2)) {
                    System.out.print("|");
                    for (int k = 0; k < 16; k++) {
                        if (k == 15) {
                            System.out.print("|");
                        } else {
                            System.out.print(" ");
                        }
                    }
                    contadorTrazado++;
                    System.out.println("");
                }

                if (fallos >= 4 && i > 2 && i < 6) {
                    System.out.print("|");
                    for (int k = 0; k < 14; k++) {
                        if (k != 13) {
                            System.out.print(" ");
                        } else {
                            if (k == 13 && i == 3) {
                                System.out.println("*****");
                            } else {
                                if (k == 13 && i == 4) {
                                    System.out.println("*   *");
                                } else {
                                    if (k == 13 && i == 5) {
                                        System.out.println("*****");
                                    }
                                }
                            }
                        }
                    }
                    contadorTrazado++;
                }

                if (fallos >= 5 && i >= 6 && i < 10) {
                    System.out.print("|");
                    for (int m = 0; m < 16; m++) {
                        if (m == 15) {
                            System.out.print("*");
                        } else {
                            if (m == 12 && i == 7 && fallos == 7) {
                                System.out.print("*******");
                                break;
                            } else {
                                System.out.print(" ");
                            }
                        }
                    }
                    contadorTrazado++;
                    System.out.println("");
                }
         
                if (fallos >= 6 && i >= 10 && i < 12) {
                    System.out.print("|");
                    for (int n = 0; n <= 17; n++) {
                        if (n == 15 - contadorDistancia || n == 15 + contadorDistancia) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    }
                    contadorDistancia++;
                    contadorTrazado++;
                    System.out.println("");
                }
            }

        }
        
        if (fallos > 2) {
            for (int i = 0; i < 15 - contadorTrazado; i++) {
                System.out.println("|");

            }
        }
    }
}
