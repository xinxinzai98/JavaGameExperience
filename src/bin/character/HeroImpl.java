package bin.character;

import bin.common.JHeroMenuPackageState;
import bin.common.JHeroMenuState;
import bin.common.JHeroState;
import bin.common.JItemType;
import bin.heropackage.HeroEquipment;
import bin.heropackage.HeroPackage;
import bin.util.ToolsImpl;

/**
 * 这是主人公
 */
public class HeroImpl extends AnimalImpl implements Hero {
    private int Strength;               //力量
    private int Agile;                  //敏捷
    private int Intelligence;           //智力
    private int Burden;                 //负重
    private int MaxBurden;              //最大负重
    private String Epithet;             //称号
    private int MaxExperience;          //最大经验值
    private JHeroState heroState;       //英雄状态宏定义
    private JHeroMenuState menuState;   //菜单状态宏定义
    private JHeroMenuPackageState packageState;      //背包状态宏定义
    private ToolsImpl Tools;            //工具类
    public HeroPackage PACKAGE;         //背包类
    private HeroEquipment heroEquipment;//英雄装备

    public HeroImpl() {
        super();
        heroState = JHeroState.HeroNormal;
        menuState = JHeroMenuState.MenuNormal;
        packageState = JHeroMenuPackageState.PackageNormal;
        if (Tools == null) {
            Tools = new ToolsImpl();
        }
        if (PACKAGE == null) {
            PACKAGE = new HeroPackage();//英雄背包
        }
        PACKAGE.addItem(JItemType.TypePosion, 1);
        PACKAGE.addItem(JItemType.TypePosion, 2);
        PACKAGE.addItem(JItemType.TypeWeapon, 1);
        PACKAGE.addItem(JItemType.TypeWeapon, 2);
    }


    public boolean OnMove(String dir) {
        switch (dir) {
            case "上":
                setPositionY(getPositionY() - 1);
                return true;

            case "右":
                setPositionX(getPositionX() + 1);
                return true;

            case "下":
                setPositionY(getPositionY() + 1);
                return true;

            case "左":
                setPositionX(getPositionX() - 1);
                return true;

            case "左上":
                setPositionX(getPositionX() - 1);
                setPositionY(getPositionY() - 1);
                return true;

            case "右上":
                setPositionX(getPositionX() + 1);
                setPositionY(getPositionY() - 1);
                return true;

            case "左下":
                setPositionX(getPositionX() - 1);
                setPositionY(getPositionY() + 1);
                return true;
            case "右下":
                setPositionX(getPositionX() + 1);
                setPositionY(getPositionY() + 1);
                return true;
            default:
                return false;
        }
    }

    @Override
    public void printMainMenu() {
        String[] MainMenu = {"人物[状态]", "查看[背包]", "[退出]菜单"};
        Tools.printMenu(MainMenu);
    }

    @Override
    public void printPackageMenu() {
        String[] PackageMenu = {"[武器]界面", "[装备]界面", "[物品]界面", "[药水]界面", "[返回]上一级"};
        Tools.printMenu(PackageMenu);
    }

    @Override
    public void printHeroState() {
        System.out.printf("\n姓名:%s", super.getName());
        System.out.printf("\n称号:%s", getEpithet());
        System.out.printf("\n等级:Lv%s", super.getLevel());
        System.out.printf("\n经验:%s",super.getExperience());
        System.out.printf("%s",getMaxExperience());
        System.out.printf("\n年龄:%s", super.getAge());
        System.out.printf("\n血量:%s/", super.getHp());
        System.out.printf("%s", super.getMaxHp());
        System.out.printf("+%s/r", super.getHpGain());
        System.out.printf("\n魔法值:%s/", super.getMp());
        System.out.printf("%s", super.getMaxMp());
        System.out.printf("+%s/r", super.getMpGain());
        System.out.printf("\n力量:%s", getStrength());
        System.out.printf("\n敏捷:%s", getAgile());
        System.out.printf("\n智力:%s", getIntelligence());
        System.out.printf("\n负重:%s/", getBurden());
        System.out.printf("%s", getMaxBurden());
        System.out.printf("\n物理抗性:%s", super.getPhysicalResistance());
        System.out.printf("\n魔法抗性:%s", super.getMagicResistance());
        System.out.printf("\n物理穿透:%s", super.getArmorPenetration());
        System.out.printf("\n魔法穿透:%s", super.getMagicPenetration());
        System.out.printf("\n当前装备");
        System.out.printf("\n武器:%s",heroEquipment.getHeroWeapon().getName());
        System.out.printf("\n头盔:%s",heroEquipment.getArmorHat().getName());
        System.out.printf("\n上身:%s",heroEquipment.getArmorCoat().getName());
        System.out.printf("\n下身:%s",heroEquipment.getArmorPant().getName());
        System.out.printf("\n护甲:%s",heroEquipment.getArmorLegging().getName());
        System.out.printf("\n鞋子:%s",heroEquipment.getArmorShoe().getName());
    }

    @Override
    public void printHeroStateMenu() {
        System.out.printf("在这个界面你可以\n");
        String[] PackageMenu = {"[脱下(名称)]装备","[返回]上一级"};
        Tools.printMenu(PackageMenu);
    }

    @Override
    public void getEquipment() {
        if (PACKAGE.isEquitmentWeaponstate()){
            PACKAGE.setEquitmentWeaponstate(false);
            if(PACKAGE.getWeapon().getLevel()>this.getLevel()){
                System.out.printf("\n装备失败,您的等级lv%s低于武器等级%s",this.getLevel(),PACKAGE.getWeapon().getLevel());
                return;
            }else{

                System.out.printf("\n装备成功");
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
