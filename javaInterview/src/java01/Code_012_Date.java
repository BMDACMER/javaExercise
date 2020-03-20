package java01;

import java.time.*;

/**
 * ����������
 */
public class Code_012_Date {
    public static void main(String[] args) {
        // Clock ��ͨ��ָ��һ��ʱ�������Ի�ȡ����ǰ��ʱ�̣�������ʱ��
        Clock c = Clock.system(ZoneId.of("Asia/Chongqing"));  // �Ϻ�ʱ��
        System.out.println("����Clock��");
        System.out.println(c.millis());   // 1584712302605
        System.out.println(c.instant()); //2020-03-20T13:51:42.605Z

        // Instant ʹ�÷���
        System.out.println("����instant��");
        Instant ist = Instant.now();
        System.out.println(ist.getEpochSecond());  // ��ȷ����  1584712579
        System.out.println(ist.toEpochMilli());   // ��ȷ������  1584712579661

        // LocalDate ��ISO-8601��ʽ��ʾ���������ͣ���ʱ����Ϣ
        LocalDate date = LocalDate.now();
        LocalDate dateFromClock = LocalDate.now(c);
        System.out.println("����LocalDate��");
        System.out.println(date);   // 2020-03-20
        System.out.println(dateFromClock);  // 2020-03-20

        // LocalDateTime �� ISO-8601��ʽ��ʾ�����ں�ʱ��
        final LocalDateTime dateTime = LocalDateTime.now();
        final LocalDateTime datetimeFromClock = LocalDateTime.now(c);
        System.out.println("����LocalDateTime");
        System.out.println(dateTime);   // 2020-03-20T21:58:56.153
        System.out.println(datetimeFromClock);   // 2020-03-20T21:58:56.153
    }
}
