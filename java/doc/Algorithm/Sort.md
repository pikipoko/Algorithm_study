## 개념
데이터를 특정 기준으로 순서대로 나열하는 것.
Java 기본 정렬은 Timsort (O(n log n))

## 언제 쓰나
- 탐색 전 전처리
- 그리디 문제에서 기준 세우기
- 이분탐색 전 필수

## 코드 템플릿
```java
import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        // 기본 배열 정렬
        int[] arr = {3, 1, 2};
        Arrays.sort(arr);   // 오름차순
        // * primitive 배열은 역순 정렬 불가 -> Integer[]로 변환 필요
        
        Integer[] arr2 = {3, 1, 2};
        Arrays.sort(arr2, (a, b) -> b - a);     // 내림차순
        
        // 2D 배열 정렬
        int[][] points = {{3, 2}, {1, 5}, {2, 1}};
        Arrays.sort(points, (a, b) -> a[0] - b[0]);     // 첫 번째 원소 기준 오름차순
        Arrays.sort(points, (a, b) ->
        {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });                                             // 첫 번째 원소끼리 같은 값이면 두 번째 원소 기준 오름차순
        
        // List 정렬
        List<Integer> list = new ArrayList<>();
        Collections.sort(list);
        Collections.sort(list, (a, b) -> b - a);  // 내림차순
    }
}
```