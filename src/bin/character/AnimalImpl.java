package bin.character;

/**
 *
 */
public class AnimalImpl implements Animal {
    private int Name;   // ����
    private int Age;    // ����
    private int Attack; // ������
    private int Hp;     // Ѫ��
    private int MaxHp;  // ���Ѫ��
    private int HpGain; // Ѫ���ظ��ٶ�
    private int Mp;     // ħ��ֵ
    private int MaxMp;  // ���ħ��ֵ
    private int MpGain; // ħ��ֵ�ָ��ٶ�
    private int Level;  // �ȼ�
    private int PhysicalResistance; //������
    private int MagicResistance;    //ħ������
    private int ArmorPenetration;   //����͸
    private int MagicPenetration;   //ħ����͸
    private int Experience; // ����ֵ
    private int positionX;  // ����X
    private int positionY;  // ����Y

    public int getName() {
        return Name;
    }

    public void setName(int name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int attack) {
        Attack = attack;
    }

    public int getHp() {
        return Hp;
    }

    public void setHp(int hp) {
        Hp = hp;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public int getExperience() {
        return Experience;
    }

    public void setExperience(int experience) {
        Experience = experience;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getMaxHp() {
        return MaxHp;
    }

    public void setMaxHp(int maxHp) {
        MaxHp = maxHp;
    }

    public int getMp() {
        return Mp;
    }

    public void setMp(int mp) {
        Mp = mp;
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
