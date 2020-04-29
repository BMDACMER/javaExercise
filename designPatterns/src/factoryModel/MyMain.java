package factoryModel;

import factoryModel.factory.Factory;
import factoryModel.plant.PlantNameConstant;

public class MyMain {
    public static void main(String[] args) throws Exception {
        Function function = new Function();
        function.put(PlantNameConstant.BEAN_NAME, 8);
        function.put(PlantNameConstant.ICE_NAME,15);
        function.put(PlantNameConstant.WALL_NAME,9);
    }
}
