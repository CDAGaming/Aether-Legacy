package com.legacy.aether.items.weapons.projectile;

import com.legacy.aether.entities.projectile.darts.EntityDartBase;
import com.legacy.aether.entities.projectile.darts.EntityDartEnchanted;
import com.legacy.aether.entities.projectile.darts.EntityDartGolden;
import com.legacy.aether.entities.projectile.darts.EntityDartPoison;
import com.legacy.aether.items.ItemsAether;
import com.legacy.aether.items.util.EnumDartShooterType;
import com.legacy.aether.registry.creative_tabs.AetherCreativeTabs;
import com.legacy.aether.registry.sounds.SoundsAether;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class ItemDartShooter extends Item
{

	public ItemDartShooter()
	{
		this.maxStackSize = 1;
		this.setHasSubtypes(true);
	}

	@Override
	public boolean isFull3D()
	{
		return false;
	}

	@Override
    public EnumRarity getRarity(ItemStack stack)
    {
    	return stack.getMetadata() == 2 ? EnumRarity.RARE : super.getRarity(stack);
    }

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems)
	{
		if (tab != AetherCreativeTabs.weapons || tab == CreativeTabs.SEARCH)
		{
			return;
		}

		for (int var4 = 0; var4 < EnumDartShooterType.values().length; ++var4)
		{
			subItems.add(new ItemStack(this, 1, var4));
		}
	}

	private int consumeItem(EntityPlayer player, Item itemID, int maxDamage)
	{
		IInventory inv = player.inventory;

		for (int i = 0; i < inv.getSizeInventory(); i++)
		{
			ItemStack stack = inv.getStackInSlot(i);

			if (stack == ItemStack.EMPTY)
			{
				continue;
			}

			int damage = stack.getItemDamage();

			if (maxDamage != 3)
			{
				if (stack.getItem() == itemID && stack.getItemDamage() == maxDamage)
				{
					if (!player.capabilities.isCreativeMode)
					{
						stack.shrink(1);
					}

					if (stack.getCount() == 0)
					{
						stack = ItemStack.EMPTY;
					}

					inv.setInventorySlotContents(i, stack);

					return damage;
				}
			}
			if (maxDamage == 3 && stack.getItem() == itemID)
			{
				if (!player.capabilities.isCreativeMode)
				{
					stack.shrink(1);
				}

				if (stack.getCount() == 0)
				{
					stack = ItemStack.EMPTY;
				}

				inv.setInventorySlotContents(i, stack);

				return 3;
			}
		}

		return -1;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return this.getUnlocalizedName() + "_" + EnumDartShooterType.getType(itemstack.getItemDamage()).toString();
	}

	@Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entityplayer, EnumHand hand)
	{
		ItemStack heldItem = entityplayer.getHeldItem(hand);
		int consume;

		if (!(entityplayer.capabilities.isCreativeMode))
		{
			consume = this.consumeItem(entityplayer, ItemsAether.dart, heldItem.getItemDamage());
		}
		else
		{
			consume = heldItem.getItemDamage();
		}

		if (consume != -1)
		{
			world.playSound(entityplayer, entityplayer.getPosition(), SoundsAether.dart_shooter_shoot, SoundCategory.PLAYERS, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));

			EntityDartBase dart = null;

			if (consume == 1)
			{
				dart = new EntityDartPoison(world, entityplayer);
			}
			else if (consume == 2)
			{
				dart = new EntityDartEnchanted(world, entityplayer);
			}
			else if (consume == 0)
			{
				dart = new EntityDartGolden(world, entityplayer);
			}

			if (!world.isRemote)
			{
				dart.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, 1.0F, 1.0F);
				world.spawnEntity(dart);

				if (!(entityplayer.capabilities.isCreativeMode))
				{
					dart.pickupStatus = EntityArrow.PickupStatus.ALLOWED;
				}
				if ((entityplayer.capabilities.isCreativeMode))
				{
					dart.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;
				}
			}
		}

		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, heldItem);
	}

}