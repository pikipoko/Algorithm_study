깊이 우선 탐색

## 개념
그래프/트리를 탐색할 때 한 방향으로 끝까지 파고든 뒤 되돌아오는 방식.
재귀 또는 스택으로 구현한다.

## 언제 쓰나
- 모든 경우의 수 탐색 (완전탐색)
- 순열 / 조합 / 부분집합 생성
- 연결된 컴포넌트 찾기
- 백트래킹

## 코드 템플릿
```java
public class Main
{
    // 재귀 DFS (그래프)
    boolean[] visited;
    List<List<Integer>> graph;
        
    void dfs(int node)
    {
        visited[node] = true;
        
        for(int next : graph.get(node))
        {
            if(!visited[next])
            {
                dfs(next);
            }
        }
    }
    
    // 백트래킹(순열)
    void permutation(int[] arr, List<Integer> current, boolean[] used)
    {
        if(current.size() == arr.length)
        {
            // 결과 처리
            return;
        }
        
        for(int i = 0; i < arr.length; i++)
        {
            if(!used[i])
            {
                used[i] = true;
                current.add(arr[i]);
                permutation(arr, current, used);
                current.remove(current.size() - 1); // 되돌리기
                used[i] = false;
            }
        }
    }
    
    // 백트래킹(조합)
    void combination(int[] arr, List<Integer> current, int start)
    {
        if(current.size() == r)
        {
            // 결과 처리
            return;
        }
        
        for(int i = start; i < arr.length; i++)
        {
            current.add(arr[i]);
            combination(arr, current, i + 1);   // i+1로 중복 방지
            current.remove(current.size() - 1);
        }
    }
}
```