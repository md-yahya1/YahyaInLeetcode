class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        
        if(n == 0)
        {
            return 1;
        }

        int total = 10;
        int unique = 9;
        int choice = 9;

        while(n > 1 && choice > 0)
        {
            unique = unique*choice;
            total += unique;
            choice--;
            n--;
        }

        return total;
    }
}