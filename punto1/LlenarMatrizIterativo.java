/*Autores: Andres Felipe Aristizabal - Edison Hoover Largo
 * Metodo: Llenar una matriz en forma de espiral de forma iterativa
 */

public class LlenarMatrizIterativo {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int filas = 10; // número de filas de la matriz
        int columnas = 10; // número de columnas de la matriz
        int[][] matriz = new int[filas][columnas];
        
        llenarMatriz(matriz);
        
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
    
    public static void llenarMatriz(int[][] matriz) {
        int inicioFila = 0;
        int finFila = matriz.length - 1;
        int inicioColumna = 0;
        int finColumna = matriz[0].length - 1;
        int valor = 1;
        
        while (inicioFila <= finFila && inicioColumna <= finColumna) { //condicion de parada.
           
            // Llenar la columna Izquierda de arriba hacia abajo
            for (int i = inicioFila; i <= finFila; i++) {
                matriz[i][inicioColumna] = valor++;
            }
            inicioColumna++;

            // Llenar la fila inferioir de izquierda a derecha
            for (int i = inicioColumna; i <= finColumna; i++) {
                matriz[finFila][i] = valor++;
            }
            finFila--;
            
            // Llenar la columna derecha de abajo hacia arriba
            for (int i = finFila; i >= inicioFila; i--) {
                matriz[i][finColumna] = valor++;
            }
            finColumna--;
            
            // Llenar la fila superior de derecha a izquierda
            for (int i = finColumna; i >= inicioColumna; i--) {
                matriz[inicioFila][i] = valor++;
            }
            inicioFila++;
        }
    }
}
