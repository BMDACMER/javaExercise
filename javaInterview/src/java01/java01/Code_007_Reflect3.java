package java01.java01;

import java.lang.reflect.Field;

public class Code_007_Reflect3 {
    public static void main(String[] args) {
        ReadOnlyClass readOnlyClass = new ReadOnlyClass();
        Class<?> clazz = ReadOnlyClass.class;
        try {
            Field field = clazz.getDeclaredField("age");
            field.setAccessible(true);
            field.set(readOnlyClass,30);
            System.out.println(readOnlyClass.getAge());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}

class ReadOnlyClass{
    private Integer age = 20;

    public Integer getAge() {
        return age;
    }
}