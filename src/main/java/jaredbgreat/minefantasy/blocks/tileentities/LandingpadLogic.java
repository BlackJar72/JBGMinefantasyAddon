package jaredbgreat.minefantasy.blocks.tileentities;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class LandingpadLogic extends TileEntity {
	private String name = "";
	
	public void onTrigger(Entity enity, World world) {
		for(int i = 0; i < 128; i++) {
			world.spawnParticle("happyVillager", 
					xCoord + world.rand.nextDouble(), 
					yCoord + (world.rand.nextDouble() + world.rand.nextDouble() + world.rand.nextDouble()), 
					zCoord + world.rand.nextDouble(), 
					(world.rand.nextDouble() - world.rand.nextDouble() * 16),  
					32 + (world.rand.nextDouble() * 128), 
					(world.rand.nextDouble() - world.rand.nextDouble()) * 16);
		}
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		name  = nbt.getString("Name");
	}
	
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setString("Name", name);
	}

}
