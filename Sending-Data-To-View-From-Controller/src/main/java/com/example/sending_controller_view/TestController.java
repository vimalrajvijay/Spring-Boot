package com.example.sending_controller_view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@GetMapping("/send1")
	public String sendData1(Model model) {
		model.addAttribute("id", 102);
		model.addAttribute("name", "XYZ");
		model.addAttribute("age", 22);
		return "display";
	}
	
	@GetMapping("/send2")
	public String sendData2(ModelMap map) {
		map.addAttribute("id", 103);
		map.addAttribute("name", "MNO");
		map.addAttribute("age", 23);
		return "display";
	}
	
	@GetMapping("/send3")
	public ModelAndView sendData3() {
		ModelAndView mav = new ModelAndView("display");
		mav.addObject("id", 103);
		mav.addObject("name", "MNO");
		mav.addObject("age", 23);
		return mav;
	}
}
