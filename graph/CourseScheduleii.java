package graph;

import java.util.ArrayList;
import java.util.Stack;
//https://leetcode.com/problems/course-schedule-ii/description/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];

            adj.get(v).add(u);
         }
          boolean[] visited = new boolean[numCourses];
          boolean[] currPath = new boolean[numCourses];
        //ans array
          int[] ans = new int[numCourses];
          Stack<Integer> st = new Stack<>();
         for(int i=0 ; i < numCourses ; i++){
            if(!visited[i]){
                //if cycle found dfs returns true
                    if(dfs(adj , visited , currPath , i , -1 , st)){
                    // if there is a cycle in the graph and we can return an empty array
                    return new int[]{};
                }
            
            }
         }
         int k=0;
         while(!st.isEmpty()){
            ans[k++] = st.peek();
            st.pop();
         }
         return ans;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj , boolean[] visited , boolean[] currPath , int i , int parent , Stack<Integer> st){

        if(currPath[i]){
            return true;
        }
        if(visited[i]){
            return false;
        }
        

        currPath[i] = true;
        visited[i] = true;

        for(int it : adj.get(i)){
            if(!visited[it]){
                dfs(adj , visited , currPath , it , i , st);
            }
            //if we are here then it means that there is a cycle in the graph and we can return true
            if(currPath[it]){
                return true;
            }
            
        }
        //if we are here then it means that there is no cycle in the graph and we can add the node to the stack
        //0->1->2->3 adj list will be 2->3,0->1,2 , 1->3 and the stack will be 3,2,1,0
        st.push(i);
        currPath[i]=false;
        return false;
    }

}

















