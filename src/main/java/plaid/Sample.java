package plaid;

import java.time.*;
import java.time.format.DateTimeFormatter;

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

    public static void main(String[] args) {
        helperFunctions();
    }

}
