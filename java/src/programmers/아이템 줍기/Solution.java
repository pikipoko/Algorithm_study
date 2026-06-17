import java.util.*;

class Solution {

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        answer = bfs(rectangle, new int[]{characterX, characterY}, new int[]{itemX, itemY});

        return answer;
    }

    private int bfs(int[][] rectangles, int[] start, int[] target)
    {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<int[]> q = new LinkedList<>();

        int[] maxXY = getMaxXY(rectangles);
        int[][] visited = new int[maxXY[0]][maxXY[1]];
        for(int[] v : visited) Arrays.fill(v, 0);

        visited[start[0]][start[1]] = 0;

        q.add(start);

        while(!q.isEmpty())
        {
            int[] cur = q.poll();
            if(cur[0] == target[0] && cur[1] == target[1])
                break;

            for(int i = 0; i < 4; i++)
            {
                int[] next = {cur[0]+dirs[i][0], cur[1]+dirs[i][1]};

                if(next[0] >= 0 && next[1] >= 0 && next[0] <= maxXY[0] && next[1] <= maxXY[1] && cntCanMove(rectangles, next) > 0 && visited[next[0]][next[1]] == 0)
                {
                    visited[next[0]][next[1]] = visited[cur[0]][cur[1]]+1;
                    q.add(next);
                }
            }

        }

        return visited[target[0]][target[1]];
    }

    private int[] getMaxXY(int[][] rectangles)
    {
        int maxX = 0;
        int maxY = 0;
        for (int[] rec : rectangles) {
            if (maxX < rec[2])
                maxX = rec[2];
            if (maxY < rec[3])
                maxY = rec[3];
        }

        return new int[]{maxX, maxY};

    }

    private int cntCanMove(int[][] rectangles, int[] next)
    {
        int cntBoundary = 0;
        for(int i = 0; i < rectangles.length; i++)
        {
            if(isBoundary(rectangles[i], next))
            {
                cntBoundary++;
                for(int j = 0; j < rectangles.length; j++)
                {
                    if(i != j)
                    {
                        if(isInside(rectangles[j], next))
                        {
                            return 0;
                        }
                        if(isBoundary(rectangles[j], next))
                        {
                            cntBoundary++;
                        }
                    }
                }
            }
        }
        return cntBoundary;
    }

    private boolean isBoundary(int[] rectangle, int[] cur)
    {
        // 위
        if(cur[1] == rectangle[3] && cur[0] >= rectangle[0] && cur[0] <= rectangle[2])
            return true;

        // 아래
        if(cur[1] == rectangle[1] && cur[0] >= rectangle[0] && cur[0] <= rectangle[2])
            return true;

        // 왼쪽
        if(cur[0] == rectangle[0] && cur[1] >= rectangle[1] && cur[1] <= rectangle[3])
            return true;

        // 오른쪽
        if(cur[0] == rectangle[2] && cur[1] >= rectangle[1] && cur[1] <= rectangle[3])
            return true;

        return false;
    }

    private boolean isInside(int[] rectangle, int[] cur)
    {
        if(cur[0] > rectangle[0] && cur[0] < rectangle[2] && cur[1] > rectangle[1] && cur[1] < rectangle[3])
            return true;

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(sol.solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
        System.out.println(sol.solution(new int[][]{{1,1,7,4}, {3,2,5,5}, {4,3,6,9}, {2,6,8,8}}, 1, 3, 7, 8));
    }
}