class Solution {
    public int romanToInt(String s) {
        int[] num = new int[89];
		num['A'] = 4;
		num['B'] = 9;
		num['E'] = 40;
		num['F'] = 90;
		num['G'] = 400;
		num['H'] = 900;
		num['I'] = 1;
		num['V'] = 5;
		num['X'] = 10;
		num['L'] = 50;
		num['C'] = 100;
		num['D'] = 500;
		num['M'] = 1000;

		s = s.replaceAll("IV", "A");
		s = s.replaceAll("IX", "B");
		s = s.replaceAll("XL", "E");
		s = s.replaceAll("XC", "F");
		s = s.replaceAll("CD", "G");
		s = s.replaceAll("CM", "H");

		int sum = 0;
 
		for (int i = 0; i < s.length() ; i++) { sum += num[s.charAt(i)]; }

		return sum;
    }
}