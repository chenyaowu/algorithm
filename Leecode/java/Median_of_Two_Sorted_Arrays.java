class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int length1 = nums1.length;
        int length2 = nums2.length;
        int total = length1 + length2;
        int index [] = new int[total/2+1];
        int j=0, k=0;
        double result = 0;
        for (int i = 0; i < index.length; i++) {
        	if(j == length1){
        		index[i] = nums2[k++];
        	}else if(k == length2){
        		index[i] = nums1[j++];
        	}else if(nums1[j] >= nums2[k]){
        		index[i] = nums2[k++];
        	}else{
        		index[i] = nums1[j++];
        	}
        	System.out.println(index[i]);
		}
        
        
        if(total%2 ==0){
        	result =(index[total/2-1] + index[total/2]) / 2.0;
        }else{
        	result = index[total/2];
        }
        
        return result;
    } 

}