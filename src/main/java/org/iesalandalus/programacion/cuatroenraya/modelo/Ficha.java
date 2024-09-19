package org.iesalandalus.programacion.cuatroenraya.modelo;

/**
 * Proyecto desarrollado por Ángel Martínez Otero - 2024
 * Proyecto 4 en Raya | Desarrollo de Aplicaciones Web (1ºDAW).
 * Consiste en la implementación de un juego de mesa clásico 4 en Raya.
 * El objetivo principal fue aplicar conceptos fundamentales de programación orientada a objetos.
 */

// SI FALLA EL TEST DE TO-STRING-DEVUELVE-CADENA-ESPERADA, ES
// SIMPLEMENTE PORQUE LE HE AÑADIDO COLOR A LAS LETRAS CON CODIGO ANSI PARA PARA
// SOLUCIONARLO Y QUE PASE LOS TEST LO UNICO QUE SE DEBE HACER ES DIRIGIRSE A LA
// CLASE ENUMERADO 'FICHA' Y CAMBIAR LA REPRESENTACION DE LA FICHA VERDE Y AZUL
// POR LAS LETRAS CORRESPONDIENTES EN VEZ DE EL CODIGO ANSI RARO QUE ESTA ESCRITO,
// ES DECIR, CAMBIAR EN FICHA VERDE ESTO '\u001B[32mV\u001B[0m' POR 'V' Y EL DE
// LA FICHA AZUL ESTO '\u001B[34mA\u001B[0m' POR 'A'. ASI PASARIAS LOS TEST DEL TO-STRING
public enum Ficha {
    VERDE("\u001B[32mV\u001B[0m"),
    AZUL("\u001B[34mA\u001B[0m");
    private String nombre;

    private Ficha(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
