package bin.heropackage;

import bin.common.JHeroMenuPackageSortState;
import bin.common.JHeroMenuPackageState;
import bin.common.JItemType;
import bin.item.Armor;
import bin.item.Posion;
import bin.item.RootItem;
import bin.item.Weapon;
import bin.item.sort.Armor.*;
import bin.item.sort.Booty.*;
import bin.item.sort.Posion.*;
import bin.item.sort.Weapon.*;
import bin.util.ToolsImpl;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Vector;

public class HeroPackage {
    private Vector<Armor> ArmorBox;
    private Vector<Weapon> WeaponBox;
    private Vector<RootItem> BootyBox;
    private Vector<Posion> PosionBox;
    private ToolsImpl Tools;
    private JHeroMenuPackageSortState sortState;

    public HeroPackage() {
        ArmorBox = new Vector<>(0);
        WeaponBox = new Vector<>(0);
        BootyBox = new Vector<>(0);
        PosionBox = new Vector<>(0);
        sortState = JHeroMenuPackageSortState.SortNone;
        if (Tools == null) {
            Tools = new ToolsImpl();
        }
    }

    /**
     * @return
     */
    public boolean addItem(JItemType itemType, int itemNum) {
        switch (itemType) {
            case TypeArmor:
                addArmor(itemNum);
                return true;
            case TypeWeapon:
                addWeapon(itemNum);
                return true;
            case TypePosion:
                addPosion(itemNum);
                return true;
            case TypeBooty:
                addBooty(itemNum);
                return true;
            default:
                return false;
        }
    }

    public void listItem(JItemType itemType) {
        switch (itemType) {
            case TypeArmor:
                listArmor();
                break;
            case TypeWeapon:
                listWeapon();
                break;
            case TypePosion:
                listPosion();
                break;
            case TypeBooty:
                listBooty();
                break;
            default:
                break;
        }
    }

    public void checkItem(JItemType itemType, int numInBox) {
        switch (itemType) {
            case TypeArmor:
                checkArmorItem(numInBox);
                break;
            case TypeWeapon:
                checkWeaponItem(numInBox);
                break;
            case TypePosion:
                checkPosionItem(numInBox);
                break;
            case TypeBooty:
                checkBootyItem(numInBox);
                break;
            default:
                break;
        }
    }

    public void printPackageHelp(JHeroMenuPackageState packageState) {
        System.out.printf("���������������\n");
        System.out.printf("0Ϊ����1Ϊ����\n");
        switch (packageState) {
            case PackageWeapon:
                String[] weaponhelp = {"��[����]����", "��[������]����", "��[�۸�]����", "[�鿴(���)]����", "[����(��Ʒ��)]", "[�뿪]��������"};
                Tools.printMenu(weaponhelp);
                break;
            case PackageArmor:
                String[] armorhelp = {"��[����]����", "��[Ѫ��]����", "��[�۸�]����", "[�鿴(���)]����", "[����(��Ʒ��)]", "[�뿪]���׽���"};
                Tools.printMenu(armorhelp);
                break;
            case PackageBotty:
                String[] bottyhelp = {"��[����]����", "��[����]����", "��[�۸�]����", "[�鿴(���)]����", "[����(��Ʒ��)]", "[�뿪]��Ʒ����"};
                Tools.printMenu(bottyhelp);
                break;
            case PackagePosion:
                String[] posionhelp = {"��[����]����", "��[����]����", "��[�۸�]����", "[�鿴(���)]����", "[����(��Ʒ��)]", "[�뿪]ҩˮ����"};
                Tools.printMenu(posionhelp);
                break;
            default:
                break;
        }
    }

    public boolean mainPackageFuncition(JHeroMenuPackageState packageState, String iput) {
        if (!iput.equals("�뿪")) {
            switch (packageState) {
                case PackageWeapon:
                    mainPackageWeapon(iput);
                    break;
                case PackageArmor:
                    mainPackageArmor(iput);
                    break;
                case PackageBotty:
                    mainPackageBooty(iput);
                    break;
                case PackagePosion:
                    mainPackagePosion(iput);
                    break;
                default:
                    break;
            }
            return true;
        } else
            return false;
    }

