package com.legacy.aether.entities.projectile.darts;

import com.legacy.aether.items.ItemsAether;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityDartEnchanted extends EntityDartBase {

    public EntityDartEnchanted(World worldIn) {
        super(worldIn);
    }

    public EntityDartEnchanted(World world, EntityLivingBase entity) {
        super(world, entity);
    }

    public void entityInit() {
        super.entityInit();
        this.setDamage(6);
    }

    @Override
    protected ItemStack getArrowStack() {
        return new ItemStack(ItemsAether.dart, 1, 2);
    }

}