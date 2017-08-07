package bin.item;

import bin.common.JItemArmorType;
import bin.common.JItemQuality;
import bin.common.JItemType;

public class Armor extends Equipment {
    private int PhysicalResistance; //物理抗性
    private int MagicResistance;    //魔法抗性
    private int MaxHp;  // 血量
    private int MaxMp;  // 魔法
    private int HpGain; // 血量回复速度
    private int MpGain; // 魔法值恢复速度
    private JItemArmorType ArmorType; //护甲类型

    public Armor() {
        System.out.printf("护甲.出现错误");
    }

    public Armor(JItemType itemType, int itemNum) {
        super(itemType, itemNum);
    }

    @Override
    public void itemInit() {
        String Name = "未知的护甲";   //名称
        int Price = 0;              //价格
        int Weight = 0;             //重量
        int Rare = 0;               //稀有度
        Boolean Binding = false;    //是否绑定
        String Info = "";           //描述
        JItemQuality Quality = JItemQuality.QualityNormal;//品质
        int Strength = 0;           //力量
        int Agile = 0;              //敏捷
        int Intelligence = 0;       //智力
        int Level = 0;              //等级
        int PhysicalResistance = 0; //物理抗性
        int MagicResistance = 0;    //魔法抗性
        int MaxHp = 0;  // 血量
        int MaxMp = 0;  // 魔法
        int HpGain = 0; // 血量回复速度
        int MpGain = 0; // 魔法值恢复速度
        JItemArmorType ArmorType = JItemArmorType.ArmorDefault; //护甲类型
        switch (super.getItemNum()) {
            case 1:
                Name = "布衣";
                Price = 10;
                Weight = 1;
                Info = "初始的小垃圾";
                Quality = JItemQuality.QualityNormal;
                ArmorType = JItemArmorType.ArmorCoat;
                break;
            case 2:
                Name = "布裤";
                Price = 10;
                Weight = 1;
                Info = "初始的小垃圾";
                Quality = JItemQuality.QualityNormal;
                ArmorType = JItemArmorType.ArmorPant;
                break;
            case 3:
                Name = "草鞋";
                Price = 10;
                Weight = 1;
                Info = "初始的小垃圾";
                Quality = JItemQuality.QualityNormal;
                ArmorType = JItemArmorType.ArmorShoe;
                break;
        }


        super.setName(Name);
        super.setPrice(Price);
        super.setWeight(Weight);
        super.setRare(Rare);
        super.setBinding(Binding);
        super.setInfo(Info);
        super.setQuality(Quality);

        super.setStrength(Strength);
        super.setAgile(Agile);
        super.setIntelligence(Intelligence);
        super.setLevel(Level);

        setPhysicalResistance(PhysicalResistance);
        setMagicResistance(MagicResistance);
        setMaxHp(MaxHp);
        setMaxMp(MaxMp);
        setHpGain(HpGain);
        setMpGain(MpGain);
        setArmorType(ArmorType);

    }

    @Override
    public void printItemInfo() {
        super.printItemInfo();
        System.out.printf("\n物理抗性:%s", PhysicalResistance);
        System.out.printf("\n魔法抗性:%s", MagicResistance);
        System.out.printf("\n增加最大生命值:%d", MaxHp);
        System.out.printf("\n增加最大魔法值:%d", MaxMp);
        System.out.printf("\n生命回复:%d", HpGain);
        System.out.printf("\n魔法回复:%d", MpGain);
        System.out.printf("\n护甲类型:");
        switch (ArmorType) {
            case ArmorHat:
                System.out.printf("头部");
                break;
            case ArmorCoat:
                System.out.printf("上身");
                break;
            case ArmorPant:
                System.out.printf("下身");
                break;
            case ArmorLegging:
                System.out.printf("护具");
                break;
            case ArmorShoe:
                System.out.printf("鞋子");
                break;
            default:
                System.out.printf("ERR");
                break;
        }

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

    public int getMaxHp() {
        return MaxHp;
    }

    public void setMaxHp(int maxHp) {
        MaxHp = maxHp;
    }

    public int getMaxMp() {
        return MaxMp;
    }

    public void setMaxMp(int maxMp) {
        MaxMp = maxMp;
    }

    public int getHpGain() {
        return HpGain;
    }

    public void setHpGain(int hpGain) {
        HpGain = hpGain;
    }

    public int getMpGain() {
        return MpGain;
    }

    public void setMpGain(int mpGain) {
        MpGain = mpGain;
    }

    public JItemArmorType getArmorType() {
        return ArmorType;
    }

    public void setArmorType(JItemArmorType armorType) {
        ArmorType = armorType;
    }
}