    private void mainPackageWeapon(String iput) {
        if (iput.contains("�鿴")) {
            String[] str = iput.split("�鿴{1}");
            int num;
            for (String aStr : str) {
                if (aStr.matches("[1-9]{1,}")) {
                    BigInteger integer = new BigInteger(aStr);
                    num = integer.intValue();
                    checkWeaponItem(num);
                    //��ʵ��װ������
                    return;
                }
            }
            System.out.printf("����Ҫ��[�鿴]�����[���]\n");
        } else if (iput.contains("����")) {
            String[] str = iput.split("����{1}");
            if (str.length == 0) {
                System.out.printf("����Ҫ��[����]�����[��Ʒ��]\n");
            } else if (str.length > 1 && str[1] != null) {
                listWeapon(str[1]);
                return;
            } else {
                System.out.printf("���������ʽ����\n");
            }
        } else {
            if (iput.contains("����")) {
                String[] str = iput.split("����{1}");
                if (str.length == 0) {
                    System.out.printf("����Ҫ��[����]�����[0/1]����ȷ����\n");
                } else if (str.length > 1 && str[1].matches("[0-1]{1}")) {
                    BigInteger integer = new BigInteger(str[1]);
                    int num = integer.intValue();
                    WeaponBoxSorting(JHeroMenuPackageSortState.SortWeight, num);
                    return;
                } else {
                    System.out.printf("���������ʽ����\n");
                }
                return;
            } else if (iput.contains("������")) {
                String[] str = iput.split("������{1}");
                if (str.length == 0) {
                    System.out.printf("����Ҫ��[������]�����[0/1]����ȷ����\n");
                } else if (str.length > 1 && str[1].matches("[0-1]{1}")) {
                    BigInteger integer = new BigInteger(str[1]);
                    int num = integer.intValue();
                    WeaponBoxSorting(JHeroMenuPackageSortState.SortAttack, num);
                    return;
                } else {
                    System.out.printf("���������ʽ����\n");
                }
            } else if (iput.contains("�۸�")) {
                String[] str = iput.split("�۸�{1}");
                if (str.length == 0) {
                    System.out.printf("����Ҫ��[�۸�]�����[0/1]����ȷ����\n");
                } else if (str.length > 1 && str[1].matches("[0-1]{1}")) {
                    BigInteger integer = new BigInteger(str[1]);
                    int num = integer.intValue();
                    WeaponBoxSorting(JHeroMenuPackageSortState.SortPrice, num);
                    return;
                } else {
                    System.out.printf("���������ʽ����\n");
                }
            } else {
                System.out.printf("������������\n");
            }
        }
        printPackageHelp(JHeroMenuPackageState.PackageWeapon);
    }

    /**
     * ��������
     *
     * @param itemName ������������
     */
    private void listWeapon(String itemName) {
        if (itemName != null) {
            int maxLength = Tools.getMaxNameLengthInWeaponBox(WeaponBox);
            int count = 0;
            System.out.printf("���\t����\t");
            for (int loop = 0; loop < maxLength - 4; loop++) {
                System.out.printf(" ");
            }
            System.out.printf("����\t����\t����\t�۸�\n");
            for (int loop = 0; loop < WeaponBox.size(); loop++) {
                if (WeaponBox.get(loop).getName().contains(itemName)) {
                    count++;
                    System.out.printf("%s\t%s", loop + 1, WeaponBox.get(loop).getName());
                    for (int dloop = 0; dloop < maxLength - Tools.getStringLength(WeaponBox.get(loop).getName()); dloop++) {
                        System.out.printf(" ");
                    }
                    System.out.printf("\t%s\t%s\t%s\t%s\n", WeaponBox.get(loop).getCount(), WeaponBox.get(loop).getWeight(), WeaponBox.get(loop).getAttack(), WeaponBox.get(loop).getPrice());
                } else
                    continue;
            }
            if (count == 0)
                System.out.printf("û����Ҫ���ҵ���Ʒ\n");
        }
    }

