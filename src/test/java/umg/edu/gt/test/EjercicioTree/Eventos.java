package umg.edu.gt.test.EjercicioTree;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioTreeSetAndMap;
import java.time.LocalDateTime;

public class Eventos {
    
    @Test
    void testGestionEventos() {
        EjercicioTreeSetAndMap gestor = new EjercicioTreeSetAndMap();
        
        // Crear fechas para los eventos
        LocalDateTime tallerFecha = LocalDateTime.of(2025, 4, 15, 14, 0);
        LocalDateTime conferenciaFecha = LocalDateTime.of(2025, 5, 10, 10, 0);
        
        // Agregar eventos en orden no cronologico
        gestor.agregarEvento(conferenciaFecha, "Conferencia de Java", "Auditorio A");
        gestor.agregarEvento(tallerFecha, "Taller de Machine Learning", "Sala 3");
        
        // Mostrar resultados 
        gestor.mostrarProximoEvento();
        gestor.mostrarEventos();
        
        // fallo intencional
        assertEquals(3, gestor.obtenerCantidadEventos(), "fallo intencional son 2 no 3 ");
    }
}