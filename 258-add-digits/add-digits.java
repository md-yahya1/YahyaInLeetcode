class Solution {
    public int addDigits(int num) {
        
        int x = num;
        if(x < 10)
        {
            return x;
        }
        while(x >= 10)
        {
            int sum = 0;
            while(x > 0)
            {
                int digit = x%10;
                sum += digit;

                x /= 10;
            }
            x = sum;
        }

        return x;
    }
}