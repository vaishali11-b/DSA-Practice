import java.util.*;


class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        //for memoization
        int[] memo = new int[n+1];
        Arrays.fill(memo , -1);
        return dp(nums , 0 , memo);
    }
    public int dp(int[] nums , int n , int[] memo){
        if(n >= nums.length){
            return 0;
        }
        if(memo[n] != -1){
            return memo[n];
        }
        //if we taking the current element
        int include = nums[n]+dp(nums , n+2 , memo);
        //if we are not considering current element
        int exclude = dp(nums , n+1 , memo);

        memo[n] =  Math.max(include , exclude);

        return memo[n];
    }

}
