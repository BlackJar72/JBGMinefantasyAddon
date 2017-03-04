package jaredbgreat.combatmod.blocks.special;

import jaredbgreat.combatmod.blocks.tileentities.LandingpadLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Landingpad extends AbstractTelepad {

	public Landingpad() {
		super("tpad00a");
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new LandingpadLogic();
	}

}
