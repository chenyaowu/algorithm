class Solution {
    public boolean isValid(String s) {
     Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '}') {
				if (stack.size() == 0 || stack.pop() != '{') {
					return false;
				}

			} else if (c == ']') {
				if (stack.size() == 0 || stack.pop() != '[') {
					return false;
				}

			} else if (c == ')') {
				if (stack.size() == 0 || stack.pop() != '(') {
					return false;
				}

			} else {
				stack.add(c);
			}
		}
		if (stack.size() == 0) {
			return true;
		}
		return false;
 
    }
}