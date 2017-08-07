package bin.gamemain;

import bin.character.HeroImpl;
import bin.common.*;
import bin.map.MapImpl;
import bin.util.ToolsImpl;

import java.io.File;

public class JGameMain implements GameMain {
    private static String info;           //输入字符
    private static JEngineState EngineState;    //引擎状态
    private static ToolsImpl Tools;          //工具类
    private static String acFile;         //存档路径
    private static File file;           //存档流
    private static MapImpl Maps;           //地图引擎
    private static HeroImpl Ben;            //英雄

    public JGameMain() {
        EngineState = JEngineState.EngineClose;
        acFile = "C:\\Users\\闫鑫\\Documents\\Study\\Java\\SuperDK\\src\\Archive\\";
        if (Tools == null)
            Tools = new ToolsImpl();
        if (file == null)
            file = new File(acFile);
        if (Maps == null)
            Maps = new MapImpl();
        if (Ben == null)
            Ben = new HeroImpl();
    }

    /**
     * GameInit
     */
    @Override
    public void GameInit() {
        System.out.println("此处应有游戏介绍和等待开始游戏");
        String[] menu = {"[开始]游戏", "[读取]存档", "[结束]游戏"};
        Tools.printMenu(menu);
        Maps.mapLoad(1);
        Ben.setPositionX(3);
        Ben.setPositionY(6);
    }

