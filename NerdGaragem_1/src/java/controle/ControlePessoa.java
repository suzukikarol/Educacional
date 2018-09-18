/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pessoa;
import DAO.PessoaDAO;
import java.util.ArrayList;

/**
 *
 * @author Alexandre
 */
public class ControlePessoa extends HttpServlet {

    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
            //parâmetro acao
            String acao = request.getParameter("acao");
            PessoaDAO pessoaDAO = new PessoaDAO();
            
            if(acao.equals("Cadastrar")){
                //recuperar os parâmetros
                String nome = request.getParameter("txtNome");
                String rg = request.getParameter("txtRG");
                String cpf = request.getParameter("txtCPF");
                String dtnasc = request.getParameter("txtDtNasc");
                String tel = request.getParameter("txtTelefone");
                String email = request.getParameter("txtEmail");
                
    
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(nome);
                pessoa.setRg(rg);
                pessoa.setCpf(cpf);
                pessoa.setDtnasc(dtnasc);
                pessoa.setTelefone(tel);
                pessoa.setEmail(email);
                pessoa.setStatus(true);
        
               
                pessoaDAO.cadastrar(pessoa);
                
                
                
                
                request.setAttribute("lista", pessoaDAO.listar());
                
               // response.getWriter().println("Cadastro realizado com sucesso!");
                RequestDispatcher rd = request.getRequestDispatcher("/Lista.jsp");
                //quem vai acionar toda essa ação é o forward
                rd.forward(request, response);   
                
            }else{
                if(acao.equals("Listar")){
                    PessoaDAO dao = new PessoaDAO();
                    List<Pessoa> listaPessoa = dao.listar();
                    
                    //atribuir a lista ao request
                    request.setAttribute("lista", listaPessoa);
                  
                    request.getRequestDispatcher("/Lista.jsp").forward(request, response);
                    
                }else if(acao.equals("Consultar")){
                    //pega os dados da interface
                    int id = Integer.parseInt(request.getParameter("id"));
                    //instancia novo pessoa e passa o id para a instância
                    Pessoa pessoa = new Pessoa();
                    pessoa.setId(id);
                    //instancia a nova DAO
                    PessoaDAO dao = new PessoaDAO();
                    //cria lista de pessoas com nome de concultarCliente
                    //que recebe o método consultar
                    Pessoa consultarPessoa = dao.Consultar(pessoa);
                    // a lista é settada com o nome de consulta
                    request.setAttribute("consulta", consultarPessoa);
                    //é referenciado os dados para a jsp alterarCliente
                    RequestDispatcher rd = request.getRequestDispatcher("/consultarCli.jsp");
                    //quem vai acionar toda essa ação é o forward
                    rd.forward(request, response);
                    
                }else if(acao.equals("Alterar")){
                    
                    /*int id = Integer.parseInt(request.getParameter("id"));
                    String nome = request.getParameter("txtNome");
                    String rg = request.getParameter("txtRG");
                    String cpf = request.getParameter("txtCPF");
                    String dtnasc = request.getParameter("txtDtNasc");
                    String telefone = request.getParameter("txtTelefone");
                    String email = request.getParameter("txtEmail");   */
                    
                    
                    Pessoa pessoa = new Pessoa();
                    pessoa.setId(0);
                    pessoa.setNome(acao);
                    pessoa.setRg(acao);
                    pessoa.setCpf(acao);
                    pessoa.setDtnasc(acao);
                    pessoa.setTelefone(acao);
                    pessoa.setEmail(acao);
                   // pessoa.setStatus(true);

  
                    PessoaDAO dao = new PessoaDAO();
                    dao.Alterar(pessoa);
                    
                    //PrintWriter out = response.getWriter();
                    
                    //out.println("Cliente ALTERADO");
                                                                         
                    RequestDispatcher rd = request.getRequestDispatcher("/consultarCli.jsp");
                    //quem vai acionar toda essa ação é o forward
                    rd.forward(request, response);
                            
                }else if(acao.equals("Excluir")){
                    //int id = Integer.parseInt(request.getParameter("id"));
                    
                    Pessoa pessoa = new Pessoa();
                   // pessoa.setId(id);
                    
                    PessoaDAO dao = new PessoaDAO();
                    dao.Excluir(false);
                    
                    //PrintWriter out= response.getWriter();
                    //out.println("Cliente Excluído!!!");
                    //*****************************************************************
                    RequestDispatcher rd = request.getRequestDispatcher("/excluirCli.jsp");
                    //quem vai acionar toda essa ação é o forward
                    rd.forward(request, response);
           
                }
            }
        }catch (Exception erro){
            RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
            request.setAttribute("erro", erro);
            rd.forward(request, response);
        }
  
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
