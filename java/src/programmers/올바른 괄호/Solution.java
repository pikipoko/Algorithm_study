import java.util.*;

class Solution {

    boolean solution(String s) {
        boolean answer = true;
        ArrayList<String> q = new ArrayList<>();

        for(int i = 0; i < s.length(); i++)
        {
            String bracket = String.valueOf(s.charAt(i));
            if("(".equals(bracket))
                q.addLast(bracket);
            else
            {
                if(q.isEmpty())
                    return false;
                q.removeLast();
            }
        }
        return q.isEmpty();
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(sol.solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
        System.out.println(sol.solution("()()"));
        System.out.println(sol.solution("(())()"));
        System.out.println(sol.solution(")()("));
        System.out.println(sol.solution("(()("));
    }
}