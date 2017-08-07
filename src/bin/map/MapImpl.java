package bin.map;

import bin.common.CommonMap;

public class MapImpl implements Map {
    private int MapNumber;
    private MapTerrainImpl[][] MapBox;//��������
    private CommonMap MapMarco;//��ͼ��

    public MapImpl() {
        this.MapBox = new MapTerrainImpl[10][10];
        this.MapMarco = new CommonMap();
    }

    @Override
    public void mapLoad(int mapnumber) {
        setMapNumber(mapnumber);
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                MapTerrainImpl mapTerrainTemp = new MapTerrainImpl(MapMarco.GetMap(this.MapNumber)[y][x]);
                MapBox[y][x] = mapTerrainTemp;
            }
        }
    }

    @Override
    public void printMap(int heropositionX, int heropositionY) {
        // ��ӡ��ͼͷ
        System.out.println(MapMarco.GetMapName(this.MapNumber));
        System.out.printf("\\y\\\\x\\");
        System.out.printf("| �� |");
        System.out.printf("| һ |");
        System.out.printf("| �� |");
        System.out.printf("| �� |");
        System.out.printf("| �� |");
        System.out.printf("| �� |");
        System.out.printf("| �� |");
        System.out.printf("| �� |");
        System.out.printf("| �� |");
        System.out.printf("| �� |");
        System.out.print("\n");

        //��ӡ��ͼ��һ��-
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print("-");
            }
        }
        System.out.print("\n");

        //��ӡ��ͼ����
        for (int y = 0; y < 10; y++) {
            System.out.printf("| 0%d |", y);
            for (int x = 0; x < 10; x++) {
                if (heropositionX == x && heropositionY == y)
                    System.out.print("| �� |");
                else {
                    System.out.print(MapBox[y][x].GetMapName());
                }
            }
            System.out.print("\n");
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 6; j++) {
                    System.out.print("-");
                }
            }
            System.out.print("\n");
        }
    }

    public void checkMap(int heropositionX, int heropositionY) {

        System.out.printf("����ǰ����@λ��\n");
        System.out.println("������Χ����");
        for (int y = heropositionY - 1; y <= heropositionY + 1; y++) {
            if (y == heropositionY - 1) {
                for (int x = heropositionX - 1; x <= heropositionX + 1; x++) {
                    System.out.print(MapBox[y][x].GetMapName());
                }
                System.out.print("\n\t�I �� �J\n");
            } else if (y == heropositionY) {
                System.out.print(MapBox[y][heropositionX - 1].GetMapName());
                for (int x = heropositionX - 1; x <= heropositionX + 1; x++) {
                    System.out.print(MapBox[y][x].GetMapName());
                }
            }
        }
        System.out.println("\n�����й����ƶ�����ʾ");
    }

    @Override
    public boolean checkMap(int heropositionX, int heropositionY, String dir) {
        int newPositionX = heropositionX;
        int newPositionY = heropositionY;
        switch (dir) {
            case "��":
                newPositionY--;
                break;

            case "��":
                newPositionX++;
                break;

            case "��":
                newPositionY++;
                break;

            case "��":
                newPositionX--;
                break;

            case "����":
                newPositionX--;
                newPositionY--;
                break;

            case "����":
                newPositionX++;
                newPositionY--;
                break;

            case "����":
                newPositionX--;
                newPositionY++;
                break;
            case "����":
                newPositionX++;
                newPositionY++;
                break;
            default:
                return false;
        }
        return MapBox[newPositionY][newPositionX].isMapPassAble();
    }

    public int getMapNumber() {
        return MapNumber;
    }

    public void setMapNumber(int mapNumber) {
        MapNumber = mapNumber;
    }
}
