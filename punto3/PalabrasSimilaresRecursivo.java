/*Autor: Andres Felipe Aristizabal - Edison Hoover Largo
 * Metodo: Dada una matriz de Strings (de n filas x 2 columnas), donde cada fila corresponde a un caso de prueba (con dos
palabras p1 y p2), devolver un vector que contenga las posiciones de las filas de la matriz original que cumplen
el criterio de ser palabras similares.

    Dos palabras son similares si tienen la misma longitud y la información de p1 está en p2 en cualquier orden.
 */


package punto3;

import java.util.ArrayList;

public class PalabrasSimilaresRecursivo {
    public static ArrayList<Integer> arreglo= new ArrayList<>();
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String[][] matriz = { {"leon", "lana"}, {"saca", "casa"}, {"arroz", "zorra"},{"volar","arbol"}, {"paro", "ropa"} };
        int cont=0;
        determinarSimilaridadRecursivo(matriz, cont);

        // Imprimir la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Filas con palabras similares\n");

        //imprimir arreglo
        String t="";
        for (int elemento : arreglo) {
             t= t + elemento + "\t" ;
            
        }
        System.out.println(t);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("El tiempo de ejecución fue de: " + executionTime + " milisegundos");
    }

    public static void determinarSimilaridadRecursivo(String matriz[][], int i){
        if(i == matriz.length){
            return;
        }
        if(matriz[i][0].length() == matriz[i][1].length()){
            int aux= verificarContenido(matriz, i, 0);
            if(aux == matriz[i][0].length()){
                arreglo.add(i);
            }
        }

        determinarSimilaridadRecursivo(matriz, ++i);
    }

    //Metodo que verifica que la palabra en la columna 2 contenga las letras de las palabra en la columna 1
    public static int verificarContenido(String matriz[][], int i, int j){
        if(j == matriz[i][0].length()){
            return 0;
        }
        String digito = String.valueOf(matriz[i][0].charAt(j));
        if(matriz[i][1].contains(digito)) {
            return 1+ verificarContenido(matriz, i, ++j);
        }
        return verificarContenido(matriz, i, ++j);
        
    }

    
}
