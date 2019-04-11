class Solution {
    public List<String> letterCombinations(String digits) {
        if("".equals(digits)){
			return new LinkedList<String>();
		}
        char c[][] = new char[10][4];
		c[2][0] = 'a';
		c[2][1] = 'b';
		c[2][2] = 'c';

		c[3][0] = 'd';
		c[3][1] = 'e';
		c[3][2] = 'f';

		c[4][0] = 'g';
		c[4][1] = 'h';
		c[4][2] = 'i';

		c[5][0] = 'j';
		c[5][1] = 'k';
		c[5][2] = 'l';

		c[6][0] = 'm';
		c[6][1] = 'n';
		c[6][2] = 'o';

		c[7][0] = 'p';
		c[7][1] = 'q';
		c[7][2] = 'r';
		c[7][3] = 's';

		c[8][0] = 't';
		c[8][1] = 'u';
		c[8][2] = 'v';

		c[9][0] = 'w';
		c[9][1] = 'x';
		c[9][2] = 'y';
		c[9][3] = 'z';

		LinkedList<String> result = new LinkedList<String>();
		result.add("");
		for (int i = 0; i < digits.length(); i++) {
			int t = digits.charAt(i) - 48;
			int size = result.size();
			for (int j = 0; j < size; j++) {
				String tempStr = result.pollFirst();
				for (int k = 0; k < c[t].length; k++) {
					if (c[t][k] != 0) {
						result.addLast(tempStr + c[t][k]);
					}

				}
			}

		}

		return result;
    }
}