class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = 1; 
        int B[] = new int[A.length];
        for(int a: A){
            if(a%2 == 0){
                B[i] = a;
                i+=2;
            }else{
                B[j] = a;
                j+=2;
            }
        }
        return B;
    }
}