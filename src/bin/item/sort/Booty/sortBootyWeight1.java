package bin.item.sort.Booty;

import bin.item.RootItem;

import java.util.Comparator;

public class sortBootyWeight1 implements Comparator<RootItem> {
    @Override
    public int compare(RootItem o1, RootItem o2) {
        return o1.getWeight() - o2.getWeight();
    }
}
