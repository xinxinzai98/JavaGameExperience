package bin.map;

import bin.common.CommonMap;

public class MapImpl implements Map {
    private int MapNumber;
    private MapTerrainImpl[][] MapBox;//地形容器
    private CommonMap MapMarco;//地图包

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
        // 打印地图头
        System.out.println(MapMarco.GetMapName(this.MapNumber));
        System.out.printf("\\y\\\\x\\");
        System.out.printf("| 零 |");
        System.out.printf("| 一 |");
        System.out.printf("| 二 |");
        System.out.printf("| 三 |");
        System.out.printf("| 四 |");
        System.out.printf("| 五 |");
        System.out.printf("| 六 |");
        System.out.printf("| 七 |");
        System.out.printf("| 八 |");
        System.out.printf("| 九 |");
        System.out.print("\n");

        //打印地图第一行-
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print("-");
            }
        }
        System.out.print("\n");

        //打印地图本体
        for (int y = 0; y < 10; y++) {
            System.out.printf("| 0%d |", y);
            for (int x = 0; x < 10; x++) {
                if (heropositionX == x && heropositionY == y)
                    System.out.print("| 我 |");
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

        System.out.printf("您当前处于@位置\n");
        System.out.println("您的周围环境");
        for (int y = heropositionY - 1; y <= heropositionY + 1; y++) {
            if (y == heropositionY - 1) {
                for (int x = heropositionX - 1; x <= heropositionX + 1; x++) {
                    System.out.print(MapBox[y][x].GetMapName());
                }
                System.out.print("\n\t↖ ↑ ↗\n");
            } else if (y == heropositionY) {
                System.out.print(MapBox[y][heropositionX - 1].GetMapName());
                for (int x = heropositionX - 1; x <= heropositionX + 1; x++) {
                    System.out.print(MapBox[y][x].GetMapName());
                }
            }
        }
        System.out.println("\n这里有关于移动的提示");
    }

    @Override
    public boolean checkMap(int heropositionX, int heropositionY, String dir) {
        int newPositionX = heropositionX;
        int newPositionY = heropositionY;
        switch (dir) {
            case "上":
                newPositionY--;
                break;

            case "右":
                newPositionX++;
                break;

            case "下":
                newPositionY++;
                break;

            case "左":
                newPositionX--;
                break;

            case "左上":
                newPositionX--;
                newPositionY--;
                break;

            case "右上":
                newPositionX++;
                newPositionY--;
                break;

            case "左下":
                newPositionX--;
                newPositionY++;
                break;
            case "右下":
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
