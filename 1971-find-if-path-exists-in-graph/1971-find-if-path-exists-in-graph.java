class Solution {
    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    private boolean validPathUtil(ArrayList<Edge> graph[], int src, int dest, boolean vis[]){
        if(src==dest){
            return true;
        }
        vis[src]=true;
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!vis[e.dest] && validPathUtil(graph, e.dest, dest, vis)){
                return true;
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(new Edge(u, v));
            graph[v].add(new Edge(v, u));
        }
        boolean vis[] = new boolean[n];
        return validPathUtil(graph, source, destination, vis);
    }
}