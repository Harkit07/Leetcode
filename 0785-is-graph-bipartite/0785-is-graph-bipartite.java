class Solution {
    public boolean isBipartite(int[][] graph) {
        int col[] = new int[graph.length];
        for(int i=0; i<col.length; i++){
            col[i]=-1;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<graph.length; i++){
            if(col[i]==-1){
                col[i]=0;
                q.add(i);
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j=0; j<graph[curr].length; j++){
                        int neigh = graph[curr][j];
                        if(col[neigh]==-1){
                            int nextCol = col[curr]==0?1:0;
                            col[neigh]=nextCol;
                            q.add(neigh);
                        }else if(col[curr]==col[neigh]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}