/*Autores: Andres Felipe Aristizabal- Edison Hoover Largo
 * Metodo: Dada una matriz, evaluar por cada posición [i][j] de la misma si el número dado corresponde a un cuadrado
    perfecto. Se debe devolver una matriz informando para cada posición el número más pequeño que al ser
    multiplicado por el número del caso de prueba da como resultado un cuadrado perfecto.

    Un número es un cuadrado perfecto si su raíz cuadrada es un número entero (sin decimales).
 */

package punto2;

public class CuadradoPerfectoIterativo {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[][] matriz = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        int[][] matrizRespuesta = new int[matriz.length][matriz[0].length];
        calcularProductosPerfectos(matriz, matrizRespuesta);

        // Imprimir la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Esta es la matriz de productos respectivamente para lograr un cuadrado perfecto:\n");

        // Imprimir la matriz de respuesta con productos para lograr un cuadrado perfecto
        for (int i = 0; i < matrizRespuesta.length; i++) {
            for (int j = 0; j < matrizRespuesta[0].length; j++) {
                System.out.print(matrizRespuesta[i][j] + "\t");
            }
            System.out.println();
        }


        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("El tiempo de ejecución fue de: " + executionTime + " milisegundos");
    }

    public static void calcularProductosPerfectos (int matriz[][], int matrizRespuesta[][] ){
        for(int i= 0; i< matriz.length; i++){
            for(int j= 0; j< matriz[0].length; j++){
                if(Math.sqrt(matriz[i][j])%1==0){//Comprueba si el numero es en si un cuadrado perfecto
                    matrizRespuesta[i][j]= 1;//si lo es el producto minimo seria 1
                }else{
                    //Se busca el producto minimo
                    for(int k=2; k<= matriz[i][j]; k++){
                        int producto= matriz[i][j]*k;
                        if(Math.sqrt(producto)%1==0){//Comprueba si el numero obtenido es un cuadrado perfecto
                            matrizRespuesta[i][j]= k;//Si lo es lo añade a la matriz
                            k= matriz[i][j]+1;
                        }
                    }
                }
            }
        }
    }
}
