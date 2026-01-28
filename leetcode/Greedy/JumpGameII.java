package Greedy;

public class JumpGameII {
    public int jump(int[] nums) {
        // jumps: The total number of jumps made.
        // current_end: The boundary of the current jump's reach.
        // farthest: The farthest index reachable from any position within the current jump's range. 
        int jumps = 0 , curr_end = 0 , farthest = 0;
        // Iterate to second-to-last index (n - 2). (We stop before the last index because once we reach it, no more jumps are needed).
        for(int i=0 ; i < nums.length-1 ; i++){
            farthest = Math.max(farthest , nums[i]+i);
            if(i == curr_end){
                curr_end = farthest;
                jumps++;
            }
        }
        return jumps;
    }
    // This approach guarantees the minimum number of jumps because at each step, we greedily   select the jump that would give us the maximum possible reach for the next jump, effectively minimizing the number of "levels" needed to cover the entire array. 
}

