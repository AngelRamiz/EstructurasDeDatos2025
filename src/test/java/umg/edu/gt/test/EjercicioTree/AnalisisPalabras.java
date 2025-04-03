package umg.edu.gt.test.EjercicioTree;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioTreeSetAndMap;
import java.util.TreeMap;

public class AnalisisPalabras {
    
    private static final String RUTA_ARCHIVO = "C:/Users/tatto/Documents/UNIVERSIDAD 5TO SEMESTRE/programacion 3/EstructuraDeDatos2025/src/main/resources/ejercicio1Tree/AnalisisPrueba.txt";
    
    @Test
    void testAnalisisBasico() throws Exception {
        EjercicioTreeSetAndMap analizador = new EjercicioTreeSetAndMap();
        TreeMap<String, Integer> resultado = analizador.contarPalabrasEnArchivo(RUTA_ARCHIVO);
        
        // revisa 
        assertEquals(2, resultado.get("hola"), "La palabra hola debe aparecer 2 veces");
        assertEquals(2, resultado.get("java"), "La palabra java debe aparecer 2 veces");
        assertEquals(1, resultado.get("mundo"), "La palabra mundo debe aparecer 1 vez");
        
        // Mostrar resultados 
        analizador.mostrarConteoPalabras(resultado);
    }
    
    @Test
    void testFallaIntencional() throws Exception {
        EjercicioTreeSetAndMap analizador = new EjercicioTreeSetAndMap();
        TreeMap<String, Integer> resultado = analizador.contarPalabrasEnArchivo(RUTA_ARCHIVO);
        
        //fallo intencional
        assertEquals(3, resultado.get("genial"), " fallo intencional genial aparece 2 veces no 3 ");
    }
}