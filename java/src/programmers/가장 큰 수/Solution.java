import java.util.*;


public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{0, 0, 0}));
//        System.out.println(sol.solution(new int[]{3, 30, 34, 5, 9}));
        }

    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        PriorityQueue<String> Pq = new PriorityQueue<>((a,b) ->
        {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });

        for (int number : numbers) {
            Pq.offer(String.format("%d", number));
        }

        while(!Pq.isEmpty()) {
            answer.append(Pq.poll());
        }

        String result = answer.toString();
        int i = 1;
        for(; i < 10; i++)
        {
            if(result.contains(String.format("%d", i)))
                break;
        }

        if(result.charAt(0) == '0') result = "0";
        return result;
    }

}

/*
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

 */