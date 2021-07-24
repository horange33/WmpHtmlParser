package com.wmp.hp;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;

public class HtmlSorterTest {
	
	private String sortedStr = "AAAabDDDddddeeeFffffffgggHhhiJJJjjjjjjjjKKkkkkkLLLlllmooppqqSSSssssstvvwww";
	private String unsortedStr = "KDLSfjsdlkfjSLDFJKsksjhjgjeqfqwopaAAAfiptohsdsdkdvbvmggJLSDJHjklfwjefklewj";
	private String sortedNum = "000000333344444445555555566666666777778888889999";
	private String unsortedNum = "659789463748590600079864565687800648456575433534";
	
	@Test
	public void sortStrTest() {
		
		String[] tmp = unsortedStr.split("");
		 
		 Arrays.sort(tmp, (String o1, String o2) -> { 
			 if(o1.compareToIgnoreCase(o2) == 0)
				 return o1.compareTo(o2);
			 else
				 return o1.compareToIgnoreCase(o2); 
		 });
		 
		 assertEquals(sortedStr, Arrays.stream(tmp).collect(Collectors.joining()));
	}
	
	@Test
	public void sortStrTest2() {

		HtmlSorter sorter = new HtmlSorter();
		String[] s = sorter.sortStr(unsortedStr);
		 
		 assertEquals(sortedStr, Arrays.stream(s).collect(Collectors.joining()));
		
	}
	
	@Test
	public void sortStrTest3() {
		String[] sArr = {""};
		
		HtmlSorter sorter = new HtmlSorter();
		
		
		assertEquals(sArr, sorter.sortStr(""));
	}
	
	@Test
	public void sortStrTest4() {
		
		String[] tmp = unsortedNum.split("");
		 
		 Arrays.sort(tmp, (String o1, String o2) -> { 
			 if(o1.compareToIgnoreCase(o2) == 0)
				 return o1.compareTo(o2);
			 else
				 return o1.compareToIgnoreCase(o2); 
		 });
		 assertEquals(sortedNum, Arrays.stream(tmp).collect(Collectors.joining()));
	}
	
	@Test
	public void sortStrTest5() {
		String[] nArr = {"0"};
		
		HtmlSorter sorter = new HtmlSorter();
		
		
		assertEquals(nArr, sorter.sortStr("0"));
	}
	
}
