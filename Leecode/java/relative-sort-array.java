class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
       int res[] = new int[arr1.length];
		int index = 0;
		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		for (int i : arr1) {
			Integer count = map1.get(i);
			if (count == null) {
				map1.put(i, 1);
			} else {
				map1.put(i, count + 1);
			}
		}

		for (int i : arr2) {
			int count = map1.get(i);
			while (count > 0) {
				res[index++] = i;
				count--;
			}
			map1.remove(i);
		}
		Set<Integer> set = map1.keySet();
		List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);
		for (int i : list) {
			int count = map1.get(i);
			while (count > 0) {
				res[index++] = i;
				count--;
			}
		}

		return res;
    }
}