class Solution {
    public long solution(long n) {
        long answer = 0;
        
        int[] nl = new int[10];
        
        for(long i = 0; i <= 10; i++)
        {
            nl[(int) (n % 10)]++;
            n /= 10;
            if(n <= 0)
                break;
        }
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < nl[9 - i]; j++)
            {
                answer *= 10;
                answer += 9 - i;
            }
        }
        
        return answer;
    }
}