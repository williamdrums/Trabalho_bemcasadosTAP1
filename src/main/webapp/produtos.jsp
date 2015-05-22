<%@page import="Classe.Produto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Produto</title>
</head>
<body>

<%

Produto produto = (Produto) request.getAttribute("produto");

%>

<form action="ProdutoController"method="post">

<h1>Cadastro Produto</h1>

<label>ID:</label>
<input type ="text" readonly="readonly" name = "id" value="<%=produto.getId() %>"/>
<br />
<br />

<label>DESCRICÃO:</label>
<input type ="text" name = "descricao" value="<%=produto.getDescricao() %>"/>
<br />
<br />

<label>VALOR:</label>
<input type = "text" name = "valor" value="<%=produto.getValor() %>"/>
<br />
<br />

<input type ="submit" value="Salvar"/>

</form>

</body>
</html>