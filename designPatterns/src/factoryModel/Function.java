package factoryModel;

import factoryModel.factory.Factory;
import factoryModel.factory.FactoryBuilder;
import factoryModel.plant.Plant;

public class Function {
    public void put(String name, int number) throws Exception{
        Factory factory = FactoryBuilder.buildByClassName(name);
        Plant plant = factory.createPlant();
        System.out.println("��" + plant.getName() + "����" + number + "�Ųݵ���");
        plant.fight();
    }
}
