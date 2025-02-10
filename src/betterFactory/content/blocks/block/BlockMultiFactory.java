package betterFactory.content.blocks.block;

import mindustry.world.blocks.production.GenericCrafter;

public class BlockMultiFactory extends BlockFactoryBasic {
    public BlockMultiFactory(String name, GenericCrafter ParentBlock) {
        super(name, ParentBlock, 2);
        this.description = this.parentBlock.description + "\n可以多线程同时操作，使其产量增大2倍，[red]但是消耗也为2倍。";


        this.hasLiquids = this.parentBlock.hasLiquids;
        this.hasItems = this.parentBlock.hasItems;
        this.hasPower = this.parentBlock.hasPower;
        this.craftTime = this.parentBlock.craftTime;

        this.size = this.parentBlock.size + 1;
    }


}
