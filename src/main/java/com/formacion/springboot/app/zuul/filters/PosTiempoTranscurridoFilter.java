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
 * Video 29: Zuul Filtro HTTP pos - Tiempo Transcurrido
 */


@Component
public class PosTiempoTranscurridoFilter extends ZuulFilter{

	private static Logger log = LoggerFactory.getLogger(PosTiempoTranscurridoFilter.class);
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info("Entrando a post filter");
		
		Long tiempoInicio = (Long)request.getAttribute("tiempoInicio");
		Long tiempoFinal = System.currentTimeMillis();
		Long tiempoTranscurrido = tiempoFinal - tiempoInicio;
		
		log.info(String.format("Tiempo transcurrido en milisegundos %s miliseg.", tiempoTranscurrido));
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
