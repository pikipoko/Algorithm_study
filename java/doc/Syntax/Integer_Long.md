값이 커질 수 있는 문제에서 오버 플로우 조심

## 코드 템플릿
```java
public class Main
{
    public static void main(String[] args) throws Exception
    {
        Integer.MAX_VALUE   // 2147483647 (약 21억)
        Integer.MIN_VALUE   // -2147483648
        Long.MAX_VALUE      // 약 9.2 * 10^18
        
        // 합이 21억 넘을 것 같으면 long 사용
    }
}
```
