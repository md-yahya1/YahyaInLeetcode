class Solution {
    public int subtractProductAndSum(int n) {
        
        int sum = 0;
        int prod = 1;

        int x = n;
        while(x > 0)
        {
            int digit = x%10;
            sum = sum + digit;
            prod = prod * digit;
            x /= 10;
        }
        return prod - sum;
    }
}