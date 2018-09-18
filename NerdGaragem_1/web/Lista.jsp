<%--
    Document   : Lista
    Created on : 14/02/2018, 19:57:39
    Author     : Alexandre
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Garagem NERD</title>
    </head>
    <body>
        <h1 style="text-align:center; font-family: cursive, Comic Sans"><font color="#DF01D7">Lista de Pessoas</h1></font>
        <%
            //recuperar lista do request
            List<Pessoa> listaPessoa = (List<Pessoa>) request.getAttribute("lista");
        %>
        
        <table data-role="table" border="1" id="table-custom-2" data-mode="columntoggle" class="ui-body-d ui-shadow table-stripe ui-responsive" data-column-btn-theme="b">
        <tr>
                <td>Nome: </td>
                <td>RG: </td>
                <td>CPF: </td>
                <td>Data de nascimento: </td>
                <td>Telefone:</td>
                <td>Email:</td>
                <td>    </td>
                <td>    </td>
            </tr>
            
            <% 
                for(Pessoa pessoa: listaPessoa ){
                       
            %>
            

            
            <tr class="ui-bar-d">
                <td> <%= pessoa.getNome() %>   </td> 
                <td> <%= pessoa.getRg() %>  </td>
                <td> <%= pessoa.getCpf()%>  </td>
                <td> <%= pessoa.getDtnasc() %>  </td>
                <td> <%= pessoa.getTelefone() %>  </td>
                <td> <%= pessoa.getEmail() %>  </td>
                
               
            
                <%-- <td><a href="ControlePessoa?id=<%=pessoa.getId() %>&acao=Excluir"> Excluir</a></td> --%>
                <td><a href="ControlePessoa?id=<%=pessoa.getId() %>&acao=Consultar"> Editar</a></td>
                <td></td>
                
            </tr>

            <% 
               }           
            %>
         
        </table>
            <br><br/>
        <a href="cadCli.html"> Voltar</a>
    </body>
</html>
