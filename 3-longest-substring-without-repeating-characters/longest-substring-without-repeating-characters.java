
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int right = 0;
        int answer = 0;

        HashSet<Character> map = new HashSet<>();

        while (right < s.length()) {
            if (!map.contains(s.charAt(right))) {
                map.add(s.charAt(right));

                answer = Math.max(answer, right - left + 1);
                right++;
            } else {
                map.remove(s.charAt(left));
                left++;
            }
        }

        return answer;
    }
}
