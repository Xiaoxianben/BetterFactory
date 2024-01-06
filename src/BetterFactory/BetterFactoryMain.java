package BetterFactory;

import BetterFactory.content.Init.ModBlocks;
import BetterFactory.content.Init.ModItems;
import BetterFactory.content.Init.ModLiquids;
import BetterFactory.content.Init.ModTechNode;
import arc.Core;
import arc.Events;
import arc.scene.ui.ScrollPane;
import arc.scene.ui.layout.Table;
import arc.util.Log;
import arc.util.Time;
import mindustry.game.EventType.ClientLoadEvent;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.BaseDialog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BetterFactoryMain extends Mod {

    public BetterFactoryMain() {
        // 获取 文件 assets/更新日志.txt
        StringBuilder txt = new StringBuilder();
        InputStream inputStream = BetterFactoryMain.class.getResourceAsStream("/更新日志.txt");
        if (inputStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    txt.append(line).append('\n');
                }
                txt.deleteCharAt(txt.length() - 1);
            } catch (IOException a) {
                Log.info(a);
            }
        } else {
            txt = new StringBuilder("暂无更新日志");
        }
        String finalTxt = txt.toString();
        Log.info("Loaded BetterFactory Mod constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("更好的工厂");
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.image(Core.atlas.find("better-factory-icon")).top().pad(32).row();
                Table table = new Table();
                table.add("本模组还在测试，贴图大多抄的其他模组（已经改的面目全非）；还有一部分完全没有改，是临时的贴图，以后一定会改。\n有问题请到B站搜“小仙本猫”");
                dialog.cont.add(table).size(500, 5).row();

                dialog.cont.button("[blue]赞助", () -> {
                    BaseDialog dialog2 = new BaseDialog("[blue]赞助");
                    Table t = new Table();
                    t.add("还在测试，暂时不能赞助");
                    dialog2.cont.add(new ScrollPane(t)).size(500, 600).row();
                    dialog2.buttons.defaults().size(620, 64);
                    dialog2.buttons.button("@close", dialog2::hide).size(500, 64);
                    dialog2.show();
                }).size(210, 64).row();
                dialog.cont.button("[red]更新日志", () -> {
                    BaseDialog dialog2 = new BaseDialog("[red]更新日志");
                    Table t = new Table();
                    t.add(finalTxt);
                    // t.add("还在测试，暂无更新日志");
                    dialog2.cont.add(new ScrollPane(t)).size(500, 600).row();
                    dialog2.buttons.defaults().size(620, 64);
                    dialog2.buttons.button("@close", dialog2::hide).size(500, 64);
                    dialog2.show();
                }).size(210, 64);

                dialog.buttons.defaults().size(210, 64);
                dialog.buttons.button("@close", dialog::hide).size(500, 64).bottom().row();
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent() {
        ModItems.init();
        ModLiquids.init();
        ModBlocks.init();
        ModTechNode.init();

        Log.info("Loading BetterFactory content.");
    }

}
