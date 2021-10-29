package com.example.stack_queue;

/**
 * Instituto Tecnologico de Costa Rica
 * Area de Ingeniera en Computadores
 *
 * Lenguaje: Java
 * Clase: QueueNode
 * @version 1.0
 * @author Gustavo Alvarado y Byron Mata
 *
 * Descripción: Esta clase contiene los metodos getter y setter que son utilizados en para los nodos y a su vez la que
 * crea los nodos como tal
 */
public class QueueNode {
    private String data;
    public QueueNode next;

    /**
     * Constructor de los nodos y del identificador
     *
     * @param Data identificador que se le asignara a cada uno de los nodos que crean
     */
    public QueueNode(String Data) {
        this.next = null;
        this.data = Data;
    }

    /**
     * Metodo para obtener el identificador del nodo indicado
     *
     * @return identificador contenido en el nodo
     */
    public String getData() {
        return data;
    }
}
