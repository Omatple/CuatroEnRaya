package org.iesalandalus.programacion.cuatroenraya.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

/**
 * Proyecto desarrollado por Ángel Martínez Otero - 2024
 * Proyecto 4 en Raya | Desarrollo de Aplicaciones Web (1ºDAW).
 * Consiste en la implementación de un juego de mesa clásico 4 en Raya.
 * El objetivo principal fue aplicar conceptos fundamentales de programación orientada a objetos.
 */


// SI FALLA EL TEST DE REPRESENTACION DEL TABLERO LLENO O CON ALGUNA TIRADA, ES
// SIMPLEMENTE PORQUE LE HE AÑADIDO COLOR A LAS LETRAS CON CODIGO ANSI PARA PARA
// SOLUCIONARLO Y QUE PASE LOS TEST LO UNICO QUE SE DEBE HACER ES DIRIGIRSE A LA
// CLASE ENUMERADO 'FICHA' Y CAMBIAR LA REPRESENTACION DE LA FICHA VERDE Y AZUL
// POR LAS LETRAS CORRESPONDIENTES EN VEZ DE EL CODIGO ANSI RARO QUE ESTA ESCRITO,
// ES DECIR, CAMBIAR EN FICHA VERDE ESTO '\u001B[32mV\u001B[0m' POR 'V' Y EL DE
// LA FICHA AZUL ESTO '\u001B[34mA\u001B[0m' POR 'A'. ASI PASARIAS LOS TEST DEL TO-STRING
public class Tablero {
    public static final int FILAS = 6;
    public static final int COLUMNAS = 7;
    public static final int FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS = 4;
    private Casilla[][] tablero = new Casilla[FILAS][COLUMNAS];

