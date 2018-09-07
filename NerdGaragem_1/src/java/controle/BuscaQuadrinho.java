/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Quadrinho;

/**
 *
 * @author 11151100178
 */
public class BuscaQuadrinho extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String termoBusca = request.getParameter("q");
        
        Quadrinho quad = new Quadrinho();
        quad = quad.pesquisarQuadrinhos(termoBusca);
        
        if(quad!=null){
            request.setAttribute("quadrinho", quad);
            request.getRequestDispatcher("produto.jsp").forward(request, response);
        }else{
            response.sendRedirect("erro.jsp");
        }
    }

}
