package imp_concepts.featuresOfJava8.dateAndTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class NewDateAndTime {
    public static void main(String[] args) {
        LocalDate now =  LocalDate.now();
        LocalTime time =  LocalTime.now();
        LocalDateTime datetime =  LocalDateTime.now();
        System.out.print(datetime);
    }
}
