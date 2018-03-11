package com.legacy.aether.items.accessories;

import com.google.common.base.Predicates;
import com.legacy.aether.Aether;
import com.legacy.aether.api.accessories.AccessoryType;
import com.legacy.aether.items.ItemsAether;
import com.legacy.aether.player.PlayerAether;
import com.legacy.aether.registry.creative_tabs.AetherCreativeTabs;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemAccessory extends Item {

    public static final String ROOT = Aether.modAddress() + "textures/slots/slot_";
    public static final IBehaviorDispenseItem DISPENSER_BEHAVIOR = new BehaviorDefaultDispenseItem() {
        protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
            ItemStack itemstack = ItemAccessory.dispenseAccessory(source, stack);
            return itemstack != null ? itemstack : super.dispenseStack(source, stack);
        }
    };
    protected final AccessoryType accessoryType;
    public ResourceLocation texture, texture_slim;
    private int colorHex = 0xdddddd;
    private boolean isDungeonLoot = false;

    public ItemAccessory(AccessoryType type) {
        this.accessoryType = type;
        this.texture = Aether.locate("textures/armor/accessory_base.png");
        this.texture_slim = Aether.locate("textures/armor/accessory_base_slim.png");
        this.setMaxStackSize(1);
        this.setCreativeTab(AetherCreativeTabs.accessories);
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, DISPENSER_BEHAVIOR);
    }

    public static ItemStack dispenseAccessory(IBlockSource blockSource, ItemStack stack) {
        BlockPos blockpos = blockSource.getBlockPos().offset((EnumFacing) blockSource.getBlockState().getValue(BlockDispenser.FACING));
        List<EntityLivingBase> list = blockSource.getWorld().<EntityLivingBase>getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(blockpos), Predicates.<EntityLivingBase>and(EntitySelectors.NOT_SPECTATING, new EntitySelectors.ArmoredMob(stack)));

        if (list.isEmpty()) {
            return null;
        } else {
            EntityLivingBase entitylivingbase = (EntityLivingBase) list.get(0);

            if (entitylivingbase instanceof EntityPlayer) {
                ItemStack itemstack = stack.copy();
                itemstack.setCount(1);

                PlayerAether playerAether = PlayerAether.get((EntityPlayer) entitylivingbase);

                if (!playerAether.accessories.setInventoryAccessory(itemstack)) {
                    BehaviorDefaultDispenseItem.doDispense(blockSource.getWorld(), itemstack, 6, (EnumFacing) blockSource.getBlockState().getValue(BlockDispenser.FACING), BlockDispenser.getDispensePosition(blockSource));
                }

                stack.shrink(1);

                return stack;
            }
        }

        return stack;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand hand) {
        ItemStack heldItem = player.getHeldItem(hand);

        if (heldItem != ItemStack.EMPTY) {
            if (PlayerAether.get(player).accessories.setInventoryAccessory(heldItem.copy())) {
                heldItem.shrink(1);

                return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, heldItem);
            }
        }

        return new ActionResult<ItemStack>(EnumActionResult.FAIL, heldItem);
    }

    public AccessoryType getType() {
        return this.accessoryType;
    }

    public Item setColor(int color) {
        this.colorHex = color;
        return this;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return this.isDungeonLoot ? ItemsAether.aether_loot : super.getRarity(stack);
    }

    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack stack, int meta) {
        return this.colorHex;
    }

    public ItemAccessory setDungeonLoot() {
        this.isDungeonLoot = true;
        return this;
    }

    public ItemAccessory setTexture(String location) {
        this.texture = new ResourceLocation("aether_legacy", "textures/armor/accessory_" + location + ".png");
        this.texture_slim = Aether.locate("textures/armor/accessory_" + location + "_slim.png");

        return this;
    }

}