    public Tablero() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = new Casilla();
            }
        }
    }

    private boolean columnaVacia(int columna) {
        boolean columnaVacia;
        if (tablero[FILAS - 1][columna].estaOcupada()) {
            columnaVacia = true;
        } else {
            columnaVacia = false;
        }
        return columnaVacia;
    }

    public boolean estaVacio() {
        int columnasNoVacias = 0;
        boolean estaVacio;
        for (int i = 0; i < COLUMNAS; i++) {
            if (columnaVacia(i)) {
                columnasNoVacias++;
            }
        }
        if (columnasNoVacias == 0) {
            estaVacio = true;
        } else {
            estaVacio = false;
        }
        return estaVacio;
    }

    private boolean columnaLLena(int columna) {
        boolean columnaLlena;
        int cantidadFilasDeColumnaLlenas = 0;
        for (int i = (FILAS - 1); i >= 0; i--) {
            if (tablero[i][columna].estaOcupada()) {
                cantidadFilasDeColumnaLlenas++;
            }
        }
        if (cantidadFilasDeColumnaLlenas == FILAS) {
            columnaLlena = true;
        } else {
            columnaLlena = false;
        }
        return columnaLlena;
    }

    public boolean estaLleno() {
        boolean estaLleno;
        int cantidadColumnasLlenas = 0;
        for (int i = 0; i < COLUMNAS; i++) {
            if (columnaLLena(i)) {
                cantidadColumnasLlenas++;
            }
        }
        if (cantidadColumnasLlenas == COLUMNAS) {
            estaLleno = true;
        } else {
            estaLleno = false;
        }
        return estaLleno;
    }

    private void comprobarFicha(Ficha ficha) {
        Objects.requireNonNull(ficha, "La ficha no puede ser nula.");
    }

    private void comprobarColumna(int columna) {
        if ((columna > (COLUMNAS - 1)) || (columna < 0)) {
            throw new IllegalArgumentException("Columna incorrecta.");
        }
    }

    private int getPrimeraFilaVacia(int columna) {
        int primeraFilaVacia = (FILAS - 1);
        for (int i = (FILAS - 1); i >= 0; i--) {
            if (tablero[i][columna].estaOcupada()) {
                primeraFilaVacia--;
            }
        }
        return primeraFilaVacia;
    }

    private boolean objetivoAlcanzado(int fichasIgualesConsecutivas) {
        boolean objetivoAlcanzado;
        if (fichasIgualesConsecutivas >= FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS) {
            objetivoAlcanzado = true;
        } else {
            objetivoAlcanzado = false;
        }
        return objetivoAlcanzado;
    }

    private boolean comprobarHorizontal(int fila, Ficha ficha) {
        boolean horizontalGanadora;
        int fichasConsecutivas = 0;
        for (int i = 0; i < COLUMNAS; i++) {
            if (tablero[fila][i].getFicha() == ficha) {
                fichasConsecutivas++;
            } else if (fichasConsecutivas < FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS) {
                fichasConsecutivas = 0;
            }
        }
        horizontalGanadora = objetivoAlcanzado(fichasConsecutivas);
        return horizontalGanadora;
    }

    private boolean comprobarVertical(int columna, Ficha ficha) {
        boolean verticalGanadora;
        int fichasConsecutivas = 0;
        for (int i = (FILAS - 1); i >= 0; i--) {
            if (tablero[i][columna].getFicha() == ficha) {
                fichasConsecutivas++;
            } else if (fichasConsecutivas < FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS) {
                fichasConsecutivas = 0;
            }
        }
        verticalGanadora = objetivoAlcanzado(fichasConsecutivas);
        return verticalGanadora;
    }

    private int menor(int fila, int columna) {
        return Math.min(fila, columna);
    }

    private boolean comprobarDiagonalNE(int filaSemilla, int columnaSemilla, Ficha ficha) {

        // NO HE PODIDO HACERLO COMO LO HA PEDIDO EL PROFESOR YA QUE NO LE VEO EL SENTIDO A LO QUE DICE DE COMO CALCULARLO
        // SEGUN LO QUE HE ENTIENDIDO QUE HAGAMOS SEGUN LO DICHO POR EL PROFESOR PARA CALCULAR LA FILA INICIAL Y COLUMNA INICIAL ES -------->
        // DESPLAZAMIENTO = MENOR(FILASEMILLA, COLUMNASEMILLA);
        // FILAINICIAL = FILASEMILLA - DESPLAZAMIENTO;
        // COLUMNAINICIAL = COLUMNASEMILLA - DESPLAZAMIENTO;
        // 100% NO SE SIDO CAPAZ DE ENTENDER LAS OPERECIONES A LAS QUE RAMON SE REFERIA :(

        // NO HE UTILIZADO EL METODO MENOR, ¿RESTARIA PUNTUACION, CUANTO?

        // LUEGO DE HACER EL SIGUIENTE METODO COMPROBARDIAGONALNO HE PODIDO OBSERVAR QUE CLARAMENTE EL PROFESOR SI TIENE RAZON
        // DE COMO CALCULAR LA FILA Y LA COLUMNA INICIAL, SIN EMBARGO LO QUE HA OCURRIDO TAMPOCO HA SIDO QUE YO NO LO HAYA SABIDO
        // INTERPRETARLO BIEN, SINO QUE EL PROFESOR TIENE INVERTIDAS LAS INSTRUCCIONES DE LOS METODOS DE LAS DIAGONALES, EN LA DIAGONALNE
        // TIENE EL DEL METODO DIAGONALNO Y VICIVERSA

        // DE IGUAL MANERA, AL HACER YO MISMO LA FORMA DE COMO SACAR LA FILA Y COLUMNA INICIAL Y
        // RECORRER LA MISMA DIAGONAL, AUNQUE NO HAYA UTILIZADO EL METODO MENOR, ¿ME RESTARIA ALGO O SERIA CORRECTO ASI?

        boolean diagonalNEGanadora;
        int fichasConsecutivas = 0;
        int filaInicial;
        int columaInicial;
        if ((columnaSemilla + filaSemilla) <= (FILAS - 1)) {
            filaInicial = columnaSemilla + filaSemilla;
            columaInicial = 0;
            for (int i = filaInicial; i >= 0; i--) {
                if (tablero[i][columaInicial].getFicha() == ficha) {
                    fichasConsecutivas++;
                } else if (fichasConsecutivas < FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS) {
                    fichasConsecutivas = 0;
                }
                columaInicial++;
            }
        } else {
            filaInicial = FILAS - 1;
            columaInicial = columnaSemilla - (filaInicial - filaSemilla);
            for (int i = columaInicial; i < COLUMNAS; i++) {
                if (tablero[filaInicial][i].getFicha() == ficha) {
                    fichasConsecutivas++;
                } else if (fichasConsecutivas < FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS) {
                    fichasConsecutivas = 0;
                }
                filaInicial--;
            }
        }
        diagonalNEGanadora = objetivoAlcanzado(fichasConsecutivas);
        return diagonalNEGanadora;
    }

    private boolean comprobarDiagonalNO(int filaSemilla, int columnaSemilla, Ficha ficha) {
        boolean diagonalNOGanadora;
        int fichasConsecutivas = 0;
        int filaInicial;
        int columnaInicial;
        filaInicial = filaSemilla - (menor(filaSemilla, columnaSemilla));
        columnaInicial = columnaSemilla - (menor(filaSemilla, columnaSemilla));
        if (columnaInicial == 0) {
            for (int i = filaInicial; i < FILAS; i++) {
                if (tablero[i][columnaInicial].getFicha() == ficha) {
                    fichasConsecutivas++;
                } else if (fichasConsecutivas < FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS) {
                    fichasConsecutivas = 0;
                }
                columnaInicial++;
            }
        } else {
            for (int i = columnaInicial; i < COLUMNAS; i++) {
                if (tablero[filaInicial][i].getFicha() == ficha) {
                    fichasConsecutivas++;
                } else if (fichasConsecutivas < FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS) {
                    fichasConsecutivas = 0;
                }
                filaInicial++;
            }
        }
        diagonalNOGanadora = objetivoAlcanzado(fichasConsecutivas);
        return diagonalNOGanadora;
    }

    private boolean comprobarTirada(int fila, int columna, Ficha ficha) {

        // PREGUNTAR QUE FORMA ES MAS EFICIENTE PARA EL CODIGO, LA REALIZADA EN EL METODO O
        // LA SIGUIENTE, MUY SIMILAR ------>
        //         if(comprobarHorizontal(fila, ficha)){
        //            tiradaGanadora = true;
        //        } else if (comprobarVertical(columna, ficha)) {
        //            tiradaGanadora = true;
        //        } else if(comprobarDiagonalNE(fila, columna, ficha)){
        //            tiradaGanadora = true;
        //        } else if(comprobarDiagonalNO(fila, columna, ficha)){
        //            tiradaGanadora = true;
        //        } else{  tiradaGanadora = false;  }

        boolean tiradaGanadora;
        tiradaGanadora = comprobarHorizontal(fila, ficha) || comprobarVertical(columna, ficha) || comprobarDiagonalNE(fila, columna, ficha) || comprobarDiagonalNO(fila, columna, ficha);
        return tiradaGanadora;
    }

    public boolean introducirFicha(int columna, Ficha ficha) throws OperationNotSupportedException {
        boolean fichaGanadora;
        comprobarFicha(ficha);
        comprobarColumna(columna);
        if (estaLleno()) {
            throw new OperationNotSupportedException("Tablero lleno.");
        } else if (columnaLLena(columna)) {
            throw new OperationNotSupportedException("Columna llena.");
        }
        int fila = getPrimeraFilaVacia(columna);
        this.tablero[fila][columna].setFicha(ficha);
        fichaGanadora = comprobarTirada(fila, columna, ficha);
        return fichaGanadora;
    }

    @Override
    public String toString() {
        StringBuilder stringRepresentacionTablero = new StringBuilder();
        for(int i=0;i<FILAS;i++){
            for(int j=0;j<COLUMNAS;j++){
                if(j==0){
                    stringRepresentacionTablero.append(String.format("|%s", tablero[i][j]));
                }else if(j==(COLUMNAS-1)){
                    stringRepresentacionTablero.append(String.format("%s|\n", tablero[i][j]));
                }else{
                    stringRepresentacionTablero.append(tablero[i][j]);
                }
            }
        }
        stringRepresentacionTablero.append(" -------\n");
        return stringRepresentacionTablero.toString();
    }
}
