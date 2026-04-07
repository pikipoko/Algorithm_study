class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        
        long sumPrice = 0;
        
        for(int i = 1; i <= count; i++)
        {
            sumPrice += price * i;
        }
        
        answer = sumPrice - money;
        
        if(answer < 0)
            answer = 0;

        return answer;
    }
}