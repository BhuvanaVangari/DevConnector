package com.dnb.DevConnector.utils;

public class Converter {
	public String[] stringToArray(String commaSeparated) {
		String [] arrayStr = commaSeparated.split("\\s*,\\s*");
		return arrayStr;
	}
	
	public String arrayToString(String[] array) {
		String str = String.join(",", array);
		return str;
	}
}
