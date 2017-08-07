package bin.common;

/**
 *
 */
public class CommonMap {
    int Map_1[][];

    public CommonMap() {
        Map_1 = new int[][]{
       //y\x 0  1  2  3  4  5  6  7  8  9
       /*0*/{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
       /*1*/{1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
       /*2*/{1, 0, 1, 0, 1, 1, 1, 1, 0, 1},
       /*3*/{1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
       /*4*/{1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
       /*5*/{1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
       /*6*/{1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
       /*7*/{1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
       /*8*/{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
       /*9*/{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
    }

    public int[][] GetMap(int mapnum) {
        switch (mapnum) {
            case 1:
                return Map_1;

        }
        return null;
    }
    public String GetMapName(int mapnum){
        switch (mapnum){
            case 1:
                return "²âÊÔµØÍ¼";
            default:
                return null;
        }
    }
}
