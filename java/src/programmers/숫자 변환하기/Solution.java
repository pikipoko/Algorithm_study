import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(10, 40, 5));
        System.out.println(sol.solution(10, 40, 30));
        System.out.println(sol.solution(2, 5, 4));
    }

    public int solution(int x, int y, int n) {
        if (x == y)
            return 0;

        boolean[] visited = new boolean[y + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = true;
        int level = 0;

        while (!queue.isEmpty())
        {
            int size = queue.size();
            level++;
            for(int i = 0; i < size; i++)
            {
                int cur = queue.poll();
                int[] nexts = {cur + n, cur * 2, cur * 3};
                for (int next : nexts)
                {
                    if (next == y)
                        return level;
                    if (next < y && !visited[next])
                    {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        return -1;
    }

    private int bfs(int x, int y, int n)
    {
        if(x==y) return 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        int level = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();  // 현재 레벨 크기
            level++;
            for(int i = 0; i < size; i++)
            {
                int cur = queue.poll();
                if(cur == y)
                    return level;
                // x+n, x*2, x*3 큐에 추가
            }

        }
        return -1;
    }

    private int cal(int x, int y, int n, int cnt)
    {
        if(x == y) return cnt;
        if(x > y) return Integer.MAX_VALUE;

        int a = cal(x + n, y, n, cnt + 1);
        int b = cal(x * 2, y, n, cnt + 1);
        int c = cal(x * 3, y, n, cnt + 1);

        return Math.min(a, Math.min(b, c));
    }
}