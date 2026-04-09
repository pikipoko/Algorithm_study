## 개념
Java에서 정렬 기준을 커스텀할 때 람다식을 사용한다.
`(a, b) -> a - b` : 오름차순 (a가 작으면 앞으로)
`(a, b) -> b - a` : 내림차순

## 코드 템플릿

```java
public class Main()
{
    public static void main(String[] args) throws Exception
    {
        // 기본 정렬 람다
        Arrays.sort(arr, (a, b) -> a - b);  // 오름차순
        Arrays.sort(arr, (a, b) -> b - a);  // 내림차순
        
        // 문자열 길이 기준 정렬
        Arrays.sort(strArr, (a, b) -> a.length() - b.length());
        
        // 다중 조건 정렬
        Arrays.sort(arr2D, (a, b) -> {
            if(a[0] != b[0])
                return a[0] - b[0]; // 첫 번째 원소 오름차순
            return a[1] - b[1];     // 같으면 두 번째 오름차순
        });
        
        // PriorityQueue에 람다
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    }
}
```