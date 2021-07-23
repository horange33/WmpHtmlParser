package com.wmp.hp;

public class HtmlParser {
	//private final String pattern1 = "<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>";
	private final String pattern1 = "<[^>]*>";
	private final String pattern2 = "<!--.*-->";
	private final String pattern3 = "\\s";
	private final String pattern4 = "[^a-zA-Z0-9]";
	private final String pattern5 = "[^0-9]";
	private final String pattern6 = "[^a-zA-Z]";
	
	
	public String removeHtmlTag(String html) {
		return html.replaceAll(pattern1, "")
				.replaceAll(pattern2, "")
				.replaceAll(pattern3, "")
				.replaceAll(pattern4, "");
	}
	
	public String removeHtmlNum(String html) {
		return html.replaceAll(pattern5, "");
	}
	
	public String removeHtmlStr(String html) {
		return html.replaceAll(pattern6, "");
	}
	
	public String removeSpecialTag(String html) {
		return html.replaceAll(pattern3, "")
				.replaceAll(pattern4, "");
	}
	
	/*public String removeSpecialTag(String html, String tag) {
		return html.replaceAll("<(/)?("+tag+")(\\s"+tag+"*=[^>]*)?(\\s)*(/)?>", "");
	}*/
}