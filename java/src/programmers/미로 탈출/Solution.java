import java.util.*;

class Solution {

    public int solution(String[] maps) {
        int answer = 0;

        int lenI = maps.length;
        int lenJ = maps[0].length();
        /*
        S : 시작 지점
        E : 출구
        L : 레버
        O : 통로
        X : 벽
         */
        int[] cur = {-1, -1};
        int[] targetPoint = {-1, -1};

        for(int i = 0; i < lenI; i++)
        {
            for(int j = 0; j < lenJ; j++)
            {
                if(maps[i].charAt(j) == 'S')
                {
                    cur[0] = i;
                    cur[1] = j;
                    break;
                }
            }
        }

        // 레버를 당긴 다음에 출구로 나가야 함.
        int tmp = bfs(maps, cur, new boolean[lenI][lenJ], 'L', targetPoint);
        if(tmp == -1)
            return -1;

        answer += tmp;

        System.out.printf("answer : %d\n", answer);

        cur[0] = targetPoint[0];
        cur[1] = targetPoint[1];
        tmp = bfs(maps, cur, new boolean[lenI][lenJ], 'E', targetPoint);
        if(tmp == -1)
            return -1;

        answer += tmp;

        return answer;
    }

    private void dfs(String[] maps, int[] cur, boolean[][] visited, char target, int cnt, int[] minCnt, int[] targetPoint)
    {
        if(cnt >= minCnt[0])
        {
            return;
        }

        if(maps[cur[0]].charAt(cur[1]) == target)
        {
            minCnt[0] = cnt;
            targetPoint[0] = cur[0];
            targetPoint[1] = cur[1];
            return;
        }

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int len = visited.length;

        for(int i = 0; i < 4; i++)
        {
            int a = cur[0] + dirs[i][0];
            int b = cur[1] + dirs[i][1];
            if(a >= 0 && a < len && b >= 0 && b < len && maps[a].charAt(b) != 'X' && !visited[a][b])
            {
                visited[a][b] = true;
                dfs(maps, new int[]{a, b}, visited, target, cnt+1, minCnt, targetPoint);
                visited[a][b] = false;
            }
        }
    }

    private int bfs(String[] maps, int[] cur, boolean[][] visited, char target, int[] targetPoint)
    {
        Queue<int[]> q = new LinkedList<>();

        q.offer(cur);
        visited[cur[0]][cur[1]] = true;

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int lenI = maps.length;
        int lenJ = maps[0].length();

        int cnt = 0;

        while(!q.isEmpty())
        {
            int[] tmp = q.poll();
            System.out.printf("%d : [%d, %d] %c\n", cnt, tmp[0], tmp[1], maps[tmp[0]].charAt(tmp[1]));
            if(maps[tmp[0]].charAt(tmp[1]) == target)
            {
                targetPoint[0] = tmp[0];
                targetPoint[1] = tmp[1];
                return cnt;
            }
            cnt++;
            for(int i = 0; i < 4; i++)
            {
                int a = cur[0] + dirs[i][0];
                int b = cur[1] + dirs[i][1];
                System.out.printf("%d %d : [%d, %d]\n", cnt, i, a, b);
                if(a >= 0 && a < lenI && b >= 0 && b < lenJ && maps[a].charAt(b) != 'X')
                {
                    q.offer(new int[]{a, b});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
        System.out.println(sol.solution(new String[]{"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"}));
    }
}