package com.legacy.aether.items.tools;

import com.legacy.aether.blocks.BlocksAether;
import com.legacy.aether.items.util.EnumAetherToolType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSkyrootTool extends ItemAetherTool {

    public ItemSkyrootTool(EnumAetherToolType toolType) {
        super(ToolMaterial.WOOD, toolType);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Item.getItemFromBlock(BlocksAether.skyroot_plank);
    }
}