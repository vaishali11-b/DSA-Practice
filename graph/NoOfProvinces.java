package graph;
//Question Link : https://leetcode.com/problems/number-of-provinces/
public class NoOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int noOfComponents = 0;
        //we traverse the graph using dfs and count the number of times we call the dfs function as that will be the number of components in the graph
        for(int i=0 ; i < n ; i++){
            if(!visited[i]){
                visited[i] = true;
                noOfComponents += 1;
                dfs(isConnected , visited , i);
            }
        }
        return noOfComponents;
    }
    //for every node we will check if it is connected to any other node and if it is connected and not visited then we will call the dfs function for that node as well and mark it as visited
    public void dfs(int[][] isConnected , boolean[] visited , int node){

        visited[node] = true;
        for(int i=0 ; i < isConnected.length ; i++){
            if(isConnected[node][i]== 1 && visited[i]!=true){
                dfs(isConnected , visited , i);
            }
        }

    }
}
