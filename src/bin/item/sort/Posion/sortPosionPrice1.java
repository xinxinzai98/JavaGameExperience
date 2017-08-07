package bin.item.sort.Posion;

import bin.item.Posion;

import java.util.Comparator;

public class sortPosionPrice1 implements Comparator<Posion> {
    @Override
    public int compare(Posion o1, Posion o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
