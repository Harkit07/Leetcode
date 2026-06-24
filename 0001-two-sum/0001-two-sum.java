class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] arr = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int i = 0, j = nums.length - 1;

        while (i < j) {
            int sum = arr[i][0] + arr[j][0];

            if (sum == target) {
                return new int[] { arr[i][1], arr[j][1] };
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return new int[] {};
    }
}