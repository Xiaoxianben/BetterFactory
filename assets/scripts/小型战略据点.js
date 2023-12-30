const 小型战略据点 = extend(CoreBlock, "小型战略据点", {
    canBreak(tile) { return Vars.state.teams.cores(tile.team()).size > 1; },
    canReplace(other) { return other.alwaysReplace; },
    canPlaceOn(tile, team) { return Vars.state.teams.cores(team).size < 201;
    },
});