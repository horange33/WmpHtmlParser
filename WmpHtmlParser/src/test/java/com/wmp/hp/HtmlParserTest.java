package com.wmp.hp;

import static org.junit.Assert.*;

import org.junit.Test;

public class HtmlParserTest {

	private String beforeString = ""
			+ "<html>"
			+ "<head>"
			+ "<script src=\"/script/main.js\"></script>"
			+ "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\"/>"
			+ "<meta charset=\"utf-8\"/>" 
			+ "<title>여기wefwe..<wdw> </title>"
			+ "</head>"
			+ "</body>"
			+ "<div id=\"id1\" style=\"display:block;width:100px;height:100px\" class=\"class\">여기만 asdas출력되면</div>"
			+ "</body>"
			+ "</html>";
	
	
	URLReader url = new URLReader();
	HtmlParser parser = new HtmlParser();
	String urlStr = "https://12bme.tistory.com/157";
	String urlStr2 = "https://www.naver.com/";
	
	@Test
	public void parserTest1() {
		
		String temp = parser.removeHtmlTag(url.getElements(urlStr));
		
		assertNotNull(temp);
	}
	
	@Test(expected=NullPointerException.class)
	public void parserTest2() {
		
		String temp = parser.removeHtmlTag(null);
		
		assertNull(temp);
	}
	
	@Test
	public void parserTest3() {
		String temp = parser.removeHtmlTag(beforeString);
		
		assertEquals("wefweasdas", temp);
	}
	
	@Test
	public void parserTest4() {
		String temp = parser.removeSpecialTag("<html><body>fd3</body></html>");
		
		assertEquals("htmlbodyfd3bodyhtml", temp);
		
	}
	
	@Test
	public void parserTest5() {
		String temp = parser.removeSpecialTag("<html><body></body></html>");
		
		assertEquals("htmlbodybodyhtml", temp);
	}
	
	@Test
	public void parserTest6() {
		String temp = parser.removeHtmlTag("<html><body></body></html>");
		
		assertEquals("", temp);
	}
}
