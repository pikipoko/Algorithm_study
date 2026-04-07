# String / StringBuilder

## 개념
- `String` : 불변(immutable). `+` 연산 반복 시 매번 새 객체 생성 -> 느림
- `StringBuilder` : 가변. 반복해서 문자를 추가할 때 필수

## 언제 쓰나
- 문자 하나씩 붙이는 경우 -> `StringBuilder`
- 문자열 파싱, 비교, 변환

## 코드 템플릿
```java
public class Main
{
    public static void main(String[] args) throws Exception
    {
        String s = "hello";
        s.length();
        s.charAt(0);            // 'h'
        s.substring(1, 3);      // "el"
        s.split(",");           // String[]로 분리
        s.contains("ell");      // true
        s.equals("hello");      // true, 문자열 비교 (== 쓰면 안됨)
        s.toCharArray();        // char[]로 변환
        s.indexOf("l");         // 처음 l이 나오는 인덱스
        s.replace("l", "r");    // 치환
        s.trim();               // 앞뒤 공백 제거
        s.toUpperCase();
        s.toLowerCase();

        // StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("hello");
        sb.append(42);
        sb.insert(0, "start");  // 특정 위치에 삽입
        sb.delete(0, 2);        // 범위 삭제
        sb.reverse();
        String result = sb.toString();
    }
}
```

