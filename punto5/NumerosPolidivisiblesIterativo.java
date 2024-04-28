/*Autores: Andres Felipe Aristizabal - Edison Hoover Largo
 * Metodo: Dada una matriz de números enteros, devolver un arreglo con todos los elementos que corresponden a números
            polidivisibles. 
            Los números polidivisibles son aquellos números que:
            • Son mayores que cero.
            • El número formado por su primer dígito es múltiplo de 1 (esto lo cumplen todos los números).
            • El número formado por sus dos primeros dígitos es múltiplo de 2.
            • El número formado por sus tres primeros dígitos es múltiplo de 3.
            • El número formado por sus cuatro primeros dígitos es múltiplo de 4.
            • ...

    
 */

package punto5;

import java.util.ArrayList;

public class NumerosPolidivisiblesIterativo {
    
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[][] matriz = { {8000, 1767, 1854}, {1804, 1525, 2627}, {2016, 1468, 3004} };
        ArrayList<Integer> arreglo= new ArrayList<>();
        verificarPolidivisibles(matriz, arreglo);

        // Imprimir la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\n");

        System.out.println("Estos son los numeros polidivisibles:\n");

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

    
    public static void verificarPolidivisibles(int matriz[][], ArrayList<Integer> arreglo){
        boolean aux = false;
        int cont = 0;
        String digitos = "";
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){
                aux = false;
                cont = 0;
                for(int k = 1; k <= Integer.toString(matriz[i][j]).length(); k++) {
                    digitos = Integer.toString(matriz[i][j]).substring(0,k);//Se abstrae la subcadena con el numero dependiendo la iteracion en la que va
                    if(Integer.parseInt(digitos) % k == 0) {//Convierte la subcadena a entero y verifica si es divisible por la iteracion correspondiente.
                        cont ++;
                    }
                    if(Integer.parseInt(Integer.toString(matriz[i][j])) > 0 && cont == Integer.toString(matriz[i][j]).length()) {
                        aux = true;
                        
                    }
                    if(aux == true){
                        arreglo.add(matriz[i][j]);
                        k = Integer.toString(matriz[i][j]).length() + 1;
                        
                    }
                    
                }
                
            }
            
        }


    }

}
