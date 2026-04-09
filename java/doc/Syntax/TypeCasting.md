## 개념
코테에서 int <-> String <-> char 변환이 자주 필요하다.

## 코드 템플릿
```java
public class main
{
    public static void main(String[] args) throws exception
    {
        // int <-> String
        String str = String.valueOf(123);       // int -> String
        String str2 = Integer.toString(123);    // int -> String
        int n = Integer.parseInt("42");         // String -> int
        
        // char <-> int
        char c = 'a';
        int n = c - 'a';                // 0
        char back = (char)('a' + n);    // 'a'
        
        char digit = '5';
        int d = digit - '0';            // 5 (char 숫자 -> int)
        char dc = (char)('0' + 5);      // '5'
        
        // int <-> char
        char ch = (char)(65);           // 'A'
        int ascii = 'A';                // 65
        
        // String <-> char[]
        char[] chars = "hello".toCharArray();
        String s = new String(chars);
    }
}
```