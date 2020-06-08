package factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    //����һ��Properties����
    private static Properties props;

    //����һ��Map,���ڴ������Ҫ�����Ķ������ǰ�����֮Ϊ����
    private static Map<String,Object> beans;

    //ʹ�þ�̬�����ΪProperties����ֵ
    static {
        try {
            //ʵ��������
            props = new Properties();
            //��ȡproperties�ļ���������
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            //ʵ��������
            beans = new HashMap<String,Object>();
            //ȡ�������ļ������е�Key
            Enumeration keys = props.keys();
            //����ö��
            while (keys.hasMoreElements()){
                //ȡ��ÿ��Key
                String key = keys.nextElement().toString();
                //����key��ȡvalue
                String beanPath = props.getProperty(key);
                //���䴴������
                Object value = Class.forName(beanPath).newInstance();
                //��key��value����������
                beans.put(key,value);
            }
        }catch(Exception e){
            throw new ExceptionInInitializerError("��ʼ��propertiesʧ�ܣ�");
        }
    }

    /**
     * ����bean�����ƻ�ȡ����
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }


}
