package com.legacy.aether.items.food;

import com.legacy.aether.registry.creative_tabs.AetherCreativeTabs;
import net.minecraft.item.ItemFood;

public class ItemAetherFood extends ItemFood {
    public ItemAetherFood(int healAmmount) {
        super(healAmmount, false);
        this.setCreativeTab(AetherCreativeTabs.food);
    }

    public ItemAetherFood(int healAmmount, float saturationAmmount) {
        super(healAmmount, saturationAmmount, false);
        this.setCreativeTab(AetherCreativeTabs.food);
    }

}