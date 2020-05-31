package juegodejorge;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Esta clase, la clase ruleta tiene todos los metodos necesarios para hacer
 * funcionar la aplicación
 * @version Version 1.0
 * @author Jorge Prieto <jorgepri@gmail.com>
 */
public class Ruleta {

    /**
     * este metodo es el que te pude cuanto dinero quieres apostar
     *
     * @return dinero devuelve el dinero que elige el usuario, si introduce
     * letras devuelve 0
     */
    public static Float determinarDinero() {
        Scanner teclado = new Scanner(System.in);
        float dinero = 0;
        try {
            System.out.println("Cuanto dinero desea meter?");
            do {
                dinero = teclado.nextFloat();
            } while (dinero <= 0);
            return dinero;
        } catch (Exception e) {
            System.out.println("Por favor no introduzca ni letras ni caracteres y recuerde que el decimal se pone con una coma");
        }
        return dinero;
    }

    /**
     * este metodo es el que se encarga de las apuestas a uno o varios números
     * funciona, al igual que el resto con un array, su longitud viene
     * determinada por la cantidad de numeros que quiere meter el jugador
     *
     * @return numeros [] devuelve el array de numeros elegido por el usuario,
     * si el usuario introduce letras devuelve null
     */
    public static int[] apuestaNumero() {
        Scanner teclado = new Scanner(System.in);
        int cantidad, i, j, auxiliar;
        int numeros[];
        boolean apto, comprobador;
        try {
            do {
                System.out.println("A cuantos numeros desea apostar?");
                cantidad = teclado.nextInt();
            } while (cantidad <= 0 || cantidad > 18);
            numeros = new int[cantidad];
            System.out.println("Introduce los numeros a los que desea apostar");
            for (i = 0; i < cantidad; i++) {

                do {
                    apto = false;
                    comprobador = true;
                    auxiliar = teclado.nextInt();
                    if (auxiliar <= 0 || auxiliar > 36) {
                        System.out.println("Este numero no entra en la ruleta");
                        comprobador = false;
                    } else {
                        for (j = 0; j < cantidad; j++) {
                            if (auxiliar == numeros[j]) {
                                System.out.println("Este numero ya está");
                                comprobador = false;
                            }
                        }
                    }
                    if (comprobador == true) {
                        apto = true;
                        System.out.println("Este numero es valido");
                    }

                } while (apto == false);
                numeros[i] = auxiliar;

            }
            return numeros;
        } catch (Exception e) {
            System.out.println("Por favor no introduzca ni letras ni caracteres y recuerde que el decimal se pone con una coma");
        }

        return null;

    }

    /**
     * Este metodo se encarga de las apuestas a los colores
     *
     * @return numeros devuelve los numeros que contiene el color apostado
     * @throws IOException
     */
    public static int[] apuestaColor() throws IOException {
        BufferedReader tecladob = new BufferedReader(new InputStreamReader(System.in));
        int numeros[];
        int i;
        numeros = new int[18];
        boolean apto;
        String color;
        do {
            System.out.println("A que color desea apostar?");
            color = tecladob.readLine();
            color = color.trim();
            color = color.toUpperCase();
        } while (!"NEGRO".equals(color) && !"ROJO".equals(color));
        if ("NEGRO".equals(color)) {
            //no pude realizar nungun bucle porque estos numeros no siguen un patrón sencillo
            System.out.println("Ha elegido el color negro");
            numeros[0] = 2;
            numeros[1] = 4;
            numeros[2] = 6;
            numeros[3] = 8;
            numeros[4] = 10;
            numeros[5] = 11;
            numeros[6] = 13;
            numeros[7] = 15;
            numeros[8] = 17;
            numeros[9] = 20;
            numeros[10] = 22;
            numeros[11] = 24;
            numeros[12] = 26;
            numeros[13] = 28;
            numeros[14] = 29;
            numeros[15] = 31;
            numeros[16] = 33;
            numeros[17] = 35;
        } else {
            System.out.println("Ha elegido el color rojo");
            numeros[0] = 1;
            numeros[1] = 3;
            numeros[2] = 5;
            numeros[3] = 7;
            numeros[4] = 9;
            numeros[5] = 12;
            numeros[6] = 14;
            numeros[7] = 16;
            numeros[8] = 18;
            numeros[9] = 19;
            numeros[10] = 21;
            numeros[11] = 23;
            numeros[12] = 25;
            numeros[13] = 27;
            numeros[14] = 30;
            numeros[15] = 32;
            numeros[16] = 34;
            numeros[17] = 36;
        }

        return numeros;
    }

