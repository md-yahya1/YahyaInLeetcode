class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> answer = new ArrayList<>();

        if(digits == null || digits.length() == 0)
        {
            return answer;
        }

        HashMap<Character, String> set = new HashMap<>();

        set.put('2',"abc");
        set.put('3',"def");
        set.put('4',"ghi");
        set.put('5',"jkl");
        set.put('6',"mno");
        set.put('7',"pqrs");
        set.put('8',"tuv");
        set.put('9',"wxyz");

        backtrack(digits, answer, set, new StringBuilder(), 0);

        return answer;
    }

    public void backtrack(String digits, List<String> answer, HashMap<Character, String> set, StringBuilder str, int index)
    {
        if(index == digits.length())
        {
            answer.add(str.toString());
            return;
        }

        String letters = set.get(digits.charAt(index));
        for(char ch : letters.toCharArray())
        {
            str.append(ch);
            backtrack(digits, answer, set, str, index + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }
}