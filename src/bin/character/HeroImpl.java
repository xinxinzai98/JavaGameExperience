package bin.character;

import bin.common.JHeroMenuPackageState;
import bin.common.JHeroMenuState;
import bin.common.JHeroState;
import bin.common.JItemType;
import bin.heropackage.HeroEquipment;
import bin.heropackage.HeroPackage;
import bin.util.ToolsImpl;

/**
 * �������˹�
 */
public class HeroImpl extends AnimalImpl implements Hero {
    private int Strength;               //����
    private int Agile;                  //����
    private int Intelligence;           //����
    private int Burden;                 //����
    private int MaxBurden;              //�����
    private String Epithet;             //�ƺ�
    private int MaxExperience;          //�����ֵ
    private JHeroState heroState;       //Ӣ��״̬�궨��
    private JHeroMenuState menuState;   //�˵�״̬�궨��
    private JHeroMenuPackageState packageState;      //����״̬�궨��
    private ToolsImpl Tools;            //������
    public HeroPackage PACKAGE;         //������
    private HeroEquipment heroEquipment;//Ӣ��װ��

    public HeroImpl() {
        super();
        heroState = JHeroState.HeroNormal;
        menuState = JHeroMenuState.MenuNormal;
        packageState = JHeroMenuPackageState.PackageNormal;
        if (Tools == null) {
            Tools = new ToolsImpl();
        }
        if (PACKAGE == null) {
            PACKAGE = new HeroPackage();//Ӣ�۱���
        }
        PACKAGE.addItem(JItemType.TypePosion, 1);
        PACKAGE.addItem(JItemType.TypePosion, 2);
        PACKAGE.addItem(JItemType.TypeWeapon, 1);
        PACKAGE.addItem(JItemType.TypeWeapon, 2);
    }


    public boolean OnMove(String dir) {
        switch (dir) {
            case "��":
                setPositionY(getPositionY() - 1);
                return true;

            case "��":
                setPositionX(getPositionX() + 1);
                return true;

            case "��":
                setPositionY(getPositionY() + 1);
                return true;

            case "��":
                setPositionX(getPositionX() - 1);
                return true;

            case "����":
                setPositionX(getPositionX() - 1);
                setPositionY(getPositionY() - 1);
                return true;

            case "����":
                setPositionX(getPositionX() + 1);
                setPositionY(getPositionY() - 1);
                return true;

            case "����":
                setPositionX(getPositionX() - 1);
                setPositionY(getPositionY() + 1);
                return true;
            case "����":
                setPositionX(getPositionX() + 1);
                setPositionY(getPositionY() + 1);
                return true;
            default:
                return false;
        }
    }

    @Override
    public void printMainMenu() {
        String[] MainMenu = {"����[״̬]", "�鿴[����]", "[�˳�]�˵�"};
        Tools.printMenu(MainMenu);
    }

    @Override
    public void printPackageMenu() {
        String[] PackageMenu = {"[����]����", "[װ��]����", "[��Ʒ]����", "[ҩˮ]����", "[����]��һ��"};
        Tools.printMenu(PackageMenu);
    }

    @Override
    public void printHeroState() {
        System.out.printf("\n����:%s", super.getName());
        System.out.printf("\n�ƺ�:%s", getEpithet());
        System.out.printf("\n�ȼ�:Lv%s", super.getLevel());
        System.out.printf("\n����:%s",super.getExperience());
        System.out.printf("%s",getMaxExperience());
        System.out.printf("\n����:%s", super.getAge());
        System.out.printf("\nѪ��:%s/", super.getHp());
        System.out.printf("%s", super.getMaxHp());
        System.out.printf("+%s/r", super.getHpGain());
        System.out.printf("\nħ��ֵ:%s/", super.getMp());
        System.out.printf("%s", super.getMaxMp());
        System.out.printf("+%s/r", super.getMpGain());
        System.out.printf("\n����:%s", getStrength());
        System.out.printf("\n����:%s", getAgile());
        System.out.printf("\n����:%s", getIntelligence());
        System.out.printf("\n����:%s/", getBurden());
        System.out.printf("%s", getMaxBurden());
        System.out.printf("\n������:%s", super.getPhysicalResistance());
        System.out.printf("\nħ������:%s", super.getMagicResistance());
        System.out.printf("\n����͸:%s", super.getArmorPenetration());
        System.out.printf("\nħ����͸:%s", super.getMagicPenetration());
        System.out.printf("\n��ǰװ��");
        System.out.printf("\n����:%s",heroEquipment.getHeroWeapon().getName());
        System.out.printf("\nͷ��:%s",heroEquipment.getArmorHat().getName());
        System.out.printf("\n����:%s",heroEquipment.getArmorCoat().getName());
        System.out.printf("\n����:%s",heroEquipment.getArmorPant().getName());
        System.out.printf("\n����:%s",heroEquipment.getArmorLegging().getName());
        System.out.printf("\nЬ��:%s",heroEquipment.getArmorShoe().getName());
    }

    @Override
    public void printHeroStateMenu() {
        System.out.printf("��������������\n");
        String[] PackageMenu = {"[����(����)]װ��","[����]��һ��"};
        Tools.printMenu(PackageMenu);
    }

    @Override
    public void getEquipment() {
        if (PACKAGE.isEquitmentWeaponstate()){
            PACKAGE.setEquitmentWeaponstate(false);
            if(PACKAGE.getWeapon().getLevel()>this.getLevel()){
                System.out.printf("\nװ��ʧ��,���ĵȼ�lv%s���������ȼ�%s",this.getLevel(),PACKAGE.getWeapon().getLevel());
                return;
            }else{

                System.out.printf("\nװ���ɹ�");
            }
        }

    }

    public JHeroState getHeroState() {
        return heroState;
    }

    public void setHeroState(JHeroState heroState) {
        this.heroState = heroState;
    }

    public JHeroMenuState getMenuState() {
        return menuState;
    }

    public void setMenuState(JHeroMenuState menuState) {
        this.menuState = menuState;
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

    public JHeroMenuPackageState getPackageState() {
        return packageState;
    }

    public void setPackageState(JHeroMenuPackageState packageState) {
        this.packageState = packageState;
    }

    public int getBurden() {
        return Burden;
    }

    public void setBurden(int burden) {
        Burden = burden;
    }

    public int getMaxBurden() {
        return MaxBurden;
    }

    public void setMaxBurden(int maxBurden) {
        MaxBurden = maxBurden;
    }

    public String getEpithet() {
        return Epithet;
    }

    public void setEpithet(String epithet) {
        Epithet = epithet;
    }

    public int getMaxExperience() {
        return MaxExperience;
    }

    public void setMaxExperience(int maxExperience) {
        MaxExperience = maxExperience;
    }
}
