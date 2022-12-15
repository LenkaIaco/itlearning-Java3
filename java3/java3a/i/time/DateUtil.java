package sk.itlearning.java3.java3a.i.time;

import java.time.Duration;
import java.time.LocalDateTime;

public class DateUtil {

	public static String getDurationFormatted(LocalDateTime start, LocalDateTime stop) {
		return Duration.between(start, stop).getSeconds() + "," + Duration.between(start, stop).getNano();
	}
	
}
