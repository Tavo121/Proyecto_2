package com.example.stack_queue;

/**
 * Instituto Tecnologico de Costa Rica
 * Area de Ingeniera en Computadores
 *
 * Lenguaje: Java
 * Clase: Stack
 * @version 1.0
 * @author Gustavo Alvarado y Byron Mata
 *
 * Descripción: Esta clase contiene algunos métodos que son utilizados en la pila
 */
public class Stack {
    private StackNode head;

    /**
     * Constructor de la pila
     */
    public Stack() {
        this.head = null;
    }

    /**
     * Metodo que se encarga de insertar los nodos con sus respectivos identificadores en el top de la pila
     * @param data indicador del nodo
     */
    public void push(String data) {
        StackNode newSNode = new StackNode(data);
        newSNode.next = this.head;
        this.head = newSNode;
    }

    /**
     * Metodo que se encarga de extraer los nodos que se ubiquen el top de la pila
     */
    public void pop() {
        if (this.head != null) {
            this.head = this.head.next;
        }
    }

    /**
     * Metodo que extrae el dato dado a "x" o "y" nodo de la pila
     * @return del identificador del nodo solicitado
     */
    public String peek() {
        if(head == null){
            return "empty";
        }
        return head.getData();
    }
}