package betterFactory.init;

import arc.struct.Seq;
import betterFactory.content.blocks.*;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.TechTree;
import mindustry.ctype.UnlockableContent;
import mindustry.game.Objectives;
import mindustry.type.ItemStack;

import java.util.Arrays;

public class ModTechTree {
    public TechTree.TechNode context = null;

    public void init() {

        addToNode(Items.silicon, () -> node(ModItems.siliconCrystal, ModItems.chip));
        addToNode(Items.lead, () -> node(ModItems.copperLeadAlloys));
        addToNode(Items.titanium, () -> node(ModItems.titaniumAlloy));

        // 生产
        addToNode(Blocks.graphitePress, () -> node(BlocksOwn.CopperLeadFactory, () -> {
            node(BlocksMulti.multiGraphitePressFactory,
                    () -> node(BlocksLarge.largeGraphitePressFactory));
            node(BlocksOwn.titaniumAlloyFactory);
        }));

        addToNode(Blocks.siliconSmelter, () -> node(BlocksMulti.multiSiliconSmelterFactory, () -> node(BlocksLarge.largeSiliconSmelterFactory)));
        addToNode(Blocks.pyratiteMixer, () -> node(BlocksMulti.multiPyratiteFactory, () -> node(BlocksLarge.largePyratiteFactory)));
        addToNode(Blocks.kiln, () -> node(BlocksMulti.multiKilnFactory, () -> node(BlocksLarge.largeKilnFactory)));
        addToNode(Blocks.sporePress, () -> node(BlocksMulti.multiSporePressFactory, () -> node(BlocksLarge.largeSporePressFactory)));
        addToNode(Blocks.pulverizer, () -> node(BlocksMulti.multiPulverizerFactory, () -> node(BlocksLarge.largePulverizerFactory)));
        addToNode(Blocks.melter, () -> node(BlocksMulti.multiMelterFactory, () -> node(BlocksLarge.largeMelterFactory)));
        addToNode(Blocks.blastMixer, () -> node(BlocksMulti.multiBlastFactory, () -> node(BlocksLarge.largeBlastFactory)));
        addToNode(Blocks.separator, () -> node(BlocksMulti.multiSeparatorFactory, () -> node(BlocksLarge.largeSeparatorFactory)));
        addToNode(Blocks.coalCentrifuge, () -> node(BlocksMulti.multiCoalCentrifugeFactory, () -> node(BlocksLarge.largeCoalCentrifugeFactory)));
        addToNode(Blocks.plastaniumCompressor, () -> node(BlocksMulti.multiPlastaniumFactory, () -> node(BlocksLarge.largePlastaniumFactory)));
        addToNode(Blocks.cryofluidMixer, () -> node(BlocksMulti.multiCryoffluidFactory, () -> node(BlocksLarge.largeCryoffluidFactory)));
        addToNode(Blocks.phaseWeaver, () -> node(BlocksMulti.multiPhaseFactory, () -> node(BlocksLarge.largePhaseFactory)));
        addToNode(Blocks.surgeSmelter, () -> node(BlocksMulti.multiSurgeFactory, () -> node(BlocksLarge.largeSurgeFactory)));

        addToNode(Blocks.cultivator, () -> node(BlocksMulti.multiCultivatorFactory, () -> node(BlocksLarge.largeCultivatorFactory)));

        // conveyor
        addToNode(Blocks.itemBridge, () -> node(
                BlocksConveyor.copperLeadConveyor, BlocksConveyor.copperLeadJunction, BlocksConveyor.copperLeadBridge,
                BlocksConveyor.titaniumAlloyConveyor, BlocksConveyor.titaniumAlloyJunction, BlocksConveyor.titaniumAlloyBridge));

        // drill
        addToNode(Blocks.pneumaticDrill, () -> node(BlocksDrill.copperLeadDrill, BlocksDrill.titaniumAlloyDrill));

        // liquid
        addToNode(Blocks.mechanicalPump, () -> node(BlocksLiquid.copperLeadPump, BlocksLiquid.titaniumAlloyPump));

        // power
        addToNode(Blocks.powerNode, () -> node(BlocksPower.copperLeadPowerNode, () -> {
            node(BlocksPower.copperLeadPowerNodeLarge, BlocksPower.copperLeadSteamGenerator);
            node(BlocksPower.titaniumAlloyPowerNode, BlocksPower.titaniumAlloyPowerNodeLarge, BlocksPower.titaniumAlloySteamGenerator);
        }));

        addToNode(Blocks.battery, () -> node(
                BlocksPower.copperLeadBattery, BlocksPower.copperLeadBatteryLarge,
                BlocksPower.titaniumAlloyBattery, BlocksPower.titaniumAlloyBatteryLarge));

        // turret
        addToNode(Blocks.duo, () -> node(BlocksTurret.kineticCannon));

        // wall
        addToNode(Blocks.copperWallLarge, () -> node(BlocksWall.copperLeadWall, () -> {
            node(BlocksWall.copperLeadWallLarge);
            node(BlocksWall.titaniumAlloyWall, BlocksWall.titaniumAlloyWallLarge);
        }));
    }

    public void addToNode(UnlockableContent p, Runnable c) {
        context = TechTree.all.find(t -> t.content == p);
        c.run();
    }

    public void node(UnlockableContent block) {
        node(block, () -> {
        });
    }

    public void node(UnlockableContent... blocks) {
        switch (blocks.length) {
            case 0:
                return;
            case 1:
                node(blocks[0]);
                break;
            default:
                node(blocks[0], () -> node(Arrays.copyOfRange(blocks, 1, blocks.length)));
        }
    }

    public void node(UnlockableContent content, Runnable children) {
        if (content == null) return;
        node(content, content.researchRequirements(), children);
    }

    public void node(UnlockableContent content, ItemStack[] requirements, Runnable children) {
        node(content, requirements, null, children);
    }

    public void node(UnlockableContent content, ItemStack[] requirements, Seq<Objectives.Objective> objectives, Runnable children) {
        TechTree.TechNode node = new TechTree.TechNode(context, content, requirements);
        if (objectives != null) {
            node.objectives.addAll(objectives);
        }

        TechTree.TechNode prev = context;
        context = node;
        children.run();
        context = prev;
    }
}
