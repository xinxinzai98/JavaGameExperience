package bin.item.sort.Armor;

import bin.item.Armor;

import java.util.Comparator;

public class sortArmorHp1 implements Comparator<Armor> {
    @Override
    public int compare(Armor o1, Armor o2) {
        return o1.getMaxHp() - o2.getMaxHp();
    }
}
