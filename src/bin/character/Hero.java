package bin.character;

/**
 *
 */
public interface Hero {
    /**
     * @param dir
     * @return 移动成功与否
     */
    public boolean OnMove(String dir);

    /**
     * 打印菜单界面
     */
    public void printMainMenu();

    /**
     * 打印背包菜单页面
     */
    public void printPackageMenu();

    /**
     * 打印英雄状态
     */
    public void printHeroState();
}
