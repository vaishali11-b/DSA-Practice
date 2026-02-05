// Problem Link: https://leetcode.com/problems/n-queens/
import java.util.ArrayList;
import java.util.List;

public class NQueen {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] sol  = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                sol[i][j] = '.';
        }
        findNQueens(n, 0, sol, ans);
        return ans;
        
    }

    public void findNQueens(int n, int x, char[][] sol, List<List<String>> ans) {

        if (x == n) {
            // process solution into final return format
            StringBuilder sb = new StringBuilder();
            List<String> listStr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                sb.setLength(0);
                for (int j = 0; j < n; j++) {
                    sb.append(sol[i][j]);
                }
                listStr.add(sb.toString());
            }
            ans.add(listStr);
            return;
        }
        for (int y = 0; y < n; y++) {
            if (sol[x][y] == 'Q') continue;
            if (canPlaceQueen(n,x, y, sol)) {
                sol[x][y] = 'Q';
                findNQueens(n, x + 1, sol, ans);
                sol[x][y] = '.';
            }
        }
    }

    public boolean canPlaceQueen(int n ,int x, int y, char[][] board){
        // check vertically
        for (char[] row : board) {
            //checking yth col for each row
            if (row[y] == 'Q')
                return false;
        }
        // check horizontally
        for (char i : board[x]) {
            if (i == 'Q')
                return false;
        }
        // check right-diagonal (/)
        // towards UP
        for (int i = x - 1,j = y + 1; i >= 0 && j < n ; i--,j++) {
                if (board[i][j] == 'Q') 
                    return false;
            
        }
        // towards DOWN
        for (int i = x + 1 , j = y - 1; i < n && j >= 0 ; i++ , j--) {
                if (board[i][j] == 'Q') 
                    return false;
        }
        // check left-diaonal (\)
        //to up
        for(int i = x-1,j= y -1 ; i >= 0 && j >= 0; i--,j--){
                if(board[i][j] == 'Q')
                    return false;
        }
        //towards down
        for(int i = x+1 ,j= y+1; i < n && j < n ; i++ ,j++){
                if(board[i][j] == 'Q')
                    return false;
        }
        return true;
    }
}