    private void WeaponBoxSorting(JHeroMenuPackageSortState sortState, int flag) {
        switch (sortState) {
            case SortAttack:
                WeaponBoxSortingAttack(flag);
                return;
            case SortWeight:
                WeaponBoxSortingWeight(flag);
                return;
            case SortPrice:
                WeaponBoxSortingPrice(flag);
                return;
            default:
        }
    }

    private void WeaponBoxSortingAttack(int flag) {
        if (flag == 0) {
            System.out.printf("����������������\n");
            Collections.sort(WeaponBox, new sortWeaponAttack0());
        } else {
            System.out.printf("����������������\n");
            Collections.sort(WeaponBox, new sortWeaponAttack1());
        }
        listWeapon();
    }

    private void WeaponBoxSortingWeight(int flag) {
        if (flag == 0) {
            System.out.printf("��������������\n");
            Collections.sort(WeaponBox, new sortWeaponWeight0());
        } else {
            System.out.printf("��������������\n");
            Collections.sort(WeaponBox, new sortWeaponWeight1());
        }
        listWeapon();
    }

    private void WeaponBoxSortingPrice(int flag) {
        if (flag == 0) {
            System.out.printf("���۸�������\n");
            Collections.sort(WeaponBox, new sortWeaponPrice0());
        } else {
            System.out.printf("���۸���������\n");
            Collections.sort(WeaponBox, new sortWeaponPrice1());
        }
        listWeapon();
    }

    private void mainPackageArmor(String iput) {
        if (iput.contains("�鿴")) {
            String[] str = iput.split("�鿴{1}");
            int num;
            for (String aStr : str) {
                if (aStr.matches("[1-9]{1,}")) {
                    BigInteger integer = new BigInteger(aStr);
                    num = integer.intValue();
                    //����ӵ�װ������
                    checkArmorItem(num);
                    return;
                }
            }
            System.out.printf("����Ҫ��[�鿴]�����[���]\n");
        } else if (iput.contains("����")) {
            String[] str = iput.split("����{1}");
            if (str.length == 0) {
                System.out.printf("����Ҫ��[����]�����[��Ʒ��]\n");
            } else if (str.length > 1 && str[1] != null) {
                listArmor(str[1]);
                return;
            } else {
                System.out.printf("���������ʽ����\n");
            }
        } else {
            if (iput.contains("����")) {
                String[] str = iput.split("����{1}");
                if (str.length == 0) {
                    System.out.printf("����Ҫ��[����]�����[0/1]����ȷ����\n");
                } else if (str.length > 1 && str[1].matches("[0-1]{1}")) {
                    BigInteger integer = new BigInteger(str[1]);
                    int num = integer.intValue();
                    ArmorBoxSorting(JHeroMenuPackageSortState.SortWeight, num);
                    return;
                } else {
                    System.out.printf("���������ʽ����\n");
                }
                return;
            } else if (iput.contains("Ѫ��")) {
                String[] str = iput.split("Ѫ��{1}");
                if (str.length == 0) {
                    System.out.printf("����Ҫ��[Ѫ��]�����[0/1]����ȷ����\n");
                } else if (str.length > 1 && str[1].matches("[0-1]{1}")) {
                    BigInteger integer = new BigInteger(str[1]);
                    int num = integer.intValue();
                    ArmorBoxSorting(JHeroMenuPackageSortState.SortHp, num);
                    return;
                } else {
                    System.out.printf("���������ʽ����\n");
                }
            } else if (iput.contains("�۸�")) {
                String[] str = iput.split("�۸�{1}");
                if (str.length == 0) {
                    System.out.printf("����Ҫ��[�۸�]�����[0/1]����ȷ����\n");
                } else if (str.length > 1 && str[1].matches("[0-1]{1}")) {
                    BigInteger integer = new BigInteger(str[1]);
                    int num = integer.intValue();
                    ArmorBoxSorting(JHeroMenuPackageSortState.SortPrice, num);
                    return;
                } else {
                    System.out.printf("���������ʽ����\n");
                }
            } else {
                System.out.printf("������������\n");
            }
        }
        printPackageHelp(JHeroMenuPackageState.PackageArmor);
    }

