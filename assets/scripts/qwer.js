//信息栏
//进游戏显示 搬运请勿移除版权等声明信息
var text = "1. 更新铜铅融合物及其相关工厂\n\
2. 更新铜铅合金及其相关工厂";

Events.on(EventType.ClientLoadEvent, cons(e => {
    var dialog = new BaseDialog("更好的工厂");
    dialog.buttons.defaults()
        .size(210, 64);
    dialog.buttons.button("@close", run(() => {
        dialog.hide();
    })).size(210, 64);
    dialog.cont.pane((() => {
        var table = new Table();
        table.add("本模组还在测试，贴图大多抄的其他模组（已经改的面目全非）；还有一部分完全没有改，是临时的贴图，以后会改\n有问题请到B站搜“小仙本猫”")
            .left()
            .growX()
            .wrap()
            .width(600)
            .maxWidth(1000)
            .pad(4)
            .labelAlign(Align.left);
        table.row();

        table.button("[blue]赞助", run(() => {
            var dialog2 = new BaseDialog("[blue]赞助");
            var table = new Table();
            var t = new Table();
            t.add("还在测试，暂时不能赞助")
            dialog2.cont.add(new ScrollPane(t))
                .size(500, 600)
                .row();
            dialog2.buttons.defaults()
                .size(620, 64);
            dialog2.buttons.button("@close", run(() => {
                dialog2.hide();
            }))
                .size(500, 64);
            dialog2.show();
        }))
            .size(210, 64)
            .row();

        table.button("[red]更新日志", run(() => {
            var dialog2 = new BaseDialog("[red]更新日志");
            var table = new Table();
            var t = new Table();

            t.add(text);
            // t.add("还在测试，暂无更新日志");
            dialog2.cont.add(new ScrollPane(t))
                .size(500, 600)
                .row();
            dialog2.buttons.defaults()
                .size(620, 64);
            dialog2.buttons.button("@close", run(() => {
                dialog2.hide();
            }))
                .size(500, 64);
            dialog2.show();
        }))
            .size(210, 64);
        return table;
    })())
        .grow()
        .center()
        .maxWidth(620);
    dialog.show();
}));
//新科技作者提供
//抄的"星辰"的