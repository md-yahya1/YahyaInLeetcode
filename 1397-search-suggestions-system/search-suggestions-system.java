class Solution {

    class Trie{
        Trie[] arr = new Trie[26];
        List<String> products = new ArrayList<>();
    }

    Trie head = new Trie();

    void insert(String word)
    {
        Trie temp = head;

        for(char ch : word.toCharArray())
        {
            int val = ch - 'a';

            if(temp.arr[val] == null)
            {
                temp.arr[val] = new Trie();
            }

            temp = temp.arr[val];

            if(temp.products.size() < 3)
            {
                temp.products.add(word);
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        Arrays.sort(products);

        for(String product : products)
        {
            insert(product);
        }

        List<List<String>> answer = new ArrayList<>();
        Trie temp = head;

        for(char ch : searchWord.toCharArray())
        {
            int value = ch - 'a';

            if(temp != null)
            {
                temp = temp.arr[value];
            }
            if (temp == null)
            {
                answer.add(new ArrayList<>());
            }
            else
            {
                answer.add(new ArrayList<>(temp.products));
            }

        }
        return answer;
    }
}