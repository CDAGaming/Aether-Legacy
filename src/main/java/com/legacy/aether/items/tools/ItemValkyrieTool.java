package com.legacy.aether.items.tools;

import com.legacy.aether.items.ItemsAether;
import com.legacy.aether.items.util.EnumAetherToolType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public class ItemValkyrieTool extends ItemAetherTool {

    public ItemValkyrieTool(EnumAetherToolType toolType) {
        super(ToolMaterial.DIAMOND, toolType);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return false;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return ItemsAether.aether_loot;
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        if (!(entityLiving instanceof EntityPlayer)) {
            return false;
        }

        EntityPlayer player = (EntityPlayer) entityLiving;

        Vec3d playerVision = player.getLookVec();
        AxisAlignedBB reachDistance = player.getEntityBoundingBox().grow(10.0D);

        List<Entity> locatedEntities = player.world.getEntitiesWithinAABB(Entity.class, reachDistance);

        Entity found = null;
        double foundLen = 0.0D;

        for (Object o : locatedEntities) {
            if (o == player) {
                continue;
            }

            Entity ent = (Entity) o;

            if (!ent.canBeCollidedWith()) {
                continue;
            }

            Vec3d vec = new Vec3d(ent.posX - player.posX, ent.getEntityBoundingBox().minY + ent.height / 2f - player.posY - player.getEyeHeight(), ent.posZ - player.posZ);
            double len = vec.lengthVector();

            if (len > 10.0F) {
                continue;
            }

            vec = vec.normalize();
            double dot = playerVision.dotProduct(vec);

            if (dot < 1.0 - 0.125 / len || !player.canEntityBeSeen(ent)) {
                continue;
            }

            if (foundLen == 0.0 || len < foundLen) {
                found = ent;
                foundLen = len;
            }
        }

        if (found != null && player.getRidingEntity() != found) {
            stack.damageItem(1, player);

            player.attackTargetEntityWithCurrentItem(found);
        }

        return false;
    }

}