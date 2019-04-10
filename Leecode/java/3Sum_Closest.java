class Solution {
    public int threeSumClosest(int[] nums, int target) {
     	Arrays.sort(nums);
		int d = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right && left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (Math.abs(sum - target) < d) {
					d = Math.abs(sum - target);
					result = sum;
				}
				if (sum == target) {
					return target;
				} else if (sum > target) {
					while (left < right && nums[right] == nums[right - 1])
						right--;
					right--;
				} else {
					while (left < right && nums[left] == nums[left + 1])
						left++;
					left++;
				}
			}
		}
		return result;   
    }
}