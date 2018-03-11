package com.legacy.aether.blocks.natural.enchanted;

import com.legacy.aether.blocks.util.BlockFloating;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockEnchantedGravitite extends BlockFloating 
{

	public BlockEnchantedGravitite()
	{
		super(Material.IRON, true);

		this.setHardness(5F);
		this.setSoundType(SoundType.METAL);
	}

	@Override
    public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon)
    {
    	return true;
    }

}