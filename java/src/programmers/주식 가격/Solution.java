import java.util.*;

class Solution {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        ArrayList<Integer> up = new ArrayList<>();
        int curr = prices[0];

        for(int i = 1; i < prices.length; i++)
        {
            int next = prices[i];
            System.out.printf("curr[%d] next[%d] answer[%s->", curr, next, Arrays.toString(answer));

            if(curr <= next)
            {
                up.addLast(curr);
            }
            else
            {
                // next < curr
                int down = 1;

                // up 1, 2
                // curr 3
                // next 2
                int tmp = curr;
                while(!up.isEmpty() && tmp > next)
                {
                    answer[i-down] = down;
                    tmp = up.removeLast();
                    down++;
                }
                if(tmp > next)              // 마지막 pop된 값도 처리
                    answer[i-down] = down;
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