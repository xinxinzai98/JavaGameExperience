package bin.item;

import bin.common.JItemQuality;
import bin.common.JItemType;

import java.util.Comparator;

public class Weapon extends Equipment {
    private int Attack;             //������
    private int SkillDamage;        //�����˺�
    private int ArmorPenetration;   //����͸
    private int MagicPenetration;   //ħ����͸

    public Weapon() {
        System.out.printf("����.���ִ���");
    }

    public Weapon(JItemType itemType, int itemNum) {
        super(itemType, itemNum);
    }

    @Override
    public void itemInit() {
        String Name = "δ֪������";   //����
        int Price = 0;              //�۸�
        int Weight = 0;             //����
        int Rare = 0;               //ϡ�ж�
        Boolean Binding = false;    //�Ƿ��
        String Info = "";           //����
        JItemQuality Quality = JItemQuality.QualityNormal;//Ʒ��
        int Strength = 0;           //����
        int Agile = 0;              //����
        int Intelligence = 0;       //����
        int Level = 0;              //�ȼ�
        int Attack = 0;             //������
        int SkillDamage = 0;        //�����˺�
        int ArmorPenetration = 0;   //����͸
        int MagicPenetration = 0;   //ħ����͸
        switch (super.getItemNum()) {
            case 1:
                Name = "Сľ��";
                Price = 10;
                Weight = 1;
                Info = "��ʼ��С����";
                Quality = JItemQuality.QualityNormal;
                Attack = 10;
                break;
            case 2:
                Name = "��ľ��";
                Price = 20;
                Weight = 2;
                Info = "��ʼ��С����";
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
        System.out.printf("\n������:%s", Attack);
        System.out.printf("\n�����˺�:%s", SkillDamage);
        System.out.printf("\n����͸:%d", ArmorPenetration);
        System.out.printf("\nħ����͸:%d\n", MagicPenetration);
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
