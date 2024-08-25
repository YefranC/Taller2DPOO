package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
    	List<String> lista = new ArrayList<>(this.mapaCadenas.values());
    	Collections.sort(lista);
        return lista;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
    	List<String> lista = new ArrayList<>(this.mapaCadenas.keySet());
    	Collections.sort(lista, Comparator.reverseOrder());;
        return lista;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
        if(this.mapaCadenas.size()>0) {
        	List<String> lista = getValoresComoLista();
        	return lista.getFirst();
        }
        else {
        	return null;
        }
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
    	if(this.mapaCadenas.size()>0) {
        	List<String> lista = getValoresComoLista();
        	return lista.getLast();
        }
        else {
        	return null;
        }    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
    	List<String> llaves = new ArrayList<String>(this.mapaCadenas.keySet());
        for (int i = 0; i < llaves.size(); i++) {
            String valor = llaves.get(i);
            llaves.set(i, valor.toUpperCase());
        }
        return llaves;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
    	int cantidad =0;
    	List<String> valores = new ArrayList<>(this.mapaCadenas.values());
    	Map<String,Integer> mapa = new HashMap<String,Integer>();
    	for(String valor: valores) {
    		mapa.put(valor, 1);
    	}
    	cantidad = mapa.size();
    	return cantidad;
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
    	char[] letras = cadena.toCharArray();
    	int izq =0;
    	int der =  letras.length-1;
    	while(izq<der) {
    		char aux = letras[izq];
    		letras[izq] = letras[der];
    		letras[der] = aux;
    		izq++;
    		der--;
    	}
    	String invertida = new String(letras);
    	
    	this.mapaCadenas.put(invertida, cadena);

    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {
    	this.mapaCadenas.remove(llave);
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
    for(Entry<String, String>pareja:this.mapaCadenas.entrySet()) {
    	if(pareja.getValue().equals(valor)) {
    		this.mapaCadenas.remove(pareja.getKey());
    		break;
    	}
    	
    }
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
    	this.mapaCadenas.clear();
    	for(Object obj: objetos) {
    		agregarCadena(obj.toString());
    	}
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
    	Map<String,String> control = new HashMap<String,String>();
    	for(Entry<String, String>pareja:this.mapaCadenas.entrySet()) {
        	control.put(pareja.getKey().toUpperCase(), pareja.getValue());
    	}
    	this.mapaCadenas= control;
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
    	List<String> valores = new ArrayList<String>(this.mapaCadenas.values());
    	for(String valor: otroArreglo) {
    		if (!valores.contains(valor)) {
    			return false;
    		}
    	}
        return true;
    }

}
