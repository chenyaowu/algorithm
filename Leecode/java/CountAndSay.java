class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        // 获取前一个
        String str = countAndSay(n - 1);
        // 返回
        StringBuffer res = new StringBuffer();
        int length = str.length();

        int head = 0;
        for (int i = 1; i < length + 1; i++) {
            if (i == length) {
                res.append(i - head).append(str.charAt(head));
            } else if (str.charAt(i) != str.charAt(head)) {
                res.append(i - head).append(str.charAt(head));
                head = i;
            }
        }

        return res.toString();

    }
}