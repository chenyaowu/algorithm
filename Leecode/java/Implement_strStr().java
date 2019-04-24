class Solution {
    public int strStr(String haystack, String needle) {
       if (needle.length() <= 0 || needle == null || haystack == null) {
			return 0;
		}
		char[] t = haystack.toCharArray(); 
		char[] p = needle.toCharArray(); 
		int i = 0;
		int j = 0;
		int[] next = getNext(needle);
		while (i < t.length && j < p.length) {
			if (j == -1 || t[i] == p[j]) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}

		if (j == p.length) {
			return i - j;
		} else {
			return -1;
		}
	}

	public int[] getNext(String needle) {
		char[] p = needle.toCharArray();
		if (p.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[p.length];
		next[0] = -1;
		int j = 0;
		int k = -1;
		while (j < p.length - 1) {
			if (k == -1 || p[j] == p[k]) {
				if (p[++j] == p[++k]) {
					next[j] = next[k];
				} else {
					next[j] = k;
				}
			} else {
				k = next[k];
			}
		}
		return next;
	}
}