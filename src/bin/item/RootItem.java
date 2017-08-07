package bin.item;

import bin.common.JItemQuality;
import bin.common.JItemType;

/**
 * 始祖物品
 */
public class RootItem {
    private JItemType ItemType;   //物品类型
    private int ItemNum;    //物品编号
    private JItemQuality Quality;// 品质
    private int Count;  // 数量


    private String Name;    //物品名称
    private int Price;  // 价格
    private int Weight; // 重量
    private int Rare;   // 稀有度
    private boolean Binding; // 是否绑定
    private String Info;    // 物品信息


    public RootItem() {
        System.out.printf("物品.出现错误");
    }

    public RootItem(JItemType itemType, int itemNum) {
        Count = 1;
        ItemType = itemType;
        ItemNum = itemNum;
    }
    public void printItemInfo(){
        System.out.printf("\n名称:%s",Name);
        System.out.printf("\n品质:%s",transQuality());
        System.out.printf("\n描述:%s",Info);
        System.out.printf("\n数量:%d",Count);
        System.out.printf("\n价格:%d元",Price);
        System.out.printf("\n重量:%dg",Weight);
        System.out.printf("\n稀有等级:%d",Rare);
        System.out.printf("\n是否绑定:%s",Binding?"是":"否");
    }
    public void itemInit(){
        switch (this.ItemNum){
            case 1:
                Name = "父亲的信";
                Price = 0;
                Weight = 0;
                Rare = 9;
                Binding = true;
                Info = Name;
                break;
        }
        Quality = JItemQuality.QualityNormal;
    }
    public String transQuality(){
        switch (this.Quality){
            case QualityEpics:
                return "史诗的";
            case QualitySuperior:
                return "上等的";
            case QualityHigh:
                return "优质的";
            case QualityNormal:
                return "普通的";
            case QualityDamaged:
                return "损坏的";
            case QualityRuin:
                return "破败不堪的";
            case QualityUnusable:
                return "无法使用的";
            default:
                return "未获取到品质";
        }
    }
    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public int getRare() {
        return Rare;
    }

    public void setRare(int rare) {
        Rare = rare;
    }

    public JItemType getItemType() {
        return ItemType;
    }

    public void setItemType(JItemType itemType) {
        ItemType = itemType;
    }

    public int getItemNum() {
        return ItemNum;
    }

    public void setItemNum(int itemNum) {
        ItemNum = itemNum;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public JItemQuality getQuality() {
        return Quality;
    }

    public void setQuality(JItemQuality quality) {
        Quality = quality;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public boolean isBinding() {
        return Binding;
    }

    public void setBinding(boolean binding) {
        Binding = binding;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }
}
