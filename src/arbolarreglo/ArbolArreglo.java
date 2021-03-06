/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolarreglo;

import java.util.Scanner;
import java.util.*;

/**
 *
 * @author Luis
 */
public class ArbolArreglo {

    /**
     * @param args the command line arguments
     */
    public static arbolab.NodoArbol ingresoNodo() {//Para ingresar el nodo por teclado

        int llave = (int) (Math.random() * 100) + 1;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese Elemento a guardar en el árbol: ");
        String valor = teclado.nextLine();
        arbolab.NodoArbol nodoNuevo = new arbolab.NodoArbol(llave, valor);
        return nodoNuevo;

    }

    public static arbolab.NodoArbol ingresoNodo(String valor1) {//Para ingresar el nodo por teclado

        int llave = (int) (Math.random() * 100) + 1;
        String valor = valor1;
        arbolab.NodoArbol nodoNuevo = new arbolab.NodoArbol(llave, valor);
        return nodoNuevo;

    }

    public static void main(String[] args) {
        // TODO code application logic here

        String cadena = "Luis Antonio Auz Garcia";
        String[] arreglo = cadena.split(" ");
        Stack pila = new Stack();
        Queue cola = new LinkedList();
        LinkedList lista = new LinkedList();

        arbolab.NodoArbol arbol = null;
        arbolab.NodoArbol nodoNuevo;
        Scanner teclado = new Scanner(System.in);
        int opcion;

        // Pila. Clase preconstruida(Stack).
        //*****************************************
        /*for (int i = 0; i < arreglo.length; i++) {
            pila.push(arreglo[i]);
        }
        while (!pila.empty()) {
            nodoNuevo = ingresoNodo(pila.pop().toString());
            arbol = arbolab.NodoArbol.insertarArbol(nodoNuevo, arbol);
        }*/
        //*****************************************
        // Cola. Clase preconstruida(Queue).
        /*for(int i = 0; i < arreglo.length; i++){
            cola.add(arreglo[i]);
        }
        
        while(!cola.isEmpty()){
           nodoNuevo = ingresoNodo(cola.poll().toString());
           arbol = arbolab.NodoArbol.insertarArbol(nodoNuevo, arbol);
        }*/
        //********************************************
        //Lista. Clase preconstruida(LinkedList).
        for (int i = 0; i < arreglo.length; i++) {
            lista.add(arreglo[i]);
        }

        List lista2 = new ArrayList(lista);
        Iterator it = lista2.iterator();
        while (it.hasNext()) {
            nodoNuevo = ingresoNodo(it.next().toString());
            arbol = arbolab.NodoArbol.insertarArbol(nodoNuevo, arbol);
        }
        //************************************************
        do {
            System.out.println("\nIngrese opción: "
                    + "\n 1. Insertar nodo en árbol"
                    + " 2. Imprimir árbol en amplitud"
                    + "\n 3. Impresión Inorden "
                    + " 4. Impresión Preorden"
                    + "\n 5. Impresión Postorden"
                    + " 6. Salir");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    nodoNuevo = ingresoNodo();
                    arbol = arbolab.NodoArbol.insertarArbol(nodoNuevo, arbol);
                    System.out.println("Ingreso satisfactorio...");
                    break;
                case 2:
                    System.out.println("Imprimiendo árbol en amplitud \n");
                    arbolab.NodoArbol.Anchura2(arbol);
                    break;
                case 3:
                    System.out.println("Imprimiendo árbol en Inorden \n");
                    arbolab.NodoArbol.Inorden(arbol);
                    break;
                case 4:
                    System.out.println("Imprimiendo árbol en PreOrden \n");
                    arbolab.NodoArbol.Preorden(arbol);
                    break;
                case 5:
                    System.out.println("Imprimiendo árbol en PostOrden \n");
                    arbolab.NodoArbol.Postorden(arbol);
                    break;
            }

        } while (opcion != 6);
    }

}
