import java.util.Arrays;

public class LongestCommonParenthesis {
    //solution 1: horizontal scanning approach it takes O(N*M) time complexity
    public String longestCommonPrefix1(String[] strs) {

        for(int i=0 ; i < strs[0].length() ; i++){
            char ch = strs[0].charAt(i);

            for(int j=1 ; j < strs.length ; j++){
                if(i >= strs[j].length() || ch!=strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

//solution 2: sorting and comparing first and last string only
    public String longestCommonPrefix2(String[] strs) {
        Arrays.sort(strs);
        String ans = strs[0];
        for(int i=1 ; i < strs.length ; i++){
            String curr = strs[i];
            int len = Math.min(curr.length() , ans.length());
            System.out.println("curr = " + curr + ", len = "+ len);
            int j=0;
            while(j < len){
                if(ans.charAt(j) == curr.charAt(j)){
                    j++;
                }else
                    break;        
            }
            ans = curr.substring(0,j);
        }
        return ans.toString();
    }

    
}
//solution 3: using trie data structure
class TrieNode{
    TrieNode[] children;
    boolean flag;
    TrieNode(){
        flag = false;
        children = new TrieNode[26];
    }
    public boolean contains(char ch){
        return (children[ch - 'a']!=null);
    }
    public void put(char ch , TrieNode node){
        children[ch - 'a'] = node;
    }
    public TrieNode get(char ch){
        return children[ch - 'a'];
    }
    public boolean hasOnlyOneChild(){
        int count = 0;
        for(int i=0 ; i < children.length ; i++){
            if(children[i]!=null){
                count++;
            }
        }
        return count == 1? true : false;
    }
    public void setEnd(){
        flag = true;
    }
    public boolean isEnd(){
        return flag;
    }
}
class Solution1 {
    public String longestCommonPrefix(String[] strs) {
       
        TrieNode root = new TrieNode();
        TrieNode node = root;
        //first insert all the strings in the trie
        String ans = strs[0];
        for(int i=0 ; i < strs.length; i++){
            node = root;
            for(int j=0 ; j < strs[i].length() ; j++){
                char ch = strs[i].charAt(j);
                if(!node.contains(ch)){
                    node.put(ch , new TrieNode());
                }
                node = node.get(ch);
            }
            node.setEnd();
        }
        //search with any string and check where the node has only one child or not
        node = root;
        int i=0;
        while(i < strs[0].length()){
           char ch = strs[0].charAt(i);
           if(node.hasOnlyOneChild() && !node.isEnd()){
                node = node.get(ch);
                i++;
            }else{
                break;
            }
        }
        return ans.substring(0,i);
    }
}

