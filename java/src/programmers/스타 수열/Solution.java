import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{0}));
        System.out.println(sol.solution(new int[]{5,2,3,3,5,3}));
        System.out.println(sol.solution(new int[]{0,3,3,0,7,2,0,2,2,0}));
    }

    public int solution(int[] a) {
        int answer = 0;

        Map<Integer, Integer> cntMap = new HashMap<>();

        for(int i : a)
        {
            cntMap.put(i, cntMap.getOrDefault(i, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(cntMap.entrySet());
        entryList.sort((ab, b) -> b.getValue() - ab.getValue());

        for(Map.Entry<Integer, Integer> e : entryList)
        {
            int key = e.getKey();
            int val = e.getValue();
            if(val*2 <= answer)
                break;
            int tmp = 0;
            for(int i = 0; i+1 < a.length; ) {
                if((a[i] != key && a[i+1] != key) || (a[i] == key && a[i+1] == key)) {
                    i++;
                    continue;
                }
                i += 2;
                tmp += 2;
            }
            answer = Math.max(answer, tmp);
        }

        return answer;
    }
}
