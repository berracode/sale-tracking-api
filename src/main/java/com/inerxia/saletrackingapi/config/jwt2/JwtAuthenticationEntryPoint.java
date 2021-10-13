package com.inerxia.saletrackingapi.config.jwt2;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inerxia.saletrackingapi.util.StandardResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest req, HttpServletResponse response, AuthenticationException e)
			throws IOException, ServletException {


		response.setCharacterEncoding("UTF-8");
		
		StandardResponse standardResponse = new StandardResponse(StandardResponse.EstadoStandardResponse.ERROR,
				"Error en la autenticación: "+"Usuario no autenticado o el token expiro " + e.getMessage());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setContentType("application/json");
		response.getWriter().write(new ObjectMapper().writeValueAsString(standardResponse));
		
	}

}
