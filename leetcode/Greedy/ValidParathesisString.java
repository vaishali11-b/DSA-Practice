package Greedy;
public class ValidParathesisString {
    //https://leetcode.com/problems/valid-parenthesis-string/
       public boolean checkValidString(String s) {
        int low = 0;   // minimum number of '(' possible
        int high = 0;  // maximum number of '(' possible
        
        for(char ch : s.toCharArray()){
            if(ch == '('){
                low++;
                high++;
            }
            if(ch == '*'){
                low--;
                high++;
            }

            if(ch == ')'){
                low--;
                high--;
            }

                //to many ')'
            if(high <0){
                return false;
            }
            if(low < 0){
                low = 0;
            }
        }
        

        return low==0;
    }
 }


