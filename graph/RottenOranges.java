package graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        //we will add all the rotten oranges to the queue and count the number of fresh oranges as well
        for(int r=0 ; r < m ; r++){
            for(int c=0 ; c < n ; c++){
                if(grid[r][c] == 2){
                    queue.add(new int[]{r,c});
                }else if(grid[r][c] == 1) fresh++;
            }
        }
        if (fresh == 0) return 0;
        int[][] dirs = {{-1,0} , {1,0} , {0 , -1} ,{0,1}};
        int minutes = 0;
        //we will do a bfs and for every rotten orange we will check its 4 directions and if there is a fresh orange then we will rot it and add it to the queue and decrease the count of fresh oranges as well and we will also keep track of the minutes taken to rot all the oranges
        while(!queue.isEmpty()){
            //size of the queue will give us the number of rotten oranges in the current minute and we will process all of them in one go and then increase the minutes by 1 after processing all the rotten oranges in the current minute
            int size = queue.size();
            boolean rottedThisTurn = false;

            for(int i=0 ; i < size ; i++){
                int[] curr = queue.poll();
                for(int[] dir : dirs){
                    int rowB = curr[0]+dir[0];
                    int colB = curr[1]+dir[1];
                    //if the adjacent cell is within the grid and has a fresh orange then we will rot it and add it to the queue and decrease the count of fresh oranges as well and we will also keep track of the minutes taken to rot all the oranges
                    if(0<=rowB && rowB<m && 0<=colB && colB<n && grid[rowB][colB] == 1){
                        grid[rowB][colB] = 2;
                        queue.add(new int[]{rowB,colB});
                        fresh--;
                        rottedThisTurn = true;
                    }
                }
            
            }
            //we will only increase the minutes if at least one orange got rotted in this turn
            if (rottedThisTurn) minutes++;
        }
    return fresh == 0 ? minutes : -1;
    }
}
