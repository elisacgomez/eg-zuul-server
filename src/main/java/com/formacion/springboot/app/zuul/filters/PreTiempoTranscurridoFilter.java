package com.formacion.springboot.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/*
 * Autor: Elisa Gomez
 * 
 * Fuente: Udemy
 * Curso: microservicios-con-spring-boot-y-spring-cloud
 * 
 * Descripcion:
 * Practica con Filter de Zuul.
 * Video 28: Zuul Filtro HTTP pre - Tiempo Transcurrido
 */


@Component
public class PreTiempoTranscurridoFilter extends ZuulFilter{

	private static Logger log = LoggerFactory.getLogger(PreTiempoTranscurridoFilter.class);
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info(String.format("%s request enrutado a %s", request.getMethod(), request.getRequestURL().toString()));
		
		Long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio);
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
