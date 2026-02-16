package matrix;
//https://leetcode.com/problems/search-a-2d-matrix-ii/description/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        //if target < end[0]
        int i=0 , j=n-1;
        while(0<= i && i < m && j >= 0 && j < n){
            if(matrix[i][j] == target){
                return true;
            }else if(target < matrix[i][j]){
                j--;
            }else{
                i++;
            }
            }
           return false; 
        }
    }
