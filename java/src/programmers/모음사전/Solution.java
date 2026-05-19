import java.util.*;


public class Solution {
    boolean[] visited;
    List<List<Integer>> graph;

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("AAAAE");
        sol.solution("AAAE");
        sol.solution("I");
        sol.solution("EIO");
//        System.out.println(sol.solution(new int[]{3, 30, 34, 5, 9}));
        }

    public int solution(String word) {
        int answer = 0;

        StringBuilder nword = new StringBuilder(word.replaceAll("A", "1"));
        nword = new StringBuilder(nword.toString().replaceAll("E", "2"));
        nword = new StringBuilder(nword.toString().replaceAll("I", "3"));
        nword = new StringBuilder(nword.toString().replaceAll("O", "4"));
        nword = new StringBuilder(nword.toString().replaceAll("U", "5"));



        for(int i = 0; i < nword.length(); i++)
        {
            int tmp = Integer.parseInt(String.valueOf(nword.charAt(i)));
            tmp = getFifth(5 - i) * (tmp - 1) + 1;
            System.out.println(i + " : " + tmp);
            answer += tmp;
        }

        return answer;
    }

    private int getFifth(int idx)
    {
        int ret = 0;

        for(int i = 0; i < idx; i++)
        {
            ret += (int) Math.pow(5, i);
        }
        return ret;
    }
}

/*
        11112
        4 + (5 ^ (5 - 5)) * (2 - 1) + (2 - 1) * (5 - 5) + 1
        4 + 1 + 1

        1
        11
        111
        1111

        11111

        11112

        1112
        3 + (5 ^ (5 - 4)) * (2 - 1) + (2 - 1) * (5 - 4) + 1
        3 + 5 + 1 + 1

        1
        11
        111

        1111
        11111
        11112
        11113
        11114
        11115

        1112

        1113
        3 + 5 * 2 + (3 -1)(1) + 1
        16

        11111 5
        1111 5
        1112 5
        16

        1
        11
        111

        1111
        11111
        11112
        11113
        11114
        11115
        1112
        11121
        11122
        11123
        11124
        11125
        1113

         */
//        }

/*
사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록되어 있습니다. 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.

단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.

제한사항
word의 길이는 1 이상 5 이하입니다.
word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져 있습니다.

word	result
"AAAAE"	6
"AAAE"	10
"I"	1563
"EIO"	1189

입출력 예 설명
입출력 예 #1

사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA", "AAA", "AAAA", "AAAAA", "AAAAE", ... 와 같습니다. "AAAAE"는 사전에서 6번째 단어입니다.

입출력 예 #2

"AAAE"는 "A", "AA", "AAA", "AAAA", "AAAAA", "AAAAE", "AAAAI", "AAAAO", "AAAAU"의 다음인 10번째 단어입니다.

입출력 예 #3

"I"는 1563번째 단어입니다.

입출력 예 #4

"EIO"는 1189번째 단어입니다.

 */