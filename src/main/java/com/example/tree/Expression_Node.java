package com.example.tree;

/**
 * Instituto Tecnologico de Costa Rica
 * Area de Ingeniera en Computadores
 *
 * Lenguaje: Java
 * Clase: Expression_Node
 * @version 1.0
 * @author Gustavo Alvarado y Byron Mata
 *
 * Descripción: Esta clase contiene los metodos getter y setter que son utilizados en para los nodos, a su vez crea los
 * nodos como tal
 */
public class Expression_Node<T> {
    private T node;
    private Expression_Node<T> right, left;

    /**
     * Constructor de los nodos
     * @param node identificador
     */
    public Expression_Node(T node){
        this.right = null;
        this.left = null;
        this.node = node;
    }

    /**
     * Metodo para obtener el identificador de cada nodo.
     * @return del identificador del nodo.
     */
    public T getNode() {
        return node;
    }

    /**
     * Metodo para obtener el nodo ubicado a la derecha
     * @return del nodo ubicado a la derecha
     */
    public Expression_Node getRight() {
        return right;
    }

    /**
     * Metodo para asignar el identificador a un nodo  
     * @param right identificador de derecha para asignar a un nodo
     */
    public void setRight(Expression_Node right) {
        this.right = right;
    }

    /**
     * Metodo para obtener el nodo ubicado a la izquierda
     * @return del nodo ubicado a la izquierdo
     */
    public Expression_Node getLeft() {
        return left;
    }

    /**
     * Metodo para asignar el identificador a un nodo
     * @param left identificador de izquierda para asignar a un nodo
     */
    public void setLeft(Expression_Node left) {
        this.left = left;
    }
}
