package jaredbgreat.combatmod.blocks.special;

import jaredbgreat.combatmod.blocks.tileentities.TelepadLogic;
import jaredbgreat.combatmod.blocks.tileentities.TeletoyLogic;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Telepad extends AbstractTelepad {

	public Telepad() {
		super("tpad01a");
		setLightLevel(1.0f);		
	}

	@Override
	public TileEntity createNewTileEntity(World wordl, int p) {
		return new TelepadLogic();
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		TileEntity te = world.getTileEntity(x, y, z);
		if(te instanceof TelepadLogic) {
			TelepadLogic logic = (TelepadLogic)te;
			logic.onActivated(world, entity);
		}
	}

}
