import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n , 0 , 0 , ans , "");
        return ans;
        
    }
    public void generate(int n , int open , int close , List<String> ans , String temp){
        if(temp.length() == n*2){
            ans.add(temp);
            return;
        }
        if(open < n){
            generate(n , open+1 , close , ans , temp+'(');
        }
        if(close < open){
            generate(n , open , close+1 , ans , temp+')');
        }
    }
}
//using StringBuilder to optimize string concatenation 
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        buildParanthesis(0 , 0 , n , ans , sb);
        return ans;
    }
    public void buildParanthesis(int openC , int closeC , int n , List<String> ans , StringBuilder sb){
        if(sb.length() == n*2){
            ans.add(new String(sb.toString()));
            return;
        }

        if(openC < n){
            buildParanthesis(openC+1 , closeC , n , ans , sb.append('('));
            sb.deleteCharAt(sb.length() - 1);
        }
        if(closeC < openC){
            buildParanthesis(openC , closeC+1 , n , ans , sb.append(')'));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
