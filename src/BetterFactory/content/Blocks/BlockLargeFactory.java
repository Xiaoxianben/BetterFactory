package BetterFactory.content.Blocks;

import mindustry.world.blocks.production.GenericCrafter;

public class BlockLargeFactory extends BlockFactoryBasic {
    public BlockLargeFactory(String name, GenericCrafter ParentBlock) {
        super(name, ParentBlock, 8);
        this.description = "在技术的提高下，减少无用消耗，产出提升4倍\n[blue]第一次工业革命(狗头)";

        this.hasPower = true;
        this.craftTime = Math.min(60.0F, this.ParentBlock.craftTime - 0.1F);

        this.size = this.ParentBlock.size + 1;
    }
}
