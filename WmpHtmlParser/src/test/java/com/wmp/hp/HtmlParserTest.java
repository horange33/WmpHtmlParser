package com.wmp.hp;

import static org.junit.Assert.*;

import org.junit.Test;

public class HtmlParserTest {

	URLReader url = new URLReader();
	HtmlParser parser = new HtmlParser();
	String urlStr = "https://12bme.tistory.com/157";
	String urlStr2 = "https://www.naver.com/";
	
	@Test
	public void parserTest1() {
		
		String temp = parser.removeHtmlTag(url.getElements(urlStr));
		
		assertNotNull(temp);
	}
	
	@Test
	public void parserTest2() {
		
		String temp = parser.removeHtmlTag(null);
		
		assertNull(temp);
	}
	
	@Test
	public void parserTest3() {
		//System.out.println(url.getElements(urlStr));
		String temp = parser.removeSpecialTag(url.getElements(urlStr));
		
		//System.out.println(temp);
	}
	
	@Test
	public void parserTest4() {
		//System.out.println(url.getElements(urlStr2));
		String temp = parser.removeSpecialTag(url.getElements(urlStr2));
		
		//System.out.println(temp);
	}
	
	@Test
	public void parserLengthTest() {
		System.out.println(url.getElements(urlStr2).length());
		String temp = parser.removeSpecialTag(url.getElements(urlStr2));
		
	}
}
