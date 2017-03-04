package jaredbgreat.combatmod.blocks.special;

import jaredbgreat.combatmod.blocks.tileentities.TelepadLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Telepad extends AbstractTelepad {

	public Telepad() {
		super("tpad02a");
		// TODO Auto-generated constructor stub
	}

	@Override
	public TileEntity createNewTileEntity(World wordl, int p) {
		return new TelepadLogic();
	}

}
