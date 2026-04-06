import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int cnt = 1;
        
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i-1] != arr[i])
            {
                cnt++;
            }
        }
        int[] answer = new int[cnt];
        
        int a = 1;
        answer[0] = arr[0];
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i-1] != arr[i])
            {
                answer[a++] = arr[i];
            }
        }
        
        return answer;
    }
}