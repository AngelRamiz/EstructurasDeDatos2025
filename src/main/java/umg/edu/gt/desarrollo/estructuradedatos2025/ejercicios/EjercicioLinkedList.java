package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

import java.util.LinkedList;
import java.util.HashSet;

public class EjercicioLinkedList {
   
	//Ejercicio 1: metodo que elimine los valores duplicados
    public static LinkedList<Integer> eliminarDuplicados(LinkedList<Integer> lista) {
        if (lista == null) {
            throw new IllegalArgumentException("La lista no puede estar vacia"); 
        }

        HashSet<Integer> conjunto = new HashSet<>();
        LinkedList<Integer> resultado = new LinkedList<>();

        for (Integer num : lista) {
            if (!conjunto.contains(num)) {
                conjunto.add(num);
                resultado.add(num);
            }
        }

        return resultado;
    }
    
    //Ejercicio 2: metodo que invierta los elementos de una LinkedList<String> sin usar otra lista o ArrayList.
    public static void invertirLinkedList(LinkedList<String> lista) {
        if (lista == null) {
            throw new IllegalArgumentException("La lista no puede estar vacia");
        }

        int left = 0;
        int right = lista.size() - 1;

        while (left < right) {
            // Intercambiar elementos
            String temp = lista.get(left);
            lista.set(left, lista.get(right));
            lista.set(right, temp);
            
            left++;
            right--;
        }
    }
    //Ejercicio 3:  metodo que devuelva una nueva LinkedList<Integer> con los elementos de ambas listas intercalados en orden

    public static LinkedList<Integer> intercalarListas(LinkedList<Integer> lista1, LinkedList<Integer> lista2) {
        LinkedList<Integer> resultado = new LinkedList<>();
        
  
        if (lista1 == null || lista2 == null) {
            throw new IllegalArgumentException("Las listas no puede estar vacia");
        }
        
        // recorremos las listas 
        while (!lista1.isEmpty() && !lista2.isEmpty()) {
            if (lista1.getFirst() < lista2.getFirst()) {
                resultado.add(lista1.poll());
            } else {
                resultado.add(lista2.poll());
            }
        }
        
        // agrega elemenots restantes
        resultado.addAll(lista1);
        resultado.addAll(lista2);
        
        return resultado;
    }
    
}