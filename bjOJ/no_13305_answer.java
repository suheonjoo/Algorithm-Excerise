import java.util.Scanner;

public class no_13305_answer {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        long[] dist = new long[N-1];
        long[] cost = new long[N];

        for(int i=0;i<N-1;i++){
            dist[i]= in.nextLong();
        }

        for(int i=0;i<N;i++){
            cost[i]= in.nextLong();
        }   //일단 주어진 값을 다 받는다

        long sum=0;
        long minCost= cost[0];

        for(int i=0;i<N-1;i++){     //순회하면서 cost
            if(cost[i]<minCost){    //현재 도시 비용이 최소값보다 작은 도시가 나오면 
                minCost=cost[i];    //최소 비용을 갱신한다
            }
            sum +=(minCost*dist[i]);    //여태까지 지나간 거리의 비용은 계속 다음 도시 갈때마다 갱신해준다
        }
        System.out.println(sum);

    }

    
}
