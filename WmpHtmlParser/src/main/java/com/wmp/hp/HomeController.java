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
public class HomeController {
	
	@Autowired
	private ParserService parserService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		
		if(request.getParameter("strURL") != null || "null".equals(request.getParameter("strURL"))) {
			parserService = new ParserService(request.getParameter("strURL")
					 ,request.getParameter("strType")
					 ,Integer.parseInt(request.getParameter("leng")));
			
			String sortedStr = parserService.getSortedString(parserService.getParseString());
			
			
			System.out.println(parserService.getAnswerNum(sortedStr));
			System.out.println(parserService.getAnswerRemainder(sortedStr));
			model.addAttribute("parserInfo1", parserService.getAnswerNum(sortedStr));
			model.addAttribute("parserInfo2", parserService.getAnswerRemainder(sortedStr));
		} else {
			model.addAttribute("parserInfo1", "-");
			model.addAttribute("parserInfo2", "-");
		}
			
				
		
		
		
		
		//URLReader url = new URLReader();
		//HtmlParser parser = new HtmlParser();
		
		//String temp = parser.removeHtmlTag(url.getElements("https://12bme.tistory.com/157"));
		//System.out.println(parser.removeHtmlNum(temp));
		//System.out.println(parser.removeHtmlStr(temp));
		//HtmlSorter sorter = new HtmlSorter();
		//sorter.sortStr(parser.removeHtmlNum(temp));
		//sorter.sortStr(parser.removeHtmlStr(temp));
		
		//String[] sortedNum = sorter.sortStr(parser.removeHtmlNum(temp));
		//String[] sortedStr = sorter.sortStr(parser.removeHtmlStr(temp));
		
		/*String result = "";
		int i=0;
		while(i<Math.max(sortedNum.length, sortedStr.length)) {
			if(i<sortedStr.length)
				result = result.concat(sortedStr[i]);
			if(i<sortedNum.length)
				result = result.concat(sortedNum[i]);
			i++;
		}*/
		//System.out.println(result);//결과
		
		//System.out.println(request.getParameter("strURL"));
		//Stream<String> stream = Arrays.stream(sorter.sortStr(parser.removeHtmlStr(temp)));
		//stream.forEach(s -> System.out.println("이름 : "+ s));
		
		
		//System.out.println(url.getElements("https://12bme.tistory.com/157"));
		//temp = parser.removeHtmlTag(url.getElements("https://12bme.tistory.com/157"));
		//System.out.println("성민1"+temp);
		//System.out.println(url.getElements("https://joongwoonc.tistory.com/38"));
		//System.out.println(parser.removeHtmlTag(url.getElements("https://joongwoonc.tistory.com/38")));
		//System.out.println(parser.removeHtmlTag2(temp));
		
		/*String tmp = "<html><head><script src=\"./script.js\">alert(\"HI\")</script></head><body>hi...</body></html>";
		System.out.println(parser.removeHtmlTag(tmp));*/

		
		/*String beforeString = ""
				+ "<html>"
				+ "<head>"
				+ "<script src=\"/script/main.js\"></script>"
				+ "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\"/>"
				+ "<meta charset=\"utf-8\"/>" 
				+ "<title>여기랑..<wdw> </title>"
				+ "</head>"
				+ "</body>"
				+ "<div id=\"id1\" style=\"display:block;width:100px;height:100px\" class=\"class\">여기만 출력되면 정상</div>"
				+ "</body>"
				+ "</html>";
		System.out.println(parser.removeHtmlTag(beforeString));*/
		
		return "parser_view";
	}
	
}