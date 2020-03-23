class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<Integer>();
        searchSum(candidates, 0, target, list, result);
        return result;
    }

     public void searchSum(int[] candidates, int l, int target, List<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = l; i < candidates.length; i++) {
            if(target - candidates[i] <0 ){
                break;
            }
            list.add(candidates[i]);
            searchSum(candidates, i, target - candidates[i], list, result);
            list.remove(list.size() - 1);
        }
    }
}