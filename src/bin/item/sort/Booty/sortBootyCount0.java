package bin.item.sort.Booty;

import bin.item.RootItem;

import java.util.Comparator;

public class sortBootyCount0 implements Comparator<RootItem> {
    @Override
    public int compare(RootItem o1, RootItem o2) {
        return o2.getCount() - o1.getCount();
    }
}
