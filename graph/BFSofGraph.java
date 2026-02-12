package graph;
import java.util.*;
//Question Link : https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        
        int src = 0;
        Queue<Integer> q = new LinkedList<>();
        visited[0] = true;
        q.add(src);
        
        
        while(!q.isEmpty()){
            int curr = q.poll();
            res.add(curr);
            
            for(int i : adj.get(curr)){
                if(!visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return res;
        }
        
        
    }


