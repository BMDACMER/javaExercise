package factoryModel.factory;

import factoryModel.component.Shell;
import factoryModel.plant.Plant;
import factoryModel.plant.Wall;

public class NewWallFactory implements Factory {

    @Override
    public Plant createPlant() {
        Wall wall = new Wall();
        Shell shell = new Shell();
        shell.setHardness(10);
        wall.setShell(shell);
        return wall;
    }
}
