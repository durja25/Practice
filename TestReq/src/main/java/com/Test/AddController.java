package com.Test;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Test.service.AddService;

@Controller
public class AddController 
{
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("t1") String t1, @RequestParam("t2") String t2)
	{
		int i=Integer.parseInt(t1);
		int j=Integer.parseInt(t2);
		
		AddService as =new AddService();
		int k = as.add(i, j); 
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("result",k);
		
		return mv;
	}
}
