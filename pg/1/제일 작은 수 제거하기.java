class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1)
        {
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        int[] answer = new int[arr.length-1];
        
        int min = 0;
        
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[min] > arr[i])
            {
                min = i;
            }
        }
        int a = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(min != i)
                answer[a++] = arr[i];
        }
        
        return answer;
    }
}