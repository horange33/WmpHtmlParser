package com.wmp.hp;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class HtmlSorterTest {
	private String beforeString = ""
			+ "<html>"
			+ "<head>"
			+ "<script src=\"/script/main.js\"></script>"
			+ "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\"/>"
			+ "<meta charset=\"utf-8\"/>" 
			+ "<title>여기랑wefwe..<wdw> </title>"
			+ "</head>"
			+ "</body>"
			+ "<div id=\"id1\" style=\"display:block;width:100px;height:100px\" class=\"class\">여기만 출력되면 정상</div>"
			+ "</body>"
			+ "</html>";
	
	
	@Test
	public void sortStrTest() {
		String str = "KDLSfjsdlkfjSLDFJKsksjhjgjeqfqwopaAAAfiptohsdsdkdvbvmggJLSDJHjklfwjefklewj";
		
		/*char[] temp = str.toCharArray();
		String[] tmp = new String[temp.length];
				
		for(int i=0;i<temp.length;i++) {
			tmp[i] = String.valueOf(temp[i]);
		}*/
		
		String[] tmp = str.split("");
		
		 /*Arrays.sort(tmp, new Comparator<String>() {
			 @Override
			 public int compare(String o1, String o2) { 
				 if(o1.compareToIgnoreCase(o2) == 0)
					 return o1.compareTo(o2);
				 else
					 return o1.compareToIgnoreCase(o2); 
			 }
		 });*/
		 
		 Arrays.sort(tmp, (String o1, String o2) -> { 
			 if(o1.compareToIgnoreCase(o2) == 0)
				 return o1.compareTo(o2);
			 else
				 return o1.compareToIgnoreCase(o2); 
		 });
		 
		 for(int i=0;i<tmp.length;i++) {
			 System.out.print(tmp[i]);
		 }
		 System.out.println();
		
	}
	
	@Test
	public void sortStrTest2() {
		String str = "KDLSfjsdlkfjSLDFJKsksjhjgjeqfqwopaAAAfiptohsdsdkdvbvmggJLSDJHjklfwjefklewj";

		HtmlSorter sorter = new HtmlSorter();
		String[] s = sorter.sortStr(str);
		 
		 for(int i=0;i<s.length;i++) {
			 System.out.print(s[i]);
		 }
		 System.out.println(str);
		
	}
	
	@Test
	public void sortStrTest3() {
		String str = "KDLSfjsdlkfjSLDFJKsksjhjgjeqfqwopaAAAfiptohsdsdkdvbvmggJLSDJHjklfwjefklewj";

		String[] tmp = str.split("");
		System.out.println();
		for(int i=0;i<tmp.length;i++)
		{
			System.out.print(tmp[i]);
		}System.out.println();
	}
}
