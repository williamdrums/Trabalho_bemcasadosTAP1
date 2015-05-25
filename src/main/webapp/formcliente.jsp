<%@page import="Classe.Cliente"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cliente</title>
</head>
<body>


<%

Cliente cliente = (Cliente) request.getAttribute("cliente");

%>

<form action="ClienteController"method="post">

<h1>Cadastro Cliente</h1>

<label>ID:</label>
<input type ="text" readonly="readonly" name = "id" value="<%=cliente.getId() %>"/>
<br />
<br />

<label>Nome:</label>
<input type ="text" name = "nome" value="<%=cliente.getNome() %>"/>
<br />
<br />

<label>Telefone:</label>
<input type = "text" name = "telefone" value="<%=cliente.getTelefone() %>"/>
<br />
<br />

<label>Email:</label>
<input type ="text" name="email" value="<%=cliente.getEmail() %>"/>
<br />
		<br />
		
		<label>Cliente</label>
 <!--  <select size="1" name="Combo">
    <option selected value="Selecione">Selecione!</option>
    <option value="2000">William</option>
    <option value="2001">José</option>
    <br />
    <br />--> 
     
      <select size="1" name="idCliente" id="idCliente">
		<option selected value  = "0">Selecione!</option>
		<c:forEach items="${requestScope.listacli}" var="cliente">
			<option value="${cliente.id}"><c:out value="${cliente.nome}"></c:out></option>
		</c:forEach>
	</select>
   
<input type ="submit" value="Salvar"/>

</form>
</body>
</html>