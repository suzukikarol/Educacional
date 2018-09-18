<%-- 
    Document   : index
    Created on : 14/02/2018, 20:10:34
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
    <body style="background-image:url('image/darkbatman.jpg')">
        <h1><font color="#FFEA03" style="font-family: cursive, Comic Sans">Garagem NERD</font><br></font><font color="#FBEFEF">  Autenticação de Usuário!</h1></font>
        <% 
            String msg = (String)request.getAttribute("msg");
            if (msg!=null){
            
        %>
        <font color="red"><%=msg%></font>
        <%}%>
        
        <form action="ControleAcesso" method="POST">
            <font color="#FBFBEF"> Login: <input type="text" name="txtLogin"></br></font>
            <font color="#FBFBEF"> Senha: <input type="password" name="txtSenha"></br></font>
            <input type="submit" value="Entrar" name="acao">
          
            
        </form>
    </body>
</html>
