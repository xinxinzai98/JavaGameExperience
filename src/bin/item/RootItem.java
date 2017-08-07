package bin.item;

import bin.common.JItemQuality;
import bin.common.JItemType;

/**
 * ʼ����Ʒ
 */
public class RootItem {
    private JItemType ItemType;   //��Ʒ����
    private int ItemNum;    //��Ʒ���
    private JItemQuality Quality;// Ʒ��
    private int Count;  // ����


    private String Name;    //��Ʒ����
    private int Price;  // �۸�
    private int Weight; // ����
    private int Rare;   // ϡ�ж�
    private boolean Binding; // �Ƿ��
    private String Info;    // ��Ʒ��Ϣ


    public RootItem() {
        System.out.printf("��Ʒ.���ִ���");
    }

    public RootItem(JItemType itemType, int itemNum) {
        Count = 1;
        ItemType = itemType;
        ItemNum = itemNum;
    }
    public void printItemInfo(){
        System.out.printf("\n����:%s",Name);
        System.out.printf("\nƷ��:%s",transQuality());
        System.out.printf("\n����:%s",Info);
        System.out.printf("\n����:%d",Count);
        System.out.printf("\n�۸�:%dԪ",Price);
        System.out.printf("\n����:%dg",Weight);
        System.out.printf("\nϡ�еȼ�:%d",Rare);
        System.out.printf("\n�Ƿ��:%s",Binding?"��":"��");
    }
    public void itemInit(){
        switch (this.ItemNum){
            case 1:
                Name = "���׵���";
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
                return "ʷʫ��";
            case QualitySuperior:
                return "�ϵȵ�";
            case QualityHigh:
                return "���ʵ�";
            case QualityNormal:
                return "��ͨ��";
            case QualityDamaged:
                return "�𻵵�";
            case QualityRuin:
                return "�ưܲ�����";
            case QualityUnusable:
                return "�޷�ʹ�õ�";
            default:
                return "δ��ȡ��Ʒ��";
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
