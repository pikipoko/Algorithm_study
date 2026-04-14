/**
 *
 */

public class Solution
{
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        System.out.println(sol.solution("aabbaccc"));
        System.out.println(sol.solution("ababcdcdababcdcd"));
        System.out.println(sol.solution("abcabcdede"));
        System.out.println(sol.solution("abcabcabcabcdededededede"));
        System.out.println(sol.solution("xababcdcdababcdcd"));

    }

    public int solution(String s)
    {
        int minLen = s.length();

        for(int i = 1; i <= s.length()/2; i++)
        {
            minLen =  Math.min(minLen, parseByLength(s, i));
        }

        return minLen;

    }

    private int parseByLength(String s, int partLen)
    {
        StringBuilder sb = new StringBuilder();
        String tmp = "";
        int cnt = 0;

        for(int i = 0; i < s.length(); i += partLen)
        {
            int end = Math.min(i + partLen, s.length());
            String t = s.substring(i, end);
            if(tmp.equals(t))
            {
                cnt++;
                continue;
            }
            if(cnt > 1)
                sb.append(cnt);
            if(!tmp.isEmpty())
                sb.append(tmp);
            tmp = t;
            cnt = 1;
        }
        if(cnt > 1)
        {
            sb.append(cnt);
        }
        sb.append(tmp);

        return sb.length();
    }
}