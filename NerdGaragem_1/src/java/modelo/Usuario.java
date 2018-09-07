/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Alexandre
 */
public class Usuario {
    private String Login;
    private String Senha;
    private PerfilDeAcesso perfil;
    private boolean Ativo;

    public Usuario() {
    }

    public Usuario(String Login, String Senha, PerfilDeAcesso perfil) {
        this.Login = Login;
        this.Senha = Senha;
        this.perfil = perfil;
        this.Ativo = true;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public PerfilDeAcesso getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilDeAcesso perfil) {
        this.perfil = perfil;
    }

    public boolean isAtivo() {
        return Ativo;
    }

    public void setAtivo(boolean Ativo) {
        this.Ativo = Ativo;
    }
    
 

}
