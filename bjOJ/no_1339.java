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

    public static int[] alpha = new int[26];

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int x = 0; x < N; x++) {
            String line = br.readLine();

            int size = line.length();

            int base = (int) Math.pow(10, size - 1);

            for (int y = 0; y < size; y++) {
                alpha[line.charAt(y) - 'A'] += base;
                base /= 10;
            }
        }

        Arrays.sort(alpha);
        int ans = 0;
        for (int x = 25; x >= 17; x--) {
            ans += alpha[x] * (x - 16);
        }
        System.out.println(ans);
    }
}
