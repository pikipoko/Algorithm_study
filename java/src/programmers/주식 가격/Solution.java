import java.util.*;

class Solution {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        ArrayList<Integer> idx = new ArrayList<>();

        for(int n = 1; n < prices.length; n++)
        {
            int c = n-1;
            int curr = prices[c];
            int next = prices[n];
            System.out.printf("curr[%d] next[%d] answer[%s->", curr, next, Arrays.toString(answer));

            if(curr <= next)
            {
                idx.addLast(c);
            }
            else
            {
                // next < curr
                while(!idx.isEmpty() && prices[c] > prices[n])
                {
                    answer[c] = n - c;
                    c = idx.removeLast();
                }
                if(prices[c] > prices[n])              // 마지막 pop된 값도 처리
                    answer[c] = down;
            }
            curr = next;
            System.out.printf("%s]\n", Arrays.toString(answer));
        }

        for(int i = 0; i < prices.length; i++)
        {
            if(answer[i] == 0)
                answer[i] = prices.length - i - 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new int[]{1, 2, 3, 2, 3})));
        System.out.println(Arrays.toString(sol.solution(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(sol.solution(new int[]{1, 2, 5, 1, 4, 1})));
        System.out.println(Arrays.toString(sol.solution(new int[]{1, 2, 5, 0, 1})));
    }
}