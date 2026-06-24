class Solution {
    public int arrayPairSum(int[] nums) {
          Arrays.sort(nums);
        
        int sum = 0;
        
        // Step 2: Take elements at even indices
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        
        return sum;
    }
}