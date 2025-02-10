package betterFactory.content.blocks;

import betterFactory.api.IHasInit;
import betterFactory.init.ModItems;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.draw.DrawTurret;

import static mindustry.type.ItemStack.with;

public class BlocksTurret implements IHasInit {

    public static Block kineticCannon;

    @Override
    public void init() {
        kineticCannon = new ItemTurret("kineticCannon") {{
            requirements(Category.turret, with(ModItems.copperLeadAlloys, 30));
            ammo(
                    Items.copper, new BasicBulletType(5.5f, 20) {{
                        width = height = 9f;
                        knockback = 0.8f;
                        ammoMultiplier = 3;
                        lifetime = 60f;
                    }},
                    Items.silicon, new BasicBulletType(5.5f, 60) {{
                        width = height = 9f;
                        knockback = 0.8f;
                        ammoMultiplier = 3;
                        lifetime = 60f;
                    }},
                    ModItems.copperLeadAlloys, new BasicBulletType(5.5f, 80) {{
                        width = height = 12f;
                        knockback = 1f;
                        ammoMultiplier = 3;
                        lifetime = 60f;
                    }},
                    ModItems.siliconCrystal, new BasicBulletType(5.5f, 100) {{
                        width = height = 13f;
                        knockback = 1f;
                        ammoMultiplier = 3;
                        lifetime = 60f;
                    }},
                    ModItems.titaniumAlloy, new BasicBulletType(5.5f, 200) {{
                        width = height = 15f;
                        knockback = 1f;
                        ammoMultiplier = 3;
                        lifetime = 60f;
                    }}
            );

            drawer = new DrawTurret() {{
                parts.add(new RegionPart("-barrel") {{
                    progress = PartProgress.recoil;
                    under = false;
                    moveY = -1.5f;
                }});
            }};

            range = 300f;
            size = 2;

            reload = 20f;
            shoot.shots = 1;
            shoot.shotDelay = 10f;

            recoil = 1.5f;
            rotateSpeed = 15f;
            inaccuracy = 2f;
            shootCone = 20f;

            scaledHealth = 200;
            shootSound = Sounds.shootSnap;
            coolant = consumeCoolant(0.2f);
        }};

    }
}