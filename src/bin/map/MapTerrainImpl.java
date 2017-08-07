package bin.map;

public class MapTerrainImpl implements MapTerrain {
    int mapNumber;
    boolean mapPassAble;//ͨ����

    /**
     * @param mapNumber ��ͼ���
     */
    public MapTerrainImpl(int mapNumber) {

        this.mapNumber = mapNumber;
        if(this.mapNumber == 1)//ǽ
            setMapPassAble(false);
        else
            setMapPassAble(true);
    }

    /**
     * @return ��ͼ������
     */
    @Override
    public String GetMapName() {
        switch (this.mapNumber) {
            case 0:
                return "| �� |";
            case 1:
                return "| ǽ |";
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
