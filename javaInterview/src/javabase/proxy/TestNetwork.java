package javabase.proxy;

public class TestNetwork {
    public static void main(String[] args) {

        ProxyServer proxyServer = new ProxyServer(new Network() {
            @Override
            public void work() {
                System.out.println("��ʼ����!!!!!!!!!!!!!");
            }
        });
        proxyServer.work();
    }
}
