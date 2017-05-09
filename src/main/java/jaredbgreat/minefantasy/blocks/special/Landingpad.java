package jaredbgreat.minefantasy.blocks.special;

import jaredbgreat.minefantasy.blocks.tileentities.LandingpadLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Landingpad extends AbstractTelepad {

	public Landingpad() {
		super("tpad00a");
		setLightLevel(0.75f);
		LandingpadLogic.landings.add(this);
	}

	public Landingpad(String name) {
		super(name);
		LandingpadLogic.landings.add(this);
	}

	
	@Override
	public TileEntity createNewTileEntity(World world, int p) {		
		return new LandingpadLogic();
	}
}
