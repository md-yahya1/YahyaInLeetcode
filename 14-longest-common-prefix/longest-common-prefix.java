class TrieNode
{
    TrieNode[] arr = new TrieNode[26];
    boolean isEnd = false;
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        TrieNode root = new TrieNode();

        for(String str : strs)
        {
            TrieNode curr = root;
            for(char ch: str.toCharArray())
            {
                int index = ch - 'a';

                if(curr.arr[index] == null)
                {
                    curr.arr[index] = new TrieNode();
                }

                curr = curr.arr[index];
            }

            curr.isEnd = true;
        }

        StringBuilder ans = new StringBuilder();

        TrieNode curr = root;
        while(true)
        {
            int count = 0;
            int nextIndex = -1;

            for(int i=0; i<26; i++)
            {
                if(curr.arr[i] != null)
                {
                    nextIndex = i;
                    count++;
                }
            }

            if(count != 1 || curr.isEnd)
            {
                break;
            }

            ans.append((char)('a' + nextIndex));

            curr = curr.arr[nextIndex];
        }

        return ans.toString();
    }
}