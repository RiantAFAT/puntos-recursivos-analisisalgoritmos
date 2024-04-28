/*Autor: Andres Felipe Aristizabal - Edison Hoover Largo.
 * Metodo: Se requier un algoritmo que identifique si las palabras en una matriz son palabras encadenadas,
 * realizando un recorrido comun yendo de fila en fila de manera ascendente.

    Dos palabras están encadenadas cuando las dos últimas letras de la primera palabra 
    son iguales a las dos primeras letras de la última(en el mismo orden).
 */


package punto4;

public class PalabrasEncadenadasRecursivo {
    public static int pru=0;
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String[][] matriz = { {"sien", "encima","mapa"}, {"pata", "tapa", "papa"}, {"pato", "toma", "mama"} };
        int l=0,u=0;
        boolean isEncadenada= verificarPalabrasEncadenadasRecursivo(matriz, l, u);

        // Imprimir la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        if(isEncadenada){
            System.out.println("La lista de palabras en la matriz corresponde a palabras encadenadas: " + isEncadenada);
        }else{
            System.out.println("La lista de palabras en la matriz no corresponde a palabras encadenas en su totalidad: " + isEncadenada);
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("El tiempo de ejecución fue de: " + executionTime + " milisegundos");
    }

    public static boolean verificarPalabrasEncadenadasRecursivo(String matriz[][], int i, int j){
        if(i == matriz.length-1 && j == matriz[0].length-1){ 
            return true;
        }
        if(j == matriz[0].length-1 ){ //Verifica que nos estemos moviendo sobre una fila
            String termina = matriz[i][j].substring(matriz[i][j].length()-2, matriz[i][j].length()-1);
		        if(matriz[i+1][0].startsWith(termina) == true) {
			        return verificarPalabrasEncadenadasRecursivo(matriz, ++i, 0);
                }else{
                    return false;
                }
        }else{
            String termina = matriz[i][j].substring(matriz[i][j].length()-2, matriz[i][j].length()-1);
		        if(matriz[i][j+1].startsWith(termina) == true) {
			        return verificarPalabrasEncadenadasRecursivo(matriz, i, ++j);
                }else{
                    return false;
                }
        }    
    }
    
}
