class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1; // nums1合并后最后位置指针
        int q = m - 1; // nums1数组最后元素位置指针
        for (int i = n - 1; i >= 0; i--) {
            while (q >= 0 && nums2[i] < nums1[q]) {
                nums1[p--] = nums1[q--];
            }
            nums1[p--] = nums2[i];
        }
    }
}