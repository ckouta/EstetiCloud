package com.barberia.springboot.app.auth.handler;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.SessionFlashMapManager;

@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		/*
		 * // set our response to OK status
		 * response.setStatus(HttpServletResponse.SC_OK);
		 * 
		 * boolean admin = false;
		 * 
		 * logger.info("AT onAuthenticationSuccess(...) function!");
		 * 
		 * for (GrantedAuthority auth : authentication.getAuthorities()) { if
		 * ("ROLE_ADMIN".equals(auth.getAuthority())) { admin = true; } }
		 * 
		 * if (admin) { response.sendRedirect("/barbero/listar"); } else {
		 * response.sendRedirect("/user"); }
		 * 
		 */

		SessionFlashMapManager flashMapManager = new SessionFlashMapManager();

		FlashMap flashMap = new FlashMap();

	
		String mensaje = String.format("text.login.success");
				

		flashMap.put("success", mensaje);

		flashMapManager.saveOutputFlashMap(flashMap, request, response);

		if (authentication != null) {
			logger.info(mensaje);
		}

		super.onAuthenticationSuccess(request, response, authentication);

	}

}
