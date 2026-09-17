class Solution {
    static class Trie{
        Trie children[] = new Trie[26];
        boolean eow = false;
    }

    public void insert(String str, Trie root){
        Trie curr = root;
        for(int i=0; i<str.length(); i++){
            int idx = str.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx] = new Trie();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    String ans = "";

    public void longestWordUtil(Trie root, StringBuilder temp){
        if(root==null){
            return;
        }
        for(int i=0; i<26; i++){
            if(root.children[i]!=null && root.children[i].eow){
                char ch = (char) (i+'a');
                temp.append(ch);
                if(temp.length() > ans.length() || (temp.length() == ans.length() && temp.toString().compareTo(ans) < 0)){
                    ans = temp.toString();
                }
                longestWordUtil(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public String longestWord(String[] words) {
        Trie root = new Trie();
        for(int i=0; i<words.length; i++){
            insert(words[i], root);
        }
        ans = "";
        longestWordUtil(root, new StringBuilder(""));
        return ans;
    }
}