    /**
     * ����װ��
     *
     * @param itemName װ�ײ�������
     */
    private void listArmor(String itemName) {
        if (itemName != null) {
            int maxLength = Tools.getMaxNameLengthInArmorBox(ArmorBox);
            int count = 0;
            System.out.printf("���\t����\t");
            for (int loop = 0; loop < maxLength - 4; loop++) {
                System.out.printf(" ");
            }
            System.out.printf("����\t����\tѪ��\t�۸�\n");
            for (int loop = 0; loop < ArmorBox.size(); loop++) {
                if (ArmorBox.get(loop).getName().contains(itemName)) {
                    count++;
                    System.out.printf("%s\t%s", loop + 1, ArmorBox.get(loop).getName());
                    for (int dloop = 0; dloop < maxLength - Tools.getStringLength(ArmorBox.get(loop).getName()); dloop++) {
                        System.out.printf(" ");
                    }
                    System.out.printf("\t%s\t%s\t%s\t%s\n", ArmorBox.get(loop).getCount(), ArmorBox.get(loop).getWeight(), ArmorBox.get(loop).getMaxHp(), ArmorBox.get(loop).getPrice());
                } else
                    continue;
            }
            if (count == 0)
                System.out.printf("û����Ҫ���ҵ���Ʒ\n");
        }
    }

    private void ArmorBoxSorting(JHeroMenuPackageSortState sortState, int flag) {
        switch (sortState) {
            case SortHp:
                ArmorBoxSortingHp(flag);
                return;
            case SortWeight:
                ArmorBoxSortingWeight(flag);
                return;
            case SortPrice:
                ArmorBoxSortingPrice(flag);
                return;
            default:
        }
    }

    private void ArmorBoxSortingHp(int flag) {
        if (flag == 0) {
            System.out.printf("��Ѫ����������\n");
            Collections.sort(ArmorBox, new sortArmorHp0());
        } else {
            System.out.printf("��Ѫ����������\n");
            Collections.sort(ArmorBox, new sortArmorHp1());
        }
        listWeapon();
    }

    private void ArmorBoxSortingWeight(int flag) {
        if (flag == 0) {
            System.out.printf("��������������\n");
            Collections.sort(ArmorBox, new sortArmorWeight0());
        } else {
            System.out.printf("��������������\n");
            Collections.sort(ArmorBox, new sortArmorWeight1());
        }
        listWeapon();
    }

    private void ArmorBoxSortingPrice(int flag) {
        if (flag == 0) {
            System.out.printf("���۸�������\n");
            Collections.sort(ArmorBox, new sortArmorPrice0());
        } else {
            System.out.printf("���۸���������\n");
            Collections.sort(ArmorBox, new sortArmorPrice1());
        }
        listWeapon();
    }

    private void mainPackageBooty(String iput) {
        if (iput.contains("�鿴")) {
            String[] str = iput.split("�鿴{1}");
            int num;
            for (String aStr : str) {
                if (aStr.matches("[1-9]{1,}")) {
                    BigInteger integer = new BigInteger(aStr);
                    num = integer.intValue();
                    checkBootyItem(num);
                    return;
                }
            }
            System.out.printf("����Ҫ��[�鿴]�����[���]\n");
        } else if (iput.contains("����")) {
            String[] str = iput.split("����{1}");
            if (str.length == 0) {
                System.out.printf("����Ҫ��[����]�����[��Ʒ��]\n");
            } else if (str.length > 1 && str[1] != null) {
                listBooty(str[1]);
                return;
            } else {
                System.out.printf("���������ʽ����\n");
            }
        } else {
            if (iput.contains("����")) {
                String[] str = iput.split("����{1}");
                if (str.length == 0) {
                    System.out.printf("����Ҫ��[����]�����[0/1]����ȷ����\n");
                } else if (str.length > 1 && str[1].matches("[0-1]{1}")) {
                    BigInteger integer = new BigInteger(str[1]);
                    int num = integer.intValue();
                    BootyBoxSorting(JHeroMenuPackageSortState.SortWeight, num);
                    return;
                } else {
                    System.out.printf("���������ʽ����\n");
                }
                return;
            } else if (iput.contains("����")) {
                String[] str = iput.split("����{1}");
                if (str.length == 0) {
                    System.out.printf("����Ҫ��[����]�����[0/1]����ȷ����\n");
                } else if (str.length > 1 && str[1].matches("[0-1]{1}")) {
                    BigInteger integer = new BigInteger(str[1]);
                    int num = integer.intValue();
                    BootyBoxSorting(JHeroMenuPackageSortState.SortCount, num);
                    return;
                } else {
                    System.out.printf("���������ʽ����\n");
                }
            } else if (iput.contains("�۸�")) {
                String[] str = iput.split("�۸�{1}");
                if (str.length == 0) {
                    System.out.printf("����Ҫ��[�۸�]�����[0/1]����ȷ����\n");
                } else if (str.length > 1 && str[1].matches("[0-1]{1}")) {
                    BigInteger integer = new BigInteger(str[1]);
                    int num = integer.intValue();
                    BootyBoxSorting(JHeroMenuPackageSortState.SortPrice, num);
                    return;
                } else {
                    System.out.printf("���������ʽ����\n");
                }
            } else {
                System.out.printf("������������\n");
            }
        }
        printPackageHelp(JHeroMenuPackageState.PackageBotty);
    }

