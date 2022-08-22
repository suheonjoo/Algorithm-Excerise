import org.w3c.dom.Node;

import java.util.*;
import java.util.stream.Collectors;


public class Main { // 테스트 자바임


    public static void main(String[] args) {

        System.out.println("args.length = " + args.length);
        for (String arg : args) {
            System.out.println("arg = " + arg);
        }

        int[] a = {1};



        System.out.println("a.length = " + a.length);


        String new_id = "...!@BaT#*..y.abcdefghijklm";
        //System.out.println((Solution.solution(new_id)));

        Ac a1 = new Ac();
        System.out.println("a1 = " + a1);
    }


}
class Ac{
    int a;

    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                '}';
    }
}


class Solution {

    public static void solution1() {

    }

    public static String solution(String new_id) {


        String answer = "";


//        1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = new_id.toLowerCase();

        System.out.println("new_id = " + new_id);


        int length = new_id.length();

//        2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        for (int i = 0; i < length; i++) {
            if ('a' <= new_id.charAt(i) && new_id.charAt(i) <= 'z') {
                continue;
            }

            if ('0' <= new_id.charAt(i) && new_id.charAt(i) <= '9') {
                continue;
            }

            if (new_id.charAt(i) == '-' || new_id.charAt(i) == '_' || new_id.charAt(i) == '.') {
                continue;
            }

            new_id = new_id.replace(new_id.charAt(i), ' ');
            System.out.println("new_id = " + new_id);
        }

        new_id = new_id.replaceAll(" ","");

        System.out.println("new_id = " + new_id);


//        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        for (int i = 0; i < new_id.length(); i++) {

        }


//        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.




//        5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.



//        6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.

//                만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.


//        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.


        return answer;

    }


}





