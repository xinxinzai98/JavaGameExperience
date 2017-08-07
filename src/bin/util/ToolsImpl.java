package bin.util;

import bin.item.Armor;
import bin.item.Posion;
import bin.item.RootItem;
import bin.item.Weapon;

import java.util.Vector;

public class ToolsImpl implements Tools {
    @Override
    public void printMenu(String[] info) {
        int maxLength = getStringLength(info[0]);
        for (int i = 0; i < info.length; i++) {
            int stringLength = getStringLength(info[i]);
            if (stringLength > maxLength)
                maxLength = stringLength;
        }
        //打印顶盖
        for (int i = 0; i < (maxLength + 4); i++) {
            System.out.print("*");
        }
        System.out.println();

        for (int i = 0; i < info.length; i++) {

            int stringLength = getStringLength(info[i]);
            //第一行
            System.out.print("* ");
            for (int j = 0; j < maxLength; j++) {
                System.out.print(" ");
            }
            System.out.println(" *");

            //第二行
            if (getStringLength(info[i]) % 2 == 0) {
                System.out.print("* ");
                for (int j = 0; j < (maxLength - stringLength) / 2; j++) {
                    System.out.print(" ");
                }
                System.out.print(info[i]);
                for (int j = 0; j < (maxLength - stringLength) / 2 + 1; j++) {
                    System.out.print(" ");
                }
                System.out.println(" *");
            } else {
                System.out.print("* ");
                for (int j = 0; j < (maxLength - stringLength) / 2; j++) {
                    System.out.print(" ");
                }
                System.out.print(info[i]);
                for (int j = 0; j < (maxLength - stringLength) / 2 + 2; j++) {
                    System.out.print(" ");
                }
                System.out.println(" *");

            }

            //第三行
            System.out.print("* ");
            for (int j = 0; j < maxLength; j++) {
                System.out.print(" ");
            }
            System.out.println(" *");

            //第四行
            for (int j = 0; j < (maxLength + 4); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Override
    public int getStringLength(String str) {
        String chinese = "[\u4e00-\u9fa5]";
        int length = 0;
        for (int j = 0; j < str.length(); j++) {
            String temp = str.substring(j, j + 1);
            if (temp.matches(chinese)) {
                length += 2;
            } else {
                length += 1;
            }
        }
        return length;
    }

    public int getMaxNameLengthInBootyBox(Vector<RootItem> objBox) {
        if (objBox.size() > 0) {
            int max = getStringLength(objBox.get(0).getName());
            for (RootItem item : objBox) {
                if (getStringLength(item.getName()) > max)
                    max = getStringLength(item.getName());
            }
            return max;
        } else {
            return 0;
        }
    }

    @Override
    public int getMaxNameLengthInPosionBox(Vector<Posion> objBox) {
        if (objBox.size() > 0) {
            int max = getStringLength(objBox.get(0).getName());
            for (Posion item : objBox) {
                if (getStringLength(item.getName()) > max)
                    max = getStringLength(item.getName());
            }
            return max;
        } else {
            return 0;
        }
    }

    @Override
    public int getMaxNameLengthInArmorBox(Vector<Armor> objBox) {
        if (objBox.size() > 0) {
            int max = getStringLength(objBox.get(0).getName());
            for (Armor item : objBox) {
                if (getStringLength(item.getName()) > max)
                    max = getStringLength(item.getName());
            }
            return max;
        } else {
            return 0;
        }
    }

    @Override
    public int getMaxNameLengthInWeaponBox(Vector<Weapon> objBox) {
        if (objBox.size() > 0) {
            int max = getStringLength(objBox.get(0).getName());
            for (Weapon item : objBox) {
                if (getStringLength(item.getName()) > max)
                    max = getStringLength(item.getName());
            }
            return max;
        } else {
            return 0;
        }
    }


}
