package factoryModel.factory;

import factoryModel.component.Arms;
import factoryModel.component.Hair;
import factoryModel.component.Shell;
import factoryModel.plant.*;

public class SimpleFactory {
    // ����ֲ�����ľ�̬����
    public static Plant createPlant(String name) {
        Plant plant = null;
        if(PlantNameConstant.BEAN_NAME.equals(name)) {
            Bean bean = new Bean();
            Hair hair = new Hair();
            hair.setColor("��ɫ");
            bean.setHair(hair);
            Arms arms = new Arms();
            arms.setBulletType("��ͨ�Ķ���");
            bean.setArms(arms);
            plant = bean;
        } else if (PlantNameConstant.ICE_NAME.equals(name)) {
            Ice ice = new Ice();
            Hair hair = new Hair();
            hair.setColor("��ɫ");
            ice.setHair(hair);
            Arms arms = new Arms();
            arms.setBulletType("�����Ķ���");
            ice.setArms(arms);
            plant = ice;
        } else if (PlantNameConstant.WALL_NAME.equals(name)) {
            Wall wall = new Wall();
            Shell shell = new Shell();
            shell.setHardness(5);
            wall.setShell(shell);
            plant = wall;
        } else if ("new_Wall".equals(name)) {
            Wall wall = new Wall();
            Shell shell = new Shell();
            shell.setHardness(10);
            wall.setShell(shell);
            plant = wall;
        }
        return plant;
    }

    public static Plant createPlantByClassName(String name) throws Exception {
        return (Plant)Class.forName(name).newInstance();
    }
}