    /**
     * Metodo que se encarga de las apuestas a zonas esas zonas son 1-18 y 19-36
     *
     * @return numeros es un array de int que contiene los numeros de la zona
     * elegida
     */
    public static int[] apuestaZona() {
        Scanner teclado = new Scanner(System.in);
        int apostar, i, suma;
        int numeros[];
        numeros = new int[18];

        try {

            do {

                System.out.println("A que zona desea apostar?");
                System.out.println("Zona 1: 1-18");
                System.out.println("Zona 2: 19-36");
                apostar = teclado.nextInt();
                switch (apostar) {
                    case 1:
                        System.out.println("Ha elegido la zona 1");
                        suma = 1;
                        for (i = 0; i < numeros.length; i++) {
                            numeros[i] = suma;
                            suma++;
                        }
                        break;

                    case 2:
                        System.out.println("Ha elegido la zona 2");
                        suma = 18;
                        for (i = 0; i < numeros.length; i++) {
                            numeros[i] = suma;
                            suma++;
                        }
                        break;

                    default:
                        System.out.println("Elija un valor válido");
                        break;
                }

            } while (apostar != 1 && apostar != 2);
            return numeros;
        } catch (Exception e) {
            System.out.println("Por favor no introduzca ni letras ni caracteres");
        }
        return null;
    }

    /**
     * Este metodo es el que pide la apuesta y determina si esta es correcta
     *
     * @param dinero es la cantidad de dinero que el apostador tiene
     * @return apostado devuelve la cantidad de dinero se ha apostado
     */
    static float apuesta(float dinero) {
        Scanner teclado = new Scanner(System.in);
        float apostado = 0;
        try {
            System.out.println("Cuanto dinero quiere apostar?");
            System.out.println("Recuarde que tiene " + dinero + " euros");
            do {
                apostado = teclado.nextFloat();
            } while (apostado <= 0 || apostado > dinero);
        } catch (Exception e) {
            System.out.println("Por favor no introduzca ni letras ni caracteres");
        }
        return apostado;
    }

    /**
     * Este metodo es determina el numero que sale de la ruleta está compuesto
     * por un simple random del cual devuelve un numero
     *
     * @return num devuelve el numero que sale en la ruleta
     */
    public static int ruletaMovimiento() {
        int num;
        num = (int) (Math.random() * 37);
        return num;
    }

    /**
     * La clase calculador es la que determina a partir del resultado de la
     * ruleta los numeros a los que se apostó y el dinero apostado la recompensa
     * y devuelve el dinero ganado, si no se ganó se devuelve 0
     *
     * @param resultado es el numero que proviene del movimiento de la ruleta
     * @param numeros numeros a los que has apostado
     * @param apostado dinero apostado
     * @return apostado devuelve el dinero apostado multiplicado por el
     * multiplicador de dinero si ha perdido se multiplica por 0 devolviendo 0
     */
    static float calculador(int resultado, int numeros[], float apostado) {
        int longitud;
        float multiplicador = 0;
        boolean ganar = false;
        for (int i = 0; i < numeros.length; i++) {
            if (resultado == numeros[i]) {
                System.out.println("Su numero ha salido enhorabuena");
                ganar = true;
                longitud = numeros.length;

                switch (longitud) {
                    case 1:
                        multiplicador = 35;
                        break;
                    case 2:
                        multiplicador = 17;
                        break;
                    case 3:
                        multiplicador = 13;
                        break;
                    case 4:
                        multiplicador = 8;
                        break;
                    case 5:
                        multiplicador = 7;
                        break;
                    case 6:
                        multiplicador = 6;
                        break;
                    case 7:
                        multiplicador = 6;
                        break;
                    case 8:
                        multiplicador = 5;
                        break;
                    case 9:
                        multiplicador = 4;
                        break;
                    case 10:
                        multiplicador = 4;
                        break;
                    case 11:
                        multiplicador = 3;
                        break;
                    case 12:
                        multiplicador = 3;
                        break;
                    case 13:
                        multiplicador = 3;
                        break;
                    case 14:
                        multiplicador = 3;
                        break;
                    case 15:
                        multiplicador = 2;
                        break;
                    case 16:
                        multiplicador = 2;
                        break;
                    case 17:
                        multiplicador = 2;
                        break;
                    case 18:
                        multiplicador = 2;
                        break;

                    default:

                        break;
                }
            }

        }
        if (ganar == false) {
            System.out.println("Usted ha perdidio la apuesta");
            apostado = 0;
        } else {
            apostado = apostado * multiplicador;
        }

        return apostado;

    }

    /**
     * Esta clase pide un numero para el menu, utiliza un try catch para evitar
     * errores, si falla devuelve 0 por lo que se vuelve a pedir el valor
     *
     * @return num numero del menu
     */
    public static int numeroMenu() {
        int num = 0;
        Scanner teclado = new Scanner(System.in);
        try {
            num = teclado.nextInt();
        } catch (Exception e) {
            System.out.println("Por favor introduzca numeros");
        }

        return num;
    }

  

}
