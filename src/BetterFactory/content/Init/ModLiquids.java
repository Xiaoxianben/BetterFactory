package BetterFactory.content.Init;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class ModLiquids {
    public static Liquid 铜铅溶液;

    public static void init() {
        铜铅溶液 = new Liquid("铜铅溶液", Color.valueOf("97D694FF"));
    }
}
