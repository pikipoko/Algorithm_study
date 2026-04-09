## 개념
우선순위가 높은 요소가 먼저 나오는 자료구조.
기본은 최소 힙(가장 작은 값이 먼저 나옴)

## 언제 쓰나
- 항상 최솟값/최댓값이 필요한 경우
- 다익스트라 최단경로
- K번째 원소 찾기

## 코드 템플릿
```java
import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        // 최소 힙(기본)
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        
        // 최대 힙
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        
        // 커스텀 정렬 (배열의 첫 번째 원소 기준 최소 힙)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        pq.offer(3);
        pq.poll();      // 최솟값 꺼냄
        pq.peek();      // 조회만
        pq.isEmpty();
    }
}
```