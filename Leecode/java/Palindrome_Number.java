class Solution {
    public boolean isPalindrome(int x) {
        StringBuilder sb = new StringBuilder(x + "");
		return sb.reverse().toString().equals(x + "");
    }
}