import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

class Grade implements Comparable<Grade> {
    int a;
    int b;

    Grade(int a, int b) {// 성적 생성자임
        this.a = a;
        this.b = b;
    }

    public int compareTo(Grade o) {
        if (this.a > o.a) {
            return 1;
        } else {
            return -1;
        }
    }

}

public class no_1946 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        for (int t = 0; t < T; t++) { //
            int N = sc.nextInt();
            ArrayList<Grade> list = new ArrayList<>();// grade에 대한 리스트 만든다

            for (int i = 0; i < N; i++) {
                int a = sc.nextInt(); // 서류, 면접 성적 입력 받기
                int b = sc.nextInt();

                list.add(new Grade(a, b)); // 리스트에 집어 넣기
            }
            // 오름차순으로 정렬
            Collections.sort(list); // 넣은 성적 값이 아니라 순위들을 정렬하기 (이때 정렬 기준은 서류성적 기준임)

            System.out.println();
            for (int i = 0; i < N; i++) {
                System.out.printf("%d %d\n", list.get(i).a, list.get(i).b);
            }

            int ans = 1; // 서류1등은 무조건 통과
            int min = list.get(0).b; // 서류 성적이 제일 낮은 애부터 면접 점수를 비교한다
            for (int i = 1; i < N; i++) { //
                if (list.get(i).b < min) { // 면접등수가 최소값이 갱신된다는 것음 서류는 등수에 밀려났지만 면접에서는 등수는 자기보다 "서류 잘본사람보다" 더 잘봤다는 것임
                    ans++;
                    min = list.get(i).b;
                }
            }
            System.out.println(ans);
        }

    }
}
