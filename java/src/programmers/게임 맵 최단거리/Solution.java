import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[][]{{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}}));
        System.out.println(sol.solution(new int[][]{{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}}));
    }

    public int solution(int[][] maps) {
        int answer = -1;

        int maxN = maps.length;
        int maxM = maps[0].length;

        int[][] dist = new int[maxN][maxM];
        for(int[] d : dist)
        {
            Arrays.fill(d, -1);
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        dist[0][0] = 1;

        while(!q.isEmpty())
        {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for(int[] d : dirs)
            {
                int nr = r + d[0], nc = c + d[1];
                if(nr >= 0 && nr < maxN && nc >= 0 && nc < maxM && maps[nr][nc] == 1 && dist[nr][nc] == -1)
                {
                    dist[nr][nc] = dist[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
//        for(int i = 0; i < maxN; i++)
//        {
//            for(int j = 0; j < maxM; j++)
//            {
//                System.out.printf("%2d ", dist[i][j]);
//            }
//            System.out.println();
//        }
        answer = dist[maxN-1][maxM-1];
        return answer;
    }

}