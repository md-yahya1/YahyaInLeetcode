class Solution {
    public int maxVowels(String s, int k) {

        int count = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        int max = count;

        for (int i = 0, j = k; j < s.length(); i++, j++) {

            if (isVowel(s.charAt(i))) {
                count--;
            }

            if (isVowel(s.charAt(j))) {
                count++;
            }

            max = Math.max(max, count);
        }

        return max;
    }

    private boolean isVowel(char ch) {
        return ch == 'a'
                || ch == 'e'
                || ch == 'i'
                || ch == 'o'
                || ch == 'u';
    }
}