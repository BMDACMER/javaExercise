package javabase.innerClass;

public class Person {
    String name = "����";
    public void eat() {
        System.out.println("�����ڳ�����~");
    }

    // �Ǿ�̬��Ա�ڲ���
    class Bird {
        String name = "dog";
        public void display(String name) {
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(Person.this.name);
            Person.this.eat();
        }
    }

    public static void main(String[] args) {
        Person person = new Person();
        Person.Bird bird = person.new Bird();
        bird.display("��ɶɶ");
    }
}
