package com.dnb.DevConnector.utils;

import java.util.Arrays;
import java.util.List;

public class Converter {
	public List<String> stringToArray(String commaSeparated) {
		String [] arrayStr = commaSeparated.split("\\s*,\\s*");
		List<String>ans=Arrays.asList(arrayStr);
		return ans;
	}
	
//	public String arrayToString(String[] array) {
//		String str = String.join(",", array);
//		return str;
//	}
}
