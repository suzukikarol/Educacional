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
public class Produto {
    private int id;
    private String titulo;
    private String edicao;
    private String editora;
    private String arte;
    private int paginas;
    private String texto;
    private String personagens;
    private String idioma;
    private String ano;
    private String dimensoes;
    private double preco;
    private String imagem;
    private boolean status;

    public Produto() {
    }

    public Produto(int id, String titulo, String edicao, String editora, String arte, int paginas, String texto, String personagens, String idioma, String ano, String dimensoes, double preco, String imagem, boolean status) {
        this.id = id;
        this.titulo = titulo;
        this.edicao = edicao;
        this.editora = editora;
        this.arte = arte;
        this.paginas = paginas;
        this.texto = texto;
        this.personagens = personagens;
        this.idioma = idioma;
        this.ano = ano;
        this.dimensoes = dimensoes;
        this.preco = preco;
        this.imagem = imagem;
        this.status = status;
    }



     public List<Produto> listarTodos(){
        List<Produto> todosProdutos = new ArrayList<Produto>();
        /*todosProdutos.add(new Produto(1, "Batman", 5.50, "image/Batman_1.jpg"));
        todosProdutos.add(new Produto(2, "Mulher Maravilha", 8.50, "image/Mulher_Maravilha.jpg"));
        todosProdutos.add(new Produto(3, "Flash", 3.50, "image/flash_1.jpg"));
        todosProdutos.add(new Produto(4, "Iron Man Poster", .00, "image/ironman_poster.jpg"));
        todosProdutos.add(new Produto(5, "Mulher Maravilha", 0.75, "image/wonderwoman.jpg")); */
        return todosProdutos;
    }
    
    public Produto pesquisarProdutos(String titulo){
        List<Produto> todosProdutos = listarTodos();
        
        for (Produto produto : todosProdutos){
            if(produto.getTitulo().equalsIgnoreCase(titulo))
                return produto;
        }
        return null;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getArte() {
        return arte;
    }

    public void setArte(String arte) {
        this.arte = arte;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getPersonagens() {
        return personagens;
    }

    public void setPersonagens(String personagens) {
        this.personagens = personagens;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
     
    
}
