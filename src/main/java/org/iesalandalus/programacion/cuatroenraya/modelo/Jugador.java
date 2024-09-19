package org.iesalandalus.programacion.cuatroenraya.modelo;

import java.util.Objects;

/**
 * Proyecto desarrollado por Ángel Martínez Otero - 2024
 * Proyecto 4 en Raya | Desarrollo de Aplicaciones Web (1ºDAW).
 * Consiste en la implementación de un juego de mesa clásico 4 en Raya.
 * El objetivo principal fue aplicar conceptos fundamentales de programación orientada a objetos.
 */

// SI FALLA EL TEST DE TO-STRING-DEVUELVE-CADENA-CORRECTAMENTE, ES
// SIMPLEMENTE PORQUE LE HE AÑADIDO COLOR A LAS LETRAS CON CODIGO ANSI PARA PARA
// SOLUCIONARLO Y QUE PASE LOS TEST LO UNICO QUE SE DEBE HACER ES DIRIGIRSE A LA
// CLASE ENUMERADO 'FICHA' Y CAMBIAR LA REPRESENTACION DE LA FICHA VERDE Y AZUL
// POR LAS LETRAS CORRESPONDIENTES EN VEZ DE EL CODIGO ANSI RARO QUE ESTA ESCRITO,
// ES DECIR, CAMBIAR EN FICHA VERDE ESTO '\u001B[32mV\u001B[0m' POR 'V' Y EL DE
// LA FICHA AZUL ESTO '\u001B[34mA\u001B[0m' POR 'A'. ASI PASARIAS LOS TEST DEL TO-STRING
public record Jugador(String nombre, Ficha ficha) {

    public Jugador(String nombre, Ficha ficha) {
        this.nombre = nombre;
        this.ficha = ficha;
        validarNombre(nombre);
        validarColorFichas(ficha);
    }

    private void validarNombre(String nombre){
        Objects.requireNonNull(nombre, "El nombre no puede ser nulo.");
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar en blanco.");
        }
    }

    private void validarColorFichas(Ficha ficha) {
        Objects.requireNonNull(ficha, "El color de las fichas no puede ser nulo.");
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", this.nombre, this.ficha);
    }
}
