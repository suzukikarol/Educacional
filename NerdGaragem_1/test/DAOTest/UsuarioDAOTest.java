/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOTest;

import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import modelo.PerfilDeAcesso;
import modelo.Usuario;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.Conexao;
import static org.junit.Assert.*;

/**
 *
 * @author 11151100178
 */
public class UsuarioDAOTest {
    private Connection conexao;
    
    @Before
    public void inicializa() throws SQLException{
        conexao = Conexao.getConexao();
        conexao.setAutoCommit(false);
    }
    
    @After
    public void finalizar() throws SQLException{
        conexao.rollback();
    }
    
    @Test
    public void deveCadastrarUmCliente(){
        
        Usuario usuario = new Usuario();
        usuario.setLogin("kakli");
        usuario.setSenha("1212");
        usuario.setPerfil(PerfilDeAcesso.COMUM);
        usuario.setAtivo(true);
        
        UsuarioDAO dao = new UsuarioDAO(conexao);
        dao.cadastraNovoUsuario(usuario);
        
        Usuario usuarioCadastrado = dao.autenticaUsuario(usuario);
        
        assertEquals(usuario.getLogin(),usuarioCadastrado.getLogin());
        assertEquals(usuario.getSenha(),usuarioCadastrado.getSenha());
        assertEquals(usuario.getPerfil(),usuarioCadastrado.getPerfil());
        
    }
    
    //senha invalido
    //nao cadastrados
    
    @Test
    public void autenticandoUsuarioLoginSenhaValido (){
        
        UsuarioDAO dao = new UsuarioDAO();
        
        Usuario usuarioautenticado = new Usuario();
        usuarioautenticado.setLogin("kakli");
        usuarioautenticado.setSenha("1212");
        
        //String LoginEsperado = "kakli";
       // String SenhaEsperado = "1212";
       
     Usuario usuarioRetorno =  dao.autenticaUsuario(usuarioautenticado);

        assertEquals(usuarioautenticado.getLogin(), usuarioRetorno.getLogin());
        assertEquals(usuarioautenticado.getSenha(), usuarioRetorno.getSenha());
    }
    
    @Test
    public void usuarioNaoCadastrado (){
        
        UsuarioDAO dao = new UsuarioDAO();
        
        Usuario usuarioautenticado = new Usuario();
        usuarioautenticado.setLogin("lulu");
        usuarioautenticado.setSenha("12");
    
        
        assertNull(dao.autenticaUsuario(usuarioautenticado));
        
    }
    
    @Test
    public void usuarioLoginSenhaInvalido (){
        
        UsuarioDAO dao = new UsuarioDAO();
        
        Usuario usuarioinvalido = new Usuario();
        usuarioinvalido.setLogin("luis");
        usuarioinvalido.setSenha("9568");
        
        
      assertNull(dao.autenticaUsuario(usuarioinvalido));
        
    }
}
