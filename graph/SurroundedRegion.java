package graph;
//Question Link : https://leetcode.com/problems/surrounded-regions/
public class SurroundedRegion {
    //we will traverse all the boundaries of the board and we will change the 'O' to '#' for all the 'O's which are connected to the boundaries and then we will change all the remaining 'O's to 'X' and then we will change all the '#' back to 'O' as these are the 'O's which are not surrounded by 'X's
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        //traverse all the boundaries
        int i=0 , j=0;
        for(j=0 ; j < n ; j++){
            if(board[i][j] == 'O'){
                dfs(board , i , j);
            }
        }
        j=0;
        for(i=0 ; i < m ; i++){
            if(board[i][j] == 'O'){
                dfs(board , i , j);
            }
        }
        i=m-1;
        j=0;
        for(j=0 ; j< n ; j++){
            if(board[i][j] == 'O'){
                dfs(board , i , j);
            }
        }
        i=0; j=n-1 ;
        for(i=0 ; i< n ; i++){
            if(board[i][j] == 'O'){
                dfs(board , i , j);
            }
        }
        for(int r=0 ; r < m ; r++){
            for(int c=0 ; c < n ; c++){
                if(board[r][c] == 'O'){
                    board[r][c]= 'X';
            }
        }
        }
        for(int r=0 ; r < m ; r++){
            for(int c=0 ; c < n ; c++){
                if(board[r][c] == '#'){
                    board[r][c]= 'O';
              }
           }
         }
    }
    //dfs to change the 'O's which are connected to the boundaries to '#' so that we can easily identify them later and we will not change them to 'X' as these are the 'O's which are not surrounded by 'X's
    public void dfs(char[][] grid , int i , int j){
        if(i<0 || i>= grid.length || j<0 || j>= grid[0].length|| grid[i][j] !='O'){
            return;
           }
            grid[i][j]= '#';
           dfs(grid , i-1, j);
           dfs(grid , i+1, j);
           dfs(grid , i, j+1);
           dfs(grid , i, j-1);
    }
}
