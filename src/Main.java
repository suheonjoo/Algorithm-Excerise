public class Main { // 테스트 자바임


    public static void main(String[] args) {

        String new_id = "=.=";
        System.out.println((Solution.solution(new_id)));



    }
}

class Settings1 {

    private static volatile Settings1 instance;

    private Settings1(){}

    public static Settings1 getInstance() {
        if (Settings1.instance == null) {
            synchronized (Settings1.class) {
                if (Settings1.instance == null) {
                    instance = new Settings1();
                }
            }
        }
        return instance;
    }

}

class Settings2 {

    private Settings2() {
    }

    private static class SettingsHolder {
        private static final Settings2 INSTANCE = new Settings2();
    }

    public static Settings2 getInstance() {
        return SettingsHolder.INSTANCE;
    }
}

enum Settings3 {
    INSTANCE;
}



class Solution {


    public static int solution(String s) {
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        //숫자가 0~9까지 10개로 정해져 있으므로 i<10
        for(int i=0; i<10; i++){
            s = s.replace(num[i], Integer.toString(i));
        }

        int answer = Integer.parseInt(s);

        return answer;
    }


}





