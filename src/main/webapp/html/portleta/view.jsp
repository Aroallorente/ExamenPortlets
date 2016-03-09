<%@page import="com.talentum.examen.Persona"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<h1>Portlet A</h1>

<portlet:actionURL var="urlPortletB" name="enviarB"/>
<portlet:actionURL var="urlPortletC" name="enviarC"/>


<%
Persona persona = (Persona)request.getAttribute("datos");

if(persona != null) {
%>
<form method="post">
	<input type="submit" value="PortletB" formaction="<%=urlPortletB %>"/>
	<input type="submit" value="PortletC" formaction="<%=urlPortletC %>"/>
	<div>Nombre: <input type="text" name="nombre" value="<%=persona.getNombre()%>"/></div>
	<div>Dirección: <input type="text" name="direccion" value="<%=persona.getDireccion()%>"/></div>
	<div>Teléfono: <input type="text" name="telefono" value="<%=persona.getTelefono()%>"/></div>
</form>
<% 
}else {
	%>

<form method="post">
	<input type="submit" value="PortletB" formaction="<%=urlPortletB %>"/>
	<input type="submit" value="PortletC" formaction="<%=urlPortletC %>"/>
	<div>Nombre: <input type="text" name="nombre" placeholder="Nombre"/></div>
	<div>Dirección: <input type="text" name="direccion" placeholder="Dirección"/></div>
	<div>Teléfono: <input type="text" name="telefono"placeholder="Teléfono"/></div>
</form>
<% } %>