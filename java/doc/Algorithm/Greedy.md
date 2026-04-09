## 개념
매 순간 현재 기준으로 가장 좋은 선택을 하는 방법.
**전체 최적 = 부분 최적**이 성립할 때만 사용 가능

## 언제 쓰나
- 정렬 후 순서대로 선택
- 최소/최대를 구하는 문제 중 DP 없이 풀리는 경우
- "항상 ~를 먼저" 같은 직관적 규칙이 보일 때

## 코드 템플릿
```java
public class Main
{
    public static void main(String[] args)
    {
        // 그리디 기본 패턴 - 정렬 후 선택
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);    // 기준 정렬
        
        int count = 0;
        int end = 0;
        
        for(int[] item : arr)
        {
            if(item[0] > end)       // 조건 체크
            {
                count++;
                end = item[1];      // 선택
            }
        }
    }
}
```