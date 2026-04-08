## 개념
FIFO(First In First Out) 구조. 먼저 넣은 것이 먼저 나온다.

## 언제 쓰나
- BFS 구현 시 필수
- 순서를 보장해야 하는 작업 처리

## 코드 템플릿
```java
import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(1);     // 삽입
        q.poll();       // 삭제 & 반환(비어있으면 null)
        q.peek();       // 조회만
        q.isEmpty();
    }
}
```