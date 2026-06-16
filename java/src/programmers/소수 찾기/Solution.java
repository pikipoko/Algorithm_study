import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("17"));
        System.out.println(sol.solution("011"));
    }

    Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;

        boolean[] visited = new boolean[numbers.length()];
        List<String> current = new ArrayList<>();
        dfs(numbers, current, visited);
        answer = set.size();

        return answer;
    }

    private void dfs(String numbers, List<String> current, boolean[] visited)
    {
        StringBuilder sb = new StringBuilder();
        for(String c : current)
        {
            sb.append(c);
        }
        int curNum = 0;
        if(!sb.isEmpty())
            curNum = Integer.parseInt(sb.toString());

        if(!set.contains(curNum) && isPrime(curNum))
        {
            set.add(curNum);
        }

        if(current.size() == numbers.length())
        {
            return;
        }

        for(int i = 0; i < numbers.length(); i++)
        {
            if(!visited[i])
            {
                String cur = String.valueOf(numbers.charAt(i));
                visited[i] = true;
                current.add(cur);
                dfs(numbers, current, visited);
                current.removeLast();
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int num)
    {
        if(num < 2) return false;
        if(num == 2) return true;       // 추가
        if(num % 2 == 0) return false;

        for(int i = 3; i * i <= num; i += 2)
        {
            if(num % i == 0) return false;
        }

        return true;
    }
}