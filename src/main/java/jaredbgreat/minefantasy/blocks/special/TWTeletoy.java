package jaredbgreat.minefantasy.blocks.special;

import jaredbgreat.minefantasy.blocks.tileentities.LandingpadLogic;
import jaredbgreat.minefantasy.blocks.tileentities.TWTeletoyLogic;
import jaredbgreat.minefantasy.blocks.tileentities.TeletoyLogic;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TWTeletoy extends Landingpad {

	public TWTeletoy() {
		super("tpad02a2");
		setLightLevel(0.75f);
		LandingpadLogic.landings.add(this);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p) {
		return new TWTeletoyLogic();
	}
	
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		TileEntity te = world.getTileEntity(x, y, z);
		if(te instanceof TWTeletoyLogic) {
			TWTeletoyLogic logic = (TWTeletoyLogic)te;
			logic.onActivated(world, entity);
		}
	}

}
