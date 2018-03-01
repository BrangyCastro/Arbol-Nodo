/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolab;
import java.util.*;
/**
 *
 * @author ROBERT
 */
public class NodoCola {
    NodoArbol elemento;
    NodoCola siguiente;
    
    public NodoCola(NodoArbol elemento){
        this.elemento=elemento; //Contexto
        siguiente=null;
    }
    
    public NodoCola(){
        siguiente=null;
    }
    
     public static NodoCola encolar(NodoArbol arbol, NodoCola cola){
      
        NodoCola nodoNuevo = new NodoCola(arbol);
        if (cola==null)//CASO 1: Cuando la lista esta vacia
        {
            cola=nodoNuevo;
        }
        else //Tiene que funcionar insertando en la cima
        {
            NodoCola temporal=cola;
            NodoCola anterior=cola;
            while(temporal!=null){
                anterior=temporal;
                temporal=temporal.siguiente;
            }
            anterior.siguiente=nodoNuevo;
        }
        
        return cola;
    }
     
     public static void imprimir(NodoCola cola){
        NodoCola temporal=cola;
        if(cola==null)
            System.out.println("Lista vacia... imposible imprimir");
        else
        {
            while(temporal!=null)
            {
                System.out.println("Llave: {"+temporal.elemento.llave+"} = "+temporal.elemento.valor);
                temporal=temporal.siguiente;
            }
        }
    }
     
      public static boolean estaVacia(NodoCola cola){
        boolean bandera=true;
        if(cola==null)
            return bandera;
        return false;
    }
      
       
       
       public static NodoCola desencolar(NodoCola cola){
           if(cola==null)
            return null;
           
           //System.out.println("Desencolado \n Llave: {"+cola.elemento.llave+"} = "+cola.elemento.valor);
           cola=cola.siguiente;
           return cola;
       }
       
       /*public static NodoArbol desencolar(NodoCola cola){
           NodoCola temporal=cola;
           if(cola==null)
            {
                //System.out.println("Imposible desencolar.... cola vacia");
                return null;
            }
           
           //System.out.println("Desencolado \n Llave: {"+cola.elemento.llave+"} = "+cola.elemento.valor);
           temporal=cola;
           cola=cola.siguiente;
           return (NodoArbol)temporal.elemento;
       }*/
}
