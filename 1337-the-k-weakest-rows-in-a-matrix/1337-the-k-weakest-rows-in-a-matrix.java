class Solution {
    static class Rows implements Comparable<Rows>{
        int sol;
        int idx;


        public Rows(int sol, int idx){
            this.sol=sol;
            this.idx=idx;
        }
        @Override
        public int compareTo(Rows r2){
            if(this.sol == r2.sol){
                return this.idx-r2.idx;
            }else{
                return this.sol-r2.sol;
            }
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Rows> pq = new PriorityQueue<>();
        for(int i=0; i<mat.length; i++){
            int count =0;
            for(int j=0; j<mat[0].length; j++){
                count+=mat[i][j]==1?1:0;
            }
            pq.add(new Rows(count, i));
        }
        int res[]=new int[k];
        int j=0;
        while(j<k){
            Rows r = pq.poll();
            res[j]=r.idx;
            j++;
        }
        return res;
    }
}