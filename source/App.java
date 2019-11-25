import java.util.Calendar;

/**
 * Driver class for the YoutubeAlarmClock class.
 */
public class App {
    public static void main(String[] args) {
        // Process arguments
        // Exit the app if we were given the wrong number of arguments
        if (args.length != 6) {
            System.err.println("Error: wrong number of arguments.");
            System.err.println("Be sure to use the form: %java App year month day hour minute second");
            System.err.println("when executing this app.");
            System.err.println("Exiting app.");
            System.exit(1);
        }

        int year = 0;
        int month = 0;
        int day = 0;
        int hour = 0;
        int minute = 0;
        int second = 0;

        try {
            year = Integer.parseInt(args[0]);
            month = Integer.parseInt(args[1]);
            day = Integer.parseInt(args[2]);
            hour = Integer.parseInt(args[3]);
            minute = Integer.parseInt(args[4]);
            second = Integer.parseInt(args[5]);
        } catch (Exception e) {
            System.err.println("Error: invalid argument. Use only integers.");
            System.exit(1);
        }

        // Set a Calendar to the given time
        Calendar c = Calendar.getInstance();
        c.set(year, month, day, hour, minute, second);
        // Create a YoutubeAlarmClock and start it
        YoutubeAlarmClock clock = new YoutubeAlarmClock(c.getTimeInMillis());
        clock.go();
    }
}