package bin.gamemain;

import bin.character.HeroImpl;
import bin.common.*;
import bin.map.MapImpl;
import bin.util.ToolsImpl;

import java.io.File;

public class JGameMain implements GameMain {
    private static String info;           //�����ַ�
    private static JEngineState EngineState;    //����״̬
    private static ToolsImpl Tools;          //������
    private static String acFile;         //�浵·��
    private static File file;           //�浵��
    private static MapImpl Maps;           //��ͼ����
    private static HeroImpl Ben;            //Ӣ��

    public JGameMain() {
        EngineState = JEngineState.EngineClose;
        acFile = "C:\\Users\\����\\Documents\\Study\\Java\\SuperDK\\src\\Archive\\";
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
        System.out.println("�˴�Ӧ����Ϸ���ܺ͵ȴ���ʼ��Ϸ");
        String[] menu = {"[��ʼ]��Ϸ", "[��ȡ]�浵", "[����]��Ϸ"};
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
        if (EngineState == JEngineState.EngineClose && checkInput("��ʼ")) {
            EngineState = JEngineState.EngineRun;
            System.out.println("�˴�����Ϸ��һ�����еĿ�����");
        } else if (EngineState == JEngineState.EngineClose && checkInput("��ȡ")) {
            EngineState = JEngineState.EngineRead;
            System.out.println("�˴�����Ϸ��ȡ�浵����ʾ");
            System.out.println("�˴���ӡ��Ϸ�浵");
            listFile(file);
        } else if (EngineState == JEngineState.EngineRead) {
        } else if (EngineState == JEngineState.EngineRun) {
            if (checkInput("����")) {

                return;
            }
            /**
             * �鿴��ͼ
             */

            if (checkInput("��ͼ")) {
                Maps.printMap(Ben.getPositionX(), Ben.getPositionY());
                return;
            }

            /**
             * �ƶ�
             */
            if (Ben.getHeroState() == JHeroState.HeroMove) {
                if (checkInput("ȡ��")) {
                    Ben.setHeroState(JHeroState.HeroNormal);
                    return;
                } else {
                    HeroOnMove(info);
                    return;
                }
            } else if (checkInput("�ƶ�")) {
                if (Ben.getHeroState() == JHeroState.HeroNormal) {
                    Ben.setHeroState(JHeroState.HeroMove);
                    Maps.checkMap(Ben.getPositionX(), Ben.getPositionY());
                    System.out.println("����[ȡ��]��ȡ���ƶ�");
                    return;
                } else {
                    System.out.println("����ǰ�޷�[�ƶ�],����[����]�Ի�ø������");
                    return;
                }
            }
            /**
             * �鿴�˵�
             */
            if (Ben.getHeroState() == JHeroState.HeroMenu) {
                // �鿴״̬����
                if (Ben.getMenuState() == JHeroMenuState.MenuHeroState) {
                    // ����ӵ�״̬����
                    if (checkInput("����")) {
                        Ben.setMenuState(JHeroMenuState.MenuNormal);
                        return;
                    }
                } else if (checkInput("״̬")) {
                    Ben.setMenuState(JHeroMenuState.MenuHeroState);
                    // ����ӵ�״̬����
                    return;
                }

                // �鿴��������
                if (Ben.getMenuState() == JHeroMenuState.MenuPackage) {
                    if (Ben.getPackageState() == JHeroMenuPackageState.PackageWeapon) {
                        if (!Ben.PACKAGE.mainPackageFuncition(Ben.getPackageState(), info)) {// �������湦��
                            Ben.printPackageMenu();
                            Ben.setPackageState(JHeroMenuPackageState.PackageNormal);
                        } else
                            return;
                    } else if (checkInput("����")) {
                        Ben.setPackageState(JHeroMenuPackageState.PackageWeapon);
                        Ben.PACKAGE.listItem(JItemType.TypeWeapon);
                        Ben.PACKAGE.printPackageHelp(Ben.getPackageState());
                        return;
                    }
                    if (Ben.getPackageState() == JHeroMenuPackageState.PackageArmor) {
                        if (!Ben.PACKAGE.mainPackageFuncition(Ben.getPackageState(), info)) {// װ�����湦��
                            Ben.printPackageMenu();
                            Ben.setPackageState(JHeroMenuPackageState.PackageNormal);
                        } else
                            return;
                    } else if (checkInput("װ��")) {
                        Ben.setPackageState(JHeroMenuPackageState.PackageArmor);
                        Ben.PACKAGE.listItem(JItemType.TypeArmor);
                        Ben.PACKAGE.printPackageHelp(Ben.getPackageState());
                        return;
                    }
                    if (Ben.getPackageState() == JHeroMenuPackageState.PackagePosion) {
                        if (!Ben.PACKAGE.mainPackageFuncition(Ben.getPackageState(), info)) {// ҩˮ���湦��
                            Ben.printPackageMenu();
                            Ben.setPackageState(JHeroMenuPackageState.PackageNormal);
                        } else
                            return;
                    } else if (checkInput("ҩˮ")) {
                        Ben.setPackageState(JHeroMenuPackageState.PackagePosion);
                        Ben.PACKAGE.listItem(JItemType.TypePosion);
                        Ben.PACKAGE.printPackageHelp(Ben.getPackageState());
                        return;
                    }
                    if (Ben.getPackageState() == JHeroMenuPackageState.PackageBotty) {
                        if (!Ben.PACKAGE.mainPackageFuncition(Ben.getPackageState(), info)) { // ��Ʒ���湦��
                            Ben.printPackageMenu();
                            Ben.setPackageState(JHeroMenuPackageState.PackageNormal);
                        } else
                            return;
                    } else if (checkInput("��Ʒ")) {
                        Ben.setPackageState(JHeroMenuPackageState.PackageBotty);
                        Ben.PACKAGE.listItem(JItemType.TypeBooty);
                        Ben.PACKAGE.printPackageHelp(Ben.getPackageState());
                        return;
                    }
                    if (checkInput("����")) {
                        Ben.setMenuState(JHeroMenuState.MenuNormal);
                        Ben.printMainMenu();
                        return;
                    }
                } else if (checkInput("����")) {
                    Ben.setMenuState(JHeroMenuState.MenuPackage);
                    Ben.printPackageMenu();
                    return;
                }

                if (checkInput("�˳�")) {
                    Ben.setHeroState(JHeroState.HeroNormal);
                    return;
                }
            } else if (checkInput("�˵�")) {
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
        System.out.println("�˴�Ӧ����Ϸ�����Ļ�");
    }

    /**
     * @param ePut �����ַ�
     * @return ��ƥ��:false �ɹ�ƥ��:true
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
                    listFile(lists[i]);//��Ŀ¼�͵ݹ����Ŀ¼���ٽ����ж�
                }
            }
        }
        //fl.toString().replaceAll(acFile,"");
        if (!file.getName().equals("Archive"))
            System.out.println(file.getName());//file����Ŀ¼�����������·���������ǵݹ�ĳ���
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
            System.out.println("�ƶ�����");
        }
    }
}
