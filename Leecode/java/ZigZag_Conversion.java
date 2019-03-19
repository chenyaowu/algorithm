class Solution {
    public String convert(String s, int numRows) {
            	if(numRows == 1)
    		return s;	
    	char c[][] = new char[numRows+1][s.length()+1];
    	int j = 0 ,k = 0;
    	boolean b = false;
    	for (int i = 0; i < s.length(); i++) {
    		c[j][k] = s.charAt(i);
    		
    		if(!b){
    			j++;
    		}else{
    			j--;
    			k++;
    		}
    		
    		
    		if(j == numRows-1){
    			b = true;
    		}
    		if(j == 0){
    			b = false;
    		}
    		
		}
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < c.length; i++) {
    		for (int l = 0; l < c[i].length; l++) {
    			if(c[i][l] != 0){
    				sb.append(c[i][l]);
    			}
			}
		}
    	
    	return sb.toString();
     
    }
}
