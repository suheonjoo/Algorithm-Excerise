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
import java.util.StringTokenizer;

import javax.management.MXBean;

public class Main { // 테스트 자바임

    static int n;
    static int[][] map;
    static boolean[][] checked;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 읽을 한줄 받아서 n에 저장

        map = new int[n][n];

        int maxHeight = 0;// map배열에서 최고높이를 저장할 것임
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // int 한 글자씩 읽어서
                // map 배열에 저장

                if (map[i][j] > maxHeight) {// 최고값이면 갱신
                    maxHeight = map[i][j];

                }
            }
        }

        int max = 0; //
        for (int height = 0; height < maxHeight + 1; height++) {// 최고점까지만 높이를 올라가면서 순회
            checked = new boolean[n][n];
            int cnt = 0;
            for (int i = 0; i < n; i++) { // cnt는 섬의 개수
                for (int j = 0; j < n; j++) {
                    if (!checked[i][j] && map[i][j] > height) {
                        cnt += dfs(i, j, height);
                    }
                }
            }
            max = Math.max(max, cnt); // 섬의 개수 최대값 계속 갱신
        }
        System.out.println(max);
    }

    static int dfs(int x, int y, int height) {
        checked[x][y] = true; // 기준점을 체크해 높고
        for (int i = 0; i < 4; i++) { // 기준점 중심으로 상하좌우를 탐색
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx > n - 1 || ny > n - 1)
                continue; // 상하좌우를 탐색하는데 map 밖이면 패스
            if (checked[nx][ny])
                continue; // 이미 지나간 곳이면 패스
            if (map[nx][ny] > height) { // 높이가 주어진 높이보다 높으면 dfs 계속 진행
                dfs(nx, ny, height);
            }

        }
        return 1;
    }
}
