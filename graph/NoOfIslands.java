package graph;

import java.util.HashSet;
//Question Link : https://leetcode.com/problems/number-of-islands/
public class NoOfIslands {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        HashSet<String> visited = new HashSet<>();
        int count = 0;
        //to check all the components
        for(int r=0 ; r < m ; r++){
            for(int c=0 ; c < n ; c++){
                if(dfs(grid , visited , r , c ,m ,n)){
                    count++;
                }
            }
        }
        return count;
    }
    //we will check for every node if it is a land and if it is a land then we will check for all its neighbours and mark them as visited as well and we will return true if we find a land and false if we find a water or if we go out of bounds or if we find a land that is already visited
    public boolean dfs(char[][] grid , HashSet<String> visited , int r , int c , int m , int n){
        boolean inRowBound = 0<=r && r<m;
        boolean inColBound = 0<=c && c<n;

        if(!inRowBound || !inColBound){
            return false;
        }

        if(grid[r][c] == '0'){
            return false;
        }

        String s = r+","+c;
        System.out.println("pos = "+ s);
        if(visited.contains(s)){
            return false;
        }

        visited.add(s);
        //explore all the neighbours
        dfs(grid , visited , r-1 , c ,m ,n);
        dfs(grid , visited , r , c+1 ,m ,n);
        dfs(grid , visited , r+1 , c ,m ,n);
        dfs(grid , visited , r , c-1 ,m ,n);

        return true;
    }
}

//using bfs
//we can also use bfs to solve this problem as well we will use a queue to store
//the nodes that we need to explore and we will mark them as visited as well and we will return true if we find a land and false if we find a water or if we go out of bounds or if we find a land that is already visited

//Using BFS
class Solution1 {
    public int numIslands1(char[][] grid) {
        if(grid ==null || grid.length=='0'){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
       
        int count = 0;
        //to check all the components
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int r=0 ; r < m ; r++){
            for(int c=0 ; c < n ; c++){
                if(grid[r][c] == '1'){
                    count += 1;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{r,c});
                    grid[r][c] = '0';
                   
                    while(!queue.isEmpty()){
                        int[] cell = queue.poll();
                        for(int[] dir : directions)
                        {
                            int rowBound = cell[0]+dir[0];
                            int colBound = cell[1]+dir[1];

                            if(0 <= rowBound && rowBound < m && 0 <= colBound && colBound < n && grid[rowBound][colBound] == '1'){
                            grid[rowBound][colBound] = '0';
                            queue.offer(new int[]{rowBound ,colBound});
                        }
                        }
                    }
                }
            }
        }
        
        return count;
    }
   
}
