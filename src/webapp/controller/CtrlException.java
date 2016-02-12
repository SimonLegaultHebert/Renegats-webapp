package webapp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CtrlException {

	@ExceptionHandler(Exception.class)
	  public ModelAndView handleError(HttpServletRequest req, Exception exception) {
	    //logger.error("Request: " + req.getRequestURL() + " raised " + exception);
		System.out.println("EXCEPTION : " + exception);
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("home", model);
	  }
}
