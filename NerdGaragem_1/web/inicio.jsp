<%-- 
    Document   : inicio
    Created on : 12/03/2018, 09:31:53
    Author     : 11151100178
--%>

<%@page import="modelo.Quadrinho"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Garagem NERD</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <link rel="stylesheet" href="estilo.css">
    </head>
    <body>
        <h1><a href="."><font style="font-family: cursive, Comic Sans" color="#0489B1">Garagem NERD</font></a></h1>
        
        <form action="BuscaQuadrinho" method="get">
            <input type="search" name="q" placeholder="Digite o nome do produto para buscar">    
        </form>
        <br>
        
        <% 
            List<Quadrinho> lista = (List<Quadrinho>) request.getAttribute("listaQuadrinhos");
            NumberFormat formatadorPreco = NumberFormat.getCurrencyInstance();
            
            if(lista != null){
                for (Quadrinho quad: lista){
            
          
        %>
        <div id="case-quadrinhos"><div id="case-quadrinhos-in">
                <div class="quadrinho">
                    <a href="BuscaQuadrinho?q=<%=quad.getNome()%>">
                        <img src="<%=quad.getImagem()%>" width="200">
                    </a>
                    <h3><%=quad.getNome()%></h3>
                    <p><%=formatadorPreco.format(quad.getPreco())%></p>
                </div>
            </div></div>
        <%
           }
        }else{
        %>
        <p>Nenhum produto disponível no momento.</p>
        <%
            }
        %>
        <br><br/>
            <a href="principal.jsp"> Voltar</a>
    </body>
</html>
