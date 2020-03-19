package java01;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * 泛型
 */
public class Code_008_Generic {
    private HashMap<Integer, String> map;

    /** 下列结果输出为：
     map的数据类型是：class java.util.HashMap
     泛型类型是：java.util.HashMap<java.lang.Integer, java.lang.String>
     class java.lang.Integer
     class java.lang.String
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Class<Code_008_Generic> c = Code_008_Generic.class;
        Field field = c.getDeclaredField("map");
        Class<?> type = field.getType();
        System.out.println("map的数据类型是：" + type);
        Type gType = field.getGenericType();
        if (gType instanceof ParameterizedType){
            ParameterizedType pType = (ParameterizedType)gType;
            System.out.println("泛型类型是：" + pType);
            for (Type t:pType.getActualTypeArguments()){
                System.out.println(t);
            }
        }
    }
}
