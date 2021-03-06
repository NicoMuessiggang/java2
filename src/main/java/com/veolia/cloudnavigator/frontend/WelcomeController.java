package com.veolia.cloudnavigator.frontend;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	@RequestMapping("/_ah/health")
	@ResponseBody
	public String healthy() {
		// Message body required though ignored
		return "Still surviving.";
	}

	@RequestMapping("/")
	public String loginMessage(HttpServletRequest request) {
		String email = request.getHeader("X-Goog-Authenticated-User-Email");
		request.setAttribute("user", email);
		return "welcome";
	}
}