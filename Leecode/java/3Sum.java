class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if(i!=0 && nums[i] == nums[i-1]) continue;
			int sum = -nums[i];
			int l = i + 1;
			int r = nums.length - 1;
			while (l < r) {
				if (nums[l] + nums[r] == sum) {
					result.add(Arrays.asList(nums[i], nums[l], nums[r]));
					// 跳过重复值
					while (l < r && nums[l] == nums[l + 1]) l++;
					while (l < r && nums[r] == nums[r - 1]) r--;
					l++;
					r--;
				} else if (nums[l] + nums[r] < sum) {
					while (l < r && nums[l] == nums[l + 1]) l++;
					l++;
				} else {
					while (l < r && nums[r] == nums[r - 1]) r--;
					r--;
				}
			}
		}

		return result;
    }
}