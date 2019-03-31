class Solution {
    public String intToRoman(int num) {
        	int t = num;
		int nums[] = new int[13];
		String s[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		nums[0] = 1000;
		nums[1] = 900;
		nums[2] = 500;
		nums[3] = 400;
		nums[4] = 100;
		nums[5] = 90;
		nums[6] = 50;
		nums[7] = 40;
		nums[8] = 10;
		nums[9] = 9;
		nums[10] = 5;
		nums[11] = 4;
		nums[12] = 1;
		String result = "";
		int i = 0;
		while (t != 0) {
			if (t >= nums[i]) {
				t -= nums[i];
				result += s[i];
			} else {
				i++;
			}
		}

		return result;
	
    }
}