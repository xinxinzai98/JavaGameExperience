package bin.item.sort.Weapon;

import bin.item.Weapon;

import java.util.Comparator;

public class sortWeaponWeight0 implements Comparator<Weapon>{
    @Override
    public int compare(Weapon o1, Weapon o2) {
        return o2.getWeight() - o1.getWeight();
    }
}
