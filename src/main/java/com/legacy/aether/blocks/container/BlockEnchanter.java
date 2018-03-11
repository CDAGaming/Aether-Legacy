package com.legacy.aether.blocks.container;

import com.legacy.aether.Aether;
import com.legacy.aether.blocks.BlocksAether;
import com.legacy.aether.networking.AetherGuiHandler;
import com.legacy.aether.tile_entities.TileEntityEnchanter;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockEnchanter extends BlockAetherContainer
{

	public BlockEnchanter()
	{
		super(Material.ROCK);

        this.setHardness(2.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityEnchanter();
	}

	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(BlocksAether.enchanter);
    }

	@Override
    @SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random)
    {
		if(state.getValue(powered).booleanValue())
		{
			float f = (float)pos.getX() + 0.5F;
			float f1 = (float)pos.getY() + 1.0F + (random.nextFloat() * 6F) / 16F;
			float f2 = (float)pos.getZ() + 0.5F;

			world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, f, f1, f2, 0.0D, 0.0D, 0.0D);
			world.spawnParticle(EnumParticleTypes.FLAME, f, f1, f2, 0.0D, 0.0D, 0.0D);
			
			if (random.nextDouble() < 0.1D)
            {
                world.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            }
		}
    }

	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
    	player.openGui(Aether.instance, AetherGuiHandler.enchanter, world, pos.getX(), pos.getY(), pos.getZ());

        return true;
    }

	@Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (tileentity instanceof TileEntityEnchanter)
        {
            InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityEnchanter)tileentity);
            worldIn.updateComparatorOutputLevel(pos, this);
        }

        super.breakBlock(worldIn, pos, state);
    }

	@Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

}