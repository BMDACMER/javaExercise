package javabase.proxy;

public class ProxyServer implements Network {
    private Network work;

    public ProxyServer(Network work) {
        this.work = work;
    }

    public void check(){
        System.out.println("����֮ǰ�ļ�鹤��");
    }

    @Override
    public void work() {
        check();
        work.work();
    }
}
