<%-- 
    Document   : cad_user
    Created on : 05/01/2018, 11:42:48
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Usuário</title>
    </head>
    <body>
        <h1><font color="#0489B1">Cadastro de novo usuário!</h1></font>
        <br/>
        <%
            String msg = (String) request.getAttribute("msg");
            if (msg!=null){
        %>
        <font color="blue"><%=msg %></font>
        <%}%>
        <form action="../ControleUsuario" method="POST">
            Login: <input type="text" name="txtLogin"></br>
            Senha: <input type="text" name="txtSenha"></br>
           Perfil: <select name="optPerfil">
                <option>COMUM</option>
                <option>ADMINISTRADOR</option>
            </select></br> 
            <input type="submit" value="Cadastrar" name="acao">   
            
            
        </form>
        <a href="/NerdGaragem/principal.jsp">Página Principal</a>
       <!-- <a href="/GaragemNerdTESTE_2/cadCli.html">Cadastro</a> -->
    </body>
</html>
