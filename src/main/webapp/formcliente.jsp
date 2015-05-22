<%@page import="Classe.Cliente"%>
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

<input type ="submit" value="Salvar"/>

</form>
</body>
</html>