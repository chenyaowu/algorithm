/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<ListNode>();
		ListNode temp = head;
		while (temp != null) {
			stack.add(temp);
			temp = temp.next;
		}

		while (n-- > 0) {
			temp = stack.pop();
		}
		if (stack.size() == 0) {
			return temp.next;
		}
		ListNode leftNode = stack.pop();
		leftNode.next = temp.next;

		return head;
    }
}