package com.legacy.aether.tile_entities;

import com.legacy.aether.world.dungeon.BronzeDungeon;
import com.legacy.aether.world.dungeon.GoldenDungeon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.server.management.PlayerList;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.Random;

public class TileEntityTreasureChest extends TileEntityChest {

    private boolean locked = true;

    private int kind = 0;

    @Override
    public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
        super.readFromNBT(par1nbtTagCompound);

        this.locked = par1nbtTagCompound.getBoolean("locked");
        this.kind = par1nbtTagCompound.getInteger("dungeonType");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound par1nbtTagCompound) {
        super.writeToNBT(par1nbtTagCompound);

        par1nbtTagCompound.setBoolean("locked", this.locked);
        par1nbtTagCompound.setInteger("dungeonType", this.kind);

        return par1nbtTagCompound;
    }

    public void unlock(int kind) {
        this.kind = kind;
        Random random = new Random();
        int p;

        if (kind == 0) {
            for (p = 0; p < 5 + random.nextInt(1); ++p) {
                this.setInventorySlotContents(random.nextInt(this.getSizeInventory()), BronzeDungeon.getBronzeLoot(random));
            }
        }

        if (kind == 1) {
            for (p = 0; p < 5 + random.nextInt(1); ++p) {
                // this.setInventorySlotContents(random.nextInt(this.getSizeInventory()), SilverDungeon.getSilverLoot(random));
            }
        }

        if (kind == 2) {
            for (p = 0; p < 5 + random.nextInt(1); ++p) {
                this.setInventorySlotContents(random.nextInt(this.getSizeInventory()), GoldenDungeon.getGoldLoot(random));
            }
        }

        this.locked = false;

        if (!this.world.isRemote) {
            this.sendToAllInOurWorld(this.getUpdatePacket());
        }
    }

    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.getNbtCompound());
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound var1 = new NBTTagCompound();
        this.writeToNBT(var1);
        return new SPacketUpdateTileEntity(this.pos, 191, var1);
    }

    @Override
    public void openInventory(EntityPlayer player) {
        super.openInventory(player);

        if (player instanceof EntityPlayerMP) {
            ((EntityPlayerMP) player).connection.sendPacket(this.getUpdatePacket());
        }
    }

    @Override
    public void closeInventory(EntityPlayer player) {
        if (!player.isSpectator()) {
            --this.numPlayersUsing;
            this.world.addBlockEvent(this.pos, this.getBlockType(), 1, this.numPlayersUsing);
            this.world.notifyNeighborsOfStateChange(this.pos, this.getBlockType(), false);
            this.world.notifyNeighborsOfStateChange(this.pos.down(), this.getBlockType(), false);
        }
    }

    private void sendToAllInOurWorld(SPacketUpdateTileEntity pkt) {
        PlayerList scm = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList();

        scm.sendPacketToAllPlayers(pkt);
    }

    public boolean isLocked() {
        return this.locked;
    }

    public int getKind() {
        return this.kind;
    }

}