    /**
     * @param ePut
     */
    @Override
    public void GameRun(String ePut) {
        info = ePut;
        if (EngineState == JEngineState.EngineClose && checkInput("开始")) {
            EngineState = JEngineState.EngineRun;
            System.out.println("此处有游戏第一次运行的开场词");
        } else if (EngineState == JEngineState.EngineClose && checkInput("读取")) {
            EngineState = JEngineState.EngineRead;
            System.out.println("此处有游戏读取存档的提示");
            System.out.println("此处打印游戏存档");
            listFile(file);
        } else if (EngineState == JEngineState.EngineRead) {
        } else if (EngineState == JEngineState.EngineRun) {
            if (checkInput("帮助")) {

                return;
            }
            /**
             * 查看地图
             */

            if (checkInput("地图")) {
                Maps.printMap(Ben.getPositionX(), Ben.getPositionY());
                return;
            }

            /**
             * 移动
             */
            if (Ben.getHeroState() == JHeroState.HeroMove) {
                if (checkInput("取消")) {
                    Ben.setHeroState(JHeroState.HeroNormal);
                    return;
                } else {
                    HeroOnMove(info);
                    return;
                }
            } else if (checkInput("移动")) {
                if (Ben.getHeroState() == JHeroState.HeroNormal) {
                    Ben.setHeroState(JHeroState.HeroMove);
                    Maps.checkMap(Ben.getPositionX(), Ben.getPositionY());
                    System.out.println("键入[取消]以取消移动");
                    return;
                } else {
                    System.out.println("您当前无法[移动],键入[帮助]以获得更多帮助");
                    return;
                }
            }
            /**
             * 查看菜单
             */
            if (Ben.getHeroState() == JHeroState.HeroMenu) {
                // 查看状态界面
                if (Ben.getMenuState() == JHeroMenuState.MenuHeroState) {
                    // 待添加的状态功能
                    if (checkInput("返回")) {
                        Ben.setMenuState(JHeroMenuState.MenuNormal);
                        return;
                    }
                } else if (checkInput("状态")) {
                    Ben.setMenuState(JHeroMenuState.MenuHeroState);
                    // 待添加的状态功能
                    return;
                }

                // 查看背包界面
                if (Ben.getMenuState() == JHeroMenuState.MenuPackage) {
                    if (Ben.getPackageState() == JHeroMenuPackageState.PackageWeapon) {
                        if (!Ben.PACKAGE.mainPackageFuncition(Ben.getPackageState(), info)) {// 武器界面功能
                            Ben.printPackageMenu();
                            Ben.setPackageState(JHeroMenuPackageState.PackageNormal);
                        } else
                            return;
                    } else if (checkInput("武器")) {
                        Ben.setPackageState(JHeroMenuPackageState.PackageWeapon);
                        Ben.PACKAGE.listItem(JItemType.TypeWeapon);
                        Ben.PACKAGE.printPackageHelp(Ben.getPackageState());
                        return;
                    }
                    if (Ben.getPackageState() == JHeroMenuPackageState.PackageArmor) {
                        if (!Ben.PACKAGE.mainPackageFuncition(Ben.getPackageState(), info)) {// 装备界面功能
                            Ben.printPackageMenu();
                            Ben.setPackageState(JHeroMenuPackageState.PackageNormal);
                        } else
                            return;
                    } else if (checkInput("装备")) {
                        Ben.setPackageState(JHeroMenuPackageState.PackageArmor);
                        Ben.PACKAGE.listItem(JItemType.TypeArmor);
                        Ben.PACKAGE.printPackageHelp(Ben.getPackageState());
                        return;
                    }
                    if (Ben.getPackageState() == JHeroMenuPackageState.PackagePosion) {
                        if (!Ben.PACKAGE.mainPackageFuncition(Ben.getPackageState(), info)) {// 药水界面功能
                            Ben.printPackageMenu();
                            Ben.setPackageState(JHeroMenuPackageState.PackageNormal);
                        } else
                            return;
                    } else if (checkInput("药水")) {
                        Ben.setPackageState(JHeroMenuPackageState.PackagePosion);
                        Ben.PACKAGE.listItem(JItemType.TypePosion);
                        Ben.PACKAGE.printPackageHelp(Ben.getPackageState());
                        return;
                    }
                    if (Ben.getPackageState() == JHeroMenuPackageState.PackageBotty) {
                        if (!Ben.PACKAGE.mainPackageFuncition(Ben.getPackageState(), info)) { // 物品界面功能
                            Ben.printPackageMenu();
                            Ben.setPackageState(JHeroMenuPackageState.PackageNormal);
                        } else
                            return;
                    } else if (checkInput("物品")) {
                        Ben.setPackageState(JHeroMenuPackageState.PackageBotty);
                        Ben.PACKAGE.listItem(JItemType.TypeBooty);
                        Ben.PACKAGE.printPackageHelp(Ben.getPackageState());
                        return;
                    }
                    if (checkInput("返回")) {
                        Ben.setMenuState(JHeroMenuState.MenuNormal);
                        Ben.printMainMenu();
                        return;
                    }
                } else if (checkInput("背包")) {
                    Ben.setMenuState(JHeroMenuState.MenuPackage);
                    Ben.printPackageMenu();
                    return;
                }

                if (checkInput("退出")) {
                    Ben.setHeroState(JHeroState.HeroNormal);
                    return;
                }
            } else if (checkInput("菜单")) {
                Ben.setHeroState(JHeroState.HeroMenu);
                Ben.printMainMenu();
                return;
            }
        }
    }

    /**
     * GameEnd
     */
    @Override
    public void GameEnd() {
        System.out.println("此处应有游戏结束的话");
    }

    /**
     * @param ePut 检验字符
     * @return 不匹配:false 成功匹配:true
     */
    @Override
    public boolean checkInput(String ePut) {
        return info.equals(ePut);
    }

    /**
     * @param file
     */
    @Override
    public void listFile(File file) {
        if (file.isDirectory()) {
            File[] lists = file.listFiles();
            if (lists != null) {
                for (int i = 0; i < lists.length; i++) {
                    listFile(lists[i]);//是目录就递归进入目录内再进行判断
                }
            }
        }
        //fl.toString().replaceAll(acFile,"");
        if (!file.getName().equals("Archive"))
            System.out.println(file.getName());//file不是目录，就输出它的路径名，这是递归的出口
    }

    /**
     * @param dir
     */
    @Override
    public void HeroOnMove(String dir) {
        if (Maps.checkMap(Ben.getPositionX(), Ben.getPositionY(), dir)) {
            Ben.OnMove(dir);
            Maps.printMap(Ben.getPositionX(), Ben.getPositionY());
        } else {
            System.out.println("移动出错");
        }
    }
}
