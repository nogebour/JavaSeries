package utils;

import java.util.ArrayList;

public class ConvertString {
	public static String convertUnicodeToString(String slashed){
		System.out.println("Before convertion :"+slashed);
		ArrayList<String> pieces = new ArrayList<String>();
		while(true){//while there is /uXXXX in the string
			if(slashed.contains("\\u")){
				pieces.add(slashed.substring(0,slashed.indexOf("\\u")));//add the bit before the /uXXXX
				char c = (char) Integer.parseInt(slashed.substring(slashed.indexOf("\\u")+2,slashed.indexOf("\\u")+6), 16);
				slashed = slashed.substring(slashed.indexOf("\\u")+6,slashed.length());
				pieces.add(c+"");//add the  unicode
			}
			else{
				break;
			}
		}
		String temp = "";
		for(String s : pieces){
			temp = temp + s;//put humpty dumpty back together again
		}
		slashed = temp + slashed;
		System.out.println("After convertion :"+slashed);
		return slashed;
	}
	
	public static String replaceBackToLine(String input){
		return input.replace("\n", " ");
	}
}
