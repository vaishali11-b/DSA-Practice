import java.util.ArrayList;

public class DetectCycleDfs {
    public boolean DetectCycleBfs(int V , ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V];

        for(int i=0 ; i < V ; i++){
            if(!visited[i])
                dfs(adj , visited , i , -1);
        }
        return false;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj ,boolean[] visited , int i , int parent){

        visited[i] = true;
        for(int it : adj.get(i)){
            if(!visited[i]){
                dfs(adj , visited , it , i);
            }else{
                if(it != parent){
                    return true;
                }
            }
        }
        

        return false;
    }
    public static void main(String[] args) {
        int V = 3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // Example: 1-2, 2-3,3-1 (No cycle)
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(0);
        adj.get(0).add(2);
        //adj.get(0).add(1);
       // adj.get(1).add(0);
        System.out.println(adj);
                
        DetectCycleBfs obj = new DetectCycleBfs();
        System.out.println(obj.isCycle(V, adj) ? "1" : "0");
    }
}
//Detect cycle in directed graph
class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
        }
        boolean[] visited = new boolean[V];
        boolean[] currPath = new boolean[V];
        for(int i=0 ; i < V ; i++){
            if(!visited[i]){
                if(dfs(adj , visited , currPath , i , -1)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj  , boolean[] visited ,
    boolean[] currPath , int i , int parent){
        if(currPath[i]){
            return true;
        }
        if(visited[i]){
            return false;
        }
        
        visited[i] = true;
        currPath[i] = true;
        
        for(int it : adj.get(i)){
            if(!visited[it]){
                dfs(adj , visited , currPath , it , i);
            }
                if(currPath[it]){
                    //System.out.println("it"+it + "i"+i);
                   return true; 
                }
        }
        currPath[i]=false;
        return false;
    }
}
