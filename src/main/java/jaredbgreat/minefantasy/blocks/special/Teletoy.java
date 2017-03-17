package jaredbgreat.minefantasy.blocks.special;

import jaredbgreat.minefantasy.blocks.tileentities.TeletoyLogic;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Teletoy extends AbstractTelepad {

	public Teletoy() {
		super("tpad02a");
		setLightLevel(0.75f);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p) {
		return new TeletoyLogic();
	}
	
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		TileEntity te = world.getTileEntity(x, y, z);
		if(te instanceof TeletoyLogic) {
			TeletoyLogic logic = (TeletoyLogic)te;
			logic.onActivated(world, entity);
		}
	}
	
	
	
	
	
	

}
