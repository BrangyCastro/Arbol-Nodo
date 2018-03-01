/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolab;

/**
 *
 * @author ROBERT
 */
public class NodoArbol {
    int llave;
    String valor;
    NodoArbol hijoIzquierdo;
    NodoArbol hijoDerecho;
    
    public NodoArbol(int llave, String valor){
        this.llave=llave;
        this.valor=valor;
        hijoIzquierdo=null;
        hijoDerecho=null;
    }
    
    public static NodoArbol insertarArbol(NodoArbol nodoNuevo, NodoArbol arbol){
        /*Este código fue modificado por Robert Moreira, la versión original del mismo esta
        en https://serprogramador.es/programar-arboles-binarios-parte-1-introduccionclasesagregar-nodo/
        */
        
       //Partiendo de la raíz preguntamos: arbol == null ( o no existe )
        if ( arbol == null ) 
          // En caso afirmativo X pasa a ocupar el lugar del nodo y ya hemos ingresado nuestro primer dato. 
          arbol=nodoNuevo;
        else {
            //preguntamos si el nodo nuevo, tiene una llave menor que la de la raiz
            if ( nodoNuevo.llave <= arbol.llave) 
                arbol.hijoIzquierdo=NodoArbol.insertarArbol(nodoNuevo, arbol.hijoIzquierdo);
            else 
                arbol.hijoDerecho=NodoArbol.insertarArbol(nodoNuevo, arbol.hijoDerecho);
        }
        return arbol;
    }
    
    /*public static void amplitud(NodoArbol a) //SE RECIBE LA RAIZ DEL ARBOL
    {
        NodoCola cola, colaAux; //DEFINICIÓN DE 2 VARIABLES DE TIPO COLA
        NodoArbol aux; //DEFINICIÓN AUX DE TIPO NODOARBOL

        if (a != null) //SI EL ÁRBOL CONTIENE NODOS...
        {
            cola=new NodoCola(); //SE INSTANCIA EL OBJETO COLA
            colaAux=null; //SE INSTANCIA EL OBJETO COLAAUX
            cola=NodoCola.encolar(a,cola); //SE INSERTA EL NODOARBOL "A" (RAIZ) COMO PRIMER NODO EN LA COLA
            while (!NodoCola.estaVacia(cola)) //MIENTRAS HAYAN ELEMENTOS EN LA COLA...
            {
                /*EL ELEMENTO EXTRAIDO DE LA COLA PRINCIPAL ES ASIGNADO 
                //A AUX Y A SU VEZ INSERTADO EN LA COLA AUXILIAR
            
                NodoCola.encolar(aux=NodoCola.desencolar(cola), colaAux);
            
                if (aux.hijoIzquierdo != null) //SI EL HIJO IZQUIERDO DEL NODO ACTUAL EXISTE
                    cola=NodoCola.encolar(aux.hijoIzquierdo, cola); //SE INSERTA ESE HIJO COMO ELEMENTO SIGUIENTE EN LA COLA
                    
                
                if (aux.hijoDerecho!= null) //SI EL HIJO DERECHO DEL NODO ACTUAL EXISTE
                    cola=NodoCola.encolar(aux.hijoDerecho, cola); //SE INSERTA ESE HIJO COMO ELEMENTO SIGUIENTE EN LA COLA
                
            }
            NodoCola.imprimir(colaAux); //POR ÚLTIMO SE IMPRIME LA COLA AUXILIAR
            
        }
    }
    */
    //Recorrido en anchura del arbol
 public static void Anchura2 (NodoArbol Nodo){
     /*
     http://jitorres.blogspot.com/2011/11/codigo-de-arbol-en-java.html
     */
     
  NodoCola cola= null;
  NodoArbol T = null;
  System.out.print ("El recorrido en Anchura es: ");
  if(Nodo != null){
   cola=NodoCola.encolar (Nodo, cola);
   while(!(NodoCola.estaVacia(cola))){
    T = new NodoArbol(cola.elemento.llave,cola.elemento.valor);
    cola=NodoCola.desencolar(cola);
    System.out.print(T.valor + " ");
    if (T.hijoIzquierdo != null)
     cola=NodoCola.encolar (T.hijoIzquierdo,cola);
    if (T.hijoDerecho != null)
     cola=NodoCola.encolar (T.hijoDerecho,cola);
   }
  }
  System.out.println();
 }

    
    public static void Inorden( NodoArbol nodo)
    {
        if(nodo!=null)
        {
            Inorden(nodo.hijoIzquierdo);
            System.out.print("\nLlave: {"+nodo.llave+"} = "+nodo.valor);
            Inorden(nodo.hijoDerecho);
        } 
    }
    
    public static void Preorden( NodoArbol nodo)
    {
        if(nodo!=null)
        {
            System.out.print("\nLlave: {"+nodo.llave+"} = "+nodo.valor);
            Preorden(nodo.hijoIzquierdo);
            Preorden(nodo.hijoDerecho);
        }
         
        
    }
    
    public static void Postorden( NodoArbol nodo)
    {
        if(nodo!=null)
        {
          Postorden(nodo.hijoIzquierdo);
          Postorden(nodo.hijoDerecho);
          System.out.print("\nLlave: {"+nodo.llave+"} = "+nodo.valor);  
        }
        
    }
}
