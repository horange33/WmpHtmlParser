package com.wmp.hp;

import org.junit.Test;

public class HtmlSorterTest {
	private String beforeString = ""
			+ "<html>"
			+ "<head>"
			+ "<script src=\"/script/main.js\"></script>"
			+ "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\"/>"
			+ "<meta charset=\"utf-8\"/>" 
			+ "<title>�����..<wdw> </title>"
			+ "</head>"
			+ "</body>"
			+ "<div id=\"id1\" style=\"display:block;width:100px;height:100px\" class=\"class\">���⸸ ��µǸ� ����</div>"
			+ "</body>"
			+ "</html>";
	
	
	@Test
	public void sorterTest() {
		HtmlSorter sorter = new HtmlSorter();
		
		
	}
}
