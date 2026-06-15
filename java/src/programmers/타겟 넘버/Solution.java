import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(sol.solution(new int[]{1, 1, 1, 1, 1}, 3));
//        System.out.println(sol.solution(new int[]{4, 1, 2, 1}, 4));
        System.out.println(sol.solution(new int[]{4, 1, 2, 1, 2, 1}, 9));
    }
    int Ccnt = 0;

    public int solution(int[] numbers, int target) {
        int answer = 0;

        int minusTarget = Arrays.stream(numbers).sum() - target;

        if(minusTarget % 2 == 1 || minusTarget < 0)
            return 0;

        minusTarget /= 2;

        boolean[] visited = new boolean[numbers.length];

        comb(numbers, visited, 0, numbers.length, numbers.length, minusTarget);
        answer = Ccnt;
        return answer;
    }

    private void comb(int[] arr, boolean[] visited, int depth, int n, int r, int minusTarget)
    {
        int ss = sumC(arr, visited, n);
        if (ss == minusTarget) {
            Ccnt++;
            return;
        }
        else if (ss > minusTarget)
        {
            return;
        }

        if (r == 0) {
            return;
        }

        if (depth == n) {
            return;
        }

        visited[depth] = true;
        comb(arr, visited, depth + 1, n, r - 1, minusTarget);

        visited[depth] = false;
        comb(arr, visited, depth + 1, n, r, minusTarget);
    }

    private int sumC(int[] arr, boolean[] visited, int n)
    {
        int ret = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                ret += arr[i];
            }
        }
        return ret;
    }
}
