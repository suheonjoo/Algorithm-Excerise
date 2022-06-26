import java.util.*;




public class Main { // 테스트 자바임

    
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();

        //String[] participant = {"119", "97674223", "1195524421"};
        //String[] completion = {"eden", "kiki"};
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

        Solution s = new Solution();
        s.Solution(clothes);
        System.out.println("s.Solution(participant) = " + s.Solution(clothes));
        //System.out.println(solution);

    }

}
class Solution {


    public int[] solution(String[] genres, int[] plays){

        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0;i<genres.length;i++){
            map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
        }

        ArrayList<String> genres_ordered = new ArrayList<>();
        while (map.size()!=0){
            int max = -1;
            String max_key = "";
            for(String key: map.keySet()){
                int tmp_cnt = map.get(key);
                if(tmp_cnt>max){
                    max = tmp_cnt;
                    max_key = key;
                }
            }
            genres_ordered.add(max_key);
            map.remove(max_key);
        }

        // 2. 장르 내 노래 선정 // 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
        ArrayList<Music> result = new ArrayList<>();
        for(String gern : genres_ordered){
            ArrayList<Music> list = new ArrayList<>();
            for(int i=0; i<genres.length; i++){
                if(genres[i].equals(gern)){
                    list.add(new Music(gern, plays[i], i));
                }
            }
            Collections.sort(list, (o1, o2) -> o2.play - o1.play); // 내림차순 소팅
            result.add(list.get(0)); 	// 1개는 무조건 수록
            if(list.size()!=1){ 	// 더 수록할 곡이 있으면(==장르 내의 노래가 1개보다 많으면) 수록
                result.add(list.get(1));
            }
        }

        // print result
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i).idx;
        }
        return answer;

    }


    public int[] Solution(String[] genres, int[] plays) {

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }

        // 1. 장르 선정  //속한 노래가 많이 재생된 장르를 먼저 수록합니다.
        ArrayList<String> genres_ordered = new ArrayList<>();
        while(map.size()!=0){
            int max = -1;
            String max_key = "";
            for(String key : map.keySet()){
                int tmp_cnt = map.get(key);
                if(tmp_cnt>max){
                    max = tmp_cnt;
                    max_key = key;
                }
            }
            genres_ordered.add(max_key);
            map.remove(max_key);
        }

        // 2. 장르 내 노래 선정 // 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
        ArrayList<Music> result = new ArrayList<>();
        for(String gern : genres_ordered){
            ArrayList<Music> list = new ArrayList<>();
            for(int i=0; i<genres.length; i++){
                if(genres[i].equals(gern)){
                    list.add(new Music(gern, plays[i], i));
                }
            }
            Collections.sort(list, (o1, o2) -> o2.play - o1.play); // 내림차순 소팅
            result.add(list.get(0)); 	// 1개는 무조건 수록
            if(list.size()!=1){ 	// 더 수록할 곡이 있으면(==장르 내의 노래가 1개보다 많으면) 수록
                result.add(list.get(1));
            }
        }

        // print result
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i).idx;
        }
        return answer;


    }

    static class Music{
        String genre;
        int play;
        int idx;

        public Music(String genre, int play, int idx) {
            this.genre = genre;
            this.play = play;
            this.idx = idx;
        }
    }

}







