//https://takeuforward.org/plus/dsa/problems/frog-jump?tab=description
class Solution {
    public int frogJump(int[] heights) {

        int[] memo = new int[heights.length];
        Arrays.fill(memo , -1);
        return dp(heights.length-1 , heights , memo);
        
    }
    public int dp(int n , int[] heights , int[] memo){

        if(n == 0){
            return 0;
        }
        if(memo[n]!= -1){
            return memo[n];
        }
        int left = dp(n-1 , heights , memo) + Math.abs(heights[n]-heights[n-1]);
        int right = Integer.MAX_VALUE;
        if(n > 1){
            right = dp(n-2 , heights , memo) + Math.abs(heights[n]-heights[n-2]);
        }
        return memo[n] = Math.min(left , right);
    }
}
