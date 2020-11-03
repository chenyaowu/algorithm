class Solution {
    public boolean validMountainArray(int[] A) {
        if (A.length <= 2) {
			return false;
		}

        boolean b = true;

		for (int i = 1; i < A.length; i++) {

			if (b && A[i - 1] >= A[i]) {
				b = false;
			}
			if (!b && (A[i - 1] <= A[i] || i == 1)) {
				return false;
			}

		}

		return !b;
    }
}