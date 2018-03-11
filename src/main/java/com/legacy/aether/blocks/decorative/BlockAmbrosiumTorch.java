package com.legacy.aether.blocks.decorative;

import com.legacy.aether.registry.creative_tabs.AetherCreativeTabs;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;

public class BlockAmbrosiumTorch extends BlockTorch {

    public BlockAmbrosiumTorch() {
        super();
        this.setTickRandomly(true);
        this.setLightLevel(0.9375F);
        this.setSoundType(SoundType.WOOD);
        this.setCreativeTab(AetherCreativeTabs.blocks);
    }

}