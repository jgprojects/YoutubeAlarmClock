import java.awt.Desktop;

import java.net.URI;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This class provides the ability to browse to a Youtube video at a given time.
 */
public class YoutubeAlarmClock {
    // Constants
    private static final long MILLIS_PER_SECOND = 1000L;
    private static final long MILLIS_PER_MINUTE = 60 * MILLIS_PER_SECOND;
    private static final long MILLIS_PER_HOUR = 60 * MILLIS_PER_MINUTE;
    private static final long MILLIS_PER_DAY = 24 * MILLIS_PER_HOUR;

    /**
     * This TimerTask prints the time remaining until mTargetTime and launches the browser,
     * cancels itself, and exits the app when time expires.
     */
    private class Tick extends TimerTask {
        public void run() {
            // Calculate the remaining time
            Calendar c = Calendar.getInstance();
            long remMillis = mTargetTime - c.getTimeInMillis();
            long remDays = remMillis / MILLIS_PER_DAY;
            long remHours = (remMillis - (remDays * MILLIS_PER_DAY)) / MILLIS_PER_HOUR;
            long remMinutes = (remMillis - (remDays * MILLIS_PER_DAY) - (remHours * MILLIS_PER_HOUR)) / MILLIS_PER_MINUTE;
            long remSeconds = (remMillis - (remDays * MILLIS_PER_DAY) - (remHours * MILLIS_PER_HOUR) - (remMinutes * MILLIS_PER_MINUTE)) / MILLIS_PER_SECOND;

            // print the remaining time
            System.out.print("\rRemaining time:\t" + remDays + " Days\t" + remHours + " Hours\t" + remMinutes + " Minutes\t"
                    + remSeconds + " Seconds");

            // if time has expired, browse to a URI, cancel this TimerTask, and exit app
            if (remMillis <= 0) {
                launchBrowser();
                this.cancel();
                System.exit(0);
            }
        }
    }

    // Instance variables
    private long mTargetTime;


    // Constructor
    public YoutubeAlarmClock(long targetTimeInMillis) {
        mTargetTime = targetTimeInMillis;
    }


    // Public Methods
    /**
     * Starts a new Tick TimerTask, which executes every second
     */
    public void go() {
        // Print current time
        Calendar c = Calendar.getInstance();
        System.out.println("Time started: " + c.getTime());
        // start TimerTask
        Timer timer = new Timer();
        timer.schedule(new Tick(), 0 /* delay */, MILLIS_PER_SECOND /* period */);
    }


    // Private Methods
    /**
     * Attempts to open a browser and navigate to a URI
     */
    private void launchBrowser() {
        try {
            URI videoUri = new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(videoUri);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
            System.exit(1);
        }
    }
}