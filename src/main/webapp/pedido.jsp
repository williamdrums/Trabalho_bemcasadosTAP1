<%@page import="Classe.Pedido"%>
<%@page import="Classe.Cliente"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="Content-Type" conteúdo="text / html; charset = UTF-8 ">

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />

<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script>
	$(function() {

		$("#datepickerDataPedido").datepicker();
	});
</script>
<script>
	$(function() {
		$("#datepickerDataEvento").datepicker();
	});
</script>
<title>Pedido</title>
</head>

<body>



	<%
		Pedido pedido = (Pedido) request.getAttribute("pedidocli");
	%>
	
	

	<form action="PedidoController" method="post"></form>

	<h1>Cadastro Pedido</h1>

	<label>Local Evento </label>
	<input type="text" name="localevento" value="" />
	<br />
	<br />

	<label>Data Pedido</label>
	<input type="text" id="datepickerDataPedido" />

	<br />
	<br />

	<label>Cliente</label>

	<!--  <select size="1" name="idCliente" id="idCliente">
		<option selected value  = "">Selecione!</option>
		<c:forEach items="${requestScope.lista}" var="cliente">
			<option value="${cliente.id}"><c:out value="${cliente.nome}"></c:out></option>
		</c:forEach>
	</select>-->
	
	<c:set var="lista" value="${requestScope.lista}"/>
	<select name ="cli" style="width: 263px;">
	<option value = "0">selecione</option>
	<c:forEach var="listas" items="${lista}">
	<option value="${listas.lista}">${listas.lista}</option>
	</c:forEach>
	</select>
	
	


	<br />
	<br />

	<form>
		<div style="height: 200px;">
			<fieldset
				style="position: relative; height: 100%; float: down; width: 160px">

				<legend
					style="font-size: 18px; font-weight: bold; color: maroon; font-family: Georgia, serif;">
				</legend>
				<label>Cerimonial</label> <input type="text" name="cerimonial" /> <br />
				<br /> <label>Data Evento</label> <input type="text"
					id="datepickerDataEvento" /> <br /> <br /> <label>Tipo</label> <select
					size="1" name="Combo2">
					<option selected value="tipo">Selecione!</option>
					<option value="2002">Casamento</option>
					<option value="2003">Aniversario</option>

				</select> <br /> <br /> <label>Horario Evento</label> <input type="text"
					name="horario" />

			</fieldset>
		</div>
		<br /> <br />

		<div style="height: 200px;">
			<fieldset style="position: center; width: 100px margin: 20px auto;">



				<legend
					style="font-size: 18px; font-weight: bold; color: maroon; font-family: Georgia, serif;">Pedido
				</legend>
				<label>Produto</label> <select size="1" name="Combo">
					<option selected value="Selecione">Selecione!</option>
					<option value="2000">Bolo</option>
					<option value="2001">Pão</option>
					<option value="2002">Salgado</option>
				</select>

				</td>
				<td><label>Quantidade</label> <input type="text" name="qtd"
					value=""> <label>Valor</label> <input type="text"
					name="valor" value=""> <input type="submit"
					value="Adicionar" /></td>

			</fieldset>
		</div>
	</form>

</body>
</html>