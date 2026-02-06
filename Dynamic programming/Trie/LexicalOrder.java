//https://leetcode.com/problems/lexicographical-numbers/?envType=problem-list-v2&envId=trie
import java.util.ArrayList;
import java.util.List;

public class LexicalOrder {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for(int i=1 ; i <= 9 ; i++){
            //it recursively check for 1,10,11,12,13 ,14 -fails , so comes back to 2 and so on.
            findLexicalOrder(i ,n , ans);
        }
        return ans;
    }
    public void findLexicalOrder(int ind ,int n ,List<Integer> ans){
        if(ind > n){
            return;
        }
        //if(!ans.contains(ind)){
            ans.add(ind);
        //}
        //
        for(int i=0 ; i<= 9 ; i++){
            int next = ind *10+i;
            if(next <= n){
                findLexicalOrder(next ,n , ans);
            }else{
                break;
            }

        }
    }
}
//time complexity
// The total number of operations is proportional to the number of elements generated, which is n
