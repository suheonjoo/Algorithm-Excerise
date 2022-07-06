import java.util.*;



public class Main { // 테스트 자바임

    
    public static void main(String[] args) {

        //StringBuffer sb = new StringBuffer();

        int[] participant = {3, 30, 34,1,2,3};
        //String[] completion = {"eden", "kiki"};
        int[][] clothes = {{0, 3}, {1, 9}, {2, 6}};




        System.out.println("s.solution(participant) = " + Solution.solution(participant));
        //System.out.println(solution);


    }
}


class Solution {

    //Collections.sort()

    public void solution1(String[] operations){
        Integer a = 10;

    }



    public static String solution(int[] numbers) {

        String answer = "";
        String []res =new String[numbers.length];

        //문자열로 변경
        for(int i=0; i<numbers.length; i++){
            res[i]=String.valueOf(numbers[i]);

        }
        //문자열을 합쳤을 때  비교 //오름차순임 !!
        Arrays.sort(res, (a,b)->{
            System.out.println("a = " + a +" b = " + b);

                    return (a+b).compareTo(b+a);
                }
        );
        System.out.println("res = " + Arrays.toString(res));

        //정렬한 값 더하기 //지금 보면 정렬한 값을 꺼꾸로 더함
        for(int i=numbers.length-1; i>=0; i--){
            answer+=res[i];
        }

        //ex) 000인 경우 0으로 리턴
        if(answer.charAt(0)=='0') return "0";

        return answer;


    }


}





