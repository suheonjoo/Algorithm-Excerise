import java.util.*;



public class Main { // 테스트 자바임

    
    public static void main(String[] args) {

        //StringBuffer sb = new StringBuffer();

        int[] participant = {1, 2, 3, 2, 3};
        //String[] completion = {"eden", "kiki"};
        int[][] clothes = {{0, 3}, {1, 9}, {2, 6}};

//        System.out.println("clothes. = " + Arrays.deepToString(clothes));
//
//        Integer[] integerArr = new Integer[] {1,3,5,2,4};
//        //int[] integerArr = new int[] {1,3,5,2,4};
//        String[] stringArr = new String[] {"A","C","B","E","D"};
//
//        Arrays.sort(integerArr,Comparator.reverseOrder());     //내림차순
//        System.out.println("integerArr = " + Arrays.toString(integerArr));
//
//        Arrays.sort(stringArr,Comparator.reverseOrder());    //내림차순
//        System.out.println("stringArr = " + Arrays.toString(stringArr));


        System.out.println("s.solution(participant) = " + Solution.solution(participant));
        //System.out.println(solution);

    }
}


class Solution {


    public void solution1(String[] operations){


    }

    public static int[] solution(int[] answers) {

        int[] answer = {};
        int[] person1 = {1,2,3,4,5}; //이만큼씩 반복
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};
        int answer1=0, answer2 =0, answer3 =0;

        for(int i =0; i<answers.length; i++){
            if(person1[i%person1.length] == answers[i]) answer1++;
            if(person2[i%person2.length] == answers[i]) answer2++;
            if(person3[i%person3.length] == answers[i]) answer3++;
        }
        int max = Math.max(Math.max(answer1, answer2),answer3); // max값 구하기

        ArrayList<Integer> list = new ArrayList<>();

        if(max==answer1) list.add(1); //max값이랑 같으면 넣는다.
        if(max==answer2) list.add(2);
        if(max==answer3) list.add(3);

        answer = new int[list.size()];

        for(int i =0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;

    }





    static boolean[] check;
    static Set<Integer> set = new HashSet<>();


    public int solution(String numbers) {


        int answer = 0;

        check = new boolean[numbers.length()];
        for(int i=1; i<= numbers.length(); i++) {
            char[] selectNumber = new char[i];
            makeNumber(numbers, selectNumber, 0, i);
        }

        for(int number: set) {
            if(isPrime(number))
                answer++;
        }
        return answer;
    }
    static boolean isPrime(int number) {
        if(number<=1)
            return false;
        for(int i=2; i<number; i++)
            if(number%i==0)
                return false;
        return true;
    }

    static void makeNumber(String numbers, char[] str, int depth, int length) { //재귀함수

        if(depth==length) {
            set.add(Integer.parseInt(new String(str)));
            return;
        }

        for(int i=0; i<numbers.length(); i++) {
            if(!check[i]) {
                check[i] = true;
                str[depth] = numbers.charAt(i);
                makeNumber(numbers, str, depth+1, length);
                check[i] = false;
            }
        }

    }

}





