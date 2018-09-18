/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleTest;
import controle.ControleUsuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

/**
 *
 * @author 11151100178
 */
public class ControleUsuarioTest {
    RequestDispatcher rd;
    HttpServletRequest request;
    HttpServletResponse response;
    
    @Before
    public void inicializa(){
        rd = mock(RequestDispatcher.class);
       request = mock(HttpServletRequest.class);
       response = mock(HttpServletResponse.class);
    }
    
     @Test
    public void loginESenhaValidos() throws ServletException, IOException{
        
        //cria obj falsos mocks
       // HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
       // HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        when(request.getParameter("acao")).thenReturn("Cadastrar");
        //simula os comportamentos
        when(request.getParameter("txtLogin")).thenReturn("bia23");
        when(request.getParameter("txtSenha")).thenReturn("123");
        when(request.getParameter("optPerfil")).thenReturn("administrador");
        //when(rd.forward(request, response));
        when(request.getRequestDispatcher("./admin/cad_user.jsp")).thenReturn(rd);
        
        //when(rd.forward(request, response))
        
        //executa o método        
        ControleUsuario servlet = new ControleUsuario(); 
        servlet.processRequest(request, response);
        
        //validação de comportamento
        verify(request).getRequestDispatcher("./admin/cad_user.jsp");
        verify(request).getParameter("txtLogin");
        verify(request).getParameter("txtSenha");
    } 
}

