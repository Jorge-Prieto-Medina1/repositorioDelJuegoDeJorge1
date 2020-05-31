package juegodejorge;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Esta es la clase ejecutable de mi aplicación la cual se trata de una ruleta
 * similar a la de un casino
 *
 * @author Jorge Prieto <jorgepri@gmail.com>
 * @version Version 1.0
 */
public class JuegoDeJorgeApp {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.awt.AWTException 
     * @throws java.lang.InterruptedException
     *
     */
    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
        //Declaración de los dos teclados proque en algunos casos me da error al leer numeros
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        Scanner tecladob = new Scanner(System.in);
        //declaración de variables
        float dinero, apostado;
        int numeros[];
        int tipoDeApuesta = 0, resultado;
        /**
         * variables La variable dinero determina la cantidad de dinero que
         * tiene el jugador tipoDeApuesta es la variable controladora del menu
         * que te pregunta el tipo de apuesta que quieres realizar resultado es
         * el número salido en la ruleta apostado es la cantidad de dinero que
         * ha apostado el jugador
         */
        boolean salir = false;
        //este boolean determina cuando se cierra la aplicación, en el caso de ser cierto, se sale
        String continuar;
        //este String es usado para preguntarte si quieres jugar o no
        System.out.println("Bienvenido al juego de la ruleta, creado por Jorge Prieto");
        do {
            dinero = Ruleta.determinarDinero();
        } while (dinero == 0);
        do {
            System.out.println("¿Desea jugar o irse? (Ponga jugar o irse)");
            System.out.println("Recuerde que tiene " + dinero + " euros actualmente");

            do {
                continuar = teclado.readLine();
                continuar = continuar.toUpperCase();
                continuar = continuar.trim();
            } while (!("JUGAR".equals(continuar)) && !("IRSE".equals(continuar)));
            if (continuar.equals("JUGAR")) {
                salir = false;

                do {
                    System.out.println("Por favor elija a que quiere apostar");
                    System.out.println("1: Apostar a números");
                    System.out.println("2: Apostar a color");
                    System.out.println("3: Apostar a zonas");
                    System.out.println("4: Me lo he pensado mejor, no quiero apostar");
                    tipoDeApuesta = 0;
                    tipoDeApuesta = Ruleta.numeroMenu();
                    switch (tipoDeApuesta) {
                        //menú con los tipos de apuestas, se puede salir si se desea
                        case 1:
             
                            System.out.println("Ha elegido apostar a numeros");
                            do {
                                numeros = Ruleta.apuestaNumero();
                            } while (numeros == null);
                            do {
                                apostado = Ruleta.apuesta(dinero);
                            } while (apostado == 0);
                            dinero = dinero - apostado;
                            resultado = Ruleta.ruletaMovimiento();
                            System.out.println("El numero ganador es .....");
                            System.out.println(resultado);
                            apostado = Ruleta.calculador(resultado, numeros, apostado);
                            dinero = dinero + apostado;
                            break;
                        case 2:
               
                            System.out.println("Ha elegido apuesta a color");
                            numeros = Ruleta.apuestaColor();
                            do {
                                apostado = Ruleta.apuesta(dinero);
                            } while (apostado == 0);
                            dinero = dinero - apostado;
                            resultado = Ruleta.ruletaMovimiento();
                            System.out.println("El numero ganador es .....");
                            System.out.println(resultado);
                            apostado = Ruleta.calculador(resultado, numeros, apostado);
                            dinero = dinero + apostado;
                            break;

                        case 3:
          
                            System.out.println("Ha elegido apuesta a zonas");
                            do {
                                numeros = Ruleta.apuestaZona();
                            } while (numeros == null);
                            do {
                                apostado = Ruleta.apuesta(dinero);
                            } while (apostado == 0);
                            dinero = dinero - apostado;
                            resultado = Ruleta.ruletaMovimiento();
                            System.out.println("El numero ganador es .....");
                            System.out.println(resultado);
                            apostado = Ruleta.calculador(resultado, numeros, apostado);
                            dinero = dinero + apostado;
                            break;

                        case 4:
                            System.out.println("No se ha realizado ninguna apuesta");
                            break;
                        default:
                            System.out.println("Introduzca un valor valido por favor");
                            break;
                    }

                } while (tipoDeApuesta != 1 && tipoDeApuesta != 2 && tipoDeApuesta != 3 && tipoDeApuesta != 4);

                //estos else e if determinan cuando se cierra la aplicación
                //el primero es porque el jugador lo pide, el segundo es porque no tiene dinero
            } else {
                salir = true;
                System.out.println("Espero que disfrutase de la experiencia");
            }

            if (dinero == 0) {
                salir = true;
                System.out.println("Usted a perdido todo su dinero largo de mi casino");
            }

        } while (!(salir));
    }

}
