class Solution {
    public class Trie{
        Trie children[] = new Trie[26];
        boolean eow = false;

        public Trie(){
        }
    }
    
    private void insert(String word, Trie root){
        Trie curr = root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]= new Trie();
            }
            curr = curr.children[idx];
        }
        curr.eow=true;
    }

    private boolean search(String word, Trie root){
        Trie curr = root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow==true;
    }

    private Map<String, Boolean> memo = new HashMap<>();

    private boolean wordBreakUtil(String str, Trie root){
        if(str.length() == 0){
            return true;
        }

        if(memo.containsKey(str)){
            return memo.get(str);
        }

        for(int i=1; i<=str.length(); i++){
            if(search(str.substring(0, i), root) && wordBreakUtil(str.substring(i), root)){
                memo.put(str, true);
                return true;
            }
        }
        memo.put(str, false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie root = new Trie();
        
        for(int i=0; i<wordDict.size(); i++){
            insert(wordDict.get(i), root);
        }

        return wordBreakUtil(s, root);
    }
}