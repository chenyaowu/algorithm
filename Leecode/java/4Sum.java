class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if(i!=0 && nums[i] == nums[i-1]) continue;
			for (int j = i + 1; j < nums.length - 1; j++) {
				if(j-1 != i  && nums[j] == nums[j-1]) continue;
				int l = j + 1;
				int r = nums.length - 1;
				while (l < r) {
					int sum = nums[i] + nums[j] + nums[l] + nums[r];
					if (sum == target) {
						result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
						while (l < r && nums[l] == nums[l + 1]) l++;
						while (l < r && nums[r] == nums[r - 1]) r--;
						l++; r--;
					} else if (sum > target) {
						while (l < r && nums[r] == nums[r - 1]) r--;
						r--;
					} else {
						while (l < r && nums[l] == nums[l + 1]) l++;
						l++;
					}

				}
			}
		}

		return result;
    }
}