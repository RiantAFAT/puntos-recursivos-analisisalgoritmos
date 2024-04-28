/*Autor: Andres Felipe Aristizabal - Edison Hoover Largo
 * Metodo: Llenar una variable en forma de espiral de forma recursiva
 */

public class llenarMatrizRecursivo{

    private static int valor=1;//variable global que controla el valor de las celdas

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int filas = 10; // número de filas de la matriz
        int columnas = 10; // número de columnas de la matriz
        int[][] matriz = new int[filas][columnas];
        //int aux= 1;
        llenarMatriz(matriz, 0, filas-1, 0, columnas-1);

        // Imprimir la matriz
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("El tiempo de ejecución fue de: " + executionTime + " milisegundos");
    }

    public static void llenarMatriz( int matriz[][], int inicioFila, int finFila, int inicioColumna, int finColumna){

        if(inicioFila > finFila || inicioColumna > finColumna){
            return;
        }
        
        matriz[inicioFila][inicioColumna] = valor++;
        llenarColumna(matriz, inicioFila+1 , finFila, inicioColumna);//Llamado recursivo para llenar columna de arriba hacia abajo
        llenarFila(matriz, finFila, inicioColumna+1 , finColumna);//Llamado recursivo para llenar fila de izquierda a derecha
        llenarColumnaInversa(matriz, finFila-1 , inicioFila, finColumna);//Llamado recursivo para llenar columna de abajo hacia arriba
        llenarFilaInversa(matriz, inicioFila, finColumna-1 , inicioColumna+1);//Llamado recursivo para llenar fila de derecha a izquierda
        
        llenarMatriz(matriz, inicioFila+1 , finFila-1 , inicioColumna+1, finColumna-1);//llamado recursivo para repetir el proceso, pero ahora omitiendo las filas y columnas llenas.

    }

    //Metodo que llena columnas de arribas hacia abajo
    public static void llenarColumna(int[][] matriz, int inicioFila, int finFila, int columna) {  
        if (inicioFila <= finFila) {
            matriz[inicioFila][columna] = valor;
            valor= valor+1;
            llenarColumna(matriz, inicioFila + 1, finFila, columna);
        }
    }

    //Metodo que llena filas de izquierda a derecha
    public static void llenarFila(int[][] matriz, int fila, int inicioColumna, int finColumna ) { 
        if (inicioColumna <= finColumna) {
            matriz[fila][inicioColumna] = valor;
            valor= valor+1;
            llenarFila(matriz, fila, inicioColumna + 1, finColumna);
        }
    }

    //Metodo que llena columnas de abajo hacia arriba
    public static void llenarColumnaInversa(int[][] matriz, int inicioFila, int finFila, int columna) {
        if (inicioFila >= finFila) {
            matriz[inicioFila][columna] = valor;
            valor= valor+1;
            llenarColumnaInversa(matriz, inicioFila-1 , finFila, columna);
        }
    }

    //Metodo que llena filas de derecha a izquierda
    public static void llenarFilaInversa(int[][] matriz, int fila, int inicioColumna, int finColumna) {
        if (inicioColumna >= finColumna) {
            matriz[fila][inicioColumna] = valor;
            valor= valor+1;
            llenarFilaInversa(matriz, fila, inicioColumna-1, finColumna);
        }
    }


}