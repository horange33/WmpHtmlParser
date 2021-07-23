package com.wmp.hp;

import java.util.Arrays;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ParserController {
	
	@Autowired
	private ParserService parserService;
	
	private static final Logger logger = LoggerFactory.getLogger(ParserController.class);
	
	@RequestMapping(value = "/")
	public String home(Model model, HttpServletRequest request) {
		
		return "/search";
	}
	
	@RequestMapping(value = "/search")
	public String search(Model model, HttpServletRequest request) {
		if(request.getParameter("strURL") != null || "null".equals(request.getParameter("strURL"))) {
			parserService = new ParserService(request.getParameter("strURL")
					 ,request.getParameter("strType")
					 ,Integer.parseInt(request.getParameter("leng")));
			
			String sortedStr = parserService.getSortedString(parserService.getParseString());
			String ansNumStr = parserService.getAnswerNum(sortedStr);
			String ansRemainStr = parserService.getAnswerRemainder(sortedStr);
			
			model.addAttribute("parserNum1", ansNumStr.length()/Integer.parseInt(request.getParameter("leng")));
			model.addAttribute("parserNum2", ansRemainStr.length());
			model.addAttribute("parserInfo1", ansNumStr);
			model.addAttribute("parserInfo2", ansRemainStr);
		} else {
			model.addAttribute("parserNum1", 0);
			model.addAttribute("parserNum2", 0);
			model.addAttribute("parserInfo1", "-");
			model.addAttribute("parserInfo2", "-");
		}
		return "/WEB-INF/views/parser_view.jsp";
	}
	
}