class Solution {
    public List<List<Integer>> generate(int numRows) {
         List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> upList = i == 0 ? null : lists.get(i - 1); //上一行
            List<Integer> newList = new ArrayList<Integer>(); //当前行
            newList.add(1);
            for (int j = 1; j <= i; j++) {
                newList.add(upList.get(j - 1) + (j >= upList.size() ? 0 : upList.get(j)));
            }
            lists.add(newList);
        }

        return lists;
    }
}