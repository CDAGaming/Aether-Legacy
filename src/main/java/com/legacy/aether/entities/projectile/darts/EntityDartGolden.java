package com.legacy.aether.entities.projectile.darts;

import com.legacy.aether.items.ItemsAether;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityDartGolden extends EntityDartBase {

    public EntityLivingBase victim;

    public EntityDartGolden(World worldIn) {
        super(worldIn);
    }

    public EntityDartGolden(World world, EntityLivingBase entity) {
        super(world, entity);
    }

    public void entityInit() {
        super.entityInit();
        this.setDamage(4);
    }

    public boolean handleWaterMovement() {
        return this.victim == null && super.handleWaterMovement();
    }

    public void setDead() {
        this.victim = null;
        super.setDead();
    }

    public boolean onHitBlock() {
        this.playSound(SoundEvents.ENTITY_ARROW_HIT, 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
        return this.victim == null;
    }

    @Override
    protected ItemStack getArrowStack() {
        return new ItemStack(ItemsAether.dart, 1, 0);
    }

}