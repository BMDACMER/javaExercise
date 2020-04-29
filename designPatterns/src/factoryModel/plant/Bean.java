package factoryModel.plant;

import factoryModel.component.Arms;
import factoryModel.component.Hair;

public class Bean implements Plant{
    private Hair hair;

    private Arms arms;

    @Override
    public String getName() {
        return "ÂÌ¶¹";
    }

    @Override
    public void fight() {
        System.out.println("·¢ÉäÒ»¿Å¶¹×Ó");
    }

    public Hair getHair() {
        return hair;
    }

    public void setHair(Hair hair) {
        this.hair = hair;
    }

    public Arms getArms() {
        return arms;
    }

    public void setArms(Arms arms) {
        this.arms = arms;
    }
}
