package com.legacy.aether.blocks.decorative;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockQuicksoilGlass extends BlockBreakable {

    public BlockQuicksoilGlass() {
        super(Material.GLASS, false);

        this.setDefaultSlipperiness(1.1F);
        this.setLightLevel(0.7375F);
        this.setHardness(0.2F);
        this.setLightOpacity(0);
        this.setSoundType(SoundType.GLASS);
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    protected boolean canSilkHarvest() {
        return true;
    }

}