// Given a graph with V vertices and E edges, represented as an edge list, print the adjacency list of the graph. The graph can be either directed or undirected based on the input.
package graph;
import java.util.*;
public class Printadjacencylist {

    public List<List<Integer>> printGraph(int V, int edges[][]) {
        Map<Integer , List<Integer>> adj = new LinkedHashMap<>();
        
         // Step 1: Initialize the map for all vertices 0 to V-1
        for (int i = 0; i < V; i++) {
            adj.put(i, new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
           
            adj.get(u).add(v);
            adj.get(v).add(u); // Remove this line if the graph is Directed
        }
        //return a List<List<Integer>> rather than Collection<List<Integer>>
        return new ArrayList<>(adj.values());
    }
    //to make sure correct order of vertices in the adjacency list we can use List<List<Integer>> instead of Map<Integer , List<Integer>>
    public List<List<Integer>> printGraph1(int V, int edges[][]) {
        List<List<Integer>> adj = new ArrayList<>();
        
         // Step 1: Initialize the map for all vertices 0 to V-1
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
           
            adj.get(u).add(v);
            adj.get(v).add(u); // Remove this line if the graph is Directed
        }
        //return a List<List<Integer>> rather than Collection<List<Integer>>
        return adj;
    }
    public static void main(String[] args) {
        Printadjacencylist obj = new Printadjacencylist();
        int V = 5;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}};
        List<List<Integer>> adjList = obj.printGraph(V, edges);
        System.out.println(adjList);
    }
}
