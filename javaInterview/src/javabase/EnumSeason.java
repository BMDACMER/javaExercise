package javabase;

enum EnumSeason {

    SPRING("����","��ů����"),
    SUMMER("����","��������"),
    AUTUMN("����","�����ˬ"),
    WINTER("����","��ѩ����");

    private final String seasonName;
    private final String seasonDesc;


    EnumSeason(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}

