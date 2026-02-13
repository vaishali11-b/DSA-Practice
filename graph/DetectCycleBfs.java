import java.util.*;

class DetectCycleBfs {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Fix 1: Correct type initialization
        boolean[] visited = new boolean[V]; 

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                visited[i] = true;
                queue.add(new int[]{i, -1}); // {current_node, parent}
                
                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    int node = curr[0];
                    int parent = curr[1];
                    
                    for (int it : adj.get(node)) {
                        if (!visited[it]) {
                            // Fix 2: Mark the NEIGHBOR as visited, not 'i'
                            visited[it] = true; 
                            queue.add(new int[]{it, node});
                        } else if (it != parent) {
                            // If visited and not the parent, a cycle exists
                            return true;
                        }
                    }
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
        adj.get(0).add(1);
        adj.get(1).add(0);
        System.out.println(adj);
                
        DetectCycleBfs obj = new DetectCycleBfs();
        System.out.println(obj.isCycle(V, adj) ? "1" : "0");
    }
}
