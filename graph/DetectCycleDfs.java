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
