package com.talentum.examen;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class PortletA
 */
public class PortletA extends GenericPortlet {

	public void init() {
		viewTemplate = getInitParameter("view-template");
	}

	@ProcessAction(name = "enviarB")
	public void enviarB(ActionRequest request, ActionResponse response) throws PortletException, IOException {

		String nombre = request.getParameter("nombre");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");

		Persona persona = new Persona(nombre, direccion, telefono);

		QName qname = new QName("http://examen.portlet.com", "datosB", "x");

		response.setEvent(qname, persona);
		request.setAttribute("datos", persona);
	}

	@ProcessAction(name = "enviarC")
	public void enviarC(ActionRequest request, ActionResponse response) throws PortletException, IOException {

		String nombre = request.getParameter("nombre");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");

		Persona persona = new Persona(nombre, direccion, telefono);

		QName qname = new QName("http://examen.portlet.com", "datosC", "x");

		response.setEvent(qname, persona);
		request.setAttribute("datos", persona);
		
	}

	@ProcessEvent(qname = "{http://examen.portlet.com}datosB")
	public void procesarDatosB(EventRequest request, EventResponse response) throws PortletException, IOException {
		Event evento = request.getEvent();
		Persona datosB = (Persona) evento.getValue();

		request.setAttribute("datos", datosB);
	}

	@ProcessEvent(qname = "{http://examen.portlet.com}datosC")
	public void procesarDatosC(EventRequest request, EventResponse response) throws PortletException, IOException {
		Event evento = request.getEvent();
		Persona datosC = (Persona) evento.getValue();

		request.setAttribute("datos", datosC);
	}

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		include(viewTemplate, renderRequest, renderResponse);
	}

	protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}

	protected String viewTemplate;

	private static Log _log = LogFactoryUtil.getLog(PortletA.class);
}
