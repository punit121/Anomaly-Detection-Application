package org.apache.commons.lang;

public class StringUtils {

	public static int countMatches(String str1, String search) {
		
		int lastIndex = 0;
		int count = 0;

		while(lastIndex != -1){

		    lastIndex = str1.indexOf(search,lastIndex);

		    if(lastIndex != -1){
		        count ++;
		        lastIndex += search.length();
		    }
		}
		return count;
	}

}
