package jaredbgreat.minefantasy.blocks.container;

import jaredbgreat.minefantasy.blocks.tileentities.LandingpadLogic;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class LandingpadContainer extends Container {
	private LandingpadLogic pad;
	
	public LandingpadContainer(InventoryPlayer player, LandingpadLogic landingpad) {
		pad = landingpad;
		
	}
	

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

}
