package umg.edu.gt.test.EjercicioLinkedList;

import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioLinkedList;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MetodoIntercambio {

    @Test
    public void IntercalarListas() {
        // Crear las lista
        LinkedList<Integer> lista1 = new LinkedList<>();
        lista1.add(1);
        lista1.add(3);
        lista1.add(5);

        LinkedList<Integer> lista2 = new LinkedList<>();
        lista2.add(2);
        lista2.add(4);
        lista2.add(6);

 
        LinkedList<Integer> esperado = new LinkedList<>();
        esperado.add(1);
        esperado.add(2);
        esperado.add(3);
        esperado.add(4);
        esperado.add(5);
        esperado.add(6);

      
        LinkedList<Integer> resultado = EjercicioLinkedList.intercalarListas(lista1, lista2);

        assertEquals(esperado, resultado, "Las listas no se mezclaron correctamente");
    }

    @Test
    public void IntercalarListasFalla() {
        // Crear las listas para el fallo
        LinkedList<Integer> lista1 = new LinkedList<>();
        lista1.add(1);
        lista1.add(3);
        lista1.add(5);

        LinkedList<Integer> lista2 = new LinkedList<>();
        lista2.add(2);
        lista2.add(4);
        lista2.add(6);

        // Lista esperada incorrecta (esto forzará el fallo)
        LinkedList<Integer> esperado = new LinkedList<>();
        esperado.add(1);
        esperado.add(2);
        esperado.add(4); //aqui esta el fallo
        esperado.add(3);
        esperado.add(5);
        esperado.add(6);

     
        LinkedList<Integer> resultado = EjercicioLinkedList.intercalarListas(lista1, lista2);

        assertEquals(esperado, resultado, "Prueba para fallar: las listas no se mezclaron correctamente");
    }
}

