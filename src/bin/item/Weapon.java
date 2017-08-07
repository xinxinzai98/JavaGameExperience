package bin.item;

import bin.common.JItemQuality;
import bin.common.JItemType;

import java.util.Comparator;

public class Weapon extends Equipment {
    private int Attack;             //攻击力
    private int SkillDamage;        //技能伤害
    private int ArmorPenetration;   //物理穿透
    private int MagicPenetration;   //魔法穿透

    public Weapon() {
        System.out.printf("武器.出现错误");
    }

    public Weapon(JItemType itemType, int itemNum) {
        super(itemType, itemNum);
    }

    @Override
    public void itemInit() {
        String Name = "未知的武器";   //名称
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
        int Attack = 0;             //攻击力
        int SkillDamage = 0;        //技能伤害
        int ArmorPenetration = 0;   //物理穿透
        int MagicPenetration = 0;   //魔法穿透
        switch (super.getItemNum()) {
            case 1:
                Name = "小木棒";
                Price = 10;
                Weight = 1;
                Info = "初始的小垃圾";
                Quality = JItemQuality.QualityNormal;
                Attack = 10;
                break;
            case 2:
                Name = "大木棒";
                Price = 20;
                Weight = 2;
                Info = "初始的小垃圾";
                Quality = JItemQuality.QualityNormal;
                Attack = 15;
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

        setAttack(Attack);
        setSkillDamage(SkillDamage);
        setArmorPenetration(ArmorPenetration);
        setMagicPenetration(MagicPenetration);

    }

    @Override
    public void printItemInfo() {
        super.printItemInfo();
        System.out.printf("\n攻击力:%s", Attack);
        System.out.printf("\n技能伤害:%s", SkillDamage);
        System.out.printf("\n物理穿透:%d", ArmorPenetration);
        System.out.printf("\n魔法穿透:%d\n", MagicPenetration);
    }

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int attack) {
        Attack = attack;
    }

    public int getSkillDamage() {
        return SkillDamage;
    }

    public void setSkillDamage(int skillDamage) {
        SkillDamage = skillDamage;
    }

    public int getArmorPenetration() {
        return ArmorPenetration;
    }

    public void setArmorPenetration(int armorPenetration) {
        ArmorPenetration = armorPenetration;
    }

    public int getMagicPenetration() {
        return MagicPenetration;
    }

    public void setMagicPenetration(int magicPenetration) {
        MagicPenetration = magicPenetration;
    }
}
