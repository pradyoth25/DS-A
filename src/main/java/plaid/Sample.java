package plaid;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class Sample {

    public static void helperFunctions() {
        LocalDate localDate = LocalDate.now();
        LocalTime sixThirty = LocalTime.of(6, 30);
        LocalDateTime someTime = LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);
        ZoneId zoneId = ZoneId.of("America/Chicago");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(someTime, zoneId);
        ZonedDateTime.parse("2015-05-03T10:15:30+01:00[Europe/Paris]");
        LocalDate initialDate = LocalDate.parse("2007-05-10");
        LocalDate finalDate = initialDate.plus(Period.ofDays(5));
        LocalTime initialTime = LocalTime.of(6, 30, 0);
        LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));
        long thirty = Duration.between(initialTime, finalTime).getSeconds();
        LocalDateTime localDateTime = LocalDateTime.of(2015, Month.JANUARY, 25, 6, 30, 1);
        String localDateString = localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(localDateString);
        Instant instant = Instant.now();
        System.out.println(DateTimeFormatter.ISO_INSTANT.format(instant));
    }

    /*
    logHit() - everytime someone loads a page
    getHits() - gets the number of times a page was called in the last 5 mins
     */

//   Queue<Long> q;
   Map<Integer, Integer> secondToFrequencyMap;

   public Sample() {
//       q = new LinkedList<>();
       secondToFrequencyMap = new ConcurrentHashMap<>();
   }

   public void logHit(int timestamp) {
//       cleanupQueue(timestamp);
//       cleanupMap(timestamp);
//       q.offer(timestamp);
       int secondValue = timestamp;
       secondToFrequencyMap.put(secondValue,
               secondToFrequencyMap.getOrDefault(secondValue, 0) + 1);
   }

   public int getHits(int timestamp) {
//       cleanupQueue(timestamp);
       cleanupMap(timestamp);
       int hits = 0;
       for (int frequency : secondToFrequencyMap.values()) {
           hits += frequency;
       }
//       return q.size();
       System.out.println(secondToFrequencyMap);
       return hits;
   }

   private void cleanupMap(int timestamp) {
       long threshold = (timestamp - 300);
       System.out.println(threshold);
//       System.out.println(threshold);
//       System.out.println(secondToFrequencyMap);
       for (int secondValue : secondToFrequencyMap.keySet()) {
           if (secondValue < threshold) {
               System.out.println("removing " + secondValue);
               secondToFrequencyMap.remove(secondValue);
           }
       }
   }

//    private void cleanupQueue(long timestamp) {
//        long currentTime = timestamp;
//        long threshold = timestamp - (5 * 60 * 1000);
//        while (!q.isEmpty()) {
//            if (q.peek() < threshold) {
//                q.remove();
//            }
//        }
//    }

}
