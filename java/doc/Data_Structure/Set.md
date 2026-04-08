## 개념
중복을 허용하지 않는 집합 자료구조.
- `HashSet` : 순서 없음
- `TreeSet` : 정렬됨

## 언제 쓰나
- 중복 제거
- 방문 여부 확인(visited 대용)
- 특정 값 존재 여부를 O(1)로 확인

## 코드 템플릿
```java
import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Set<Integer> set = new HashSet<>();
        
        set.add(1);
        set.contains(1);    // true
        set.remove(1);
        set.size();
        
        // 배열에서 중복 제거
        int[] arr = {1, 2, 2, 3, 3};
        Set<Integer> unique = new HashSet<>();
        for(int x : arr)
            uniq.add(x);
    }
}
```