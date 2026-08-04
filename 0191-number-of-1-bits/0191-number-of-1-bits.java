class Solution {
    public int hammingWeight(int n) {
        if(n<0) return 0;
        int count=0;
        while(n>0){
            if((n&1)!=0){
                count++;
            }
            n=n>>1;
        }
        return count;
    }
}