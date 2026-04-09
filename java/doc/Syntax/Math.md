## 코드 템플릿
```java
public class Main
{
    public static void main(String[] args) throws Exception
    {
        Math.max(a, b);
        Math.min(a, b);
        Math.abs(x);
        Math.sqrt(x);           // double 반환
        (int) Math.sqrt(x);     // int로 캐스팅
        Math.pow(2, 10);        // 2^10, double 반환
        (long) Math.pow(2, 10)  // long으로 캐스팅
    }
    
    // 소수 판별
    boolean isPrime(int n)
    {
        if( n < 2)
            return false;
        for(int i = 2; i <= (int)Math.sqrt(n); i++)
        {
            if(n % i == 0)
                return false;
        }
        return true;
    }
    
    // 최대공약수 (GCD)
    int gcd(int a, int b)
    {
        return b == 0? a : gcd(b, a % b);
    }
    
    // 최소공배수 (LCM)
    int lcm(int a, int b)
    {
        return a / gcd(a, b) * b;
    }
}
```