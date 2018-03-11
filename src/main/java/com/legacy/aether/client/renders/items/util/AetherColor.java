package com.legacy.aether.client.renders.items.util;

import com.legacy.aether.blocks.BlocksAether;
import com.legacy.aether.blocks.natural.BlockAercloud;
import com.legacy.aether.items.ItemMoaEgg;
import com.legacy.aether.items.accessories.ItemAccessory;
import com.legacy.aether.items.armor.ItemAetherArmor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class AetherColor implements IItemColor, IBlockColor
{

	private Item item;

	public AetherColor(Item item)
	{
		this.item = item;
	}

	@Override
	public int colorMultiplier(ItemStack stack, int tintIndex)
	{
		if (this.item instanceof ItemAccessory)
		{
			return ((ItemAccessory)stack.getItem()).getColorFromItemStack(stack, 0);
		}

		if (this.item instanceof ItemAetherArmor)
		{
			return ((ItemAetherArmor)stack.getItem()).getColorization(stack);
		}

		if (this.item instanceof ItemMoaEgg)
		{
			return ((ItemMoaEgg)stack.getItem()).getColorFromItemStack(stack);
		}

		if (this.item == Item.getItemFromBlock(BlocksAether.aercloud))
		{
			return BlockAercloud.getHexColor(stack);
		}

		return 0;
	}

	@Override
	public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex)
	{
		if (this.item == Item.getItemFromBlock(BlocksAether.aercloud))
		{
			return BlockAercloud.getHexColor(new ItemStack(state.getBlock(), 1, state.getBlock().getMetaFromState(state)));
		}

		return 0;
	}

}