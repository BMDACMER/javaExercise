package factoryModel;

import factoryModel.factory.Factory;
import factoryModel.factory.FactoryBuilder;
import factoryModel.plant.Plant;

public class Function {
    public void put(String name, int number) throws Exception{
        Factory factory = FactoryBuilder.buildByClassName(name);
        Plant plant = factory.createPlant();
        System.out.println("将" + plant.getName() + "放在" + number + "号草地上");
        plant.fight();
    }
}
