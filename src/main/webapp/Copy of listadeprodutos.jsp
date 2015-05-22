<%@page import="java.util.List"%>
<%@page import="Classe.Produto"%>
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
<th>ID </th> <th>DESCRICAO </th> <th>VALOR </th>  <th>ACAO </th> <th>ALTERAR</th>
</tr>
<% 		

//Scriplet
List<Produto> lista = (List<Produto>) request.getAttribute("lista");

for(Produto prod: lista){%>
 <tr>
     <td><%=prod.getId()%></td>
     <td><%out.print(prod.getDescricao()); %></td>
     <td><%=prod.getValor()%></td>
     
     <td><a href="prodcontroller?acao=exc&id=<%= prod.getId()%>"> Excluir </a></td>
     |
     <td><a href="prodcontroller?acao=alt&id=<%= prod.getId()%>"> Alterar </a></td>
 
 </tr>

<% 	
}
%>
</table>

</body>
</html>