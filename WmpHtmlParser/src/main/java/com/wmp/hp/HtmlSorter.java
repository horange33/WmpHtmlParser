package com.wmp.hp;

import java.util.Arrays;
import java.util.Comparator;

public class HtmlSorter {
	public String[] sortStr(String str) {
		/*char[] temp = str.toCharArray();
		String[] tmp = new String[temp.length];
				
		for(int i=0;i<temp.length;i++) {
			tmp[i] = String.valueOf(temp[i]);
		}*/
		
		String[] tmp = str.split("");
		
		 Arrays.sort(tmp, (String o1, String o2) -> { 
			 if(o1.compareToIgnoreCase(o2) == 0)
				 return o1.compareTo(o2);
			 else
				 return o1.compareToIgnoreCase(o2); 
		 });
		 
		 
		return tmp;
	}
	
}