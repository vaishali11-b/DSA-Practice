/**
    In our virtual 10-ary tree, each number can have children (by adding digits at the end), and we move in a preorder traversal: explore deep (children), then move to siblings, then backtrack to the parent when needed.

    Here's the breakdown:
    *Going Deeper (curr = 10)
    → e.g., from 1 to 10 to 100
    → This is like going down the left-most branch of the tree.

    Going to Next Sibling (curr++)
    → e.g., from 1 to 2, or from 12 to 13
    → As long as curr + 1 ≤ n and it doesn’t end in 9.

    Backtracking (curr //= 10)
    → When you can't go deeper or to a valid sibling, you need to backtrack to a parent and then try its next sibling.
*/

import java.util.*;

class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> output = new ArrayList<>();
        int curr =1;
        for(int i=0 ; i < n ; i++){
            output.add(curr);
            if( curr*10 <= n){
                curr *= 10;
            }else{
            
                while(curr % 10 == 9 || curr+1 > n){
                    curr /= 10;
                }
                curr++;
            }
        
        }
        return output;
    }
}
