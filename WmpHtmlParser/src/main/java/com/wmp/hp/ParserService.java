package com.wmp.hp;

import org.springframework.stereotype.Service;

@Service("parserService")
public class ParserService {
	
	private String url;
	private String type;
	private int unit;

	ParserService() {
		url = "";
		type = "0";
		unit = 0;
	}
	
	ParserService(String url, String type, int unit) {
		this.url = url;
		this.type = type;
		this.unit = unit;
	}
	
	public String getParseString() {
		URLReader urlReader = URLReader.getInstance();
		HtmlParser parser = new HtmlParser();

		if(type.equals("1")) {
			return parser.removeHtmlTag(urlReader.getElements(url));
		} else if(type.equals("2")) {
			return parser.removeSpecialTag(urlReader.getElements(url));
		} else {
			return urlReader.getElements(url);
		}
	}
	
	public String getSortedString(String sortingStr) {//in parse string
		HtmlSorter sorter = new HtmlSorter();
		HtmlParser parser = new HtmlParser();
		
		String result = "";
		int i=0;
		
		String[] sortedNum = sorter.sortStr(parser.removeHtmlNum(sortingStr));
		String[] sortedStr = sorter.sortStr(parser.removeHtmlStr(sortingStr));
		
		while(i<Math.max(sortedNum.length, sortedStr.length)) {
			if(i<sortedStr.length)
				result = result.concat(sortedStr[i]);
			if(i<sortedNum.length)
				result = result.concat(sortedNum[i]);
			i++;
		}
		
		return result;
	}
	
	public String getAnswerNum(String sortedStr) {
		int num = 0;
		try {
		 num = sortedStr.length() / unit;
		} catch(NumberFormatException e) {
			System.out.println(e);
		}
		
		return sortedStr.substring(0, num * unit);
	}
	
	public String getAnswerRemainder(String sortedStr) {
		int num = 0;
		try {
		 num = sortedStr.length() / unit;
		} catch(NumberFormatException e) {
			System.out.println(e);
		}
		
		return sortedStr.substring(num * unit);
	}
}
