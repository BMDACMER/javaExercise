package java01;

import java.util.Date;

public class Code_001_Immutable {
    public static void main(String[] args) {
        Date d = new Date();
//        Immutable immutable = new Immutable(d);
//        immutable.printState();   // Tue Mar 17 09:38:40 CST 2020
//        d.setMonth(5);  // 引用对象发生改变，则Immutable也随之改变
//        immutable.printState();  // Wed Jun 17 09:38:40 CST 2020
        System.out.println("*******************");

        Immutable2 immutable2 = new Immutable2(d);
        immutable2.printState();
        d.setMonth(3);  // 已解除引用，相当于原来对象的改变不会影响到现在对象
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

// 如果一个类成员不是不可变量，那么在成员初始化或者使用get方法获取该成员变量时需要通过clone方法，来确保类的不可变性
class Immutable2 {
    private Date d;

    public Immutable2(Date d) {
        this.d = (Date) d.clone();   // 相当于解除引用
    }

//    public Date getD() {
//        return (Date) d.clone();
//    }

    public void printState() {
        System.out.println(d);
    }
}
