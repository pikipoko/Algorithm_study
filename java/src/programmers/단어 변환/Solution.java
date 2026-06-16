import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(sol.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    public int solution(String begin, String target, String[] words) {
        int[] minCnt = {words.length + 1};

        boolean[] visited = new boolean[words.length];
        dfs(words, visited, begin, target, 0, minCnt);

        return minCnt[0] == words.length+1 ? 0 : minCnt[0];
    }

    private void dfs(String[] words, boolean[] visited, String cur, String target, int cnt, int[] minCnt)
    {
        if(minCnt[0] <= cnt)
            return;
        if(cur.equals(target))
        {
            minCnt[0] = cnt;
            return;
        }

        for(int i = 0; i < words.length; i++)
        {
            if(!visited[i] && isOneLetterDif(words[i], cur))
            {
                visited[i] = true;
                dfs(words, visited, words[i], target, cnt+1, minCnt);
                visited[i] = false;
            }
        }
    }

    private boolean isOneLetterDif(String str1, String str2)
    {
        int cnt = 0;

        for(int i = 0; i < str1.length(); i++)
        {
            if(str1.charAt(i) != str2.charAt(i))
                cnt++;
        }

        return cnt == 1;
    }

}