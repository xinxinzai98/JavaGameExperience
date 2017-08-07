package bin.map;

/**
 * Map
 */
public interface Map {

    /**
     * @param nMapNumber 加载地图
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
     * @param dir 方向
     * @return 移动成功:true 移动失败:false
     */
    public boolean checkMap(int heropositionX, int heropositionY, String dir);
}
