class Solution {
    public int myAtoi(String str) {
 	str = str.trim();
		if (str.equals("")) { return 0; }
		String numStr = "";
		int i = 0;
		char t = str.charAt(i);
		boolean b = false;
        	int num = 0;
		while (t == '+' || t == '0') {
			if(t == '+'){ num++; }
			i++;
			if (str.length() == i) { return 0; }
			t = str.charAt(i);
		}
		if(num>1){ return 0; }
		if (t == '-') {
			if (i != 0 || str.length() == 1) { return 0; } 
			else { b = true; t = str.charAt(++i); }
		}

		while (t > 47 && t < 58) {
           		i++;
			if (t == '0' && numStr.length() != 0) { numStr += t; } 
			else if (t != '0') { numStr += t; }

			if (i == str.length()) { break; }
			t = str.charAt(i);
		}
		
		if (numStr.equals("")) { return 0; }
	    
        	numStr = b ? "-" + numStr : numStr;
		if (b && numStr.length() > 11) {
			return Integer.MIN_VALUE;
		} else if (!b && numStr.length() > 10) {
			return Integer.MAX_VALUE;
		} else if (b && numStr.length() == 11 && comparison(numStr, "-2147483648")) {
			return Integer.MIN_VALUE;
		} else if (!b && numStr.length() == 10 && comparison(numStr, "2147483647")) {
			return Integer.MAX_VALUE;
		}

		return Integer.parseInt(numStr);

    }
    
    private static boolean comparison(String str, String otherStr) {
		for (int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			char b = otherStr.charAt(i);
			if (a > b) { return true;}
			else if(a<b){ return false;}
		}
		return false;
	}
}
