class Solution {
    public int[] merge(int arr1[], int arr2[]){
        int temp[] = new int[arr1.length + arr2.length];
        int i=0, j=0, k=0;

        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                temp[k++]=arr1[i++];
            }else{
                temp[k++]=arr2[j++];
            }
        }
        while(i<arr1.length){
            temp[k++]=arr1[i++];
        }
        while(j<arr2.length){
            temp[k++]=arr2[j++];
        }
        return temp;
    }

    public int[] mergeSort(int arr[], int si, int ei){
        if(si>=ei){
            return new int[]{arr[si]};
        }
        int mid = si+(ei-si)/2;
        int left[]= mergeSort(arr, si, mid);
        int right[]= mergeSort(arr, mid+1, ei);
        return merge(left, right);
    }

    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
}