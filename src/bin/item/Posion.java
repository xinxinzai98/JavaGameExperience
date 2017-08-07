package bin.item;

import bin.common.JItemQuality;
import bin.common.JItemType;

public class Posion extends RootItem {
    private int Hp;                 //�ظ�Ѫ��
    private int Mp;                 //�ָ�ħ��
    private int Round;              //�����غ���
    private int Attack;             //����������
    private int PhysicalResistance; //������
    private int MagicResistance;    //ħ������

    public Posion() {
        System.out.printf("ҩˮ.���ִ���");
    }

    public Posion(JItemType itemType, int itemNum) {
        super(itemType, itemNum);
    }

    @Override
    public void itemInit() {
        String Name = "δ֪��ҩˮ";      //��Ʒ����
        int Price = 0;                  // �۸�
        int Weight = 0;                 // ����
        int Rare = 0;                   // ϡ�ж�
        boolean Binding = false;        // �Ƿ��
        String Info = "";               // ��Ʒ��Ϣ
        JItemQuality Quality = JItemQuality.QualityNormal;//Ʒ��
        int Hp = 0;                     // �ظ�Ѫ��
        int Mp = 0;                     // �ָ�ħ��
        int Round = 0;                  // �����غ���
        int Attack = 0;                 // ����������
        int PhysicalResistance = 0;     // ������
        int MagicResistance = 0;        // ħ������

        switch (super.getItemNum()){
            case 1:
                Name = "���";
                Price = 2;
                Weight = 1;
                Rare = 0;
                Binding = false;
                Info = "���Ǹ����";
                Hp = 20;
                break;
            case 2:
                Name = "��ѧ�������";
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
