//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombination {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        HashMap<Integer , String> map = new HashMap<>();
        map.put(2 , "abc");
        map.put(3 , "def");
        map.put(4 , "ghi");
        map.put(5 , "jkl");
        map.put(6 , "mno");
        map.put(7 , "pqrs");
        map.put(8 , "tuv");
        map.put(9 , "wxyz");
        StringBuilder sb = new StringBuilder();
        findCombination(digits , map ,ans , 0 , sb);
        return ans;
    }
    public void findCombination(String digits ,HashMap<Integer , String> map ,  List<String> ans,int idx , StringBuilder sb){
         // Base case: one letter chosen for each digit
        if(idx == digits.length()){
            ans.add(sb.toString());
            return;
        }
         // Convert current digit character to integer
        int digit = digits.charAt(idx) - '0'; // char → int
         // Letters corresponding to current digit
        String letters = map.get(digit);
          // loop over letters, NOT digits
        for(int i=0 ; i < letters.length() ; i++){
           
            sb.append(letters.charAt(i));
            findCombination(digits , map ,ans , idx+1 , sb);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
