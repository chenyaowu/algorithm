class Solution {
    public String longestCommonPrefix(String[] strs) {
      if (strs != null && strs.length > 0) {
			if (strs.length == 1) {
				return strs[0];
			} else {
				StringBuilder sb = new StringBuilder();
				String temp = strs[0];

				for (int j = 0; j < temp.length(); j++) {
					for (int i = 1; i < strs.length; i++) {
						if (j > strs[i].length()-1) {
							return sb.toString();
						}
						if (temp.charAt(j) != strs[i].charAt(j)) {
							return sb.toString();
						}
					}
					sb.append(temp.charAt(j));
				}
				return sb.toString();

			}
		}
		return "";  
    }
}