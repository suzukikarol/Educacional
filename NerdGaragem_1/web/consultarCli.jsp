<%-- 
    Document   : alterarCli
    Created on : 14/02/2018, 20:06:24
    Author     : Alexandre
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Cliente</title>
    </head>
    <body>
        <% 
        
        //recuperar a lista do request
        Pessoa pessoa = (Pessoa) request.getAttribute("consulta");
           
        %>
  
        <div class="container">
        <h1 style="text-align: center;">ATUALIZAR CADASTRO DE CLIENTES</h1>
        <form action="ControlePessoa" method="POST">
            Id: <input type="text" name="txtId" value="<%= pessoa.getId() %>"><br/>
            Nome: <input type="text" name="txtNome" value="<%= pessoa.getNome() %>"><br/>
            RG: <input type="text" name="txtRG" value="<%= pessoa.getRg() %>"><br/>
            CPF: <input type="text" name="txtCPF" value="<%= pessoa.getCpf() %>"><br/>
            Data de Nasc: <input type="text" name="txtDtNasc" value="<%= pessoa.getDtnasc() %>"><br/>
            Telefone: <input type="text" name="txtTelefone" value="<%= pessoa.getTelefone() %>"><br/>
            Email: <input type="text" name="txtEmail" value="<%= pessoa.getEmail() %>"><br/>
           
            
            <input class="ui-btn ui-btn-b" type="submit" name="acao" value="Salvar">
            <input class="ui-btn ui-btn-b" type="submit" name="acao" value="Excluir"><br/><br/>
            <%-- <input type="submit" name="acao" value="<%= "Alterar" %>"> --%>
           
        
        </form>
    </div>
        <a href="principal.jsp">Página Principal</a>
    </body>
</html>
