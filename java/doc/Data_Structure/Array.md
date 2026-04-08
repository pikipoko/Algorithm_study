## 개념
고정 크기의 연속된 메모리 공간. 인덱스로 O(1) 접근.

## 언제 쓰나
- 크기가 정해져 있을 때
- 2D 그리드(지도, 행렬) 표현
- DP 테이블

## 코드 템플릿
```java
public class Main
{
    public static void main(String[] args) throws Exception
    {
        // 1D 배열
        int[] arr = new int[5];
        Arrays.sort(arr);
        Arrays.fill(arr, 0);
        int[] copy = Arrays.copyOfRange(arr, 1, 4); // [1, 4)
        
        // 2D 배열
        int[][] grid = new int[3][4];
        int N = gird.length;            // 행 수
        int M = grid[0].length;         // 열 수
        
        // 2D 배열 정렬 (첫 번째 원소 기준)
        Arrays.sort(grid, (a, b) -> a[0] - b[0]);
    }
}
```