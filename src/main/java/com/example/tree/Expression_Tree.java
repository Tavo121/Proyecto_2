package com.example.tree;
import com.example.stack_queue.Queue;
import com.example.stack_queue.Stack;

import javax.servlet.http.HttpServlet;

public class Expression_Tree{

    private Expression_Node<Object> root;

    public Expression_Tree(){
        this.root = null;
    }

    public boolean Empty(){
        return this.root == null;
    }

    public void organizeQS(String Expre) {
        int Elem = Expre.length();
        Queue cola = new Queue();
        Stack pila = new Stack();

        for(int i = 0; i<=Elem-1; i++){
            char index = Expre.charAt(i);

            if( index == '(' || index == '+' || index == '-' || index == '/' || index == '*') {
                pila.push(String.valueOf(index));

            }else if(index == ')'){
                String item = pila.peek();
                while(!item.equals("(")){
                    cola.enqueue(item);
                    pila.pop();
                    item = pila.peek();
                }
                if(pila.peek().equals("(")){
                    pila.pop();
                }

            }else{
                cola.enqueue(String.valueOf(index));
            }
        }

        if (!pila.peek().equals("empty") && (!pila.peek().equals("("))) {
            cola.enqueue(pila.peek());
        }

        while(!cola.isEmpty()){
            System.out.print(cola.dequeue());
            System.out.print("");
        }
    }

    public void createTree(Queue cola){

    }

    public static void main(String[] args) {
        Expression_Tree tree = new Expression_Tree();
        //tree.organizeQS("(a+(b*c))+(((d*e)+f)*g)");
        //tree.organizeQS("(1+2-(4*9)+5)");
        //a b c * + d e * f + g * +
    }
}