import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisTest {
    public static void main(String[] args) {
        // 创建jedis对象
        Jedis jedis = new Jedis("192.168.1.101", 6379);

        // 测试链接
        String ping = jedis.ping();
        System.out.println(ping);  // PONG
        // 向redis中添加String类型的数据
        jedis.set("k7", "v7");
        // 获取Redis中K7对应的值
        String v7 = jedis.get("k7");
        System.out.println("k7对应的值为：" + v7);   // k7对应的值为：v7
        //获取Redis中的所有的key
        Set<String> keys = jedis.keys("*");
        // 遍历
        for (String key : keys) {
            System.out.println(key);
        }
    }

}
