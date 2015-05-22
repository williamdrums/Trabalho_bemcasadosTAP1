<%@page import="Classe.Pedido" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 <meta  http-equiv = "Content-Type"  conteúdo = "text / html; charset = UTF-8 " >

 <link  rel = "stylesheet"  href = "http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css"  /> 
 
  <script  src = "http://code.jquery.com/jquery-1.8.3.js" ></script> 
  <script  src = "http://code.jquery.com/ui/1.9.2/jquery-ui.js" ></script> 
  <script> 
  
  
  
$ ( function ()  { 
	
	
    $ (  "#datepickerDataPedido"  ). datepicker (); 
}); 
</script> 
  <script> 
$ ( function ()  { 
    $ (  "#datepickerDataEvento"  ). datepicker (); 
}); 
</script> 
<title>Pedido</title>
</head>

<body>



<%
Pedido pedido = (Pedido) request.getAttribute("pedido");
%>

<form action="PedidoController" method="post"></form>

<h1> Cadastro Pedido </h1>

<label>Local Evento </label>
<input type="text" name = "localevento" value=""/>
<br />
<br />

<label>Data Pedido</label>
Data: <input  tipo = "text"  id = "datepickerDataPedido"  /> 
</ body> 
  </ html>
   <br />
   <br />
  
  <label>Cliente</label>
  <select size="1" name="Combo">
    <option selected value="Selecione">Selecione!</option>
    <option value="2000">William</option>
    <option value="2001">José</option>
    <br />
    <br />

    
</select>Ï

<form>
<div  style="height:100px;"  >
<fieldset style="position:relative; height:100%;  float:left;  width:160px">

<legend style="font-size: 18px; font-weight: bold;
                                        color: maroon; font-family: Georgia, serif;"> </legend>
<label>Cerimonial</label>
<input type="text" name = "cerimonial"/>
<br />
<br />
<label>Data Evento</label>
Data: <input  tipo = "text"  id = "datepickerDataEvento"  /> 
</ body> 
  </ html>
  <br />
  <br />

</fieldset>
</div>
</form>



<input type="checkbox" /> Cliente

<label>Data Pedido</label>


</body>
</html>