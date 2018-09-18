/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pessoa;
import util.Conexao;

/**
 *
 * @author Alexandre
 */
public class PessoaDAO {
    private Connection conexao = null;
    
     public PessoaDAO() {
        this.conexao = Conexao.getConexao();

    }
    
     public void cadastrar(Pessoa pessoa){
         try{
           //conexao.setAutoCommit(false);
  
             String sql = "INSERT INTO Pessoa (nome, rg, cpf, dt_nasc, tel, email, status) VALUES (?,?,?,?,?,?,?)";
              
             PreparedStatement pstmt = conexao.prepareStatement(sql);
             pstmt.setString(1, pessoa.getNome());
             pstmt.setString(2,pessoa.getRg());
             pstmt.setString(3,pessoa.getCpf());
             pstmt.setString(4, pessoa.getDtnasc());
             pstmt.setString(5, pessoa.getTelefone());
             pstmt.setString(6, pessoa.getEmail());
             pstmt.setBoolean(7, pessoa.isStatus());
             
             pstmt.execute();
            
             
            // cadastrar(pessoa); ERRADO!!!
             conexao.commit();
        
        }catch (SQLException e){
             try {
                 conexao.rollback();
             } catch (SQLException ex) {
                 Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, "Erro no cadastro: "+ e.getMessage());
        }finally{
             if (conexao != null){
             try {
                 
                 conexao.close();
             } catch (SQLException ex) {
                 Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
            
            }
         }
        }
      public List<Pessoa> listar() {
        List<Pessoa> listaPessoa = null;
        try {
            Connection conexao = Conexao.getConexao();

            String sql = "SELECT * FROM Pessoa";
            PreparedStatement pstmt = conexao.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            listaPessoa = new ArrayList();
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("id_pessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setRg(rs.getString("rg"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setDtnasc(rs.getString("dt_nasc"));
                pessoa.setTelefone(rs.getString("tel"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setStatus(true);
         
                listaPessoa.add(pessoa);
             
            }

        } catch (SQLException e) {
            Logger.getLogger(Pessoa.class.getName()).
                    log(Level.SEVERE, "Erro ao listar: " + e.getMessage());
        }

        return listaPessoa;
    }

        //************************************
        public Pessoa Consultar(Pessoa pessoa){

           Pessoa pessoaConsulta = new Pessoa();
           
          
          try{
              
              Connection conexao = Conexao.getConexao();
              
              
              String sql = "SELECT * FROM pessoa WHERE id_pessoa = ?";
               
              PreparedStatement pstmt = conexao.prepareStatement(sql);
              pstmt.setInt(1, pessoa.getId());
              
              ResultSet  rs  =  pstmt.executeQuery();
             
              
              //só vai retornar uma linha de obj
             while(rs.next()){
                  //ArrayList<Endereco> teste = new ArrayList<>();
                  pessoaConsulta.setId(rs.getInt("id_pessoa"));
                  pessoaConsulta.setNome(rs.getString("nome"));
                  pessoaConsulta.setRg(rs.getString("rg"));
                  pessoaConsulta.setCpf(rs.getString("cpf"));
                  pessoaConsulta.setDtnasc(rs.getString("dt_nasc"));
                  pessoaConsulta.setTelefone(rs.getString("tel"));
                  pessoaConsulta.setEmail(rs.getString("email"));
                  pessoaConsulta.setStatus(rs.getBoolean("status"));

            }
    
          }catch (Exception e) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, "Erro ao listar: "+ e.getMessage());
          }
 
          
          return pessoaConsulta;    
        }
      
       public void Alterar(Pessoa pessoa) {
        /*
            1. Uma conexao com db ***já existe no topo
            2. Instrucao SQL
            3. Executar o SQL
            4. Fechar a conexao  
         */
        try {
            //2
            String sql = "UPDATE Pessoa SET  nome = ? , rg = ?, cpf = ?, dt_nasc = ?, tel = ?, email = ? where id_pessoa = ?";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
             //pstmt.setInt(1, pessoa.getId());
             pstmt.setString(1, pessoa.getNome());
             pstmt.setString(2,pessoa.getRg());
             pstmt.setString(3,pessoa.getCpf());
             pstmt.setString(4, pessoa.getDtnasc());
             pstmt.setString(5, pessoa.getTelefone());
             pstmt.setString(6, pessoa.getEmail());
             //pstmt.setBoolean(8, pessoa.isStatus());
             
             pstmt.executeUpdate();
            
             /*
            String sql = "UPDATE Pessoa SET (nome, rg, cpf, dt_nasc, tel, email) VALUES (?,?,?,?,?,?)";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, pessoa.getNome());
            pstmt.setString(2, pessoa.getRg());
            pstmt.setString(3, pessoa.getCpf());
            pstmt.setString(4, pessoa.getDtnasc());
            pstmt.setString(5, pessoa.getTelefone());
            pstmt.setString(6, pessoa.getEmail());
            //pstmt.setInt(7, pessoa.getId());
            //pstmt.setBoolean(8, true);
            
            pstmt.executeUpdate(); */

            //4
            conexao.close();

        } catch (Exception e) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, "Erro no cadastro: " + e.getMessage());
        }

    }
    public void Excluir(boolean status){
          
          Connection conexao = null;
  
      try{
            //2
             conexao = Conexao.getConexao();
             conexao.setAutoCommit(false);
             String sql = "UPDATE pessoa SET status= TRUE"; //WHERE id_pessoa=?";
             //3
             PreparedStatement pstmt = conexao.prepareStatement(sql);
             //pstmt.setInt(1, pessoa.getId());
             pstmt.execute();
             
             //4
             conexao.commit();   
         
        }catch(Exception e){
          try {
              conexao.rollback();
          } catch (SQLException ex) {
              Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, "Erro no cadastro: "+ e.getMessage());
        } finally{
          try {
              conexao.close();
          } catch (SQLException ex) {
              Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
       }
    }
}
