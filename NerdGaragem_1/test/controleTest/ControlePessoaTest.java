/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleTest;

import controle.ControlePessoa;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author 11151100178
 */
public class ControlePessoaTest {
 
    HttpServletRequest request;
    HttpServletResponse response;
    
    @Before
    public void inicializa(){
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
    }
    
    @Test
    public void cadastraCliente() throws ServletException, IOException{
        
        //fazer entrar na acao
        
        when(request.getParameter("txtNome")).thenReturn("beatriz");
        when(request.getParameter("txtRG")).thenReturn("11.111.111-1");
        when(request.getParameter("txtCPF")).thenReturn("222.222.222-22");
        when(request.getParameter("txtDtNasc")).thenReturn("2007-08-21");
        when(request.getParameter("txtTelefone")).thenReturn("11 1111-1111");
        when(request.getParameter("txtEmail")).thenReturn("bia@bia.com");
        
        ControlePessoa controle = new ControlePessoa();
        controle.processRequest(request,response);
        
        verify(response).sendRedirect("cadCli.html");
        verify(request).getParameter("txtNome");
        verify(request).getParameter("txtRG");
        verify(request).getParameter("txtCPF");
        verify(request).getParameter("txtDtNasc");
        verify(request).getParameter("txtTelefone");
        verify(request).getParameter("txtEmail");
        
        
        
    }
}
