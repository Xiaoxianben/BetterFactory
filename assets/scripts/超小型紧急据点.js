const 超小型紧急据点 = extend(CoreBlock, "超小型紧急据点", {
    canBreak(tile) { return Vars.state.teams.cores(tile.team()).size > 1; },
    canReplace(other) { return other.alwaysReplace; },
    canPlaceOn(tile, team) { return Vars.state.teams.cores(team).size < 16;
    },
});