package jaredbgreat.minefantasy.blocks.tileentities;

import jaredbgreat.minefantasy.mechanics.TwoWayTeleportManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class TwoWayBaseLogic extends LandingpadLogic {
	protected static final TwoWayTeleportManager manager = new TwoWayTeleportManager();
	
	
	@Override
	public void onActivated(World world, Entity entity) {
		if(!manager.canTP(entity)) {
			manager.add(entity);
			return;
		} else {
			manager.add(entity);
			if(usable(world) && (entity instanceof EntityLivingBase)) {
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
				onTrigger(entity, world);
			}
		}
	}
	
	
	public static void updateManager() {
		manager.swap();
	}
	
	
	@Override	
	public void onTrigger(Entity entity, World world) {
		onTrigger2(entity, world);
		checkMate(world);
		if(mate != null) {
			if(mate instanceof TwoWayBaseLogic) {
				TwoWayBaseLogic other = (TwoWayBaseLogic)mate;
				other.onTrigger2(entity, world);
			} else {
				mate.onTrigger(entity, world);
			}
		}
	}
	
	public void onTrigger2(Entity entity, World world) {
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
	
}