    /**
     * ������Ʒ
     *
     * @param itemName ��Ʒ��������
     */
    private void listBooty(String itemName) {
        if (itemName != null) {
            int maxLength = Tools.getMaxNameLengthInBootyBox(BootyBox);
            int count = 0;
            System.out.printf("���\t����\t");
            for (int loop = 0; loop < maxLength - 4; loop++) {
                System.out.printf(" ");
            }
            System.out.printf("����\t����\t�۸�\n");
            for (int loop = 0; loop < BootyBox.size(); loop++) {
                if (BootyBox.get(loop).getName().contains(itemName)) {
                    count++;
                    System.out.printf("%s\t%s", loop + 1, BootyBox.get(loop).getName());
                    for (int dloop = 0; dloop < maxLength - Tools.getStringLength(BootyBox.get(loop).getName()); dloop++) {
                        System.out.printf(" ");
                    }
                    System.out.printf("\t%s\t%s\t%s\n", BootyBox.get(loop).getCount(), BootyBox.get(loop).getWeight(), BootyBox.get(loop).getPrice());
                } else
                    continue;
            }
            if (count == 0)
                System.out.printf("û����Ҫ���ҵ���Ʒ\n");
        }
    }

    private void BootyBoxSorting(JHeroMenuPackageSortState sortState, int flag) {
        switch (sortState) {
            case SortCount:
                BootyBoxSortingCount(flag);
                return;
            case SortWeight:
                BootyBoxSortingWeight(flag);
                return;
            case SortPrice:
                BootyBoxSortingPrice(flag);
                return;
            default:
        }
    }

    private void BootyBoxSortingCount(int flag) {
        if (flag == 0) {
            System.out.printf("��������������\n");
            Collections.sort(BootyBox, new sortBootyCount0());
        } else {
            System.out.printf("��������������\n");
            Collections.sort(BootyBox, new sortBootyCount1());
        }
        listBooty();
    }

    private void BootyBoxSortingWeight(int flag) {
        if (flag == 0) {
            System.out.printf("��������������\n");
            Collections.sort(BootyBox, new sortBootyWeight0());
        } else {
            System.out.printf("��������������\n");
            Collections.sort(BootyBox, new sortBootyWeight1());
        }
        listBooty();
    }

    private void BootyBoxSortingPrice(int flag) {
        if (flag == 0) {
            System.out.printf("���۸�������\n");
            Collections.sort(BootyBox, new sortBootyPrice0());
        } else {
            System.out.printf("���۸���������\n");
            Collections.sort(BootyBox, new sortBootyPrice1());
        }
        listBooty();
    }

