package umg.edu.gt.test.EjercicioLinkedList;

import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioLinkedList;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InvertirElementos {

    @Test
    public void InvertirLinkedListCorrecto() {
    	
        // creamos la lista
        LinkedList<String> lista = new LinkedList<>();
        lista.add("A");
        lista.add("B");

        // lista despues de la inversion
        LinkedList<String> esperado = new LinkedList<>();
        esperado.add("B");
        esperado.add("A");

       
        EjercicioLinkedList.invertirLinkedList(lista);
        assertEquals(esperado, lista, "La lista no se invirtió correctamente");
    }

    @Test
    public void InvertirLinkedListFalla() {
        //lista para fallo
        LinkedList<String> lista = new LinkedList<>();
        lista.add("X");
        lista.add("Y");

        //para forzar el fallo
        LinkedList<String> esperado = new LinkedList<>();
        esperado.add("X"); 
        esperado.add("Y"); 

        EjercicioLinkedList.invertirLinkedList(lista);
        assertEquals(esperado, lista, "Prueba forzada a fallar: la inversión no debería coincidir con este resultado");
    }
}
