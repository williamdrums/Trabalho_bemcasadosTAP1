<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



<table border="1">
<tr bgcolor="#CCCCCC">
<th>ID </th> <th>NOME </th> <th>TELEFONE </th> <th>EMAIL </th> <th>ACAO </th> <th>ALTERAR</th>
</tr>


<c:forEach items="${requestScope.lista}" var="cli">

 <tr>
     <td>${cli.id}</td>
     <td>${cli.nome}</td>
     <td>${cli.telefone}</td>
     <td>${cli.email}</td>
     
     <td><a href="clicontroller?acao=exc&id=${cli.id}"> Excluir </a></td>
     
     <td><a href="clicontroller?acao=alt&id=${cli.id}"> Alterar </a></td>
 
 </tr>

</c:forEach>
</table>

</body>
</html>