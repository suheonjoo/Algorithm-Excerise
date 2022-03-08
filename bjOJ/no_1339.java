import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class no_1339 { // 테스트 자바임

    public static int[] alpha = new int[26]; // 알파벳 숫자크기만큼 배열 크기를 정한다
    // 0부터 알파벳 a,b,c.. 차례로 들어간다

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 몇개를 입력받을지

        for (int x = 0; x < N; x++) {
            String line = br.readLine(); // 문자열 받기

            int size = line.length(); // 받은 문자열 길이 넣기

            int base = (int) Math.pow(10, size - 1); // 최대 자리수크기 (10의 승)을 한다

            for (int y = 0; y < size; y++) {
                // line.charAt(y)는 받아온 문자열을 앞에서 부터 하나씩 가리키는 것임
                alpha[line.charAt(y) - 'A'] += base; // 해당 알파벳 자리에 자리수 크기를 더한다
                base /= 10;// 당연히 다음 자리 수로 갈려면 10으로 나누어야지
            }
        }

        Arrays.sort(alpha); // 배열의 값을 오름차순으로 정렬함
        int ans = 0;
        // 0부터 9까지 수 배정하기 0은 솔직 히 배정안해도 됨 값의 변화가 없음
        for (int x = 25; x >= 17; x--) {
            ans += alpha[x] * (x - 16); // 큰값을 가진 것부터 차례대로 9부터 집어 넣음 그러면서 더함
        }
        System.out.println(ans); // 최종합 출력
    }
}
