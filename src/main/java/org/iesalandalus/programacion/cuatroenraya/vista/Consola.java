package org.iesalandalus.programacion.cuatroenraya.vista;

import org.iesalandalus.programacion.cuatroenraya.modelo.Ficha;
import org.iesalandalus.programacion.cuatroenraya.modelo.Jugador;
import org.iesalandalus.programacion.cuatroenraya.modelo.Tablero;
import org.iesalandalus.programacion.utilidades.Entrada;

/**
 * Proyecto desarrollado por Ángel Martínez Otero - 2024
 * Proyecto 4 en Raya | Desarrollo de Aplicaciones Web (1ºDAW).
 * Consiste en la implementación de un juego de mesa clásico 4 en Raya.
 * El objetivo principal fue aplicar conceptos fundamentales de programación orientada a objetos.
 */
public class Consola {
    private Consola() {
    }

    public static String leerNombre() {
        String nombre;
        System.out.print("Escriba a continuación su nombre: ");
        nombre = Entrada.cadena();
        while (nombre.isBlank() || nombre == null) {
            System.out.println("ERROR: Intentelo de nuevo.");
            System.out.print("Escriba a continuación su nombre: ");
            nombre = Entrada.cadena();
        }
        return nombre;
    }

    public static Ficha elegirColorFichas() {
        Ficha ficha;
        int numFicha;
        System.out.print("A continuación eliga el color de su ficha escribiendo el numero del color 1-VERDE o 2-AZUL: ");
        numFicha = Entrada.entero();
        while (!(numFicha == 1 || numFicha == 2)) {
            System.out.println("ERROR: Intentelo de nuevo.");
            System.out.print("A continuación eliga el color de su ficha escribiendo el numero del color 1-VERDE o 2-AZUL: ");
            numFicha = Entrada.entero();
        }
        switch (numFicha) {
            case 1:
                ficha = Ficha.VERDE;
                break;
            case 2:
                ficha = Ficha.AZUL;
                break;
            default:
                ficha = Ficha.VERDE;
        }
        return ficha;
    }

    public static Jugador leerJugador() {
        Jugador jugador;
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        System.out.println("JUGADOR I --> Debe elegir el nombre de su jugador y el color de sus fichas.");
        String nombreJugador = leerNombre();
        Ficha fichaJugador = elegirColorFichas();
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        jugador = new Jugador(nombreJugador, fichaJugador);
        return jugador;
    }

    public static Jugador leerJugador(Ficha ficha) {
        Jugador jugador;
        System.out.println("JUGADOR II --> Debe elegir unicamente el nombre de su jugador.");
        String nombreJugador = leerNombre();
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        Ficha fichaJugador = (ficha == Ficha.VERDE) ? Ficha.AZUL : Ficha.VERDE;
        jugador = new Jugador(nombreJugador, fichaJugador);
        return jugador;
    }

    public static int leerColumna(Jugador jugador) {
        int columnaElegida;
        System.out.print(String.format("'%s', introduzca la columna(1-7) donde desee poner su ficha: ", jugador.nombre()));
        columnaElegida = Entrada.entero();
        while (columnaElegida < 1 || columnaElegida > Tablero.COLUMNAS) {
            System.out.println("ERROR: Columna invalida.");
            System.out.print(String.format("'%s', introduzca la columna(1-7) donde desee poner su ficha: ", jugador.nombre()));
            columnaElegida = Entrada.entero();
        }
        return columnaElegida;
    }
}
