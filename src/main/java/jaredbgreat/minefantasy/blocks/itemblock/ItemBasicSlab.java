package jaredbgreat.minefantasy.blocks.itemblock;

import jaredbgreat.minefantasy.blocks.BasicSlab;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

public class ItemBasicSlab extends ItemSlab {

	public ItemBasicSlab(Block slab, BasicSlab half, BasicSlab full) {
		super(slab, half, full, false);
	}

}
