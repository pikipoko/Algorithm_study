## 개념
크기가 고정된 배열과 달리, 요소를 자유롭게 추가/삭제할 수 있는 동적 배열.

## 언제 쓰나
- 크기를 미리 알 수 없을 때
- 인덱스로 빠르게 접근해야할 때
- DFS 경로 추적, 결과 수집 등

## 코드 템플릿
```java
import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        List <Integer> list = new ArrayList<>();
        
        list.add(1);        // 추가
        list.get(0);        // 인덱스 접근
        list.size();        // 크기
        list.remove(0);     // 인덱스로 삭제
        list.contains(1);   // 포함 여부
        
        Collections.sort(list);     // 오름차순
        Collections.sort(list, (a, b) -> b - a); // 내림차순
        Collections.sort(list, (a, b) -> a - b); // 오름차순(람다)
    }
}
```