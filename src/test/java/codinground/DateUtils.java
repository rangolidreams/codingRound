package codinground;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    static final long ONE_DAY = 24 * 60 * 60 * 1000;
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static Date today() {
        return new Date();
    }
    public static Date tomorrow() {
        return nDaysFromToday(1);
    }
    public static Date nDaysFromToday(long n) {
        return new Date(System.currentTimeMillis() + ONE_DAY * n);
    }
    public static String formatDate(Date date) {
        return dateFormat.format(date);
    }
}
