package Greedy;

import java.util.Arrays;
import java.util.TreeMap;

public class HandOfStraights {
    //https://leetcode.com/problems/hand-of-straights/submissions/1900498797/
    //brute force using greedy O(n2)
    public boolean isNStraightHand(int[] nums, int k) {
        if (nums.length % k != 0) return false;


        Arrays.sort(nums);
        for(int i=0 ; i < nums.length ; i++){
            if(nums[i] != -1){
                if(!findSize(nums, i, nums.length, k)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean findSize(int[] nums,int i , int n , int k){
        int curr = nums[i];
        nums[i] = -1;
        int count =1;
         for (int j = i + 1; j < n && count < k; j++) { 
            if(nums[j] == curr+1){
                curr = nums[j];
                nums[j] = -1;
                count++;
    
            }
        }
        return count == k;
    }

    //solution 2 O(n log n)
    class Solution {
    public boolean isNStraightHand(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        //stores sorted by key
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(int num : nums){
            tm.put(num , tm.getOrDefault(num , 0)+1);
        }
        while(!tm.isEmpty()) {
            //gets the first key in sorted order
            int start = tm.firstKey();
            for(int i=0 ; i < k ; i++){
                int curr = start + i;
                if(!tm.containsKey(curr)){
                    return false;
                }
                int value = tm.get(curr);
                if(value == 1){
                    tm.remove(curr);
                }else{
                    tm.put(curr , value-1);
                }
            }
        }
        return true;
    }
}

}

