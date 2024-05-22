class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0 ; i< board.length ; i++){
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            for(int j=0; j < board.length ; j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(row.contains(board[i][j])){
                    return false;
                }
                row.add(board[i][j]);
            }
            for(int j=0; j < board.length ; j++){
                if(board[j][i]=='.'){
                    continue;
                }
                if(col.contains(board[j][i])){
                    return false;
                }
                col.add(board[j][i]);
            }
        }
        Set<Character>[][] sudoku = new HashSet[3][3];
        int n = board.length ; 
        for(int i=0 ; i < n ; i++){
            for(int j=0 ; j < n ; j++){
                if(sudoku[i/3][j/3] == null) {
                    sudoku[i/3][j/3] = new HashSet<>();
                }
                if(sudoku[i/3][j/3].contains(board[i][j])){
                    return false;
                }else{
                    char cellValue = board[i][j];
                    if (cellValue != '.') {
                    sudoku[i/3][j/3].add(Character.valueOf(cellValue));
                    }
                }
                //System.out.print(sudoku[i/3][j/3]);
            }
        }
        return true;
    }
}
