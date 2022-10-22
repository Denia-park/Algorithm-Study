package DateFormatEx;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateFormatEx2 {
    public static void main(String[] args) {
        LocalDate newYear = LocalDate.parse("2016-01-01", DateTimeFormatter.ISO_LOCAL_DATE);

        LocalDate date = LocalDate.parse("2001-01-01");
        LocalTime time = LocalTime.parse("23:59:59");
        LocalDateTime dateTime = LocalDateTime.parse("2001-01-01T23:59:59");

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime endOfYear = LocalDateTime.parse("2015-12-31 23:59:59", pattern);
        //"yyyy-MM-ddTHH:mm:ss" 로 내용이 입력되는 경우 : 예외 발생
        //"2015-12-31T23:59:59" 로 내용이 입력되는 경우 : 예외 발생

        System.out.println(newYear);
        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);
        System.out.println(endOfYear);
    }
}
