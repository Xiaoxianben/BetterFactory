package BetterFactory.content.Init;

import BetterFactory.content.Blocks.BlockLargeFactory;
import BetterFactory.content.Blocks.BlockMultiLineFactory;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.production.GenericCrafter;

public class ModBlocks {
    public static BlockMultiLineFactory 多线压缩厂;
    public static BlockMultiLineFactory 多线冶炼厂;
    public static BlockMultiLineFactory 多线混合厂;
    public static BlockMultiLineFactory 多线窑炉厂;
    public static BlockMultiLineFactory 多线压榨厂;
    public static BlockMultiLineFactory 多线粉碎厂;
    public static BlockMultiLineFactory 多线熔化厂;
    public static BlockMultiLineFactory 多线培养厂;

    public static BlockLargeFactory 大型压缩厂;
    public static BlockLargeFactory 大型冶炼厂;
    public static BlockLargeFactory 大型混合厂;
    public static BlockLargeFactory 大型窑炉厂;
    public static BlockLargeFactory 大型压榨厂;
    public static BlockLargeFactory 大型粉碎厂;
    public static BlockLargeFactory 大型熔化厂;
    public static BlockLargeFactory 大型培养厂;

    public static void init() {
        多线压缩厂 = new BlockMultiLineFactory("多线压缩厂", (GenericCrafter) Blocks.graphitePress) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅融合物, 52, Items.graphite, 5));
            this.consumeItem(Items.coal, 8);
        }};
        多线冶炼厂 = new BlockMultiLineFactory("多线冶炼厂", (GenericCrafter) Blocks.siliconSmelter) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅融合物, 28, Items.graphite, 10, Items.silicon, 5));
            this.consumePower(1.5F);
            this.consumeItems(ItemStack.with(Items.coal, 4, Items.sand, 8));
        }};
        多线混合厂 = new BlockMultiLineFactory("多线混合厂", (GenericCrafter) Blocks.pyratiteMixer) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅融合物, 36, Items.graphite, 5, Items.pyratite, 5));
            this.consumePower(0.6F);
            this.consumeItems(ItemStack.with(Items.coal, 4, Items.lead, 8, Items.sand, 8));
        }};
        多线窑炉厂 = new BlockMultiLineFactory("多线窑炉厂", (GenericCrafter) Blocks.kiln) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅融合物, 45, Items.graphite, 30));
            this.consumePower(1.8F);
            this.consumeItems(ItemStack.with(Items.lead, 4, Items.sand, 4));
        }};
        多线压榨厂 = new BlockMultiLineFactory("多线压榨厂", (GenericCrafter) Blocks.sporePress) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅融合物, 32, Items.graphite, 20));
            this.consumePower(2.1F);
            this.consumeItems(ItemStack.with(Items.sporePod, 4));
        }};
        多线粉碎厂 = new BlockMultiLineFactory("多线粉碎厂", (GenericCrafter) Blocks.pulverizer) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅融合物, 26, Items.graphite, 10));
            this.consumePower(1.5F);
            this.consumeItems(ItemStack.with(Items.scrap, 4));
        }};
        多线熔化厂 = new BlockMultiLineFactory("多线熔化厂", (GenericCrafter) Blocks.melter) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅融合物, 32, Items.graphite, 50));
            this.consumePower(3.0F);
            this.consumeItems(ItemStack.with(Items.scrap, 4));
        }};
        多线培养厂 = new BlockMultiLineFactory("多线培养厂", (GenericCrafter) Blocks.cultivator) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅融合物, 25, Items.silicon, 40, Items.graphite, 40));
            this.consumePower(4.0F);
            this.consumeLiquid(Liquids.water, 1.2F);
        }};

        大型压缩厂 = new BlockLargeFactory("大型压缩厂", (GenericCrafter) Blocks.graphitePress) {{
            this.hasLiquids = false;
            this.hasItems = true;
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅合金, 52, Items.graphite, 10));
            this.consumePower(1.0F);
            this.consumeItem(Items.coal, 8);
        }};
        大型冶炼厂 = new BlockLargeFactory("大型冶炼厂", (GenericCrafter) Blocks.siliconSmelter) {{
            this.hasLiquids = false;
            this.hasItems = true;
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅合金, 28, Items.graphite, 25, Items.silicon, 20));
            this.consumePower(2.5F);
            this.consumeItems(ItemStack.with(Items.sand, 8));
        }};
        大型混合厂 = new BlockLargeFactory("大型混合厂", (GenericCrafter) Blocks.pyratiteMixer) {{
            this.hasLiquids = false;
            this.hasItems = true;
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅合金, 36, Items.graphite, 15, Items.pyratite, 20));
            this.consumePower(1.0F);
            this.consumeItems(ItemStack.with(Items.coal, 4, Items.sand, 8));
        }};
        大型窑炉厂 = new BlockLargeFactory("大型窑炉厂", (GenericCrafter) Blocks.kiln) {{
            this.hasLiquids = false;
            this.hasItems = true;
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅合金, 45, Items.graphite, 45));
            this.consumePower(2.5F);
            this.consumeItems(ItemStack.with(Items.sand, 4));
        }};
        大型压榨厂 = new BlockLargeFactory("大型压榨厂", (GenericCrafter) Blocks.sporePress) {{
            this.hasLiquids = true;
            this.hasItems = true;
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅合金, 32, Items.graphite, 30));
            this.consumePower(3.0F);
            this.consumeItems(ItemStack.with(Items.sporePod, 4));
        }};
        大型粉碎厂 = new BlockLargeFactory("大型粉碎厂", (GenericCrafter) Blocks.pulverizer) {{
            this.hasLiquids = false;
            this.hasItems = true;
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅合金, 26, Items.graphite, 30));
            this.consumePower(2.5F);
            this.consumeItems(ItemStack.with(Items.sand, 4));
        }};
        大型熔化厂 = new BlockLargeFactory("大型熔化厂", (GenericCrafter) Blocks.melter) {{
            this.hasLiquids = true;
            this.hasItems = true;
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅合金, 32, Items.graphite, 80));
            this.consumePower(4.0F);
            this.consumeItems(ItemStack.with(Items.scrap, 4));
        }};
        大型培养厂 = new BlockLargeFactory("大型培养厂", (GenericCrafter) Blocks.cultivator) {{
            this.hasLiquids = true;
            this.hasItems = true;
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅合金, 25, Items.silicon, 50, Items.graphite, 60));
            this.consumePower(4.0F);
            this.consumeLiquid(Liquids.water, 2.4F);
        }};


    }
}
