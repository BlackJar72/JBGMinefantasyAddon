package jaredbgreat.minefantasy.blocks.special;

import jaredbgreat.minefantasy.blocks.tileentities.LandingpadLogic;
import jaredbgreat.minefantasy.blocks.tileentities.TWTelepadLogic;
import jaredbgreat.minefantasy.blocks.tileentities.TelepadLogic;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TWTelepad extends Landingpad {

	public TWTelepad() {
		super("tpad01a2");
		setLightLevel(1.0f);
		LandingpadLogic.landings.add(this);	
	}

	@Override
	public TileEntity createNewTileEntity(World wordl, int p) {
		return new TWTelepadLogic();
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		TileEntity te = world.getTileEntity(x, y, z);
		if(te instanceof TWTelepadLogic) {
			TWTelepadLogic logic = (TWTelepadLogic)te;
			logic.onActivated(world, entity);
		}
	}
}
