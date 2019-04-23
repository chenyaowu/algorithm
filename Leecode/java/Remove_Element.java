class Solution {
    public int removeElement(int[] nums, int val) {
      
		if (nums.length == 0)
			return 0;
		int head = 0;
		int tail = nums.length - 1;
		while (head <= tail) {
			if (nums[head] == val) {
				nums[head] = nums[tail];
				nums[tail] = val;
				tail--;
			} else {
				head++;
			}

		}

		return head;
	  
    }
}