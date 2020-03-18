package java01;

/**
 *  多态
 */

class Base{
    public Base(){
        g();
    }

    public void g(){
        System.out.println("Base g()");
    }

    public void f(){
        System.out.println("Base f()");
    }

}

class Derived extends Base{
    @Override
    public void g() {
//        super.g();
        System.out.println("Derived g()");
    }

    @Override
    public void f() {
        System.out.println("Derived f()");
    }


}

public class Code_006_Overload_Override {

    public static void main(String[] args) {
        Base b = new Derived();
        b.f();
        b.g();
        /**  输出结果
         Derived g()
         Derived f()
         Derived g()
         */
    }
}
