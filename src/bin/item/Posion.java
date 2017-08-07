package bin.item;

import bin.common.JItemQuality;
import bin.common.JItemType;

public class Posion extends RootItem {
    private int Hp;                 //回复血量
    private int Mp;                 //恢复魔法
    private int Round;              //持续回合数
    private int Attack;             //提升攻击力
    private int PhysicalResistance; //物理抗性
    private int MagicResistance;    //魔法抗性

    public Posion() {
        System.out.printf("药水.出现错误");
    }

    public Posion(JItemType itemType, int itemNum) {
        super(itemType, itemNum);
    }

    @Override
    public void itemInit() {
        String Name = "未知的药水";      //物品名称
        int Price = 0;                  // 价格
        int Weight = 0;                 // 重量
        int Rare = 0;                   // 稀有度
        boolean Binding = false;        // 是否绑定
        String Info = "";               // 物品信息
        JItemQuality Quality = JItemQuality.QualityNormal;//品质
        int Hp = 0;                     // 回复血量
        int Mp = 0;                     // 恢复魔法
        int Round = 0;                  // 持续回合数
        int Attack = 0;                 // 提升攻击力
        int PhysicalResistance = 0;     // 物理抗性
        int MagicResistance = 0;        // 魔法抗性

        switch (super.getItemNum()){
            case 1:
                Name = "面包";
                Price = 2;
                Weight = 1;
                Rare = 0;
                Binding = false;
                Info = "就是个面包";
                Hp = 20;
                break;
            case 2:
                Name = "范学博的面包";
                break;
        }





        super.setName(Name);
        super.setPrice(Price);
        super.setWeight(Weight);
        super.setRare(Rare);
        super.setBinding(Binding);
        super.setInfo(Info);
        super.setQuality(Quality);

        setHp(Hp);
        setMp(Mp);
        setRound(Round);
        setAttack(Attack);
        setPhysicalResistance(PhysicalResistance);
        setMagicResistance(MagicResistance);
    }

    public int getHp() {
        return Hp;
    }

    public void setHp(int hp) {
        Hp = hp;
    }

    public int getMp() {
        return Mp;
    }

    public void setMp(int mp) {
        Mp = mp;
    }

    public int getRound() {
        return Round;
    }

    public void setRound(int round) {
        Round = round;
    }

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int attack) {
        Attack = attack;
    }

    public int getPhysicalResistance() {
        return PhysicalResistance;
    }

    public void setPhysicalResistance(int physicalResistance) {
        PhysicalResistance = physicalResistance;
    }

    public int getMagicResistance() {
        return MagicResistance;
    }

    public void setMagicResistance(int magicResistance) {
        MagicResistance = magicResistance;
    }
}
