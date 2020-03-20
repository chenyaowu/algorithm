class Solution {
    public int searchInsert(int[] nums, int target) {
        int mid = nums.length / 2;
        if (target == nums[mid])
            return mid;
        if (target > nums[mid]) {
            return searchInsert(nums, mid + 1, nums.length - 1, target);
        } else {
            return searchInsert(nums, 0, mid, target);
        }
    }

     private int searchInsert(int[] nums, int left, int right, int target) {
        if (left >= right) {
            if (target > nums[right]) {
                return right + 1;
            } else {
                return right;
            }
        }

        int mid = (left + right) / 2;
        if (target == nums[mid])
            return mid;
        if (target > nums[mid]) {
            return searchInsert(nums, mid + 1, right, target);
        } else {
            return searchInsert(nums, left, mid, target);
        }
    }
}