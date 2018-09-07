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
import modelo.Produto;
import modelo.Quadrinho;
import util.Conexao;

/**
 *
 * @author 11151100178
 */
public class ProdutoDAO {
    private Connection conexao = null;
   

    public ProdutoDAO() {
        this.conexao = Conexao.getConexao();
    }
    
    public void Cadastrar(Produto produto) throws SQLException{
        try{
            
            String sqlQuadrinho = "INSERT INTO Quadrinho(titulo, edicao, editora, arte, paginas, texto, personagens, idioma, ano, dimensoes, preco, imagem) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement pstmtQuadrinho = conexao.prepareStatement(sqlQuadrinho);
            pstmtQuadrinho.setString(1, produto.getTitulo());
            pstmtQuadrinho.setString(2, produto.getEdicao());
            pstmtQuadrinho.setString(3, produto.getEditora());
            pstmtQuadrinho.setString(4, produto.getArte());
            pstmtQuadrinho.setInt(5, produto.getPaginas());
            pstmtQuadrinho.setString(6, produto.getTexto());
            pstmtQuadrinho.setString(7, produto.getPersonagens());
            pstmtQuadrinho.setString(8, produto.getIdioma());
            pstmtQuadrinho.setString(9, produto.getAno());
            pstmtQuadrinho.setString(10, produto.getDimensoes());
            pstmtQuadrinho.setDouble(11, produto.getPreco());
            pstmtQuadrinho.setString(12, produto.getImagem());
            
            pstmtQuadrinho.execute();

            
            
            
            conexao.commit();
   
        }catch (SQLException e){
             try {
                 conexao.rollback();
             } catch (SQLException ex) {
                 Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, "Erro no cadastro: "+ e.getMessage());
        }finally{
             if (conexao != null){
             try {
                 
                 conexao.close();
             } catch (SQLException ex) {
                 Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
            
            }
         }
    }
    public List<Produto> listar(){
        List<Produto> listaproduto = null;
        try{
            
            Connection conexao= Conexao.getConexao();
            
            String sql = "SELECT * FROM Quadrinho";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();
            
            listaproduto = new ArrayList();
            while (rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getInt("id_quadrinho"));
                produto.setTitulo(rs.getString("titulo"));
                produto.setEdicao(rs.getString("edicao"));
                produto.setEditora(rs.getString("editora"));
                produto.setArte(rs.getString("arte"));
                produto.setPaginas(rs.getInt("paginas"));
                produto.setTexto(rs.getString("texto"));
                produto.setPersonagens(rs.getString("personagens"));
                produto.setIdioma(rs.getString("idioma"));
                produto.setAno(rs.getString("ano"));
                produto.setDimensoes(rs.getString("dimensoes"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setImagem("imagem");
                
          
                
                listaproduto.add(produto);
            
            }
        }catch(SQLException e) {
            Logger.getLogger(Pessoa.class.getName()).
                    log(Level.SEVERE, "Erro ao listar: " + e.getMessage());
        }finally{ //***************** new part
            try{
                if(conexao != null){
                    conexao.close();
                }
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
        
        return listaproduto;

    }
    public Produto Consultar(Produto produto){
        
        Produto produtoConsulta = new Produto();
        
        try{
            
            Connection conexao = Conexao.getConexao();
            
            String sql = "SELECT * FROM Quadrinho Where id_quadrinho=?";
            
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, produto.getId());
            
            ResultSet rs = pstmt.executeQuery();
            
            //só vai retornar uma linha de obj
            while(rs.next()){
                
                produtoConsulta.setId(rs.getInt("id_quadrinho"));
                produtoConsulta.setTitulo(rs.getString("titulo"));
                produtoConsulta.setEdicao(rs.getString("edicao"));
                produtoConsulta.setEditora(rs.getString("editora"));
                produtoConsulta.setArte(rs.getString("arte"));
                produtoConsulta.setPaginas(rs.getInt("paginas"));
                produtoConsulta.setTexto(rs.getString("texto"));
                produtoConsulta.setPersonagens(rs.getString("personagens"));
                produtoConsulta.setIdioma(rs.getString("idioma"));
                produtoConsulta.setAno(rs.getString("ano"));
                produtoConsulta.setDimensoes(rs.getString("dimensoes"));
                produtoConsulta.setPreco(rs.getDouble("preco"));
                produtoConsulta.setImagem(rs.getString("imagem"));
                
                
                
            }
   
        }catch (Exception e) {
               Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, "Erro ao listar: "+ e.getMessage());
        }  
        
        return produtoConsulta;
    }
    
    public void Alterar(Produto produto){
         /*
            1. Uma conexao com db ***já existe no topo
            2. Instrucao SQL
            3. Executar o SQL
            4. Fechar a conexao
        
         */
        try{
            //2
            String sqlProduto = "UPDATE Quadrinho SET (titulo, edicao, editora, arte, paginas, texto, personagens, idioma, ano, dimensoes, preco, imagem) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmtProduto = conexao.prepareStatement(sqlProduto, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmtProduto.setString(1, produto.getTitulo());
            pstmtProduto.setString(2, produto.getEdicao());
            pstmtProduto.setString(3, produto.getEditora());
            pstmtProduto.setString(4, produto.getArte());
            pstmtProduto.setInt(5, produto.getPaginas());
            pstmtProduto.setString(6, produto.getTexto());
            pstmtProduto.setString(7, produto.getPersonagens());
            pstmtProduto.setString(8, produto.getIdioma());
            pstmtProduto.setString(9, produto.getAno());
            pstmtProduto.setString(10, produto.getDimensoes());
            pstmtProduto.setDouble(11, produto.getPreco());
            pstmtProduto.setString(12, produto.getImagem());
            
            pstmtProduto.executeUpdate();
            
            //4
            conexao.close();
        }catch (Exception e) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, "Erro no cadastro: " + e.getMessage());
        } 
        
    }public void Excluir (boolean status){
        
        Connection conexao = null;
        
        try{
            //2
            conexao = Conexao.getConexao();
            conexao.setAutoCommit(false);
            String sql = "UPDATE quadrinho SET status = FALSE"; //WHERE id_quadrinho = ?";
            
            //3
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            
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
