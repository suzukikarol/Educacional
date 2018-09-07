/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Quadrinho;

/**
 *
 * @author 11151100178
 */
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        Quadrinho quad = new Quadrinho();
        List<Quadrinho> lista = quad.listarTodos();
        request.setAttribute("listaQuadrinhos", lista);
        request.getRequestDispatcher("inicio.jsp").forward(request, response);
        
    }

}
