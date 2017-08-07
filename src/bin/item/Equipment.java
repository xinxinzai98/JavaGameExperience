package bin.item;

import bin.common.JItemType;

public abstract class Equipment extends RootItem {
    private int Strength;               //力量
    private int Agile;                  //敏捷
    private int Intelligence;           //智力
    private int Level;                  //等级
    private boolean Arma;               //是否装备

    public Equipment() {
        System.out.printf("装备.出现错误");
    }

    public Equipment(JItemType itemType, int itemNum) {
        super(itemType, itemNum);
        Arma = false;
    }

    @Override
    public void printItemInfo() {
        super.printItemInfo();
        System.out.printf("\n是否装备:%s",Arma);
        System.out.printf("\n力量:%s",Strength);
        System.out.printf("\n敏捷:%s",Agile);
        System.out.printf("\n智力:%d",Intelligence);
        System.out.printf("\n等级:Lv %d",Level);
    }

    public int getStrength() {
        return Strength;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }

    public int getAgile() {
        return Agile;
    }

    public void setAgile(int agile) {
        Agile = agile;
    }

    public int getIntelligence() {
        return Intelligence;
    }

    public void setIntelligence(int intelligence) {
        Intelligence = intelligence;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public boolean isArma() {
        return Arma;
    }

    public void setArma(boolean arma) {
        Arma = arma;
    }
}
