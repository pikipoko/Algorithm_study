# ⚠️ Java 코테 주의사항

| 주의 | 설명 |
|------|------|
| `==` vs `.equals()` | 객체(String 등) 비교는 반드시 `.equals()` |
| `arr.length` vs `list.size()` | 배열은 `.length` (괄호 없음), List는 `.size()` |
| 제네릭에 primitive 불가 | `List<int>` ❌ → `List<Integer>` ✅ |
| `int[]`를 List에 못 넣음 | `Integer[]` 또는 `List<Integer>` 사용 |
| String 반복 연결 | `+` 반복 ❌ → `StringBuilder` ✅ |
| 정수 오버플로우 | 값이 21억 넘을 것 같으면 `long` 사용 |
| `Stack` 클래스 | 구식, 느림 → `Deque` (ArrayDeque) 사용 권장 |