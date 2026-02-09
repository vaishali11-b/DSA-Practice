package graph;

import java.util.ArrayList;

public class DFSofGraph {
//adj is the adjacency list of the graph , we are given adj list in this question
//we create adj list using the edges given in the input and then we call the dfs function to traverse the graph
//Sample Input 1:
// 5 4
// 0 2
// 0 1
// 1 2
// 3 4
/
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        
        dfs(adj , visited , res , 0);
        return res;
          
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj , boolean[] visited ,
    ArrayList<Integer> res ,int idx){
        
        visited[idx] = true;
        res.add(idx);
        
        for(int i : adj.get(idx)){
            if(!visited[i]){
                dfs(adj , visited , res , i);
            }
        }
    }
}
