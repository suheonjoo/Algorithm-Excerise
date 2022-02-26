import java.util.Scanner;

public class no_13305 { // 파일 이름과 같아야 함

    static int[] city;
    static int[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        distance = new int[N - 1];
        city = new int[N];

        for (int i = 0; i < N - 1; i++) {
            distance[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            city[i] = sc.nextInt();
        } // 일단 입려값을 다 넣고

        int nowc = 0;
        int nowd = 0;

        int sumd = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (city[nowc] < city[i]) { // 현재 도시가 싼값이면 다음 도시 체크
                i++;
            } else {
                // 현재 도시보다 싼값이 존재하면 지금 도시부터 싼도시까지의 거리를 더하고 그 값에 현재 도시 값을 곲한다
                for (int j = nowd; j < i; j++) {
                    sumd += distance[j];
                }
                sum += sumd * city[nowc];
                nowc = i;
                sumd = 0;
                nowd = i - 1;
            }

        }
        System.out.println(sum);

    }

}