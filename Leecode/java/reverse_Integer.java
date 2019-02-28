class Solution {
    public int reverse(int x) {
         	int result = 0;
    	while(x!=0){
    		int pop = x%10;
    		if(Integer.MAX_VALUE / 10 < result || (result == Integer.MAX_VALUE / 10 && pop>7)) return 0;
    		if(Integer.MIN_VALUE / 10 > result || (result == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
    		result = result *10 + pop;
    		x = x/10;
    	}
    	return result;
    }
}
