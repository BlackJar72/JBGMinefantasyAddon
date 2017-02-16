package jaredbgreat.combatmod.blocks.itemblock;

import jaredbgreat.combatmod.blocks.BasicSlab;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

public class ItemBasicSlab extends ItemSlab {

	public ItemBasicSlab(Block slab, BasicSlab half, BasicSlab full) {
		super(slab, half, full, false);
	}

}
