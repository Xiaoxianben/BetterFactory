package BetterFactory.content.Init;

import arc.graphics.Color;
import mindustry.type.Item;

public class ModItems {
    public static Item 铜铅融合物;
    public static Item 铜铅合金;
    public static Item 晶体;
    public static Item 芯片;
    public static Item 钛合金;

    public static void init() {
        铜铅融合物 = new Item("铜铅融合物", Color.valueOf("97D694FF"));
        铜铅合金 = new Item("铜铅合金", Color.valueOf("97D597FF"));
        晶体 = new Item("晶体", Color.valueOf("EBEEF5FF"));
        芯片 = new Item("芯片", Color.valueOf("EBEEF5FF"));
        钛合金 = new Item("钛合金", Color.valueOf("ACB3CFFF"));
    }
}
