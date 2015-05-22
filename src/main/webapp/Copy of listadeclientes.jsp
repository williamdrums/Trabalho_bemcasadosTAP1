
<%@page import="Classe.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
<tr bgcolor="#CCCCCC">
<th>ID </th> <th>NOME </th> <th>TELEFONE </th> <th>EMAIL </th> <th>ACÃO </th> <th>ALTERAR</th>
</tr>
<% 		

//Scriplet
List<Cliente> lista = (List<Cliente>) request.getAttribute("lista");

for(Cliente cli: lista){%>
 <tr>
     <td><%=cli.getId()%></td>
     <td><%out.print(cli.getNome()); %></td>
     <td><%=cli.getTelefone()%></td>
     <td><%=cli.getEmail()%></td>
     <td><a href="clicontroller?acao=exc&id=<%= cli.getId()%>"> Excluir </a></td>
     |
     <td><a href="clicontroller?acao=alt&id=<%= cli.getId()%>"> Alterar </a></td>
 
 </tr>

<% 	
}
%>
</table>

</body>
</html>