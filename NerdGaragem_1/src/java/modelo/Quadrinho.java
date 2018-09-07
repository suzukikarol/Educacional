/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 11151100178
 */
public class Quadrinho {
    private int codigo;
    private String nome;
    private double preco;
    private String imagem;

    public Quadrinho() {
    }

    public Quadrinho(int codigo, String nome, double preco, String imagem) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.imagem = imagem;
    }

    public List<Quadrinho> listarTodos(){
        List<Quadrinho> todosQuadrinhos = new ArrayList<Quadrinho>();
        todosQuadrinhos.add(new Quadrinho(1, "Batman", 5.50, "image/Batman_1.jpg"));
        todosQuadrinhos.add(new Quadrinho(2, "Mulher Maravilha", 8.50, "image/Mulher_Maravilha.jpg"));
        todosQuadrinhos.add(new Quadrinho(3, "Flash", 3.50, "image/flash_1.jpg"));
        todosQuadrinhos.add(new Quadrinho(4, "Iron Man Poster", .00, "image/ironman_poster.jpg"));
        todosQuadrinhos.add(new Quadrinho(5, "Mulher Maravilha", 0.75, "image/wonderwoman.jpg"));
        return todosQuadrinhos;
    }
    
    public Quadrinho pesquisarQuadrinhos(String nome){
        List<Quadrinho> todosQuadrinhos = listarTodos();
        
        for (Quadrinho quadrinho : todosQuadrinhos){
            if(quadrinho.getNome().equalsIgnoreCase(nome))
                return quadrinho;
        }
        return null;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }  
    
}