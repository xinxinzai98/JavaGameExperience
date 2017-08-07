package bin.item.sort.Weapon;

import bin.item.Weapon;

import java.util.Comparator;

public class sortWeaponWeight1 implements Comparator<Weapon> {
    @Override
    public int compare(Weapon o1, Weapon o2) {
        return o1.getWeight() - o2.getWeight();
    }
}
