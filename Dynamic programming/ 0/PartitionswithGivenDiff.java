class Solution {
    public int countPartitions(int[] arr, int diff) {
        int sum = 0;
        for (int s : arr) sum += s;

        // CRITICAL: Algebra check
        // 1. (sum + diff) must be even to divide by 2
        // 2. total sum must be at least as large as the diff
        if ((sum + diff) % 2 != 0 || sum < diff) return 0;

        int s1 = (sum + diff) / 2;
        
        // n+1 rows to handle n elements (1 to n) and the base case (0)
        Integer[][] memo = new Integer[arr.length + 1][s1 + 1];
        
        return dp(arr, s1, arr.length, memo);
    }

    public int dp(int[] arr, int target, int n, Integer[][] memo) {
        // Base Case: No elements left to pick
        if (n == 0) {
            return target == 0 ? 1 : 0;
        }

        // Check Memoization table
        if (memo[n][target] != null) {
            return memo[n][target];
        }

        int mod = 1000000007;
        int result;

        // Use arr[n-1] because n is 1-based (count), but array is 0-based
        if (arr[n - 1] <= target) {
            // Include AND Exclude
            result = (dp(arr, target - arr[n - 1], n - 1, memo) + 
                      dp(arr, target, n - 1, memo)) % mod;
        } else {
            // Exclude only
            result = dp(arr, target, n - 1, memo) % mod;
        }

        // Store and return
        return memo[n][target] = result;
    }
}