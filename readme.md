# YoutubeAlarmClock

This is a Java console app that counts down the seconds until a given time and launches a web browser and navigates to a YouTube video.

## Running

To run the app, open your favorite command line interface, navigate to the `YoutubeAlarmClock/classes` directory and run the program with the command: `java App <year> <month> <day> <hour> <minute> <second>`.

For example: `java App 2020 0 1 13 23 45` will start the app and count down until 1:23:45 PM on January 1st of 2020.
- Note that numbering for the month begins at zero.

## Compiling

To edit the source code of the app and apply the changes:
- open the .java files in the `YoutubeAlarmClock/source` directory with a text editor
- make any changes and save the file(s)
- compile with `javac -d ../classes *.java` from the `YoutubeAlarmClock/source` directory