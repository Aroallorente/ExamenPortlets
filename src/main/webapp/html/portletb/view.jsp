<%@page import="com.talentum.examen.Persona"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<h1>Portlet B</h1>

<%
	Persona persona = (Persona)request.getAttribute("datosB");

	if(persona != null) {	
	
%>
<form method="post">
	<div>Nombre:<input type="text" name="nombre" value="<%=persona.getNombre()%>"/></div>
	<div>Direccion:<input type="text" name="dirección" value="<%=persona.getDireccion()%>"/></div>
	<div>Telefono:<input type="text" name="telefono" value="<%=persona.getTelefono()%>"/></div>
</form>
<%
	}else{
%>
<form method="post">
	<div>Nombre:<input type="text" name="nombre" placeholder="Nombre"/></div>
	<div>Direccion:<input type="text" name="dirección" placeholder="Dirección"/></div>
	<div>Telefono:<input type="text" name="telefono" placeholder="Teléfono"/></div>
</form>

<%
	}
%>