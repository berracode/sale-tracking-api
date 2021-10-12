package com.inerxia.saletrackingapi.config;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.common.net.HttpHeaders;



@Component
public class CORSFilter extends OncePerRequestFilter {


	private final List<Pattern> corsAllowedOriginPatterns = new ArrayList<>();

	/**
	 * Una lista de patrones de expresión regular delimitada por comas que definen
	 * qué orígenes pueden verificar con exito la comprobación CORS.
	 */
	@Value("#{'${cors.origins}'.split(',')}")
	private List<String> corsAllowedOrigins;

	/**
	 * Una lista de patrones de expresión regular delimitada por comas que definen
	 * qué headers pueden verificar con exito la comprobación CORS.
	 */
	@Value("#{'${cors.headers}'.split(',')}")
	private List<String> allowedHeaders;

	/**
	 * Una lista de patrones de expresión regular delimitada por comas que definen
	 * qué methods pueden verificar con exito la comprobación CORS.
	 */
	@Value("#{'${cors.methods}'.split(',')}")
	private List<String> allowedMethods;

	@Value(value = "${cors.maxage}")
	private String maxAge;

	@PostConstruct
	public void initialize() {

		if (this.corsAllowedOrigins != null) {
			for (String allowedOrigin : this.corsAllowedOrigins) {
				this.corsAllowedOriginPatterns.add(Pattern.compile(allowedOrigin));
			}
		}
	}

	@Override
	protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
			final FilterChain filterChain) throws ServletException, IOException {

		String origin = request.getHeader(HttpHeaders.ORIGIN); // ver si puedo usar builder o final

		if (origin != null) {

			if (!esOrigenPermitidoEnCors(origin)) {
				System.out.println("Hola");
			}
			response.addHeader("Access-Control-Allow-Origin", "*");

		}
		System.out.println("validando cors");

		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Authorization, content-type, xsrf-token, Access-Control-Allow-Headers");
		response.addHeader("Access-Control-Expose-Headers", "xsrf-token");

		if ("OPTIONS".equals(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			filterChain.doFilter(request, response);
		}

	}

	private boolean esOrigenPermitidoEnCors(final String origin) {
		for (Pattern pattern : this.corsAllowedOriginPatterns) {
			if (pattern.matcher(origin).find()) {
				return true;
			}
		}
		return false;
	}

}