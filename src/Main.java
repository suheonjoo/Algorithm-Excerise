import package1.A;

import javax.swing.plaf.IconUIResource;
import java.util.*;
import java.util.stream.Collectors;


public class Main { // 테스트 자바임


    public static void main(String[] args) {
        System.out.println("Solution.solution() = " + Solution.solution(
                new int[]{90, 0, 0, 95, 1, 1}


        ));

//        System.out.println("Solution1.solution() = " + Solution1.solution(
//
//
//        ));
        Spliterator

    }
}


class Solution {


    public static int solution(int[] money) {
        int answer = 0;


//        인덱스 0부터 시작하면 n-1개까지
//        인덱스 1부터 시작하면 n까지 순회
//
//        dp[i+2] dp[i+3] 둘중에 큰값을 dp[i]에 더하기

        int[] dp = new int[money.length];
        //System.out.println("dp = " + Arrays.toString(dp));

        int max0 = money[0];
        int max1 = money[1];

        if (money.length == 1) {
            return money[0];
        }

        if (money.length==2) {
            return Math.max(money[0],money[1]);
        }

        if (money.length == 3) {

            return Math.max(money[2] ,Math.max(money[0] ,money[1]));
        }

        if (money.length ==4) {
            return Math.max(money[0]+money[2], money[1]+money[3]);
        }


        dp[0]= money[0];
        dp[1]= Integer.MIN_VALUE;

        dp[2]= Math.max(money[2] ,Math.max( money[0], dp[1]));
        dp[3]= Math.max(money[0]+money[2], dp[1]+money[3]);

        //0   1  2   3  4  5
        //90, 0, 0, 95, 1, 1

        //0부터 시작
        for (int i = 4; i  < money.length-1; i++) {

            dp[i] = Math.max( Math.max(money[i-1] + dp[i-3], money[i-1] + dp[i-4]), Math.max(dp[i - 2] + money[i] , dp[i - 3]+ money[i]));


        }
        max0 = Math.max(dp[money.length-2], dp[money.length-3]);

        //System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));


        dp[0]= Integer.MIN_VALUE;
        dp[1]= money[1];
        dp[2]= Math.max(money[2] ,Math.max( dp[0], money[1]));
        dp[3]= Math.max(dp[0]+money[2], money[1]+money[3]);


        //1부터 시작
        for (int i = 4; i  < money.length; i++) {
            dp[i] = Math.max( Math.max(money[i-1] + dp[i-3], money[i-1] + dp[i-4]), Math.max(dp[i - 2] + money[i] , dp[i - 3]+ money[i]));
        }
        max1 = Math.max(dp[money.length-1], dp[money.length-2]);

        //System.out.println("11Arrays.toString(dp) = " + Arrays.toString(dp));




        return Math.max(max0,max1);
    }


}








