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


        //System.out.println("s.solution(participant) = " + Solution.solution(participant));
        //System.out.println(solution);

        //B b = new B(10);
        //C c = new C();
        //Y y = new Y();

        A a = new A();

    }
}
class A{


}

class Solution {

    //Collections.sort()

    public void solution1(String[] operations){
        Integer a = 10;

    }



    public String solution(int[] numbers) {

        String answer = "";
        String []res =new String[numbers.length];

        //문자열로 변경
        for(int i=0; i<numbers.length; i++){
            res[i]=String.valueOf(numbers[i]);

        }
        //문자열을 합쳤을 때  비교
        Arrays.sort(res, (a,b)->{
                    return (a+b).compareTo(b+a);
                }
        );

        //정렬한 값 더하기

        for(int i=numbers.length-1; i>=0; i--){
            answer+=res[i];
        }

        //ex) 000인 경우 0으로 리턴
        if(answer.charAt(0)=='0') return "0";

        return answer;


    }


}





