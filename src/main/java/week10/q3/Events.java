package week10.q3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Events {

    private static final String[] EVENT_TYPES = {"Login", "Logout", "Purchase", "ViewPage", "Error"};
    private static final Random RANDOM = new Random();

    public void generateEventsFile(String filename, int numRecords) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for (int i = 0; i < numRecords; i++) {
                String timestamp = dateFormat.format(new Date(System.currentTimeMillis()
                        - RANDOM.nextInt(1_000_000_000)));
                String eventType = EVENT_TYPES[RANDOM.nextInt(EVENT_TYPES.length)];
                int userId = RANDOM.nextInt(1000);

                String record = String.format("%s | Event Type: %s | User ID: %d",
                        timestamp, eventType, userId);
                writer.write(record);
                writer.newLine();
            }
        }
    }

    public void printEventsFromFile(String filename) throws IOException {
        List<String> events = Files.readAllLines(Paths.get(filename));
        events.forEach(System.out::println);
    }

    public List<String> readEventsFromFile(String filename) throws IOException {
        return Files.readAllLines(Paths.get(filename));
    }

    public static void main(String[] args) throws IOException {
        Events events = new Events();

        String filename = "events.txt";
        int numRecords = 10;

        events.generateEventsFile(filename, numRecords);
        System.out.println("Generated Events:");
        events.printEventsFromFile(filename);

        List<String> eventRecords = events.readEventsFromFile(filename);
        System.out.println("Retrieved Event Records:");
        eventRecords.forEach(System.out::println);
    }


}
