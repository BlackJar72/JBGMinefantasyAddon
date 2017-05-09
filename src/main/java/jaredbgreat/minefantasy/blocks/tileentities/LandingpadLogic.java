package jaredbgreat.minefantasy.blocks.tileentities;

import java.util.HashSet;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class LandingpadLogic extends TelepadBaseLogic {
	public static final HashSet<Block> landings = new HashSet<Block>();
	private String name = "";
	
	
	public void onTrigger(Entity enity, World world) {
		world.playSoundEffect(xCoord, yCoord, zCoord, "mob.endermen.portal", 1f, 1f);
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


	@Override
	boolean inRange() {
		return false;
	}

}
