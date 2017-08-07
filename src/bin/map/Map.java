package bin.map;

/**
 * Map
 */
public interface Map {

    /**
     * @param nMapNumber ���ص�ͼ
     */
    public void mapLoad(int nMapNumber);

    /**
     * @param heropositionX
     * @param heropositionY
     */
    public void printMap(int heropositionX, int heropositionY);

    /**
     * @param heropositionX
     * @param heropositionY
     */
    public void checkMap(int heropositionX, int heropositionY);

    /**
     * @param heropositionX
     * @param heropositionY
     * @param dir ����
     * @return �ƶ��ɹ�:true �ƶ�ʧ��:false
     */
    public boolean checkMap(int heropositionX, int heropositionY, String dir);
}
