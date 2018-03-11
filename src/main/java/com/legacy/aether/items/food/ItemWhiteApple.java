package com.legacy.aether.items.food;

import com.legacy.aether.player.PlayerAether;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWhiteApple extends ItemAetherFood {

    public ItemWhiteApple() {
        super(0);
        this.setAlwaysEdible();
    }

    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        PlayerAether.get(player).attainCure(300);
    }

}