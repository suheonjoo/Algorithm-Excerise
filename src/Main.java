import java.util.*;


public class Main { // 테스트 자바임


    public static void main(String[] args) {

        //StringBuffer sb = new StringBuffer();

        int[] participant = {3, 0, 6, 1, 5};
        //String[] completion = {"eden", "kiki"};
        int[][] clothes = {{0, 3}, {1, 9}, {2, 6}};


        //System.out.println("s.solution(participant) = " + Solution.solution(participant));
        //System.out.println(solution);

        //So s = new So();
        Solution.solution1();
    }

    class So {
        int a;
    }

}


class Solution {

    //Collections.sort()

    public static void solution1() {
        String[] stringArray = new String[4];
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = String.valueOf(i + 1);
        }

        Arrays.sort(stringArray, (a, b) -> {
            System.out.println("(a+b) = " + (a+b) + " (b+a) = "+(b+a));

            System.out.println("(a + b).compareTo(b+a) = " + (a + b).compareTo(b+a));

            return (a + b).compareTo(b+a);
        });

    }

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static int solution(int n, int[][] edge) {

        Iterator

        visited = new boolean[n + 1];
        int answer;

        for (int i = 0; i <= n; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {     // 양방향 추가해주기
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        answer = bfs();
        return answer;

    }
    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int cnt = 0;
        while (true) {
            Queue<Integer> temp = new LinkedList<>();

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int adj : graph.get(cur)) {
                    if (!visited[adj]) {
                        temp.add(adj);
                        visited[adj] = true;
                    }
                }
            }

            if (temp.isEmpty()) break;
            queue.addAll(temp);
            cnt = temp.size();
        }

        return cnt;
    }


}





