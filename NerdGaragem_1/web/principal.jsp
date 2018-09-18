<%-- 
    Document   : principal
    Created on : 14/02/2018, 20:16:26
    Author     : Alexandre
--%>

<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Garagem NERD</title>
    </head>
    <body>
        <%
            //recupera o usuario da sessao
            Usuario usuario = (Usuario)session.getAttribute("usuarioAutenticado");
            
            if(usuario !=null){
        %>
        <h1 style="font-family: cursive, Comic Sans"><font color="#DF01D7">Bem vindo, <%=usuario.getLogin() %>!</h1>
        <%}%>
        
        <a href="admin/cad_user.jsp"><font color ="#DF01D7" style="font-family: cursive, Comic Sans">Cadastro usuário</font> </a>></br>
        <a href="cadCli.html"><font color ="#DF01D7" style="font-family: cursive, Comic Sans">Cadastro Dados do cliente</font></a>></br>
        <a href="cadProduto.html"><font color ="#DF01D7" style="font-family: cursive, Comic Sans">Cadastro de produtos </font></a>></br>
        <!--<a href="inicio.jsp"><font color ="#DF01D7" style="font-family: cursive, Comic Sans">Carrinho</font></a>></br> -->
        <a href="index1.jsp"><font color ="#DF01D7" style="font-family: cursive, Comic Sans">Carrinho</font></a>></br>
        <a href="ControleAcesso?acao=Sair"><font color ="#DF01D7" style="font-family: cursive, Comic Sans">Logout</font></a>
    </body>
</html>

    <%-- style="background-image:url('image/darth_pop.jpg')"
     cor amarela: #FFEA03
    --%>