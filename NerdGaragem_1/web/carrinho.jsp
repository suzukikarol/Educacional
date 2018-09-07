<%-- 
    Document   : carrinho
    Created on : 20/03/2018, 08:31:40
    Author     : 11151100178
    ARRUMAR ESSE NEGÓCIO AQUI, PÁGINA 13 ***
--%>

<%@page import="modelo.ItemDeCompra"%>
<%@page import="modelo.CarrinhoDeCompra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Garagem NERD</title>
    </head>
    <body>
        <h1>Carrinho de Compras!</h1>
        <table border="1" cellpadding="2" >
        <tr>
           <td bgcolor="#000088"><font color="#FBEFEF">Excluir</font></td>
           <td bgcolor="#000088"><font color="white">Item</font></td>
           <td bgcolor="#000088"><font color="white">QTD</font></td>
           <td bgcolor="#000088"><font color="white">Preço Unitário</font></td>
           <td bgcolor="#000088"><font color="white">Total Item</font></td>
           <td bgcolor="#000088"><font color="white">+1</font></td>
        </tr>
        <%
            //recupera os produtos do carrinho da sessao
            CarrinhoDeCompra carrinho = (CarrinhoDeCompra) session.getAttribute("carrinho");
            for(ItemDeCompra item : carrinho.getItens()){
        %>
        <tr>
            <td><a href="ControleCarrinho?acao=removeProduto&id=<%=item.getProduto().getId()%>">X</td>
            <td><%=item.getProduto().getTitulo()%></td>
            <td><%=item.getQuantidade() %></td>
            <td><%=item.getProduto().getPreco() %></td>
            <td><%=item.getTotal()%></td>
            <td><a href="ControleCarrinho?acao=addProduto&id=<%=item.getProduto().getId()%>">+</a></td>
        </tr>
        <%
            }
        %>
        </table>
        
        <strong>Valor Total: <%=carrinho.calculaTotal() %></strong><br/>
        <a href="index1.jsp">Continue Comprando!</a><br/>
        <a href="ControleCarrinho?acao=cancelaCompra">Cancelar Compra</a>
    </body>
</html>
