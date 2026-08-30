class Solution {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src=s;
            this.dest=d;
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Edge> graph[]= new ArrayList[numCourses];
        for(int i=0; i< numCourses; i++){
            graph[i]= new ArrayList<>();
        }
        for(int[] pre: prerequisites){
            graph[pre[1]].add(new Edge(pre[1], pre[0]));
        }

        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<numCourses; i++){
            if(!vis[i]){
               if(hasCycle(graph, i, vis, stack, s)){
                    return new int[0];
               }
            }
        }

        int result[] = new int[numCourses];
        for(int i=0; i<result.length; i++){
            result[i]=s.pop();
        }
        return result;
    }

    public boolean hasCycle(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[], Stack<Integer> s){
        vis[curr]=true;
        stack[curr]=true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }else if(!vis[e.dest] && hasCycle(graph, e.dest, vis, stack, s)){
                return true;
            }
        }
        stack[curr]=false;
        s.push(curr);
        return false;
    }
}