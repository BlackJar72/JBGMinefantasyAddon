package jaredbgreat.combatmod.blocks.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMF1 extends ItemBlock {
	private final String name;

	public ItemBlockMF1(Block block) {
		super(block);
		name = block.getUnlocalizedName();
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item) {
		return name + item.getItemDamage();
	}
}
