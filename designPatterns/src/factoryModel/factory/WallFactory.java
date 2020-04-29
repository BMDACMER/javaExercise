package factoryModel.factory;

import factoryModel.component.Shell;
import factoryModel.plant.Plant;
import factoryModel.plant.Wall;

public class WallFactory implements Factory {
    public Plant createPlant() {
        Wall wall = new Wall();
        Shell shell = new Shell();
        shell.setHardness(5);
        wall.setShell(shell);
        return wall;
    }
}
