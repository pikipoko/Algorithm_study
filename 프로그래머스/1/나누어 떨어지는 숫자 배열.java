class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer1 = new int[arr.length];
        
        int cnt = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] % divisor == 0)
            {
                answer1[cnt] = arr[i];
                cnt++;
            }
        }
        
        if(cnt == 0)
        {
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        int[] answer = new int[cnt];
        
        for(int i = 0; i < cnt; i++)
        {
            answer[i] = answer1[i];
        }
        
        for(int i = 0; i < cnt - 1; i++)
        {
            for(int j = 0; j < cnt - 1; j++)
            {
                if(answer[j] > answer[j+1])
                {
                    int tmp = answer[j];
                    answer[j] = answer[j+1];
                    answer[j+1] = tmp;
                }
            }
            
        }
        
        return answer;
    }
}