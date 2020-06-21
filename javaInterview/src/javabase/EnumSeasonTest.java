package javabase;

public class EnumSeasonTest {
    public static void main(String[] args) {
        EnumSeason summer = EnumSeason.SUMMER;
        System.out.println(summer.toString());
        System.out.println("********************");
        EnumSeason[] values = EnumSeason.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        System.out.println("============");

        Thread.State[] value2 = Thread.State.values();
        for (int i = 0; i < value2.length; i++) {
            System.out.println(value2[i]);
        }

        System.out.println("**************============**********");

        EnumSeason winter = EnumSeason.valueOf("WINTER");
        System.out.println(winter.getSeasonName() + "\t" + winter.getSeasonDesc());
    }
}
