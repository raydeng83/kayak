import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by z00382545 on 9/13/16.
 *
 * A flag is added to indicate count direction change
 */
public class CountUpAndDown {
    public static void main(String[] args) {
        countUpAndDown(4, 20);
    }

    public static void countUpAndDown(int start, int end) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            boolean flag = false;   //flag to change count direction
            int i = start;

            public void run() {
                if (i == end) flag = true;

                if (!flag) {
                    //count up
                    System.out.println(i);
                    i++;
                } else {
                    //count down
                    if (i == start) timer.cancel();
                    System.out.println(i);
                    i--;
                }
            }
        }, 0, 1);
    }
}
