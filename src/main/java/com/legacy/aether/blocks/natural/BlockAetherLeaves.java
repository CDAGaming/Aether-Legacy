package com.legacy.aether.blocks.natural;

import com.legacy.aether.blocks.BlocksAether;
import com.legacy.aether.blocks.util.EnumLeafType;
import com.legacy.aether.blocks.util.IAetherMeta;
import com.legacy.aether.entities.particles.ParticleGoldenOakLeaves;
import com.legacy.aether.registry.creative_tabs.AetherCreativeTabs;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockAetherLeaves extends BlockLeaves implements IAetherMeta {

    public static final PropertyEnum<EnumLeafType> leaf_type = PropertyEnum.create("aether_leaves", EnumLeafType.class);

    public BlockAetherLeaves() {
        super();

        this.setHardness(0.2F);
        this.setLightOpacity(1);
        this.setCreativeTab(AetherCreativeTabs.blocks);
        this.setDefaultState(this.getDefaultState().withProperty(leaf_type, EnumLeafType.Green).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
    }

    @Override
    public String getMetaName(ItemStack stack) {
        return ((EnumLeafType) this.getStateFromMeta(stack.getItemDamage()).getValue(leaf_type)).getName();
    }

    @Override
    public int damageDropped(IBlockState state) {
        return 0;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getStateFromMeta(meta).withProperty(DECAYABLE, false).withProperty(CHECK_DECAY, false);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);

        if (!world.isRemote) {
            return;
        }

        if (Minecraft.getMinecraft().gameSettings.particleSetting != 2) {
            if (((EnumLeafType) state.getValue(leaf_type)) == EnumLeafType.Golden) {
                for (int ammount = 0; ammount < 4; ammount++) {
                    double d = pos.getX() + (random.nextFloat() - 0.5D) * 10;
                    double d1 = pos.getY() + (random.nextFloat() - 0.5D) * 10;
                    double d2 = pos.getZ() + (random.nextFloat() - 0.5D) * 10;
                    double d3 = (random.nextFloat() - 0.5D) * 0.5D;
                    double d4 = (random.nextFloat() - 0.5D) * 0.5D;
                    double d5 = (random.nextFloat() - 0.5D) * 0.5D;

                    ParticleGoldenOakLeaves obj = new ParticleGoldenOakLeaves(world, d, d1, d2, d3, d4, d5);
                    FMLClientHandler.instance().getClient().effectRenderer.addEffect(obj);
                }
            }
        }
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
        for (int j = 0; j < EnumLeafType.values().length; ++j) {
            EnumLeafType leafType = EnumLeafType.values()[j];

            list.add(new ItemStack(this, 1, leafType.getMeta()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(leaf_type, EnumLeafType.getType(meta % 2)).withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
    }

    public int getMetaFromState(IBlockState state) {
        int i = 0;
        i = i | ((EnumLeafType) state.getValue(leaf_type)).getMeta();

        if (!((Boolean) state.getValue(DECAYABLE)).booleanValue()) {
            i |= 4;
        }

        if (((Boolean) state.getValue(CHECK_DECAY)).booleanValue()) {
            i |= 8;
        }

        return i;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{leaf_type, DECAYABLE, CHECK_DECAY});
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ((EnumLeafType) state.getValue(leaf_type)) == EnumLeafType.Green ? Item.getItemFromBlock(BlocksAether.skyroot_sapling) : Item.getItemFromBlock(BlocksAether.golden_oak_sapling);
    }

    @Override
    public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        ArrayList<ItemStack> list = new ArrayList<ItemStack>();
        IBlockState state = world.getBlockState(pos);

        if (state.getValue(leaf_type) != null) {
            list.add(new ItemStack(this, 1, state.getValue(leaf_type).getMeta()));
        }

        return list;
    }

    @Override
    public EnumType getWoodType(int meta) {
        return null;
    }

}