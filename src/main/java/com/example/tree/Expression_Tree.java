package com.example.tree;
import com.example.stack_queue.Queue;
import com.example.stack_queue.Stack;

/**
 * Instituto Tecnologico de Costa Rica
 * Area de Ingeniera en Computadores
 *
 * Lenguaje: Java
 * Clase: Expression_Tree
 * @version 1.0
 * @authors Gustavo Alvarado y Byron Mata
 *
 * Descripción: Esta clase contiene los metodos necesarios para crear el arbol de expresion binario, desde poner la exprecion en notacion posfija hasta crear el arbol como tal.
 */
public class Expression_Tree {
    private Expression_Node<Object> root;

    /**
     * Constructor que crea el arbol vacio
     */
    public Expression_Tree(){
        this.root = null;
    }

    /**
     * Metodo para detectar si un nodo contiene un operador u operando
     * @param node parametro que contiene el identificador del nodo (operador u operando).
     * @return true si el nodo contiene un operador, false si el nodo contiene un operando.
     */
    public boolean Operator(String node){
        if (node.equals("+") || node.equals("-") || node.equals("/") || node.equals("*") || node.equals("%")){
            return true;

        }else{
            return false;
        }
    }

    /**
     * Metodo para ingresar en la cola la expresion matematica en forma posfija.
     * @param Expre parametro que contiene la expresion matematica.
     */
    public void organizeQS(String Expre){
        int Elem = Expre.length();
        Queue cola = new Queue(); //cola que almacela la expresion posfija
        Stack pila = new Stack(); //pila que almacena temporalmente los operadores y parentesis.

        for(int i = 0; i<=Elem-1; i++){
            char index = Expre.charAt(i);

            if( index == '(' || index == '+' || index == '-' || index == '/' || index == '*' || index == '%') { //es operador
                pila.push(String.valueOf(index));//se agrega el operador a la pila

            }else if(index == ')'){ //es parentesis derecho.
                String item = pila.peek();

                while(!item.equals("(")){ //mientras no encuentre un parentesis izquierdo agrega los elementos de la pila a la cola.
                    cola.enqueue(item);
                    pila.pop();
                    item = pila.peek();
                }
                if(pila.peek().equals("(")){ //si es parentesis izquierdo lo elimina.
                    pila.pop();
                }

            }else{ //operandos
                cola.enqueue(String.valueOf(index));
            }
        }

        if (!pila.peek().equals("empty") && (!pila.peek().equals("("))) { //se asegura que todos los elementos de la pila se agreguen a la cola.
            cola.enqueue(pila.peek());
        }

        createTree(cola);
    }

    /**
     * Metodo que crea el arbol de expresion binario a partir de la cola.
     * @param cola parametro que contiene la expresion en notacion posfija ingresada en la cola.
     * @return retorna el arbol de expresion binario creado.
     */
    public Expression_Node createTree(Queue cola){
        java.util.Stack<Expression_Node> stack = new java.util.Stack<>(); //pila de
        Expression_Node parent;
        int count = cola.size();

        for(int i = 0; i < count; i ++){
            String value = cola.peek();
            if (!Operator(value)){
                parent = new Expression_Node<>(value);
                stack.push(parent);
                cola.dequeue();

            }else{
                parent = new Expression_Node<>(value);
                parent.setRight(stack.pop());
                parent.setLeft(stack.pop());

                stack.push(parent);

                System.out.println("Operador--------------------------------");
                System.out.println(parent.getNode());
                System.out.println(parent.getLeft().getNode());
                System.out.println(parent.getRight().getNode());
                System.out.println("------------------------------------------");
                cola.dequeue();
            }
        }
        parent = stack.peek();
        stack.pop();

        return parent;
    }
}