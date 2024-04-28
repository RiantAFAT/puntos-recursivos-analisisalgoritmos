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

public class NumerosPolidivisiblesRecursivo {

    public static ArrayList<Integer> arreglo= new ArrayList<>();;


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[][] matriz = { {8000, 1767, 1854}, {1804, 1525, 2627}, {2016, 1468, 3004} };
        int m = 0,n = 0;
        verificarPolidivisiblesRecursivo(matriz, m, n);


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

    public static void verificarPolidivisiblesRecursivo(int matriz[][], int i, int j){
        if(i == matriz.length && j == matriz[0].length){
            return;
        }
        if(j == matriz[0].length - 1){
            comprobarPolidivisibilidadRecursivo(matriz[i][j], 1, false, 0);
            if(i == matriz.length - 1){
                verificarPolidivisiblesRecursivo(matriz, ++i, ++j);
            }else{
                verificarPolidivisiblesRecursivo(matriz, ++i, 0);
            }
        }else{
            comprobarPolidivisibilidadRecursivo(matriz[i][j], 1, false, 0);
            verificarPolidivisiblesRecursivo(matriz, i, ++j);
        }
    }

    //Metodo que comprueba si el valor de la matriz enviado corresponde a un numero polidivisible
    public static void comprobarPolidivisibilidadRecursivo(int valor, int k, boolean aux, int cont){
        if(k > Integer.toString(valor).length()){
            return;
        }
        String digitos = Integer.toString(valor).substring(0,k);//Se abstrae la subcadena con el numero dependiendo la iteracion en la que va
        if(Integer.parseInt(digitos) % k == 0) {//Convierte la subcadena a entero y verifica si es divisible por la iteracion correspondiente.
            cont ++;
        }
        if(Integer.parseInt(Integer.toString(valor)) > 0 && cont == Integer.toString(valor).length()) {
            aux = true;
        }
        if(aux == true){
            arreglo.add(valor);
            k = Integer.toString(valor).length() + 1;
                        
        }
        comprobarPolidivisibilidadRecursivo(valor, ++k, aux, cont);
    }
    
}
