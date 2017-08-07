package bin.item.sort.Armor;

import bin.item.Armor;

import java.util.Comparator;

public class sortArmorHp0 implements Comparator<Armor> {
    @Override
    public int compare(Armor o1, Armor o2) {
        return o2.getMaxHp() - o1.getMaxHp();
    }
}
