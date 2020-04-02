class Solution {
    public int missingNumber(int[] nums) {
        int sum = (1 + nums.length) * nums.length / 2;
        for (int i : nums) {
            sum -= i;
        }
       
        return sum;
    }
}