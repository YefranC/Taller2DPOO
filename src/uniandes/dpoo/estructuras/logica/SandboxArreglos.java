package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
    	int[] arregloEnterosCopia = new int [this.arregloEnteros.length];
    	System.arraycopy(this.arregloEnteros,0 , arregloEnterosCopia, 0, this.arregloEnteros.length);
        return arregloEnterosCopia;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
    	String[] arregloCadenasCopia = new String [arregloCadenas.length];
    	System.arraycopy(arregloCadenas,0 , arregloCadenasCopia, 0, arregloCadenas.length);
        return arregloCadenasCopia;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
        return this.arregloEnteros.length;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        return this.arregloCadenas.length;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	int[] arregloEnterosNuevo = new int[this.arregloEnteros.length+1];
    	
    	System.arraycopy(this.arregloEnteros, 0, arregloEnterosNuevo, 0, this.arregloEnteros.length);
    	
    	arregloEnterosNuevo[arregloEnterosNuevo.length-1]= entero;
    	
    	this.arregloEnteros=arregloEnterosNuevo;

    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	String[] arregloCadenasNuevo = new String[this.arregloCadenas.length+1];
    	
    	System.arraycopy(arregloCadenas, 0, arregloCadenasNuevo, 0, getCantidadCadenas());
    	
    	arregloCadenasNuevo[arregloCadenasNuevo.length-1]= cadena;
    	
    	this.arregloCadenas=arregloCadenasNuevo;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	int conteo=0;
    	for (int entero: this.arregloEnteros) {
    		if (entero==valor) {
    			conteo++;
    		}
    	}
    	
    	int[] arregloControl = new int[this.arregloEnteros.length-conteo];
    	
    	int index = 0;
    	
    	for(int entero : this.arregloEnteros) {
    		
    		if (entero!= valor) {
    			arregloControl[index]=entero;
    			index++;
    		}
    	}
    	this.arregloEnteros=arregloControl;
    	
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	int conteo=0;
    	String cadenaMayuscula= cadena.toUpperCase();
    	String cadenaMinuscula = cadena.toLowerCase();
    	for (String x: this.arregloCadenas) {
    		if (x.equals(cadenaMayuscula) || x.equals(cadenaMinuscula)) {
    			conteo++;
    		}
    	}
    	
    	String[] arregloControl = new String[this.arregloCadenas.length-conteo];
    	
    	int index = 0;
    	
    	for(String x : this.arregloCadenas) {
    		
    		if (!x.equals(cadenaMayuscula) && !x.equals(cadenaMinuscula)) {
    			arregloControl[index]=x;
    			index++;
    		}
    	}
    	this.arregloCadenas=arregloControl;
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	int [] control = new int[getCantidadEnteros()+1];
    	if (posicion<0) {
    		control[0]= entero;
    		System.arraycopy(this.arregloEnteros, 0, control, 1, this.arregloEnteros.length);
    		this.arregloEnteros=control;
    	}
    	else if(posicion>=this.arregloEnteros.length) {
    		agregarEntero(entero);
    	}
    	else {
    		control[posicion]=entero;
    		int i = 0;
    		for(int entero1: this.arregloEnteros) {
    			if(i==posicion) {
    				i++;
    				control[i]=entero1;
    			}
    			else {
    				control[i]=entero1;
    			}
    			i++;
    		}
    		this.arregloEnteros=control;
    	}
    	
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	 if(posicion>=0 && posicion<this.arregloEnteros.length) {
    		 
    		 int[] control = new int[this.arregloEnteros.length-1];
    		 
    		 int index = 0;
    		 for(int entero:this.arregloEnteros) {
    			 if (index ==posicion) {
    				 continue;
    				 
    				 
    			 }
    			 else {
    				 control[index]= entero;
    				 index++;
    			 }
    		 }
    		 
    	 }
    	
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	int[] control = new int[valores.length];
    	int index =0;
    	for(double valor: valores) {
    		
    		control[index]= (int) valor;
    		index++;
    	}
    	this.arregloEnteros= control;
    	
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	String[] control = new String[objetos.length];
    	
    	for(int i = 0; i<objetos.length;i++) {
    		control[i] = objetos[i].toString();
    	}
    	this.arregloCadenas = control;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	int[] control = new int[this.arregloEnteros.length];
    	int index = 0;
    	for(int entero: this.arregloEnteros) {
    		
    		if (entero>=0) {
    			control[index] = entero;
    			}
    		else {
    			control[index] = entero*-1;
    		}
			index++;
    	}
    	this.arregloEnteros=control;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	//Uso de selection Sort*
    	
    	for (int i=0; i<(this.arregloEnteros.length-1);i++) {
    		int menor = i;
    		for( int j =i+1; j<this.arregloEnteros.length;j++) {
    			if (this.arregloEnteros[j]<this.arregloEnteros[menor]) {
        			menor = j;	
    				}
    			}
    		if (menor!=i) {
    			int aux = this.arregloEnteros[i];
    			this.arregloEnteros[i]=this.arregloEnteros[menor];
    			this.arregloEnteros[menor]=aux;
    		}
    	}
    	
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	// Uso de algoritmo selection sort
    	for(int i=0;i<(this.arregloCadenas.length-1);i++) {
    		
    		int menor = i;
    		
    		for(int j=i+1;j<this.arregloCadenas.length;j++) {
    			
    			if(this.arregloCadenas[j].compareTo(this.arregloCadenas[menor])<0) {
    				menor = j;
    			}
    		}
    		
    		
    		if(menor!=i) {
    			String aux = this.arregloCadenas[i];
    			this.arregloCadenas[i]=this.arregloCadenas[menor];
    			this.arregloCadenas[menor]=aux;
    		}
    		
    	}
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int[] control = getCopiaEnteros();
    	eliminarEntero(valor);
    	int cantidad = (control.length-this.arregloEnteros.length);
    	this.arregloEnteros=control;
    	return cantidad;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	String[] control = getCopiaCadenas();
    	eliminarCadena(cadena);
    	int cantidad = (control.length-this.arregloCadenas.length);
    	this.arregloCadenas = control;
        return cantidad;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero(int valor) {
        
    	int [] control = getCopiaEnteros();
    	
    	int a = contarApariciones(valor);
        
        int[] respuesta = new int[a];
        
        int x = 0;
        this.arregloEnteros=control;
        for(int i =0;i<this.arregloEnteros.length;i++) {
            if (arregloEnteros[i] == valor) {
                respuesta[x] = i; 
                x++;
            }  
        }
        return respuesta;
    }


    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
    	int[] respuesta = new int[]{};
    	if(this.arregloEnteros.length!=0) {
    		int[]res =new int[2];
    		int[] control = getCopiaEnteros();
    		organizarEnteros();
    		res[0]=this.arregloEnteros[0];
    		res[1]=this.arregloEnteros[this.arregloEnteros.length-1];
    		this.arregloEnteros=control;
    		respuesta= res;
    		}
		return respuesta;
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	HashMap<Integer,Integer> respuesta = new HashMap<Integer,Integer>();
    	for (int entero: this.arregloEnteros) {
    		int apariciones = contarApariciones(entero);
    		respuesta.put(entero, apariciones);
    	}
    	
        return respuesta;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteros diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	int cantidad = 0;
    	int[] control = getCopiaEnteros();
    	while(this.arregloEnteros.length!=0) {
    		int x = contarApariciones(this.arregloEnteros[0]);
    		if(x>1) {
    			cantidad++;
    		}
    		eliminarEntero(this.arregloEnteros[0]);
    	}
    	this.arregloEnteros=control;
        return cantidad;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	if(this.arregloEnteros.length != otroArreglo.length) {
    		return false;
    	}
    	
    	
    	for(int i = 0; i< this.arregloEnteros.length;i++) {
    		if (this.arregloEnteros[i] != otroArreglo[i]) {
                return false;
    		}
    	}
    	
		return true;
    	
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
        boolean respuesta = false;
        if(this.arregloEnteros.length==otroArreglo.length) {
        	int[] control = getCopiaEnteros();
        	organizarEnteros();
        	int[] auxiliar = getCopiaEnteros();
        	this.arregloEnteros= otroArreglo;
        	organizarEnteros();
        	respuesta = compararArregloEnteros(auxiliar);
        	this.arregloEnteros=control;
        	return respuesta;
        	}
        	
        return respuesta;
        }
        
       

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	int[] arregloRandom = new int[cantidad];
    	
    	for(int i = 0; i<cantidad;i++) {
    		
    		arregloRandom[i] = (int) (Math.random()*(maximo-minimo+1))+minimo;
    	}
    	this.arregloEnteros= arregloRandom;
    }

}
