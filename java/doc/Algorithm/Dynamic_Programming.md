동적 프로그래밍

## 개념
큰 문제를 작은 부분 문제로 나누고, 결과를 저장(메모이제이션)해서 중복 계산을 피하는 방법.

## 언제 쓰나
- "최대/최소 값을 구하라"
- "경우의 수를 구하라"
- 재귀로 풀면 중복 호출이 생기는 경우

## 코드 템플릿
```java
public class Main
{
    public static void main(String[] args) throws Exception
    {
        // 1D DP (피보나치 예시)
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        // 2D DP (격자 최단경로 예시)
        int[][] dp = new int[N][M];
        dp[0][0] = grid[0][0];
        
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < M; j++)
            {
                if(i == 0 && j == 0)
                    continue;
                
                int up = (i > 0) ? dp[i-1][j] : Integer.MAX_VALUE;
                int left = (j > 0) ? dp[i][j-1] : Integer.MAX_VALUE;
                
                dp[i][j] = Math.min(up, left) + grid[i][j];
            }
        }
        
        // 메모이제이션 (Top-Down)
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        fib(n);
    }
    
    private int fib(int n)
    {
        if(n <= 1)
            return n;
        if(memo[n] != -1)
            return memo[n];
        return memo[n] = fib(n-1) + fib(n-2);
    }
}
```