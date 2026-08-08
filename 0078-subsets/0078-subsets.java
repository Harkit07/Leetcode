class Solution {
    public void addSubSet(int nums[], List<Integer> current, List<List<Integer>> result, int i){
        if(i==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[i]);
        addSubSet(nums, current, result, i+1);
        current.remove(current.size()-1);
        addSubSet(nums, current, result, i+1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        addSubSet(nums, new ArrayList<>(), result, 0);
        return result;
    }
}