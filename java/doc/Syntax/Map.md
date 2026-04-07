## 개념
Key-Value 쌍으로 데이터를 저장하는 자료구조
- `HashMap` : 순서 없음, 빠름
- `TreeMap` : 키 기준 정렬

## 언제 쓰나
- 빈도수 카운팅
- 특정 값의 존재 여부 빠르게 확인
- 그래프 인접 리스트 표현

## 코드 템플릿
```java
import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Map<String, Integer> map = new HashMap<>();
        
        map.put("apple", 1);
        map.get("apple");               // 1
        map.getOrDefault("banana", 0);  // 없으면 0 반환
        map.containsKey("apple");       // true
        map.remove("apple");
        
        // 빈도수 카운팅 패턴(핵심!)
        for(char c : str.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // 순회
        for(Map.Entry<String, Integer> e : map.entrySet())
        {
            System.out.println(e.getKey() + " : ")
        }
    }
}
```