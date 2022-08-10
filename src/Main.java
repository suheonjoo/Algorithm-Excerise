import org.w3c.dom.Node;

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
        //Solution.solution1();

        int[] arrows;

        arrows = new int[]{6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};
        System.out.println(Solution.solution(arrows));
        Solution.solution(arrows);
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
            System.out.println("(a+b) = " + (a + b) + " (b+a) = " + (b + a));

            System.out.println("(a + b).compareTo(b+a) = " + (a + b).compareTo(b + a));

            return (a + b).compareTo(b + a);
        });

    }

    public static int solution(int[] arrows) {

        int answer = 0;

        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

        Node curNode = new Node(0, 0);

        Map<Node, List<Node>> visited = new HashMap<>();


        for (int arrow : arrows) {
            //2번 반복해서 스케일 업함
            for (int i = 0; i < 1; i++) {

                Node nextNode = new Node(curNode.x + dx[arrow], curNode.y + dy[arrow]);

                if (!visited.containsKey(nextNode)) {
                    //다음 이동할 새로 만남점 추가해주기
                    visited.put(nextNode, makeEdgeList(curNode));


                    //현제 노드도 처음 만들어진거면 맵에 추가하기
                    if (visited.get(curNode) == null) {

                        visited.put(curNode, makeEdgeList(nextNode));
                    } else {// 그게 아니면 다음 노드를 자기 리스트에 추가하기
                        visited.get(curNode).add(nextNode);
                    }

                    //다음 노드를 방분핝 적이 있고, 간선은 처음 만들어진 것이면 각각 리스트에 추가하고 answer도 1 올려줌
                } else if (!visited.get(nextNode).contains(curNode)) {
                    visited.get(nextNode).add(curNode);
                    visited.get(curNode).add(nextNode);
                    answer++;
                }

                curNode = nextNode;

            }
        }
        return answer;
    }

    private static List<Node> makeEdgeList(Node node) {
        // edge 리스트 새로 만들기
        List<Node> edge = new ArrayList<>();
        edge.add(node);
        return edge;

    }

    private static class Node{

        int x, y;

        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


}





