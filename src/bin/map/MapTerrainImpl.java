package bin.map;

public class MapTerrainImpl implements MapTerrain {
    int mapNumber;
    boolean mapPassAble;//通过性

    /**
     * @param mapNumber 地图编号
     */
    public MapTerrainImpl(int mapNumber) {

        this.mapNumber = mapNumber;
        if(this.mapNumber == 1)//墙
            setMapPassAble(false);
        else
            setMapPassAble(true);
    }

    /**
     * @return 地图中文名
     */
    @Override
    public String GetMapName() {
        switch (this.mapNumber) {
            case 0:
                return "| 空 |";
            case 1:
                return "| 墙 |";
            default:
                return null;
        }
    }

    public boolean isMapPassAble() {
        return mapPassAble;
    }

    public void setMapPassAble(boolean mapPassAble) {
        this.mapPassAble = mapPassAble;
    }

    public int getMapNumber() {
        return mapNumber;
    }

    public void setMapNumber(int mapNumber) {
        this.mapNumber = mapNumber;
    }
}
