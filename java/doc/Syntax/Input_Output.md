## 개념
프로그래머스는 함수 파라미터로 입력을 받아서 `return`으로 반환하기 때문에
`Scanner` / `BufferedReader`는 백준 등 콘솔 입력 문제에서만 사용한다.

## 코드 템플릿
```java
// 프로그래머스 기본 구조
class Solution
{
    public int solution(int[] arr, int target)
    {
        int answer = 0;
        // 로직
        return answer;
    }
}

// 백준 - Scanner (편하지만 느림)
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s  = sc.next();
        String line = sc.nextLine();
    }
}

// 백준 - BufferedReader (빠른, 입력 많을 때 필수)
import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().treim());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        // 출력
        System.out.println("결과: " + answer);
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        System.out.print(sb);   // 출력 많을 때 StringBuilder로 모아서 한 번에
    }
}
```