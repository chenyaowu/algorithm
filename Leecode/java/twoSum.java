class Solution {
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length-1);
    	for (int i = 0; i < nums.length; i++) {
    		if(map.get(nums[i]) == null ){
    			map.put(target-nums[i], i);
    		}else{
    			result[0] = map.get(nums[i]);
    			result[1] = i; 
    		}
		}
    	return result;
    }
}