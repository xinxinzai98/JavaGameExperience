package bin.util;

import bin.item.Armor;
import bin.item.Posion;
import bin.item.RootItem;
import bin.item.Weapon;

import java.util.Vector;

/**
 *  Tools
 */
public interface Tools {
    /**
     * @param info
     */
    void printMenu(String [] info);

    /**
     * @param str
     * @return 字符串长度(包括中文)
     */
    int getStringLength(String str);

    /**
     * @param objBox
     * @return
     */
    int getMaxNameLengthInBootyBox(Vector<RootItem> objBox);

    /**
     * @param objBox
     * @return
     */
    int getMaxNameLengthInPosionBox(Vector<Posion> objBox);

    /**
     * @param objBox
     * @return
     */
    int getMaxNameLengthInArmorBox(Vector<Armor> objBox);

    /**
     * @param objBox
     * @return
     */
    int getMaxNameLengthInWeaponBox(Vector<Weapon> objBox);

}
