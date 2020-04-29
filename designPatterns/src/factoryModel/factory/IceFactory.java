package factoryModel.factory;

import factoryModel.component.Arms;
import factoryModel.component.Hair;
import factoryModel.plant.Ice;
import factoryModel.plant.Plant;

public class IceFactory implements Factory {

    @Override
    public Plant createPlant() {
        Ice ice = new Ice();
        Hair hair = new Hair();
        hair.setColor("À¶É«");
        ice.setHair(hair);
        Arms arms = new Arms();
        arms.setBulletType("±ù¶³µÄ¶¹×Ó");
        ice.setArms(arms);
        return ice;
    }
}
