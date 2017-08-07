package bin.item.sort.Weapon;

import bin.item.Weapon;

import java.util.Comparator;

public class sortWeaponAttack1 implements Comparator<Weapon> {
    @Override
    public int compare(Weapon o1, Weapon o2) {
        return o1.getAttack() - o2.getAttack();
    }
}
