// Implement Trie (Prefix Tree)
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
    public void setEnd(){
        flag = true;
    }
    public boolean isEnd(){
        return flag;
    }

    public TrieNode get(char ch){
        return children[ch - 'a'];
    }
}
public class ImplementTrie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(!node.contains(ch)){
                node.put(ch , new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(!node.contains(ch)){
                return false;
            }
            node = node.get(ch);
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
         TrieNode node = root;
        for(char ch : prefix.toCharArray()){
            if(!node.contains(ch)){
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
