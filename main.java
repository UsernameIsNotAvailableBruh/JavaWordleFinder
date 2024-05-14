import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

class Main{
    public static void main(String ... args) {
        int iterations = 1;
        List<Integer> Num = new ArrayList<Integer>(iterations);
        for (int x=0; x<iterations; x++){
            int count = 0;
            for (int y=0; y<100; y++){
                Random rand = new Random();
                int RandomNum = java.lang.Math.abs(rand.nextInt()%2);
                if (RandomNum == 1){
                    count++;
                };
            }
            Num.add(count);
        }
        int sum = 0;
        for (int i=0;i<Num.size();i++){
            sum += Num.get(i);
        }
        System.out.println(sum/iterations);
    }
}