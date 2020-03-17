package java01;

import java.util.Date;

public class Code_001_Immutable {
    public static void main(String[] args) {
        Date d = new Date();
//        Immutable immutable = new Immutable(d);
//        immutable.printState();   // Tue Mar 17 09:38:40 CST 2020
//        d.setMonth(5);  // ���ö������ı䣬��ImmutableҲ��֮�ı�
//        immutable.printState();  // Wed Jun 17 09:38:40 CST 2020
        System.out.println("*******************");

        Immutable2 immutable2 = new Immutable2(d);
        immutable2.printState();
        d.setMonth(3);  // �ѽ�����ã��൱��ԭ������ĸı䲻��Ӱ�쵽���ڶ���
        immutable2.printState();
    }
}


class Immutable {
    private Date d;

    public Immutable(Date d) {
        this.d = d;
    }

    public void printState() {
        System.out.println(d);
    }
}

// ���һ�����Ա���ǲ��ɱ�������ô�ڳ�Ա��ʼ������ʹ��get������ȡ�ó�Ա����ʱ��Ҫͨ��clone��������ȷ����Ĳ��ɱ���
class Immutable2 {
    private Date d;

    public Immutable2(Date d) {
        this.d = (Date) d.clone();   // �൱�ڽ������
    }

//    public Date getD() {
//        return (Date) d.clone();
//    }

    public void printState() {
        System.out.println(d);
    }
}
