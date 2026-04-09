## 개념
**정렬된 배열**에서 탐색 범위를 절반씩 줄여가며 값을 찾는 방법.
시간복잡도 O(log n)

## 언제 쓰나
- 정렬된 배열에서 특정 값 탐색
- "최솟값/최댓값을 구하라" + 범위가 클 때 -> **파라메트릭 서치**
- "가능한가?" 라는 조건 함수가 단조증가/감소일 때

## 코드 템플릿
```java
public class Main
{
    public static void main(String[] args) throws Exception
    {
        // 기본 이분탐색
        int left = 0, right = arr.length - 1;
        
        while(left <= right)
        {
            int mid = (left + right) / 2;
            
            if(arr[mid] == target)
            {
                // 찾음
                break;
            } else if (arr[mid] < target)
            {
                left = mid + 1;
            } else
            {
                right = mid - 1;
            }
        }
        
        // 파라메트릭 서치 (정답 범위에 이분탐색)
        int left = 최솟값, right = 최댓값;
        int answer = 0;
        
        while(left <= right)
        {
            int mid = (left + right) / 2;
            
            if(isPossible(mid))     // mid가 조건을 만족하는지 확인
            {
                answer = mid;
                left = mid + 1;
            } else
            {
                right = mid + 1;
            }
        }
    }
}
```