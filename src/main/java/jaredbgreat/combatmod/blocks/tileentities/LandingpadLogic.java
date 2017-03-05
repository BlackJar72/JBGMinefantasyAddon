package jaredbgreat.combatmod.blocks.tileentities;

import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class LandingpadLogic extends TileEntity {
	
	public void onTrigger(Entity enity, World world) {/*Do nothing, at least for now*/
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
