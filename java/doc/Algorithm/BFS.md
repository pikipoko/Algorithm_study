너비 우선 탐색

## 개념
그래프/트리를 탐색할 때 현재 노드와 인접한 노드를 모두 먼저 탐색하는 방식.
Queue로 구현한다. 최단 거리 보장

## 언제 쓰나
- 최단 경로/거리 문제 (BFS가 처음 도달한 순간 = 최단 거리)
- 레벨(층) 단위 탐색
- 2D 그리드 탐색

## 코드 템플릿
```java
import java.util.*;

public class Main
{
    // 그래프 BFS
    boolean[] visited;
    Queue<Integer> q = new LinkedList<>();
    List<List<Integer>> graph;
    
    void bfs(int start)
    {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty())
        {
            int node = q.poll();
            
            for(int next : graph.get(node))
            {
                if(!visited[next])
                {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception
    {
        // 2D 그리드 BFS (최단거리)
        int[][] grid;
        int N = grid.length, M = grid[0].length;
        int[][] dist = new int[N][M];
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
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && grid[ne][nc] == 1 && dist[nr][nc] == 0)
                {
                    dist[nr][nc] = dist[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
    
}
```