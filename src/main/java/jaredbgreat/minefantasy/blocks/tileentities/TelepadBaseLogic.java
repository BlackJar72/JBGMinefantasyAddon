package jaredbgreat.minefantasy.blocks.tileentities;

import jaredbgreat.minefantasy.ConfigHandler;
import jaredbgreat.minefantasy.blocks.AddonBlocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class TelepadBaseLogic extends TileEntity {
	double targetX = 0d, targetY = 255d, targetZ = 0d;
	boolean active = false;
	private LandingpadLogic mate = null;
	
	
	public void onActivated(World world, Entity entity) {
		if(usable(world) && (entity instanceof EntityLivingBase)) {
			if(entity instanceof EntityPlayerMP) {				
				EntityPlayerMP traveller = (EntityPlayerMP)entity;
				traveller.playerNetServerHandler
						.setPlayerLocation(targetX, targetY, targetZ, 
										   traveller.rotationYaw, traveller.rotationPitch);
				world.playSoundEffect(targetX, yCoord, zCoord, "mob.endermen.portal", 1f, 1f);
			} else {
				EntityLivingBase traveller = (EntityLivingBase)entity;	
				traveller.setLocationAndAngles(targetX, targetY, targetZ, 
												traveller.rotationYaw, traveller.rotationPitch);
				world.playSoundEffect(targetX, yCoord, zCoord, "mob.endermen.portal", 1f, 1f);
			}
			onTrigger(entity, world);
		}
	}
	
	
	private void telesickness(EntityLivingBase traveller) {
		if(ConfigHandler.telesickness) {
			// For some reason the potion effects get stuck on with the
			// inventory gui, even when the effects are over!  Thus, not used :(
			traveller.addPotionEffect(new PotionEffect(15,  30, 0));
			traveller.addPotionEffect(new PotionEffect(19,  60, 0));
			traveller.addPotionEffect(new PotionEffect(17, 100, 0));
			traveller.addPotionEffect(new PotionEffect(9,  160, 0));
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
	
	
	boolean usable(World world) {
		return (active && inRange() && toPad(world));
	}
	
	
	boolean toPad(World world) {
		int x = (int)(targetX - 0.5d);
		int y = (int)targetY;
		int z = (int)(targetZ - 0.5d);
		return world.getBlock(x, y, z).equals(AddonBlocks.landingpad);
	}
	
	
	public void setData(double x, double y, double z) {
		active = true;
		targetX = x;
		targetY = y;
		targetZ = z;
	}
	
	
	public void setInactive() {
		active = false;
		targetX = 0;
		targetY = 0;
		targetZ = 0;
	}
	
	
	private void checkMate(World world) {
		if(mate == null) {
			int x = (int)(targetX - 0.5d);
			int y = (int)targetY;
			int z = (int)(targetZ - 0.5d);
			TileEntity te = world.getTileEntity(x, y, z);
			if(te instanceof LandingpadLogic) {
				mate = (LandingpadLogic)te;
			}
		}		
	}
	
	
	public LandingpadLogic getMate(World world) {
		checkMate(world);
		return mate;
	}
	
	public void onTrigger(Entity entity, World world) {
		for(int i = 0; i < 128; i++) {
			world.spawnParticle("happyVillager", 
					xCoord + world.rand.nextDouble(), 
					yCoord + (world.rand.nextDouble() + world.rand.nextDouble() + world.rand.nextDouble()), 
					zCoord + world.rand.nextDouble(), 
					(world.rand.nextDouble() - world.rand.nextDouble() * 16),  
					32 + (world.rand.nextDouble() * 128), 
					(world.rand.nextDouble() - world.rand.nextDouble()) * 16);
		}
		checkMate(world);
		if(mate != null) {
			mate.onTrigger(entity, world);
		}
	}

}
