/*Autores: Andres Felipe Aristizabal - Edison Hoover Largo
 * Metodo: Dada una matriz, evaluar por cada posición [i][j] de la misma si el número dado corresponde a un cuadrado
    perfecto. Se debe devolver una matriz informando para cada posición el número más pequeño que al ser
    multiplicado por el número del caso de prueba da como resultado un cuadrado perfecto.

    Un número es un cuadrado perfecto si su raíz cuadrada es un número entero (sin decimales).
 */

package punto2;

public class CuadradoPerfectoRecursivo {
    public static int matrizRespuesta[][];

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[][] matriz = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        matrizRespuesta = new int[matriz.length][matriz[0].length];
        int k= 0, l=0;
        calcularProductosPerfectosRecursivo(matriz, k, l);

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

    public static void calcularProductosPerfectosRecursivo(int matriz[][], int i, int j){
        if(i== matriz.length && j== matriz[0].length){
            return;
        }
        //Comprueba si el numero en si es un cuadrado perfecto, si lo es el producto minimo seria 1.
        if(Math.sqrt(matriz[i][j])%1==0){
            matrizRespuesta[i][j]= 1;
        }else{
            //Busca un producto minimo que consiga un cuadrado perfecto.
            encontrarProductoCuadradoPerfecto(matriz,i, j, 2);
        }
        if(j< matriz[0].length-1){
            calcularProductosPerfectosRecursivo(matriz, i, ++j);
        }else if(i< matriz.length-1){
            calcularProductosPerfectosRecursivo(matriz, ++i, 0);
        }
        
    }

    /*Funcion que busca un producto minimo para el valor de la 
    posicion de la matriz que logre como resultado un cuadrado perfecto.*/
    public static void encontrarProductoCuadradoPerfecto(int matriz[][], int i, int j, int k){
        if(k>= (matriz[i][j]+1)){
            return;
        }
        int producto= matriz[i][j]*k;
        if(Math.sqrt(producto)%1==0){
            matrizRespuesta[i][j]= k;
            k= matriz[i][j]+1;
        }
        encontrarProductoCuadradoPerfecto(matriz, i, j, ++k);
    }

    
}
