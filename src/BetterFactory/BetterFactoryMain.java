package BetterFactory;

import BetterFactory.content.Init.ModBlocks;
import BetterFactory.content.Init.ModItems;
import BetterFactory.content.Init.ModTechNode;
import arc.Core;
import arc.Events;
import arc.util.Log;
import arc.util.Time;
import mindustry.game.EventType.ClientLoadEvent;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.BaseDialog;

public class BetterFactoryMain extends Mod {

    public BetterFactoryMain() {
        Log.info("Loaded BetterFactory mod constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("frog");
                dialog.cont.add("behold").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.image(Core.atlas.find("BetterFactory-icon")).pad(20f).row();
                dialog.cont.image(Core.atlas.find("BetterFactory-frog")).pad(20f).row();
                dialog.cont.button("取消", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent() {
        ModItems.init();
        ModBlocks.init();
        ModTechNode.init();

        Log.info("Loading BetterFactory content.");
    }

}
