package com.example.stack_queue;

/**
 * Instituto Tecnologico de Costa Rica
 * Area de Ingeniera en Computadores
 *
 * Lenguaje: Java
 * Clase: Queue
 * @version 1.0
 * @author Gustavo Alvarado y Byron Mata
 *
 * Descripción: Esta clase contiene algunos métodos que son utilizados en la cola
 */
public class Queue {
    private QueueNode head = null;
    private QueueNode tail = null;

    /**
     * Metodo para verificar si el nodo se encuentra vacío
     * @return Null
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Metodo para agregar o incorporar un nodo en la cola con su respectivo identificador
     * @param item Identificador el nodo
     */
    public void enqueue(String item) {
        QueueNode newNode = new QueueNode(item);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    /**
     * Metodo que extrae el último nodo que ingreso en la cola
     * @return del dato contenido en el último nodo ingresado, es decir, la cabeza
     */
    public String dequeue() {
        String item = head.getData();
        if (tail == head) {
            tail = null;
        }
        head = head.next;
        return item;
    }

    /**
     * Metodo que extrae el dato dado a "x" o "y" nodo de la cola
     * @return del dato o identificador contenido en el nodo
     */
    public String peek() {
        if (head == null) {
            return null;
        }
        return head.getData();
    }

    /**
     * Metodo que permite obtener el tamaño de la cola
     * @return del tamaño de la cola
     */
    public int size() {
        int cnt = 0;
        for (QueueNode node = head; node != null; node = node.next) {
            cnt++;
        }
        return cnt;
    }

}

