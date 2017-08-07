package bin.item;

import bin.common.JItemArmorType;
import bin.common.JItemQuality;
import bin.common.JItemType;

public class Armor extends Equipment {
    private int PhysicalResistance; //������
    private int MagicResistance;    //ħ������
    private int MaxHp;  // Ѫ��
    private int MaxMp;  // ħ��
    private int HpGain; // Ѫ���ظ��ٶ�
    private int MpGain; // ħ��ֵ�ָ��ٶ�
    private JItemArmorType ArmorType; //��������

    public Armor() {
        System.out.printf("����.���ִ���");
    }

    public Armor(JItemType itemType, int itemNum) {
        super(itemType, itemNum);
    }

    @Override
    public void itemInit() {
        String Name = "δ֪�Ļ���";   //����
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
        int PhysicalResistance = 0; //������
        int MagicResistance = 0;    //ħ������
        int MaxHp = 0;  // Ѫ��
        int MaxMp = 0;  // ħ��
        int HpGain = 0; // Ѫ���ظ��ٶ�
        int MpGain = 0; // ħ��ֵ�ָ��ٶ�
        JItemArmorType ArmorType = JItemArmorType.ArmorDefault; //��������
        switch (super.getItemNum()) {
            case 1:
                Name = "����";
                Price = 10;
                Weight = 1;
                Info = "��ʼ��С����";
                Quality = JItemQuality.QualityNormal;
                ArmorType = JItemArmorType.ArmorCoat;
                break;
            case 2:
                Name = "����";
                Price = 10;
                Weight = 1;
                Info = "��ʼ��С����";
                Quality = JItemQuality.QualityNormal;
                ArmorType = JItemArmorType.ArmorPant;
                break;
            case 3:
                Name = "��Ь";
                Price = 10;
                Weight = 1;
                Info = "��ʼ��С����";
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
        System.out.printf("\n������:%s", PhysicalResistance);
        System.out.printf("\nħ������:%s", MagicResistance);
        System.out.printf("\n�����������ֵ:%d", MaxHp);
        System.out.printf("\n�������ħ��ֵ:%d", MaxMp);
        System.out.printf("\n�����ظ�:%d", HpGain);
        System.out.printf("\nħ���ظ�:%d", MpGain);
        System.out.printf("\n��������:");
        switch (ArmorType) {
            case ArmorHat:
                System.out.printf("ͷ��");
                break;
            case ArmorCoat:
                System.out.printf("����");
                break;
            case ArmorPant:
                System.out.printf("����");
                break;
            case ArmorLegging:
                System.out.printf("����");
                break;
            case ArmorShoe:
                System.out.printf("Ь��");
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
