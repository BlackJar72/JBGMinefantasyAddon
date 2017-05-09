package jaredbgreat.minefantasy.blocks.tileentities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

public class TWTeletoyLogic extends TwoWayBaseLogic {
	private static double RANGESQ = 65536d; // 256 (maximum range) squared
	
	boolean inRange() {
		return (((targetX - xCoord) * (targetX - xCoord))  
			  + ((targetY - yCoord) * (targetY - yCoord))
			  + ((targetZ - zCoord) * (targetZ - zCoord)) <= RANGESQ);
	}
	
	public static void setMaxRange(int range) {
		long sqare = ((long)range) * ((long)range);
		RANGESQ = (double)(range * range);
	}
	
	
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
}
