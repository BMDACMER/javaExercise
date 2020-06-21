package javabase.proxy;

public class Server implements Network {
    @Override
    public void work() {
        System.out.println("我才是真实的服务器");
    }
}
