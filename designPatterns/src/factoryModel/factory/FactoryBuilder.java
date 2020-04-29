package factoryModel.factory;

import factoryModel.plant.PlantNameConstant;

public class FactoryBuilder {
    public static Factory build(String name) {
        Factory factory = null;
        if(PlantNameConstant.BEAN_NAME.equals(name)) {
            factory = new BeanFactory();
        } else if (PlantNameConstant.ICE_NAME.equals(name)) {
            factory = new IceFactory();
        } else if (PlantNameConstant.WALL_NAME.equals(name)) {
            factory = new WallFactory();
        }
        return factory;
    }

    public static Factory buildByClassName(String name) throws Exception {
        return (Factory)Class.forName(name).newInstance();
    }
}
