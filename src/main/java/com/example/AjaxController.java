package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import com.example.stack_queue.Queue;
import com.example.tree.Expression_Node;
import com.example.tree.Expression_Tree;


/**
 * Instituto Tecnologico de Costa Rica
 * Area de Ingeniera en Computadores
 *
 * Lenguaje: Java
 * Clase: AjaxController
 * @version 1.0
 * @author Gustavo Alvarado y Byron Mata
 *
 * Descripción: Esta clase contiene los metodos necesarios para crear la conexión de las clases java creadas para
 * el proceso de la expresión ingresada con el archivo jsp y viceversa, esto por medio de la extencion HttpServlet
 */
@WebServlet(name = "AjaxController", value = "/AjaxController")
public class AjaxController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");

        //expresion ingresada por el usuario.
        String name = request.getParameter("name");

        //creacion del arbol y evaluacion del mismo.
        Expression_Tree ExprTr = new Expression_Tree();
        Queue ExprQueue = ExprTr.organizeQS(name);
        Expression_Node Tree = ExprTr.createTree(ExprQueue);
        int rslt = ExprTr.evaluate(Tree);//resultado del arbol evaluado.

        PrintWriter out = response.getWriter(); //canal de envio de datos de vuelta a la pagina web
        out.println("El resultado de su expresion es: "+rslt); //envio del resultado de la expresion evaluada a la pagina web
        System.out.println(rslt);
    }
}
