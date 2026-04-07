import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sumD= 0;
        Arrays.sort(d);
        
        for(int i = 0; i < d.length; i++)
        {
            sumD += d[i];
            if(sumD <= budget)
            {
                answer = i+1;
            }
        }
        return answer;
    }
}