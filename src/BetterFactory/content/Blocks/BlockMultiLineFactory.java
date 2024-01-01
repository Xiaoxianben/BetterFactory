package BetterFactory.content.Blocks;

import mindustry.world.blocks.production.GenericCrafter;

public class BlockMultiLineFactory extends BlockFactoryBasic {
    public BlockMultiLineFactory(String name, GenericCrafter ParentBlock) {
        super(name, ParentBlock, 4);
        this.description = "可以多线程同时操作，使其每秒产量增大4倍，[red]但是消耗也为4倍";


        this.hasLiquids = this.ParentBlock.hasLiquids;
        this.hasItems = this.ParentBlock.hasItems;
        this.hasPower = this.ParentBlock.hasPower;
        this.craftTime = this.ParentBlock.craftTime;

        this.size = this.ParentBlock.size + 1;
    }


}
