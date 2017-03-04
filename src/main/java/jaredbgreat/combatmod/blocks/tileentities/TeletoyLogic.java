package jaredbgreat.combatmod.blocks.tileentities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TeletoyLogic extends TelepadBaseLogic {
	static final double RANGESQ = 16384d;
	
	boolean inRange() {
		return (((targetX - xCoord) * (targetX - xCoord))  
			  + ((targetY - yCoord) * (targetY - yCoord))
			  + ((targetZ - zCoord) * (targetZ - zCoord)) <= RANGESQ);
	}
}
