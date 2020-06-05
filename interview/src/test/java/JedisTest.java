import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisTest {
    public static void main(String[] args) {
        // ����jedis����
        Jedis jedis = new Jedis("192.168.1.101", 6379);

        // ��������
        String ping = jedis.ping();
        System.out.println(ping);  // PONG
        // ��redis�����String���͵�����
        jedis.set("k7", "v7");
        // ��ȡRedis��K7��Ӧ��ֵ
        String v7 = jedis.get("k7");
        System.out.println("k7��Ӧ��ֵΪ��" + v7);   // k7��Ӧ��ֵΪ��v7
        //��ȡRedis�е����е�key
        Set<String> keys = jedis.keys("*");
        // ����
        for (String key : keys) {
            System.out.println(key);
        }
    }

}
