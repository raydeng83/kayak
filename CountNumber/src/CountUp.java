import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by z00382545 on 9/9/16.
 *
 * Time flows anyways, so timer is leveraged to print out sequence of numbers.
 */
public class CountUp {

    public static void main(String[] args) {
        countUp(4, 20);
    }

    public static void countUp(int start, int end) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int i = start;

            public void run() {
                if (i == end) timer.cancel();
                System.out.println(i);
                i++;
            }
        }, 0, 1);
    }


}
