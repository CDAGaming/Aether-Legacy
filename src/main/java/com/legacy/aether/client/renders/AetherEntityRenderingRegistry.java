package com.legacy.aether.client.renders;

import com.legacy.aether.blocks.BlocksAether;
import com.legacy.aether.client.renders.entities.*;
import com.legacy.aether.client.renders.entities.layer.AccessoriesLayer;
import com.legacy.aether.client.renders.entities.projectile.*;
import com.legacy.aether.entities.block.EntityFloatingBlock;
import com.legacy.aether.entities.block.EntityTNTPresent;
import com.legacy.aether.entities.bosses.EntityFireMinion;
import com.legacy.aether.entities.bosses.EntityValkyrie;
import com.legacy.aether.entities.bosses.slider.EntitySlider;
import com.legacy.aether.entities.bosses.sun_spirit.EntitySunSpirit;
import com.legacy.aether.entities.bosses.valkyrie_queen.EntityValkyrieQueen;
import com.legacy.aether.entities.hostile.*;
import com.legacy.aether.entities.passive.EntityAerwhale;
import com.legacy.aether.entities.passive.EntityMiniCloud;
import com.legacy.aether.entities.passive.EntitySheepuff;
import com.legacy.aether.entities.passive.mountable.*;
import com.legacy.aether.entities.projectile.EntityHammerProjectile;
import com.legacy.aether.entities.projectile.EntityLightningKnife;
import com.legacy.aether.entities.projectile.EntityPhoenixArrow;
import com.legacy.aether.entities.projectile.EntityZephyrSnowball;
import com.legacy.aether.entities.projectile.crystals.EntityFireBall;
import com.legacy.aether.entities.projectile.crystals.EntityIceyBall;
import com.legacy.aether.entities.projectile.crystals.EntityThunderBall;
import com.legacy.aether.entities.projectile.darts.EntityDartBase;
import com.legacy.aether.tile_entities.TileEntityChestMimic;
import com.legacy.aether.tile_entities.TileEntityTreasureChest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class AetherEntityRenderingRegistry {

    public static void initialize() {
        /* Misc */
        register(EntityHammerProjectile.class, HammerProjectileRenderer.class);
        register(EntityFloatingBlock.class, FloatingBlockRenderer.class);
        register(EntityParachute.class, ParachuteRenderer.class);
        register(EntityZephyrSnowball.class, ZephyrSnowballRenderer.class);
        register(EntityPhoenixArrow.class, PhoenixArrowRenderer.class);
        register(EntityLightningKnife.class, LightningKnifeRenderer.class);

        /* Darts */
        register(EntityDartBase.class, DartBaseRenderer.class);

        /* Crystals */
        register(EntityFireBall.class, FireBallRenderer.class);
        register(EntityIceyBall.class, IceyBallRenderer.class);
        register(EntityThunderBall.class, ThunderBallRenderer.class);

        /* Bosses */
        register(EntitySlider.class, SliderRenderer.class);
        register(EntityValkyrieQueen.class, ValkyrieQueenRenderer.class);
        register(EntitySunSpirit.class, SunSpiritRenderer.class);

        /* Hostile */
        register(EntityMimic.class, MimicRenderer.class);
        register(EntitySentry.class, SentryRenderer.class);
        register(EntityAechorPlant.class, AechorPlantRenderer.class);
        register(EntityFireMinion.class, FireMinionRenderer.class);
        register(EntityZephyr.class, ZephyrRenderer.class);
        register(EntityValkyrie.class, ValkyrieRenderer.class);
        register(EntityCockatrice.class, CockatriceRenderer.class);

        /* Passive */
        register(EntityMoa.class, MoaRenderer.class);
        register(EntityPhyg.class, PhygRenderer.class);
        register(EntityFlyingCow.class, FlyingCowRenderer.class);
        register(EntitySheepuff.class, SheepuffRenderer.class);
        register(EntityAerwhale.class, AerwhaleRenderer.class);
        register(EntityAerbunny.class, AerbunnyRenderer.class);
        register(EntitySwet.class, SwetRenderer.class);
        register(EntityMiniCloud.class, MiniCloudRenderer.class);
        register(EntityTNTPresent.class, TNTPresentRenderer.class);
        register(EntityWhirlwind.class, WhirlwindRenderer.class);
    }

    @SuppressWarnings("deprecation")
    public static void registerTileEntities() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTreasureChest.class, new TreasureChestRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChestMimic.class, new ChestMimicRenderer());

        ForgeHooksClient.registerTESRItemStack(Item.getItemFromBlock(BlocksAether.treasure_chest), 0, TileEntityTreasureChest.class);
        ForgeHooksClient.registerTESRItemStack(Item.getItemFromBlock(BlocksAether.chest_mimic), 0, TileEntityChestMimic.class);
    }

    public static void initializePlayerLayers() {
        RenderPlayer slim_render = Minecraft.getMinecraft().getRenderManager().getSkinMap().get("slim");
        slim_render.addLayer(new AccessoriesLayer(true, (ModelPlayer) slim_render.getMainModel()));

        RenderPlayer default_render = Minecraft.getMinecraft().getRenderManager().getSkinMap().get("default");
        default_render.addLayer(new AccessoriesLayer(false, (ModelPlayer) default_render.getMainModel()));
    }

    public static <ENTITY extends Entity> void register(Class<ENTITY> classes, final Class<? extends Render<ENTITY>> render) {
        RenderingRegistry.registerEntityRenderingHandler(classes, new IRenderFactory<ENTITY>() {

            @Override
            public Render<ENTITY> createRenderFor(RenderManager manager) {
                try {
                    return render.getConstructor(RenderManager.class).newInstance(manager);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return null;
            }
        });
    }

}