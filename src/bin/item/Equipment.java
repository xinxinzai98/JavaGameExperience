package bin.item;

import bin.common.JItemType;

public abstract class Equipment extends RootItem {
    private int Strength;               //����
    private int Agile;                  //����
    private int Intelligence;           //����
    private int Level;                  //�ȼ�
    private boolean Arma;               //�Ƿ�װ��

    public Equipment() {
        System.out.printf("װ��.���ִ���");
    }

    public Equipment(JItemType itemType, int itemNum) {
        super(itemType, itemNum);
        Arma = false;
    }

    @Override
    public void printItemInfo() {
        super.printItemInfo();
        System.out.printf("\n�Ƿ�װ��:%s",Arma);
        System.out.printf("\n����:%s",Strength);
        System.out.printf("\n����:%s",Agile);
        System.out.printf("\n����:%d",Intelligence);
        System.out.printf("\n�ȼ�:Lv %d",Level);
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
