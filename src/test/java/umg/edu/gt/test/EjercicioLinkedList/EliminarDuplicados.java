package umg.edu.gt.test.EjercicioLinkedList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioLinkedList;

public class EliminarDuplicados {

    @Test
    public void EliminarDuplicado() {
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(1);
        lista.add(2);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(4);
        lista.add(5);

        LinkedList<Integer> resultado = EjercicioLinkedList.eliminarDuplicados(lista);

        LinkedList<Integer> esperado = new LinkedList<>();
        esperado.add(1);
        esperado.add(2);
        esperado.add(3);
        esperado.add(4);
        esperado.add(5);

        assertEquals(esperado, resultado);
    }

    @Test
    public void ListaVacia() {
        LinkedList<Integer> lista = new LinkedList<>();
        LinkedList<Integer> resultado = EjercicioLinkedList.eliminarDuplicados(lista);
        assertTrue(resultado.isEmpty());
    }

    @Test
    public void ForzarFallo() {
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(1);
        lista.add(1);
        lista.add(2);
        lista.add(3);

        LinkedList<Integer> resultado = EjercicioLinkedList.eliminarDuplicados(lista);

        // Test para hacerlo fallar
        LinkedList<Integer> incorrecto = new LinkedList<>();
        incorrecto.add(1);
        incorrecto.add(1);
        incorrecto.add(2);
        incorrecto.add(3);

        assertEquals(incorrecto, resultado);
    }
}