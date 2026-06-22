import java.util.*;

class Solution {

    public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		Deque<Integer> stack = new ArrayDeque<>();

		for(int i = 0; i < prices.length; i++)
		{
			while(!stack.isEmpty() && prices[stack.getLast()] > prices[i])
			{
				int idx = stack.removeLast();
				answer[idx] = i - idx;
			}
			stack.addLast(i);
		}

		while(!stack.isEmpty())
		{
			int idx = stack.removeLast();
			answer[idx] = prices.length - 1 - idx;
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