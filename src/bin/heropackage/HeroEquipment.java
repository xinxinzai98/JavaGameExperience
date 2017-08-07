package bin.heropackage;

import bin.common.JItemArmorType;
import bin.common.JItemType;
import bin.item.Armor;
import bin.item.Weapon;

public class HeroEquipment {
    private Weapon HeroWeapon;
    private Armor ArmorHat;
    private Armor ArmorCoat;
    private Armor ArmorPant;
    private Armor ArmorLegging;
    private Armor ArmorShoe;

    public HeroEquipment() {
        HeroWeapon = new Weapon(JItemType.TypeWeapon, 1);
        ArmorHat = new Armor(JItemType.TypeArmor, 0);
        ArmorHat.setArmorType(JItemArmorType.ArmorHat);
        ArmorCoat = new Armor(JItemType.TypeArmor, 0);
        ArmorCoat.setArmorType(JItemArmorType.ArmorCoat);
        ArmorPant = new Armor(JItemType.TypeArmor, 0);
        ArmorPant.setArmorType(JItemArmorType.ArmorPant);
        ArmorLegging = new Armor(JItemType.TypeArmor,0);
        ArmorLegging.setArmorType(JItemArmorType.ArmorLegging);
        ArmorShoe = new Armor(JItemType.TypeArmor,0);
        ArmorShoe.setArmorType(JItemArmorType.ArmorShoe);
    }
    public void EquipmentWeapon(Weapon weapon){
        HeroWeapon = weapon;
    }

    public Weapon getHeroWeapon() {
        return HeroWeapon;
    }

    public Armor getArmorHat() {
        return ArmorHat;
    }

    public Armor getArmorCoat() {
        return ArmorCoat;
    }

    public Armor getArmorPant() {
        return ArmorPant;
    }

    public Armor getArmorLegging() {
        return ArmorLegging;
    }

    public Armor getArmorShoe() {
        return ArmorShoe;
    }
}