    private void mainPackagePosion(String iput) {
        if (iput.contains("�鿴")) {
            String[] str = iput.split("�鿴{1}");
            int num;
            for (String aStr : str) {
                if (aStr.matches("[1-9]{1,}")) {
                    BigInteger integer = new BigInteger(aStr);
                    //����ӵ�ʹ�ù���
                    num = integer.intValue();
                    checkPosionItem(num);
                    return;
                }
            }
            System.out.printf("����Ҫ��[�鿴]�����[���]\n");
        } else if (iput.contains("����")) {
            String[] str = iput.split("����{1}");
            if (str.length == 0) {
                System.out.printf("����Ҫ��[����]�����[��Ʒ��]\n");
            } else if (str.length > 1 && str[1] != null) {
                listPosion(str[1]);
                return;
            } else {
                System.out.printf("���������ʽ����\n");
            }
        } else {
            if (iput.contains("����")) {
                String[] str = iput.split("����{1}");
                if (str.length == 0) {
                    System.out.printf("����Ҫ��[����]�����[0/1]����ȷ����\n");
                } else if (str.length > 1 && str[1].matches("[0-1]{1}")) {
                    BigInteger integer = new BigInteger(str[1]);
                    int num = integer.intValue();
                    PosionBoxSorting(JHeroMenuPackageSortState.SortWeight, num);
                    return;
                } else {
                    System.out.printf("���������ʽ����\n");
                }
                return;
            } else if (iput.contains("����")) {
                String[] str = iput.split("����{1}");
                if (str.length == 0) {
                    System.out.printf("����Ҫ��[����]�����[0/1]����ȷ����\n");
                } else if (str.length > 1 && str[1].matches("[0-1]{1}")) {
                    BigInteger integer = new BigInteger(str[1]);
                    int num = integer.intValue();
                    PosionBoxSorting(JHeroMenuPackageSortState.SortCount, num);
                    return;
                } else {
                    System.out.printf("���������ʽ����\n");
                }
            } else if (iput.contains("�۸�")) {
                String[] str = iput.split("�۸�{1}");
                if (str.length == 0) {
                    System.out.printf("����Ҫ��[�۸�]�����[0/1]����ȷ����\n");
                } else if (str.length > 1 && str[1].matches("[0-1]{1}")) {
                    BigInteger integer = new BigInteger(str[1]);
                    int num = integer.intValue();
                    PosionBoxSorting(JHeroMenuPackageSortState.SortPrice, num);
                    return;
                } else {
                    System.out.printf("���������ʽ����\n");
                }
            } else {
                System.out.printf("������������\n");
            }
        }
        printPackageHelp(JHeroMenuPackageState.PackagePosion);
    }

    /**
     * ����ҩˮ
     *
     * @param itemName ҩˮ��������
     */
    private void listPosion(String itemName) {
        if (itemName != null) {
            int maxLength = Tools.getMaxNameLengthInPosionBox(PosionBox);
            int count = 0;
            System.out.printf("���\t����\t");
            for (int loop = 0; loop < maxLength - 4; loop++) {
                System.out.printf(" ");
            }
            System.out.printf("����\t����\t�۸�\n");
            for (int loop = 0; loop < PosionBox.size(); loop++) {
                if (PosionBox.get(loop).getName().contains(itemName)) {
                    count++;
                    System.out.printf("%s\t%s", loop + 1, PosionBox.get(loop).getName());
                    for (int dloop = 0; dloop < maxLength - Tools.getStringLength(PosionBox.get(loop).getName()); dloop++) {
                        System.out.printf(" ");
                    }
                    System.out.printf("\t%s\t%s\t%s\n", PosionBox.get(loop).getCount(), PosionBox.get(loop).getWeight(), PosionBox.get(loop).getPrice());
                } else
                    continue;
            }
            if (count == 0)
                System.out.printf("û����Ҫ���ҵ���Ʒ\n");
        }
    }

    private void PosionBoxSorting(JHeroMenuPackageSortState sortState, int flag) {
        switch (sortState) {
            case SortCount:
                PosionBoxSortingCount(flag);
                return;
            case SortWeight:
                PosionBoxSortingWeight(flag);
                return;
            case SortPrice:
                PosionBoxSortingPrice(flag);
                return;
            default:
        }
    }

    private void PosionBoxSortingCount(int flag) {
        if (flag == 0) {
            System.out.printf("��������������\n");
            Collections.sort(PosionBox, new sortPosionCount0());
        } else {
            System.out.printf("��������������\n");
            Collections.sort(PosionBox, new sortPosionCount1());
        }
        listPosion();
    }

