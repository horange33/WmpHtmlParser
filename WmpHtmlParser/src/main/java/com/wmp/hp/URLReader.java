package com.wmp.hp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
 
 
public class URLReader {
	
	private static URLReader reader = null;
	
	URLReader() {
	}

	public synchronized static URLReader getInstance() {
		if (reader == null)
			reader = new URLReader();
		return reader;
	}
	
	public String getElements(String strUrl) {
		StringBuffer sbuf = new StringBuffer();
         
        try {
            URL url = new URL(strUrl);
             
            URLConnection urlConn = url.openConnection();
             
            InputStream is = urlConn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
             
            String str;
            while((str=br.readLine()) != null){
            	sbuf.append(str) ;
            }
            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return sbuf.toString();
	}
	
 
}