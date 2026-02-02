public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0 ; i < board.length ; i++){
            for(int j=0 ; j < board[0].length ; j++){
                if(board[i][j] == word.charAt(0)){
                    if(backTrack(board , i , j , visited ,0 , word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean backTrack(char[][] board ,int i , int j , boolean[][] visited ,int k, String word){
        if(k == word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length||visited[i][j]||board[i][j]!=word.charAt(k)){
            return false;
        }
        visited[i][j] = true;
        if(backTrack(board ,i+1,j , visited,k+1,word)||
        backTrack(board ,i-1,j , visited,k+1,word)||
        backTrack(board ,i,j+1 , visited,k+1,word)||
        backTrack(board ,i,j-1 , visited,k+1,word)){
            return true;
        }
        visited[i][j]=false;
        return false;
    }
}