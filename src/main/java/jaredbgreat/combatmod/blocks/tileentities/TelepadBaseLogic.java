package jaredbgreat.combatmod.blocks.tileentities;

import jaredbgreat.combatmod.blocks.MF1Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class TelepadBaseLogic extends TileEntity {
	double targetX = 0d, targetY = 255d, targetZ = 0d;
	boolean active = false;
	
	
	public void onActivated(World world, Entity entity) {
		if(usable() && toPad(world) && (entity instanceof EntityLivingBase)) {
			if(entity instanceof EntityPlayerMP) {
				EntityPlayerMP traveller = (EntityPlayerMP)entity;
				traveller.playerNetServerHandler
						.setPlayerLocation(targetX, targetY, targetZ, 
										   traveller.rotationYaw, traveller.rotationPitch);
			} else {
				EntityLivingBase traveller = (EntityLivingBase)entity;			
				traveller.setLocationAndAngles(targetX, targetY, targetZ, 
												traveller.rotationYaw, traveller.rotationPitch);
			}
		}
	}
	
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		active  = nbt.getBoolean("active");
		targetX = nbt.getDouble("targetX");
		targetY = nbt.getDouble("targetY");
		targetZ = nbt.getDouble("targetZ");
	}
	
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setBoolean("active", active);
		nbt.setDouble("targetX", targetX);
		nbt.setDouble("targetY", targetY);
		nbt.setDouble("targetZ", targetZ);
	}
	
	
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}
	
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, nbt);
	}
	
	
	abstract boolean inRange();
	
	
	boolean usable() {
		return (active && inRange());
	}
	
	
	boolean toPad(World world) {
		int x = (int)(targetX - 0.5d);
		int y = (int)targetY;
		int z = (int)(targetZ - 0.5d);
		return world.getBlock(x, y, z).equals(MF1Blocks.landingpad);
	}
	
	
	public void setData(double x, double y, double z) {
		active = true;
		targetX = x;
		targetY = y;
		targetZ = z;
	}

}
