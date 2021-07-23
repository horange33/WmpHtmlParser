package com.wmp.hp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ParserServiceTest {
	
	@Test
	public void parserTest1() {
		//int num = sortedStr.length() / unit;
		//sortedStr.substring(0, num * unit);
		int length = 0;
		int unit = 0;
		int num = length * unit;
		
		String str = "";
		
		assertEquals(0, length * unit);
		//assertEquals(0, length / unit);
		assertEquals(0, length * 3);
		assertEquals(0, length / 3);
		assertEquals("", str.substring(0,0));
		System.out.println(str.substring(0,0));
	}
	
	@Test
	public void parserTest2() {
		String str = "ABCDE";
		
		assertEquals("", str.substring(5));
	}
}
