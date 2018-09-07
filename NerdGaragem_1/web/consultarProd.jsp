<%-- 
    Document   : alterarProd
    Created on : 26/02/2018, 11:39:28
    Author     : 11151100178
--%>

<%@page import="modelo.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%-- <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
        <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script> --%>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <title>Alterar Produtos</title>
    </head>
    <body>
        <%
            //recuperar a lista do request
            Produto produto = (Produto)request.getAttribute("consulta");
        %>
        
        
        <div class="container">
            <h1 style="text-align: center "font-family: inherit><font color="#0489B1">ATUALIZAR CADASTRO DE PRODUTOS</font></h1>
        <form action="ControleProduto" method="POST">
            ID: <input type="text" name="txtId" value="<%=produto.getId() %>"><br/><br/>
            Título: <input type="text" name="txtTitulo" value="<%=produto.getTitulo() %>">
            Edição: <input type="text" name="txtEdicao" value="<%=produto.getEdicao() %>"><br/>
            Editora: <input type="text" name="txtEditora" value="<%=produto.getEditora() %>">
            Arte: <input type="text" name="txtArte" value="<%=produto.getArte() %>"><br/>
            Paginas: <input type="number" name="Paginas" value="<%=produto.getPaginas() %>">
            Texto: <input type="text" name="txtTexto" value="<%=produto.getTexto() %>"><br/>
            Personagens: <input type="text" name="txtPersonagens" value="<%=produto.getPersonagens() %>">
            Idioma: <input type="text" name="txtIdioma" value="<%=produto.getIdioma() %>"><br/>
            Ano: <input type="text" name="txtAno" value="<%=produto.getAno() %>">
            Dimensões: <input type="text" name="txtDimensoes" value="<%=produto.getDimensoes() %>"><br/><br/>
            Preço: <input type="text" name="txtPreco" value="<%=produto.getPreco() %>"><br/>
            Imagem: <input type="text" name="txtImagem" value="<%=produto.getImagem() %>"><br/>
            
            <input class="ui-btn ui-btn-b" type="submit" name="acao" value="Alterar">
            <input class="ui-btn ui-btn-b" type="submit" name="acao" value="Excluir"><br/><br/>
            
           
            
        </form>
        
        </div>
            <a href="principal.jsp">Página Principal</a>
    </body>
</html>
