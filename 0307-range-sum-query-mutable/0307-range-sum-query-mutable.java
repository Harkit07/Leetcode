class NumArray {
    static int tree[];
    static int arr[];
    static int n;

    private void buildTree(int i, int start, int end){
        if(start==end){
            tree[i]=arr[start];
            return;
        }
        int mid = start+(end-start)/2;
        buildTree(2*i+1, start, mid);
        buildTree(2*i+2, mid+1, end);
        tree[i]=tree[2*i+1]+tree[2*i+2];
    }

    public NumArray(int[] nums) {
        arr=nums;
        n = nums.length;
        tree=new int[n*4];
        buildTree(0, 0, n-1);
    }

    private void updateUtil(int i, int si, int sj, int idx, int diff){
        if(idx < si || idx > sj){
            return;
        }
        tree[i]+=diff;
        if(si!=sj){
            int mid = si+(sj-si)/2;
            updateUtil(2*i+1, si, mid, idx, diff);
            updateUtil(2*i+2, mid+1, sj, idx, diff);
        } 
    }
    
    public void update(int index, int val) {
        int diff = val-arr[index];
        arr[index]=val;
        updateUtil(0, 0, n-1, index, diff);
    }
    
    private int getSum(int i,int si, int sj, int qi, int qj){
        if(qi > sj || qj < si){
            return 0;
        }else if(si >= qi && sj <= qj){
            return tree[i];
        }else{
            int mid = si+(sj-si)/2;
            int left = getSum(2*i+1, si, mid, qi, qj);
            int right = getSum(2*i+2, mid+1, sj, qi, qj);
            return left+right;
        }
    }

    public int sumRange(int left, int right) {
       return getSum(0, 0, n-1, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */