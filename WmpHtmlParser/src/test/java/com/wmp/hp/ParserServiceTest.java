package com.wmp.hp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ParserServiceTest {
	
	@Test
	public void parserTest1() {
		int length = 0;
		int unit = 0;
		
		String str = "";
		
		assertEquals(0, length * unit);
		assertEquals(0, length * 3);
		assertEquals(0, length / 3);
		assertEquals("", str.substring(0,0));
	}
	
	@Test(expected=ArithmeticException.class)
	public void parserTest2() {
		int length = 0;
		int unit = 0;
		
		assertEquals(0, length / unit);
	}
	
	@Test
	public void parserTest3() {
		String str = "ABCDE";
		
		assertEquals("", str.substring(5));
	}
}
