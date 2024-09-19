package org.iesalandalus.programacion.cuatroenraya;

import org.iesalandalus.programacion.cuatroenraya.modelo.CuatroEnRaya;
import org.iesalandalus.programacion.cuatroenraya.modelo.Jugador;
import org.iesalandalus.programacion.cuatroenraya.vista.Consola;
import org.iesalandalus.programacion.utilidades.Entrada;

/**
 * Proyecto desarrollado por Ángel Martínez Otero - 2024
 * Proyecto 4 en Raya | Desarrollo de Aplicaciones Web (1ºDAW).
 * Consiste en la implementación de un juego de mesa clásico 4 en Raya.
 * El objetivo principal fue aplicar conceptos fundamentales de programación orientada a objetos.
 */
public class ClaseMain {
    public static void main(String[] args) {
        Jugador[] arrayJugadores = new Jugador[2];
        int respuestaFinal = 1;
        while (respuestaFinal == 1) {
            arrayJugadores[0] = Consola.leerJugador();
            arrayJugadores[1] = Consola.leerJugador(arrayJugadores[0].ficha());
            CuatroEnRaya cuatroEnRaya = new CuatroEnRaya(arrayJugadores[0], arrayJugadores[1]);
            cuatroEnRaya.jugar();
            System.out.print("Menu final: \n1-Reiniciar tablero y volver a jugar.\n2-Salir del juego 4 en raya.\n\nA continuación escriba el digito de la acción que desee realizar: ");
            respuestaFinal = Entrada.entero();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            while (!(respuestaFinal == 1 || respuestaFinal == 2)) {
                System.out.println("ERROR: Digito invalido.");
                System.out.print("Menu final: \n1-Reiniciar tablero y volver a jugar.\n2-Salir del juego 4 en raya.\n\nA continuación escriba el digito de la acción que desee realizar: ");
                respuestaFinal = Entrada.entero();
                System.out.println("-----------------------------------------------------------------------------------------------------------------");
            }
        }
    }
}
