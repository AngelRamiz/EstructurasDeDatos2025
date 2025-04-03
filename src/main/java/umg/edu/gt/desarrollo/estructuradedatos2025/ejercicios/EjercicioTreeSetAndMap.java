package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Iterator;

public class EjercicioTreeSetAndMap {
/** INSTRUCCIONES
	Escriba el algoritmo que resuelve el problema en esta clase.
Debe crear un package llamado umg.edu.gt.test.EjercicioTree que corresponda al Test de esta clase.
Genere un Test por cada ejemplo y fuerce que uno de esos Test falle, puede implementar retornar un resultado
y compararlo con el esperado.
 */
/* EJERCICIO 1: Análisis de Frecuencia de Palabras (TreeMap)
 * 📜 Descripción: Escriba un programa que lea un texto de un archivo y cuente la frecuencia de cada palabra, ordenándolas alfabéticamente.
	🔹 Instrucciones:
		Leer un archivo de texto (.txt).			
		Dividir el texto en palabras (ignorando puntuaciones y convirtiéndolas a minúsculas).
		Almacenar cada palabra en un TreeMap<String, Integer>, donde la clave es la palabra y el valor es el número de veces que aparece.
		Imprimir las palabras en orden alfabético junto con su frecuencia.
 */

   
    public TreeMap<String, Integer> contarPalabrasEnArchivo(String rutaArchivo) throws IOException {
        TreeMap<String, Integer> conteoPalabras = new TreeMap<>();
        
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String lineaActual;
            
            while ((lineaActual = lector.readLine()) != null) {
                String[] palabras = lineaActual.toLowerCase().split("\\s+");
                
                for (String palabra : palabras) {
                    if (!palabra.isEmpty()) {
                        conteoPalabras.put(palabra, conteoPalabras.getOrDefault(palabra, 0) + 1);
                    }
                }
            }
        }
        
        return conteoPalabras;
    }
    
   
    public void mostrarConteoPalabras(TreeMap<String, Integer> conteo) {
        System.out.println("\nConteo de palabras:");
        conteo.forEach((palabra, cantidad) -> 
            System.out.println(palabra + ": " + cantidad));
    }
        
        /* EJERCICIO 2: Rastreador de Versiones de Código (TreeMap)

		📜 Descripción: Desarrolle un programa que simule un rastreador de versiones de archivos en un sistema de control de versiones.
		🔹 Instrucciones:
			Utilice un TreeMap<Integer, String>, donde la clave representa el número de versión y el valor es el contenido de esa versión del código.			
			Debe permitir:			
			Agregar una nueva versión con una clave autoincrementada.			
			Obtener una versión específica dada su clave.			
			Obtener la última versión disponible.			
			Eliminar una versión específica si es necesario.
			
			Salida:
				Agregar versión 1: "System.out.println('Hola Mundo');"
				Agregar versión 2: "System.out.println('Hola Java');"
				Última versión: "System.out.println('Hola Java');"
				Versión 1: "System.out.println('Hola Mundo');"
     */
    
    private final TreeMap<Integer, String> historialVersiones = new TreeMap<>();
    private int versionActual = 0;

    public int agregarVersionCodigo(String codigo) {
        versionActual++;
        historialVersiones.put(versionActual, codigo);
        System.out.printf("Agregar version %d: \"%s\"%n", versionActual, codigo);
        return versionActual;
    }

    public String obtenerVersionCodigo(int numeroVersion) {
        return historialVersiones.get(numeroVersion);
    }
    
    public String obtenerUltimaVersion() {
        if (historialVersiones.isEmpty()) {
            return null;
        }
        String ultima = historialVersiones.lastEntry().getValue();
        System.out.printf("Ultima version: \"%s\"%n", ultima);
        return ultima;
    }
  
    public void mostrarVersion(int numeroVersion) {
        String codigo = obtenerVersionCodigo(numeroVersion);
        if (codigo != null) {
            System.out.printf("Version %d: \"%s\"%n", numeroVersion, codigo);
        }
    }
    
    /** EJERCICIO 3: Sistema de Gestión de Eventos (TreeSet)
	📜 Descripción: Implemente un sistema para administrar eventos ordenados cronológicamente.		
	🔹 Instrucciones:		
		Utilice un TreeSet<Evento>, donde cada Evento debe contener:		
		fecha (LocalDateTime)		
		nombre (String)		
		ubicación (String)		
		Los eventos deben ordenarse automáticamente por fecha y hora.		
		Debe permitir:		
			Agregar un nuevo evento.		
			Mostrar la lista de eventos en orden cronológico.		
			Obtener el próximo evento a ocurrir.		
			Eliminar un evento pasado automáticamente después de una consulta.
			
		Salida:
			Próximo evento: "Conferencia de Java", 2025-05-10 10:00, Auditorio A  
			Lista de eventos:  
			1. "Taller de Machine Learning", 2025-04-15 14:00, Sala 3  
			2. "Conferencia de Java", 2025-05-10 10:00, Auditorio A  

 */
  
 // Clase interna para representar eventos
    private static class Evento implements Comparable<Evento> {
        LocalDateTime fecha;
        String nombre;
        String ubicacion;

        Evento(LocalDateTime fecha, String nombre, String ubicacion) {
            this.fecha = fecha;
            this.nombre = nombre;
            this.ubicacion = ubicacion;
        }

     
        public int compareTo(Evento otro) {
            return this.fecha.compareTo(otro.fecha);
        }

        
        public String toString() {
            return String.format("\"%s\", %s, %s", 
                nombre, 
                fecha.toString().replace("T", " "), 
                ubicacion);
        }
    }

    private final TreeSet<Evento> eventos = new TreeSet<>();

    // Metodos
    public void agregarEvento(LocalDateTime fecha, String nombre, String ubicacion) {
        eventos.add(new Evento(fecha, nombre, ubicacion));
    }

    public String obtenerProximoEvento() {
        return eventos.isEmpty() ? null : eventos.first().toString();
    }

    public void eliminarEventosPasados() {
        LocalDateTime ahora = LocalDateTime.now();
        Iterator<Evento> it = eventos.iterator();
        
        while (it.hasNext()) {
            Evento e = it.next();
            if (e.fecha.isBefore(ahora)) {
                it.remove();
            } else {
                break;
            }
        }
    }

    public void mostrarEventos() {
        System.out.println("Lista de eventos:");
        int i = 1;
        for (Evento evento : eventos) {
            System.out.printf("%d. %s%n", i++, evento);
        }
    }

    public void mostrarProximoEvento() {
        String proximo = obtenerProximoEvento();
        if (proximo != null) {
            System.out.println("Proximo evento: " + proximo);
        }
    }
    public int obtenerCantidadEventos() {
        return eventos.size();
    }
}