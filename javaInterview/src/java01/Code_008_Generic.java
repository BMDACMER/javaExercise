package java01;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * ����
 */
public class Code_008_Generic {
    private HashMap<Integer, String> map;

    /** ���н�����Ϊ��
     map�����������ǣ�class java.util.HashMap
     ���������ǣ�java.util.HashMap<java.lang.Integer, java.lang.String>
     class java.lang.Integer
     class java.lang.String
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Class<Code_008_Generic> c = Code_008_Generic.class;
        Field field = c.getDeclaredField("map");
        Class<?> type = field.getType();
        System.out.println("map�����������ǣ�" + type);
        Type gType = field.getGenericType();
        if (gType instanceof ParameterizedType){
            ParameterizedType pType = (ParameterizedType)gType;
            System.out.println("���������ǣ�" + pType);
            for (Type t:pType.getActualTypeArguments()){
                System.out.println(t);
            }
        }
    }
}
