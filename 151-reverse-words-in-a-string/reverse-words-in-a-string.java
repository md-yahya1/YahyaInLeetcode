class Solution {
    public String reverseWords(String s) {
        
        String rev[] = s.trim().split("\\s+");

        int i=0;
        int j=rev.length-1;

        while(i<j)
        {
            String temp = rev[i];
            rev[i] = rev[j];
            rev[j] = temp;

            i++;
            j--;
        }

        return String.join(" ", rev);
    }
}