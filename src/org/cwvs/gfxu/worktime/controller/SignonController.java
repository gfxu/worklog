package org.cwvs.gfxu.worktime.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cwvs.gfxu.worktime.controller.UserSession;
import org.cwvs.gfxu.worktime.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 */
public class SignonController implements Controller {

	private static Logger logger = LoggerFactory.getLogger(SignonController.class);
	

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		logger.info("user login info is username:"+username+";password:"+password);
		User account = new User();
		if (account == null) {
			return new ModelAndView("Error", "message", "Invalid username or password.  Signon failed.");
		}
		else {
			UserSession userSession = new UserSession(account);
			PagedListHolder myList = new PagedListHolder();
			myList.setPageSize(4);
			userSession.setMyList(myList);
			request.getSession().setAttribute("userSession", userSession);
			String forwardAction = request.getParameter("forwardAction");
			if (forwardAction != null) {
				response.sendRedirect(forwardAction);
				return null;
			}
			else {
				return new ModelAndView("index");
			}
		}
	}

}
