class Solution {
    public int[] solution(int n, int m) {
        if(n > m)
        {
            int tmp = n;
            n = m;
            m = tmp;
        }
        
        int[] answer = new int[2];
        
        for(int i = 1; i <= n; i++)
        {
            if(n % i == 0 && m % i == 0)
            {
                answer[0] = i;
            }
        }
        
        answer[1] = ((int) n / answer[0]) * ((int) m / answer[0]) * answer[0];
        
        return answer;
    }
}