    private void PosionBoxSortingWeight(int flag) {
        if (flag == 0) {
            System.out.printf("��������������\n");
            Collections.sort(PosionBox, new sortPosionWeight0());
        } else {
            System.out.printf("��������������\n");
            Collections.sort(PosionBox, new sortPosionWeight1());
        }
        listPosion();
    }

    private void PosionBoxSortingPrice(int flag) {
        if (flag == 0) {
            System.out.printf("���۸�������\n");
            Collections.sort(PosionBox, new sortPosionPrice0());
        } else {
            System.out.printf("���۸���������\n");
            Collections.sort(PosionBox, new sortPosionPrice1());
        }
        listPosion();
    }

    private void checkBootyItem(int numInBox) {
        if (numInBox > 0)
            BootyBox.get(numInBox - 1).printItemInfo();
    }

    private void checkWeaponItem(int numInBox) {
        if (numInBox > 0) {
            System.out.printf("��Ҫ�鿴����%s����Ʒ", numInBox);
            WeaponBox.get(numInBox - 1).printItemInfo();
        } else {
            System.out.printf("������ı�Ų����ڣ�����������");
        }
    }

    private void checkArmorItem(int numInBox) {
        if (numInBox > 0)
            ArmorBox.get(numInBox - 1).printItemInfo();
    }

    private void checkPosionItem(int numInBox) {
        if (numInBox > 0)
            PosionBox.get(numInBox - 1).printItemInfo();
    }

    private void listBooty() {
        int maxLength = Tools.getMaxNameLengthInBootyBox(BootyBox);
        System.out.printf("���\t����\t");
        for (int loop = 0; loop < maxLength - 4; loop++) {
            System.out.printf(" ");
        }
        System.out.printf("����\t����\t�۸�\n");
        for (int loop = 0; loop < BootyBox.size(); loop++) {
            System.out.printf("%s\t%s", loop + 1, BootyBox.get(loop).getName());
            for (int dloop = 0; dloop < maxLength - Tools.getStringLength(BootyBox.get(loop).getName()); dloop++) {
                System.out.printf(" ");
            }
            System.out.printf("\t%s\t%s\t%s\n", BootyBox.get(loop).getCount(), BootyBox.get(loop).getWeight(), BootyBox.get(loop).getPrice());
        }
    }

    private void listWeapon() {
        int maxLength = Tools.getMaxNameLengthInWeaponBox(WeaponBox);
        System.out.printf("���\t����\t");
        for (int loop = 0; loop < maxLength - 4; loop++) {
            System.out.printf(" ");
        }
        System.out.printf("����\t����\t����\t�۸�\n");
        for (int loop = 0; loop < WeaponBox.size(); loop++) {
            System.out.printf("%s\t%s", loop + 1, WeaponBox.get(loop).getName());
            for (int dloop = 0; dloop < maxLength - Tools.getStringLength(WeaponBox.get(loop).getName()); dloop++) {
                System.out.printf(" ");
            }
            System.out.printf("\t%s\t%s\t%s\t%s\n", WeaponBox.get(loop).getCount(), WeaponBox.get(loop).getWeight(), WeaponBox.get(loop).getAttack(), WeaponBox.get(loop).getPrice());
        }
    }

    private void listArmor() {
        int maxLength = Tools.getMaxNameLengthInArmorBox(ArmorBox);
        System.out.printf("���\t����\t");
        for (int loop = 0; loop < maxLength - 4; loop++) {
            System.out.printf(" ");
        }
        System.out.printf("����\t����\tѪ��\t�۸�\n");
        for (int loop = 0; loop < ArmorBox.size(); loop++) {
            System.out.printf("%s\t%s", loop + 1, ArmorBox.get(loop).getName());
            for (int dloop = 0; dloop < maxLength - Tools.getStringLength(ArmorBox.get(loop).getName()); dloop++) {
                System.out.printf(" ");
            }
            System.out.printf("\t%s\t%s\t%s\t%s\n", ArmorBox.get(loop).getCount(), ArmorBox.get(loop).getWeight(), ArmorBox.get(loop).getMaxHp(), ArmorBox.get(loop).getPrice());
        }
    }

