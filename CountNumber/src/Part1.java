import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by z00382545 on 9/9/16.
 */
public class Part1 {

    public static void main(String[] args) throws Exception {
        countUp(5,100);
    }

    public static void countUp(int start, int end) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int i=start;

            public void run() {
                if(i==end) timer.cancel();
                System.out.println(i);
                i++;
            }
        }, 0, 1);
    }
}
