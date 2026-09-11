class Solution {
    static class Pair implements Comparable<Pair>{
        int x;
        int y;
        int distSq;

        public Pair(int x, int y, int distSq){
            this.x=x;
            this.y=y;
            this.distSq=distSq;
        }

        @Override
        public int compareTo(Pair p2){
            return this.distSq - p2.distSq;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0; i<points.length; i++){
            int distSq = points[i][0]*points[i][0]+points[i][1]*points[i][1];
            pq.add(new Pair(points[i][0], points[i][1], distSq));
        }
        int res[][]=new int[k][2];
        int j=0;
        while(j<k){
            Pair p = pq.poll();
            res[j][0]=p.x;
            res[j][1]=p.y;
            j++;
        }
        return res;
    }
}