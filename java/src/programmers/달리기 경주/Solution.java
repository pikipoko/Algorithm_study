import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"})));
        System.out.println();
        System.out.println(Arrays.toString(sol.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"mine", "mine", "kai", "kai"})));
        System.out.println();
        System.out.println(Arrays.toString(sol.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "mine", "kai", "mine"})));
        System.out.println();
        System.out.println(Arrays.toString(sol.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"mine", "kai", "mine", "kai"})));
    }

    public String[] solution(String[] players, String[] callings) {

//        LinkedList<String> result = new LinkedList<>(Arrays.asList(players));
        Map<Integer, String> result = new HashMap<>();
//        ArrayList<String> result = new ArrayList<>(List.of(players));
        setMap(players, result);

        int cnt = 0;
        for(int i = 0; i < callings.length; i++)
        {
            cnt++;
            if(i+1 < callings.length && callings[i].equals(callings[i+1]))
            {
                continue;
            }
            rankUp(result, callings[i], cnt);
            cnt = 0;
        }
        setArray(players, result);
//        return result.toArray(new String[0]);
        return players;
    }

    private void rankUp(LinkedList<String> players, String call, int up)
    {
        int c = players.indexOf(call);
        players.remove(c);

        players.add(c - up, call);
        System.out.println(String.format("%s, %s %d up", players, call, up));
    }
    private void rankUp(ArrayList<String> players, String call, int up)
    {
        int c = players.indexOf(call);
        players.remove(c);

        players.add(c - up, call);

        System.out.println(String.format("%s, %s %d up", players, call, up));
    }

    private void setMap(String[] players, Map<Integer, String> playersMap)
    {
        for(int i = 0; i < players.length; i++)
        {
            playersMap.put(i, players[i]);
        }
    }

    private void setArray(String[] players, Map<Integer, String> playersMap)
    {
        for(Map.Entry<Integer, String> p : playersMap.entrySet())
        {
            players[p.getKey()] = p.getValue();
        }
    }

    private void rankUp(Map<Integer, String> players, String call, int up)
    {

        System.out.println(String.format("%s, %s %d up", players, call, up));
    }
}
/*
  얀에서는 매년 달리기 경주가 열립니다. 해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다. 예를 들어 1등부터 3등까지 "mumu", "soe", "poe" 선수들이 순서대로 달리고 있을 때, 해설진이 "soe"선수를 불렀다면 2등인 "soe" 선수가 1등인 "mumu" 선수를 추월했다는 것입니다. 즉 "soe" 선수가 1등, "mumu" 선수가 2등으로 바뀝니다.

  선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players와 해설진이 부른 이름을 담은 문자열 배열 callings가 매개변수로 주어질 때, 경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return 하는 solution 함수를 완성해주세요.

  제한사항
  5 ≤ players의 길이 ≤ 50,000
  players[i]는 i번째 선수의 이름을 의미합니다.
  players의 원소들은 알파벳 소문자로만 이루어져 있습니다.
  players에는 중복된 값이 들어가 있지 않습니다.
  3 ≤ players[i]의 길이 ≤ 10
  2 ≤ callings의 길이 ≤ 1,000,000
  callings는 players의 원소들로만 이루어져 있습니다.
  경주 진행중 1등인 선수의 이름은 불리지 않습니다.

 */