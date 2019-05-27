class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
			return new int[] { -1, -1 };
		}

		int left = findLeft(nums, target);
		int right = findRight(nums, target);
		return new int[] { left, right };
    }
    
    
    private int findLeft(int[] nums, int num) {
        int low = 0;
        int hight = nums.length - 1;
        int mid = 0;
        while (low <= hight) {
            mid = low + (hight - low) / 2;
            if (nums[mid] > num) {
                hight = mid - 1;
            } else if (nums[mid] < num) {
                low = mid + 1;
            } else if (mid - 1 >= low && nums[mid - 1] == num) {
                hight = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
	}
    
    private int findRight(int[] nums, int num) {
        int low = 0;
        int hight = nums.length - 1;
        int mid = 0;
        while (low <= hight) {
            mid = low + (hight - low) / 2;
            if (nums[mid] > num) {
                hight = mid - 1;
            } else if (nums[mid] < num) {
                low = mid + 1;
            } else if (mid + 1 <= hight && nums[mid + 1] == num) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
	}


}
