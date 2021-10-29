package com.example.stack_queue;

/**
 * Instituto Tecnologico de Costa Rica
 * Area de Ingeniera en Computadores
 *
 * Lenguaje: Java
 * Clase: StackNode
 * @version 1.0
 * @author Gustavo Alvarado y Byron Mata
 *
 * Descripción: Esta clase contiene los metodos getter y setter que son utilizados en para los nodos, a su vez crea los
 * nodos como tal
 */
public class StackNode {
    private String data;
    public StackNode next;

    /**
     * Constructor de los nodos y del identificador
     * @param data identificador que se le asignara a cada uno de los nodos que se creen
     */
    public StackNode(String data) {
        this.next = null;
        this.data = data;
    }

    /**
     * Metodo para obtener el identificador del nodo indicado
     * @return del identificador que el nodo contiene
     */
    public String getData() { return this.data; }
}