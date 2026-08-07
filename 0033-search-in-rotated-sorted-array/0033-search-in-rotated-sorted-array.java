class Solution {
    public int srch(int arr[], int key, int si, int ei){
        if(si>ei){
            return -1;
        }
        int mid=si+(ei-si)/2;
        if(arr[mid]==key){
            return mid;
        }

        if(arr[si]<=arr[mid]){
            if(arr[si]<=key && key<=arr[mid]){
                return srch(arr, key, si, mid-1);
            }else{
                return srch(arr, key, mid+1, ei);
            }
        }else{
            if(arr[mid]<=key && key<=arr[ei]){
                return srch(arr, key, mid+1, ei);
            }else{
                return srch(arr, key, si, mid-1);
            }
        }
    }

    public int search(int[] nums, int target) {
        return srch(nums, target, 0, nums.length-1);
    }
}