package factoryModel.factory;

import factoryModel.component.Arms;
import factoryModel.component.Hair;
import factoryModel.plant.Bean;
import factoryModel.plant.Plant;

public class BeanFactory implements Factory{
    @Override
    public Plant createPlant() {
        Bean bean = new Bean();
        Hair hair = new Hair();
        hair.setColor("��ɫ");
        bean.setHair(hair);
        Arms arms = new Arms();
        arms.setBulletType("��ͨ�Ķ���");
        bean.setArms(arms);
        return bean;
    }
}
