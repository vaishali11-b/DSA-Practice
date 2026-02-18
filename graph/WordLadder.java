package graph;
import java.util.*;
//https://leetcode.com/problems/word-ladder/description/
class Pair{
    String word;
    int i;
    Pair(String word , int i){
        this.word = word;
        this.i = i;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       
        Set<String> set = new HashSet<>(wordList);
        //if the end word is not present in the set then we can return 0
        if(!set.contains(endWord)) return 0;
        Queue<Pair> queue = new LinkedList<>();
        //we are adding the begin word to the queue and removing it from the set
        queue.add(new Pair(beginWord , 1));
        set.remove(beginWord);
        //we are doing bfs and for each word we are replacing each character with all the characters from a to z and if the replaced word is present in the set then we are adding it to the queue and removing it from the set
        while(!queue.isEmpty()){
            String word = queue.peek().word;
            int c = queue.peek().i;
            queue.remove();
            //if the word is equal to the end word then we can return the count
            if(word.equals(endWord)) return c;
            //we are replacing each character of the word with all the characters from a to z and if the replaced word is present in the set then we are adding it to the queue and removing it from the set
            for(int i=0 ; i < word.length() ; i++){
                for(char ch = 'a' ; ch <= 'z' ; ch++){
                    char[] replacedChar = word.toCharArray();
                    replacedChar[i] = ch;
                    String replacedWord = new String(replacedChar);
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        queue.add(new Pair(replacedWord , c+1));
                    }
                }
            
            }
        }
        //if we are here then it means that there is no path from the begin word to the end word and we can return 0
        return 0;
    }
}
