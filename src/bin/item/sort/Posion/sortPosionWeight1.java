package bin.item.sort.Posion;

import bin.item.Posion;

import java.util.Comparator;

public class sortPosionWeight1 implements Comparator<Posion>{
    @Override
    public int compare(Posion o1, Posion o2) {
        return o1.getWeight() - o2.getWeight();
    }
}
