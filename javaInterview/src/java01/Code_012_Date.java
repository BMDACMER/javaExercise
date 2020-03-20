package java01;

import java.time.*;

/**
 * 日期新特性
 */
public class Code_012_Date {
    public static void main(String[] args) {
        // Clock 类通过指定一个时区，可以获取到当前的时刻，日期与时间
        Clock c = Clock.system(ZoneId.of("Asia/Chongqing"));  // 上海时区
        System.out.println("测试Clock：");
        System.out.println(c.millis());   // 1584712302605
        System.out.println(c.instant()); //2020-03-20T13:51:42.605Z

        // Instant 使用方法
        System.out.println("测试instant：");
        Instant ist = Instant.now();
        System.out.println(ist.getEpochSecond());  // 精确到秒  1584712579
        System.out.println(ist.toEpochMilli());   // 精确到毫秒  1584712579661

        // LocalDate 以ISO-8601格式显示的日期类型，无时区信息
        LocalDate date = LocalDate.now();
        LocalDate dateFromClock = LocalDate.now(c);
        System.out.println("测试LocalDate：");
        System.out.println(date);   // 2020-03-20
        System.out.println(dateFromClock);  // 2020-03-20

        // LocalDateTime 以 ISO-8601格式显示的日期和时间
        final LocalDateTime dateTime = LocalDateTime.now();
        final LocalDateTime datetimeFromClock = LocalDateTime.now(c);
        System.out.println("测试LocalDateTime");
        System.out.println(dateTime);   // 2020-03-20T21:58:56.153
        System.out.println(datetimeFromClock);   // 2020-03-20T21:58:56.153
    }
}
