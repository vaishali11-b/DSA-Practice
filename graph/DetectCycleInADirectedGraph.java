package graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInADirectedGraph {
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0,1} , {0,2} , {1,2} , {2,0} , {2,3}};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
        }
        
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }
        boolean[] vis = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        for(int i=0 ; i < numCourses ; i++){
            if(!vis[i]){
                if(dfs(i , vis , adj ,recStack))
                    return false;
            }
        }
        return true;
        
    }
    public boolean dfs(int i , boolean[] vis , List<List<Integer>> adj , boolean[] recStack){
        if(recStack[i]){
            return true;
        }
        if(vis[i]){
            return false;
        }

        vis[i] = true;
        recStack[i] = true;

        for(int it : adj.get(i)){
            if(dfs(it , vis , adj , recStack)){
                return false;
            }
        }

        recStack[i] = false;
        return true;
    }
}