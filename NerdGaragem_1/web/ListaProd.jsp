<%-- 
    Document   : ListaProd
    Created on : 26/02/2018, 08:27:17
    Author     : 11151100178
--%>

<%@page import="modelo.Produto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Garagem NERD</title>
    </head>
    <body>
        <h1 style="text-align:center; font-family: cursive, Comic Sans"><font color="#DF01D7">Lista de Produtos</h1>
        <% 
            //recuperar lista do request
            List<Produto> listaproduto = (List<Produto>) request.getAttribute("lista");
        %>
        
        <table data-role="table" border="1" id="table-custom-2" data-mode="columntoggle" class="ui-body-d ui-shadow table-stripe ui-responsive" data-column-btn-theme="b"> 
            <tr>
                <td>Título: </td>
                <td>Edição: </td>
                <td>Editora: </td>
                <td>Arte: </td>
                <td>Páginas: </td>
                <td>Texto: </td>
                <td>Personagens: </td>
                <td>Idioma: </td>
                <td>Ano: </td>
                <td>Dimensões: </td>
                <td>Preço: </td>
                <td>Imagem: </td>
                <td> </td>
                <td> </td>                
            </tr>   
            
            <% 
                for(Produto produto: listaproduto){
            %>
            
            <tr class="ui-bar-d">
                <td><%= produto.getTitulo() %> </td>
                <td><%= produto.getEdicao() %> </td>
                <td><%= produto.getEditora() %> </td>
                <td><%= produto.getArte() %> </td>
                <td><%= produto.getPaginas() %> </td>
                <td><%= produto.getTexto() %> </td>
                <td><%= produto.getPersonagens() %> </td>
                <td><%= produto.getIdioma() %> </td>
                <td><%= produto.getAno() %> </td>
                <td><%= produto.getDimensoes() %> </td>
                <td><%= produto.getPreco() %></td>
                <td><%= produto.getImagem() %></td>
                
                <td><a href="ControleProduto?id=<%=produto.getId() %>&acao=Consultar"> Editar</a></td>
               <%-- <td><a href="ControleProduto?id=<%=produto.getId() %>&acao=Consultar"> Atualizar</a></td> --%>
            </tr>
            
            <% 
                }
            %>
            
        </table>
            <br><br/>
            <a href="cadProduto.html"> Voltar</a>
    </body>
</html>
