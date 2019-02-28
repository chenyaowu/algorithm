/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
  		int sum ,t = 0;
		ListNode result = new ListNode(0);
		ListNode temp = result;
		while(l1 != null || l2 != null){
			
			int val1 = 0,val2 = 0;
			if(l1 != null){ val1 = l1.val;}
			if(l2 != null){val2 = l2.val;}
			
			sum = val1 + val2 + t;
			t = sum/10;
			
			temp.next = new ListNode(sum%10);
			temp = temp.next;
			
			if(l1 != null){	l1 = l1.next;}
			if(l2 != null){l2 = l2.next;}
		}
		
		if(t != 0){	temp.next = new ListNode(t);}
		
		return result.next;


    }
}