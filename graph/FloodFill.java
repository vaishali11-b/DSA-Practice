package graph;

import java.util.LinkedList;
import java.util.Queue;
//Question Link : https://leetcode.com/problems/flood-fill/
public class FloodFill {
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        if(image[sr][sc] == color){
            return image;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});
        //store the original color of the starting cell as we will only change the color of the cells which have the same color as the starting cell and we will also use this original color to check if the adjacent cells have the same color as the starting cell or not
        int original = image[sr][sc];
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            //we will change the color of all the cells in the current level of the bfs and then we will add all the adjacent cells which have the same color as the original color to the queue for processing in the next level of the bfs and we will keep doing this until there are no more cells to process in the queue
            image[sr][sc] = color;
            //level order traversal of the bfs
            for(int i=0 ; i < size ; i++){
                int[] cell = queue.poll();
                for(int[] dir : dirs){
                    int rb = cell[0]+dir[0]; int cb = cell[1]+dir[1];
                    if(0<=rb && rb<m && 0<=cb && cb<n && image[rb][cb]==original){
                        image[rb][cb]=color;
                        queue.add(new int[]{rb,cb});
                    }
                }
            }
        }
        return image;


    }
}
