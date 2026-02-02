//https://leetcode.com/problems/palindrome-partitioning/


import java.util.ArrayList;
import java.util.List;

public class PalindromeSubstring {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        palindromePartition(s , 0 , ans , new ArrayList<>());
        return ans;
    }
    // Backtracking function
    // start -> current index in string from where partitioning starts
    // partition -> current path (one possible partition)
    public void palindromePartition(String s ,int start ,List<List<String>> ans ,List<String> partition){
        // Base case: entire string is used
        if(start == s.length()){
            ans.add(new ArrayList<>(partition));
            return;
        }
    
    // Try all possible cuts starting from 'start'
        for(int end = start ; end < s.length() ; end++){
            if(findPalindrome(s , start , end)){
                partition.add(s.substring(start , end+1));
                 // Explore remaining string
                palindromePartition(s ,end+1 , ans , partition);
                // Un-choose (backtrack)
                partition.remove(partition.size()-1);
            }
        }
    }
    public boolean findPalindrome(String s , int left , int right){
        
        while(left >= 0 && right <s.length() && left<=right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
