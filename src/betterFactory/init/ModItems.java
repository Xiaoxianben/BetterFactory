package betterFactory.init;

import arc.graphics.Color;
import mindustry.type.Item;

public class ModItems {
    public static Item copperLeadAlloys;
    public static Item titaniumAlloy;
    public static Item siliconCrystal;
    public static Item chip;

    public void init() {
        copperLeadAlloys = new Item("copperLeadAlloy", Color.valueOf("97D597FF")) {{
            this.hardness = 2;
            this.cost = 1.0F;
        }};
        titaniumAlloy = new Item("titaniumAlloy", Color.valueOf("ACB3CFFF")) {{
            this.hardness = 5;
            this.cost = 1.0F;
        }};
        siliconCrystal = new Item("siliconCrystal", Color.valueOf("EBEEF5FF")) {{
            this.cost = 1.0F;
        }};
        chip = new Item("chip", Color.valueOf("EBEEF5FF")) {{
            this.cost = 1.0F;
        }};
    }
}
