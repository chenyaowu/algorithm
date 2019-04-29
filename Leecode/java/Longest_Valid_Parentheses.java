class Solution {
    public int longestValidParentheses(String s) {
    	int res = 0, start = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); ++i) {
			char a = s.charAt(i);
			if (a == '(') {
				stack.push(i);
			} else if (a == ')') {
				if (stack.empty()) {
					start = i + 1;
				} else {
					stack.pop();
					res = stack.empty() ? Math.max(res, i - start + 1) : Math.max(res, i - stack.peek());
				}
			}
		}
		return res;
    }
}