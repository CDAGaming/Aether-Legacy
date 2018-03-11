package com.legacy.aether.networking.packets;

import com.legacy.aether.containers.inventory.InventoryAccessories;
import com.legacy.aether.player.PlayerAether;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class PacketAccessory extends AetherPacket<PacketAccessory>
{

	private InventoryAccessories accessories;

	private int entityID;

	public PacketAccessory()
	{
		
	}

	public PacketAccessory(PlayerAether thePlayer)
	{
		this.accessories = thePlayer.accessories;
		this.entityID = thePlayer.thePlayer.getEntityId();
	}

	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.entityID = buf.readInt();

		this.accessories = new InventoryAccessories(null);
		this.accessories.readData(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(this.entityID);
		this.accessories.writeData(buf);
	}

	@Override
	public void handleClient(PacketAccessory message, EntityPlayer player) 
	{
		if (player != null && player.world != null)
		{
			EntityPlayer parent = (EntityPlayer) player.world.getEntityByID(message.entityID);

			if (parent != null)
			{
				message.accessories.player = parent;
				PlayerAether.get(parent).accessories = message.accessories;
			}
		}
	}

	@Override
	public void handleServer(PacketAccessory message, EntityPlayer player)
	{

	}

}
