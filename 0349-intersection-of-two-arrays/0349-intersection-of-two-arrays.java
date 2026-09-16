class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums1.length; i++){
            set.add(nums1[i]);
        }
        int n = nums1.length>nums2.length?nums1.length:nums2.length;
        int res[] = new int[n];
        int count = 0;
        for(int i=0; i<nums2.length; i++){
            if(set.contains(nums2[i])){
                set.remove(nums2[i]);
                res[count] = nums2[i];
                count++;
            }
        }
        return Arrays.copyOf(res, count);
    }
}