package umg.edu.gt.test.EjercicioTree;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioTreeSetAndMap;

public class Rastreador {
    
    @Test
    void testRastreadorVersiones() {
        EjercicioTreeSetAndMap rastreador = new EjercicioTreeSetAndMap();
        
        // Agregar versiones 
        int v1 = rastreador.agregarVersionCodigo("System.out.println('Hola Mundo');");
        int v2 = rastreador.agregarVersionCodigo("System.out.println('Hola Java');");
        
        // Obtener ultima version
        rastreador.obtenerUltimaVersion();
        
        // Mostrar version  
        rastreador.mostrarVersion(v1);
        
        // fallo intencional
        assertEquals(3, v2, " Fallo intencional v2 tiene que ser 2 no 3 ");
    }
}