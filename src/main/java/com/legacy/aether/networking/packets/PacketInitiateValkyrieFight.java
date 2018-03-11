package com.legacy.aether.networking.packets;

import com.legacy.aether.entities.bosses.valkyrie_queen.EntityValkyrieQueen;
import com.legacy.aether.player.PlayerAether;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class PacketInitiateValkyrieFight extends AetherPacket<PacketInitiateValkyrieFight>
{

	public int slotId, entityId;

	public PacketInitiateValkyrieFight()
	{
		
	}

	public PacketInitiateValkyrieFight(int slotId, int entityId)
	{
		this.slotId = slotId;
		this.entityId = entityId;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.slotId = buf.readInt();
		this.entityId = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(this.slotId);
		buf.writeInt(this.entityId);
	}

	@Override
	public void handleClient(PacketInitiateValkyrieFight message, EntityPlayer player)
	{

	}

	@Override
	public void handleServer(PacketInitiateValkyrieFight message, EntityPlayer player) 
	{
		player.inventory.setInventorySlotContents(message.slotId, ItemStack.EMPTY);

		Entity entity = player.world.getEntityByID(message.entityId);

		if (entity instanceof EntityValkyrieQueen)
		{
			((EntityValkyrieQueen)entity).setBossReady(true);
			PlayerAether.get(player).setCurrentBoss((EntityValkyrieQueen)entity);
		}
	}

}