package bin.character;

/**
 *
 */
public class AnimalImpl implements Animal {
    private int Name;   // 名字
    private int Age;    // 年龄
    private int Attack; // 攻击力
    private int Hp;     // 血量
    private int MaxHp;  // 最大血量
    private int HpGain; // 血量回复速度
    private int Mp;     // 魔法值
    private int MaxMp;  // 最大魔法值
    private int MpGain; // 魔法值恢复速度
    private int Level;  // 等级
    private int PhysicalResistance; //物理抗性
    private int MagicResistance;    //魔法抗性
    private int ArmorPenetration;   //物理穿透
    private int MagicPenetration;   //魔法穿透
    private int Experience; // 经验值
    private int positionX;  // 坐标X
    private int positionY;  // 坐标Y

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