    private void listPosion() {
        int maxLength = Tools.getMaxNameLengthInPosionBox(PosionBox);
        System.out.printf("���\t����\t");
        for (int loop = 0; loop < maxLength - 4; loop++) {
            System.out.printf(" ");
        }
        System.out.printf("����\t����\t�۸�\n");
        for (int loop = 0; loop < PosionBox.size(); loop++) {
            System.out.printf("%s\t%s", loop + 1, PosionBox.get(loop).getName());
            for (int dloop = 0; dloop < maxLength - Tools.getStringLength(PosionBox.get(loop).getName()); dloop++) {
                System.out.printf(" ");
            }
            System.out.printf("\t%s\t%s\t%s\n", PosionBox.get(loop).getCount(), PosionBox.get(loop).getWeight(), PosionBox.get(loop).getPrice());
        }
    }

    private void addBooty(int itemNum) {
        if (!checkBooty(itemNum)) {
            RootItem bootyTemp = new RootItem(JItemType.TypeBooty, itemNum);
            bootyTemp.itemInit();
            BootyBox.addElement(bootyTemp);
        } else {
            for (int loop = 0; loop < BootyBox.size(); loop++) {
                if (BootyBox.get(loop).getItemNum() == itemNum) {
                    BootyBox.get(loop).setCount(BootyBox.get(loop).getCount() + 1);
                    break;
                }
            }
        }
    }

    private void addPosion(int itemNum) {
        if (!checkPosion(itemNum)) {
            Posion posionTemp = new Posion(JItemType.TypePosion, itemNum);
            posionTemp.itemInit();
            PosionBox.addElement(posionTemp);
        } else {
            for (int loop = 0; loop < PosionBox.size(); loop++) {
                if (PosionBox.get(loop).getItemNum() == itemNum) {
                    PosionBox.get(loop).setCount(PosionBox.get(loop).getCount() + 1);
                    break;
                }
            }
        }
    }

    private void addArmor(int itemNum) {
        if (!checkArmor(itemNum)) {
            Armor armorTemp = new Armor(JItemType.TypeArmor, itemNum);
            armorTemp.itemInit();
            ArmorBox.addElement(armorTemp);
        } else {
            for (int loop = 0; loop < ArmorBox.size(); loop++) {
                if (ArmorBox.get(loop).getItemNum() == itemNum) {
                    ArmorBox.get(loop).setCount(ArmorBox.get(loop).getCount() + 1);
                    break;
                }
            }
        }
    }

    private void addWeapon(int itemNum) {
        if (!checkWeapon(itemNum)) {
            Weapon weaponTemp = new Weapon(JItemType.TypeWeapon, itemNum);
            weaponTemp.itemInit();
            WeaponBox.addElement(weaponTemp);
        } else {
            for (int loop = 0; loop < WeaponBox.size(); loop++) {
                if (WeaponBox.get(loop).getItemNum() == itemNum) {
                    WeaponBox.get(loop).setCount(WeaponBox.get(loop).getCount() + 1);
                    break;
                }
            }
        }
    }

    private boolean checkBooty(int itemNum) {
        boolean dupe = false;
        for (RootItem item : BootyBox) {
            if (item.getItemNum() == itemNum) {
                dupe = true;
                break;
            }
        }
        return dupe;
    }

    private boolean checkArmor(int itemNum) {
        boolean dupe = false;
        for (Armor item : ArmorBox) {
            if (item.getItemNum() == itemNum) {
                dupe = true;
                break;
            }
        }
        return dupe;
    }

    private boolean checkWeapon(int itemNum) {
        boolean dupe = false;
        for (Weapon item : WeaponBox) {
            if (item.getItemNum() == itemNum) {
                dupe = true;
                break;
            }
        }
        return dupe;
    }

    private boolean checkPosion(int itemNum) {
        boolean dupe = false;
        for (Posion item : PosionBox) {
            if (item.getItemNum() == itemNum) {
                dupe = true;
                break;
            }
        }
        return dupe;
    }

}
