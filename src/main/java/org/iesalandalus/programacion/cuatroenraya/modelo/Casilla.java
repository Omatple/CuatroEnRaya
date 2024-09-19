package org.iesalandalus.programacion.cuatroenraya.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

/**
 * Proyecto desarrollado por �ngel Mart�nez Otero - 2024
 * Proyecto 4 en Raya | Desarrollo de Aplicaciones Web (1�DAW).
 * Consiste en la implementaci�n de un juego de mesa cl�sico 4 en Raya.
 * El objetivo principal fue aplicar conceptos fundamentales de programaci�n orientada a objetos.
 */

// SI FALLA EL TEST DE TO-STRING-DEVUELVE-CADENA-ESPERADA, ES
// SIMPLEMENTE PORQUE LE HE A�ADIDO COLOR A LAS LETRAS CON CODIGO ANSI PARA PARA
// SOLUCIONARLO Y QUE PASE LOS TEST LO UNICO QUE SE DEBE HACER ES DIRIGIRSE A LA
// CLASE ENUMERADO 'FICHA' Y CAMBIAR LA REPRESENTACION DE LA FICHA VERDE Y AZUL
// POR LAS LETRAS CORRESPONDIENTES EN VEZ DE EL CODIGO ANSI RARO QUE ESTA ESCRITO,
// ES DECIR, CAMBIAR EN FICHA VERDE ESTO '\u001B[32mV\u001B[0m' POR 'V' Y EL DE
// LA FICHA AZUL ESTO '\u001B[34mA\u001B[0m' POR 'A'. ASI PASARIAS LOS TEST DEL TO-STRING
public class Casilla {
    private Ficha ficha;

    public Casilla() {
        this.ficha = null;
    }

    public boolean estaOcupada() {
        boolean ocupado;
        if (getFicha() == null) {
            ocupado = false;
        } else {
            ocupado = true;
        }
        return ocupado;
    }

    public Ficha getFicha() {
        return this.ficha;
    }

    public void setFicha(Ficha ficha) throws OperationNotSupportedException {
        if (estaOcupada()) {
            throw new OperationNotSupportedException("La casilla ya contiene una ficha.");
        }
        this.ficha = Objects.requireNonNull(ficha, "No se puede poner una ficha nula.");
    }

    @Override
    public String toString() {
        String stringResultado;
        if (estaOcupada()) {
            stringResultado = String.format("%s", this.ficha);
        } else {
            stringResultado = String.format(" ");
        }
        return String.format("%s", stringResultado);
    }
}
