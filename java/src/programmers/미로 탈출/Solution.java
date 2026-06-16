import java.util.*;

class Solution {

    public int solution(String[] maps) {
        int lenI = maps.length;
        int lenJ = maps[0].length();

        int[] S = new int[2], L = new int[2], E = new int[2];

        for(int i = 0; i < lenI; i++)
        {
            for(int j = 0; j < lenJ; j++)
            {
                if(maps[i].charAt(j) == 'S')
                {
                    S[0] = i;
                    S[1] = j;
                }
                else if(maps[i].charAt(j) == 'L')
                {
                    L[0] = i;
                    L[1] = j;
                }
                else if(maps[i].charAt(j) == 'E')
                {
                    E[0] = i;
                    E[1] = j;
                }
            }
        }

        // 레버를 당긴 다음에 출구로 나가야 함.
        int toL = bfs(maps, S, L);
        if(toL == -1)
            return -1;

        int toE = bfs(maps, L, E);
        if(toE == -1)
            return -1;

        return toL + toE;
    }

    private int bfs(String[] maps, int[] start, int[] target)
    {
        Queue<int[]> q = new LinkedList<>();

        q.offer(start);

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int lenI = maps.length;
        int lenJ = maps[0].length();

        int[][] dist = new int[lenI][lenJ];
        for(int[] row : dist)
        {
            Arrays.fill(row, -1);
        }
        dist[start[0]][start[1]] = 0;


        while(!q.isEmpty())
        {
            int[] cur = q.poll();
            if(cur[0] == target[0] && cur[1] == target[1])
            {
                return dist[cur[0]][cur[1]];
            }
            for(int i = 0; i < 4; i++)
            {
                int a = cur[0] + dirs[i][0];
                int b = cur[1] + dirs[i][1];
                if(a >= 0 && a < lenI && b >= 0 && b < lenJ && maps[a].charAt(b) != 'X' && dist[a][b] == -1)
                {
                    dist[a][b] = dist[cur[0]][cur[1]] + 1;
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