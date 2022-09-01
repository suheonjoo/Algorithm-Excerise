
import java.util.stream.Collectors;

import java.util.*;

public class Main { // 테스트 자바임


    public static void main(String[] args) {

        //String new_id = "=.=";
        //1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5   right
        //7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2  left
        //1, 2, 3, 4, 5, 6, 7, 8, 9, 0      right
        int[] numbers = new int[]{2,5,8,0};
        String hand = "right";

        System.out.println((Solution.solution(numbers,hand)));


    }
}


class Solution {


    public static String solution(int[] numbers, String hand) {



        List<Integer> integerList = Arrays.stream(numbers).boxed().collect(Collectors.toList());

        String answer = "";

        Map<String, Node> integerNodeMap = new HashMap<>();
        integerNodeMap.put("1", new Node(1, 1));
        integerNodeMap.put("2", new Node(1, 2));
        integerNodeMap.put("3", new Node(1, 3));

        integerNodeMap.put("4", new Node(2, 1));
        integerNodeMap.put("5", new Node(2, 2));
        integerNodeMap.put("6", new Node(2, 3));

        integerNodeMap.put("7", new Node(3, 1));
        integerNodeMap.put("8", new Node(3, 2));
        integerNodeMap.put("9", new Node(3, 3));

        integerNodeMap.put("*", new Node(4, 1));
        integerNodeMap.put("0", new Node(4, 2));
        integerNodeMap.put("#", new Node(4, 3));

        String leftRecentString = "*";
        String rightRecentString = "#";
        String numberString = "";



        for (Integer integerNumber: integerList) {
            if (integerNumber == 1 || integerNumber == 4 || integerNumber == 7) {
                answer += "L";
                leftRecentString = integerNumber.toString();
            }

            if (integerNumber == 3 || integerNumber == 6 || integerNumber == 9) {
                answer += "R";
                rightRecentString = integerNumber.toString();
            }

            if (integerNumber == 2 || integerNumber == 5 || integerNumber == 8 || integerNumber == 0) {

                //왼쪽꺼 선택해야함
                if (Node.computeDistance(integerNodeMap, leftRecentString, rightRecentString, integerNumber.toString()) == 0) {
                    answer += "L";
                    leftRecentString = integerNumber.toString();
                } else if (Node.computeDistance(integerNodeMap, leftRecentString, rightRecentString, integerNumber.toString()) == 1) {
                    answer += "R";
                    rightRecentString = integerNumber.toString();
                } else {
                    if (hand.equals("right")) {     //여기서 equals 로 해야함 == 으로 하니깐 프로그램스 테스트 코드 통과를 못함
                        answer += "R";
                        rightRecentString = integerNumber.toString();
                    } else if (hand.equals("left")) {
                        answer += "L";
                        leftRecentString = integerNumber.toString();
                    }

                }
            }
        }


        return answer;
    }




    static class Node {

        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static int computeDistance(Map<String, Node> integerNodeMap,
                                           String leftRecentString,
                                           String rightRecentString,
                                           String numberString) {


            Node leftNode = integerNodeMap.get(leftRecentString);
            Node rightNode = integerNodeMap.get(rightRecentString);
            Node standard = integerNodeMap.get(numberString);

            double xpow = Math.pow(Math.abs(leftNode.x - standard.x), 2);
            double ypow = Math.pow(Math.abs(leftNode.y - standard.y), 2);
            double sumleft = xpow + ypow;

            xpow = Math.pow(Math.abs(rightNode.x - standard.x), 2);
            ypow = Math.pow(Math.abs(rightNode.y - standard.y), 2);

            double sumright = xpow + ypow;

            if (sumleft<sumright) {
                return 0;
            } else if (sumleft > sumright) {
                return 1;
            } else {
                return 2;
            }

        }



    }


}





