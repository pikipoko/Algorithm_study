## 개념
앞/뒤 양방향으로 삽입/삭제가 가능한 자료구조.
Stack과 Queue를 모두 대체할 수 있어 코테에서 가장 범용적으로 쓰인다.

## 언제 쓰나
- Stack 대용 (`push` / `pop`)
- Queue 대용 (`offer` / `poll`)
- 슬라이딩 윈도우 최대/최솟값

## 코드 템플릿
```java
import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Deque<Integer> dq = new ArrayDeque<>();
        
        // Stack처럼
        dq.push(1);     // 앞에 삽입
        dq.pop();      // 앞에서 삭제
        
        // Queue처럼
        dq.offer(1);    // 뒤에 삽입 (= offerLast)
        dq.poll();      // 앞에서 삭제 (= pollFirst)
        
        // 양방향
        dq.offerFirst(1);   dq.offerLast(2);
        dq.pollFirst();     dq.pollLast();
        dq.peekFirst();     dq.peekLast();
    }
}
```