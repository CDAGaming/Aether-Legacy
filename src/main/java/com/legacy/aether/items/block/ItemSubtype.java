package com.legacy.aether.items.block;

import com.legacy.aether.blocks.util.IAetherMeta;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemSubtype extends ItemBlock
{

	public ItemSubtype(Block block)
	{
		super(block);
		this.setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return "tile." + ((IAetherMeta)this.block).getMetaName(itemstack);
	}

	@Override
	public int getMetadata(int damage)
	{
		return damage;
	}

}