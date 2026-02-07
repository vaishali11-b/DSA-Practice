//https://www.geeksforgeeks.org/problems/prefix-match-with-other-strings/1?page=1&category=Trie&company=Samsung&sortBy=latest
package Strings;

public class Prefixmatchwithothestrings {
    public int klengthpref(String[] arr, int n, int k, String str) {
        // code here
        if(str.length() < k){
            return 0;
        }
        String s = str.substring(0,k);
        int count = 0;
        for(int i=0 ; i < arr.length ; i++){
            String st = arr[i];
            if(st.length() >= s.length() && st.substring(0,k).equals(s)){
                count++;
            }
        }
        return count;
        
    }
}
