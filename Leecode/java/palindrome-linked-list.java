class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        List<Integer> list = new ArrayList<Integer>();
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        if (list.size() == 1) {
            return true;
        }

        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i).intValue() != list.get(list.size() - 1 - i).intValue()) {
                return false;
            }
        }

        return true;
    }
}