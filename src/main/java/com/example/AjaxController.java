package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import com.example.stack_queue.Queue;
import com.example.tree.Expression_Node;
import com.example.tree.Expression_Tree;

@WebServlet(name = "AjaxController", value = "/AjaxController")
public class AjaxController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        String name = request.getParameter("name");

        Expression_Tree ExprTr = new Expression_Tree();
        Queue ExprQueue = ExprTr.organizeQS(name);
        Expression_Node Tree = ExprTr.createTree(ExprQueue);
        int rslt = ExprTr.evaluate(Tree);

        PrintWriter out = response.getWriter();
        out.println("El resultado de su expresion es: "+rslt);
        System.out.println(rslt);

    }
}
