class Solution {
    public:
        int climbStairs(int n) {
            if(n < 3)
                return n;
            int results = 1;
            int resultb = 2;
            int temp = resultb;
    
            int i = 3;
    
            while(i <= n)
            {
                temp = resultb;
                resultb = resultb + results;
                results = temp;
                i++;
            }
    
            return resultb;
        }
    };