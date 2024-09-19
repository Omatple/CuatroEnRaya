package org.iesalandalus.programacion.cuatroenraya.modelo;

import org.iesalandalus.programacion.cuatroenraya.vista.Consola;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

/**
 * Proyecto desarrollado por Ángel Martínez Otero - 2024
 * Proyecto 4 en Raya | Desarrollo de Aplicaciones Web (1ºDAW).
 * Consiste en la implementación de un juego de mesa clásico 4 en Raya.
 * El objetivo principal fue aplicar conceptos fundamentales de programación orientada a objetos.
 */
public class CuatroEnRaya {
    private static final int NUMERO_JUGADORES = 2;
    private Jugador[] arrayJugadores = new Jugador[NUMERO_JUGADORES];
    private Tablero tablero;

    public CuatroEnRaya(Jugador jugador1, Jugador jugador2) {
        this.arrayJugadores[0] = Objects.requireNonNull(jugador1, "El JUGADOR I no puede ser nulo.");
        this.arrayJugadores[1] = Objects.requireNonNull(jugador2, "El JUGADOR II no puede ser nulo.");
        this.tablero = new Tablero();
    }

    private boolean tirar(Jugador jugador) {
        boolean tiradaGanadora = false;
        int columnaElegida;
        boolean validador = false;
        while (!validador) {
            try {
                columnaElegida = Consola.leerColumna(jugador);
                System.out.println("\n");
                tiradaGanadora = this.tablero.introducirFicha((columnaElegida - 1), jugador.ficha());
                validador = true;
            } catch (OperationNotSupportedException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        return tiradaGanadora;
    }

    public void jugar() {
        boolean tiradaGanadora = false;
        boolean tableroLleno = false;
        Jugador jugadorGanador = arrayJugadores[0];
        while (!(tiradaGanadora || tableroLleno)) {
            tiradaGanadora = tirar(arrayJugadores[0]);
            jugadorGanador = arrayJugadores[0];
            System.out.println(this.tablero);
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            tableroLleno = tablero.estaLleno();
            if (!(tiradaGanadora || tableroLleno)) {
                tiradaGanadora = tirar(arrayJugadores[1]);
                jugadorGanador = arrayJugadores[0];
                System.out.println(this.tablero);
                System.out.println("-----------------------------------------------------------------------------------------------------------------");
                tableroLleno = tablero.estaLleno();
            }
        }
        if (tableroLleno && tiradaGanadora) {
            System.out.println(String.format("¡¡WOW!! '%s' has conseguidor hacer %d en raya alzandote con la victoria y ademas completar el tablero con llenandolo con la ultima ficha %s del tablero. ", tablero.FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS, jugadorGanador.nombre(), jugadorGanador.ficha()));
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
        } else if (tiradaGanadora) {
            System.out.println(String.format("¡¡ENHORABUENA '%s', HAS GANADO!! Has sido el primer jugador en hacer %d en raya con la ficha %s y alzarte con la victoria.", jugadorGanador.nombre(), tablero.FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS, jugadorGanador.ficha()));
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
        } else {
            System.out.println(String.format("¡¡HASTA AQUI!! Habeis terminado llenando el tablero de fichas, sois unos jugadores excepcionles que no habeis dejado a vuestro oponente llegar a conectar el %d en raya. ", tablero.FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS));
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
        }
    }
}
