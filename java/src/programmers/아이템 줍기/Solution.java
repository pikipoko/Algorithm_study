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
        int[][] visited = new int[maxXY[0]+1][maxXY[1]+1];
        for(int[] v : visited) Arrays.fill(v, -1);

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

                if(next[0] >= 0 && next[1] >= 0 && next[0] <= maxXY[0] && next[1] <= maxXY[1] && cntCanMove(rectangles, next, cur) > 0 && visited[next[0]][next[1]] == -1)
                {
                    visited[next[0]][next[1]] = visited[cur[0]][cur[1]]+1;
                    q.add(next);
                }
            }

        }

        printCost(visited, maxXY);

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

    private int cntCanMove(int[][] rectangles, int[] next, int[] cur)
    {
        /*
        현재와 다음 점이 같은 직사각형 위에 있는 경우만 갈 수 있음.
         */
        int cntBoundary = 0;
        for(int i = 0; i < rectangles.length; i++)
        {
            if(isRectangleBoundaryLine(rectangles[i], cur, next))
            {
                cntBoundary++;
                for(int j = 0; j < rectangles.length; j++)
                {
                    if(i != j)
                    {
                        if(isRectangleIncludeLine(rectangles[j], cur, next))
                        {
                            return 0;
                        }
                    }
                }
            }
        }
        return cntBoundary;
    }

    private boolean isRectangleBoundaryLine(int[] rectangle, int[] cur, int[] next)
    {
        int leftX   = rectangle[0];
        int downY   = rectangle[1];
        int rightX  = rectangle[2];
        int upY     = rectangle[3];

        // x same, |
        if(cur[0] == next[0])
        {
            // 왼쪽, 오른쪽 선
            if(cur[0] == leftX || cur[0] == rightX)
            {
                if(downY <= cur[1] && cur[1] <= upY //
                        && downY <= next[1] && next[1] <= upY)
                {
                    return true;
                }
            }
        }

        // y same, -
        else
        {
            // 위, 아래 선
            if(cur[1] == downY || cur[1] == upY)
            {
                if(leftX <= cur[0] && cur[0] <= rightX //
                        && leftX <= next[0] && next[0] <= rightX)
                {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isRectangleIncludeLine(int[] rectangle, int[] cur, int[] next)
    {
        int leftX   = rectangle[0];
        int downY   = rectangle[1];
        int rightX  = rectangle[2];
        int upY     = rectangle[3];

        // x same, |
        if(cur[0] == next[0])
        {
            if(leftX <= cur[0] && cur[0] <= rightX)
            {
                if(downY <= cur[1] && cur[1] <= upY //
                        && downY <= next[1] && next[1] <= upY)
                {
                    return true;
                }
            }
        }
        // y same, -
        else
        {
            if(downY <= cur[1] && cur[1] <= upY)
            {
                if(leftX <= cur[0] && cur[0] <= rightX //
                        && leftX <= next[0] && next[0] <= rightX)
                {
                    return true;
                }
            }
        }

        return false;
    }

    private void printCost(int[][] visited, int[] maxXY)
    {
        System.out.println("----".repeat(maxXY[0]));
        for(int j = 0; j < maxXY[1]+1; j++)
        {
            for(int i = 0; i < maxXY[0]+1; i++)
            {
                int cur = visited[i][maxXY[1] - j];
                if(cur != -1)
                    System.out.printf("%2d ", visited[i][maxXY[1] - j]);
                else
                    System.out.print("   ");
            }
            System.out.println();
        }
        System.out.println("----".repeat(maxXY[0]));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(sol.solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
        System.out.println(sol.solution(new int[][]{{1,1,7,4}, {3,2,5,5}, {4,3,6,9}, {2,6,8,8}}, 1, 3, 7, 8));
        System.out.println(sol.solution(new int[][]{{1,1,8,4}, {2,2,4,9}, {3,6,9,8}, {6,3,7,7}}, 9, 7, 6, 1));
        System.out.println(sol.solution(new int[][]{{1,1,5,7}}, 1, 1, 4, 7));
        System.out.println(sol.solution(new int[][]{{2,1,7,5}, {6,4,10,10}}, 3, 1, 7, 10));
        System.out.println(sol.solution(new int[][]{{2,2,5,5}, {1,3,6,4}, {3,1,4,6}}, 1, 4, 6, 3));
    }
}