package bin.character;

/**
 *
 */
public interface Hero {
    /**
     * @param dir
     * @return �ƶ��ɹ����
     */
    public boolean OnMove(String dir);

    /**
     * ��ӡ�˵�����
     */
    public void printMainMenu();

    /**
     * ��ӡ�����˵�ҳ��
     */
    public void printPackageMenu();

    /**
     * ��ӡӢ��״̬
     */
    public void printHeroState();
}
