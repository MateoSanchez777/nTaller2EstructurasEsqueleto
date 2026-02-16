package uniandes.dpoo.estructuras.logica;

import java.util.Collection;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;


/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre conjuntos implementados usando un árbol (TreeSet).
 *
 * Todos los métodos deben operar sobre el atributo arbolCadenas que se declara como un NavigableSet.
 * 
 * El objetivo de usar el tipo NavigableSet es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (TreeSet).
 * 
 * A diferencia de un Set, en un NavigableSet existe una noción de orden que en este caso corresponde al órden lexicográfico.
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxConjuntos
{
    /**
     * Un conjunto (set) de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Por defecto, los elementos del conjunto están ordenados lexicográficamente.
     */
    private NavigableSet<String> arbolCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxConjuntos( )
    {
        arbolCadenas = new TreeSet<String>( );
    }

    /**
     * Retorna una lista con las cadenas del conjunto ordenadas lexicográficamente
     * @return Una lista con las cadenas ordenadas
     */
    public List<String> getCadenasComoLista( )
    {
        return new ArrayList<>(arbolCadenas);
    }


    public List<String> getCadenasComoListaInvertida( )
    {
        return new ArrayList<>(arbolCadenas.descendingSet());
    }


    public String getPrimera( )
    {
        if (arbolCadenas.isEmpty())
            return null;

        return arbolCadenas.first();
    }

    public String getUltima( )
    {
        if (arbolCadenas.isEmpty())
            return null;

        return arbolCadenas.last();
    }

    public Collection<String> getSiguientes( String cadena )
    {
        if (cadena == null)
            return new ArrayList<>();

        return arbolCadenas.tailSet(cadena, true);

    }


    public int getCantidadCadenas( )
    {
        return arbolCadenas.size();
    }

    public void agregarCadena( String cadena )
    {
        if (cadena != null)
            arbolCadenas.add(cadena);
    }


    public void eliminarCadena( String cadena )
    {
        arbolCadenas.remove(cadena);
    }

    public void eliminarCadenaSinMayusculasOMinusculas( String cadena )
    {
        String encontrada = null;

        for (String s : arbolCadenas)
        {
        	if (cadena == null)
        	    return;

            {
                encontrada = s;
                break;
            }
        }

        if (encontrada != null)
        {
            arbolCadenas.remove(encontrada);
        }
    }

    public void eliminarPrimera( )
    {
        if (!arbolCadenas.isEmpty())
        {
            arbolCadenas.pollFirst();
        }
    }

    public void reiniciarConjuntoCadenas( List<Object> objetos )
    {
        arbolCadenas.clear();

        if (objetos == null)
            return;

        for (Object obj : objetos)
        {
            if (obj != null)
                arbolCadenas.add(obj.toString());
        }
    }


    public void volverMayusculas( )
    {
        TreeSet<String> nuevo = new TreeSet<>();

        for (String s : arbolCadenas)
        {
            if (s != null)
                nuevo.add(s.toUpperCase());
        }

        arbolCadenas = nuevo;
    }


    public TreeSet<String> invertirCadenas( )
    {
        TreeSet<String> invertido = new TreeSet<>(Collections.reverseOrder());
        invertido.addAll(arbolCadenas);
        return invertido;
    }


    public boolean compararElementos( String[] otroArreglo )
    {
        if (otroArreglo == null)
            return false;

        for (String s : otroArreglo)
        {
            if (!arbolCadenas.contains(s))
                return false;
        }

        return true;
    }
    
}
