package application;

import java.util.Timer;
import java.util.TimerTask;

public class AblaufTime {
	static int interval;
	static Timer timer;	
		
	public static void time(int time) {
		int delay = 1000;
	    int period = 1000;
	    Timer timer = new Timer();
	    interval = time;
	    System.out.println(time);
	    timer.scheduleAtFixedRate(new TimerTask() {

	        public void run() {
	            System.out.println(setInterval());

	        }
	    }, delay, period);
	}

private static final int setInterval() {
    if (interval == 1)
        timer.cancel();
    return --interval;
}

public static void main(String[] args) {
	time(10);
}

}
