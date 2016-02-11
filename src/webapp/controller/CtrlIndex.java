package webapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CtrlIndex {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {	
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("home", model);
	}
	
	@RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
	public ModelAndView aboutUs() {
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("aboutUs", model);
	}
}
