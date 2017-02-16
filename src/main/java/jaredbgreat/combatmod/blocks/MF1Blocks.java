package jaredbgreat.combatmod.blocks;

import static net.minecraft.block.Block.soundTypeStone;
import jaredbgreat.combatmod.blocks.itemblock.ItemBasicSlab;
import jaredbgreat.combatmod.blocks.itemblock.ItemBlockMF1;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;

public class MF1Blocks {
	
	
	public static Block slate = new BasicMetaBlock("slate", Material.rock, 4, 2.2f, 6.0f, soundTypeStone);
	public static Block granite = new BasicMetaBlock("granite", Material.rock, 4, 5.0f, 18.0f, soundTypeStone);	
	//public static Block storageBlock = new BasicMetaBlock("storage", Material.rock, 1, 0.7f, 1.0f, soundTypeStone);
	
	
	public static Block slateSlab1 = new BasicSlab("slate", false, Material.rock, 4, 2.2f, 6.0f, soundTypeStone);
	public static Block slateSlab2 = new BasicSlab("slate", true, slateSlab1, Material.rock, 4, 2.2f, 6.0f, soundTypeStone);
	public static Block graniteSlab1 = new BasicSlab("granite", false, Material.rock, 4, 5.0f, 18.0f, soundTypeStone);
	public static Block graniteSlab2 = new BasicSlab("granite", true, graniteSlab1, Material.rock, 4, 5.0f, 18.0f, soundTypeStone);	
	
	
	public static void register() {
		//Some setup
		slate.setHarvestLevel("pickaxe", 1);
		granite.setHarvestLevel("pickaxe", 2);
		
		//Registering basic blocks
		
		//Registering meta-blocks
		GameRegistry.registerBlock(slate, ItemBlockMF1.class, "slate");
		GameRegistry.registerBlock(granite, ItemBlockMF1.class, "granite");
		//GameRegistry.registerBlock(storageBlock, ItemBlockMF1.class, "sulphur_block");
		
		//Registering slabs
		GameRegistry.registerBlock(slateSlab1, ItemBasicSlab.class, "slate_slab1", slateSlab1, slateSlab2);
		GameRegistry.registerBlock(slateSlab2, ItemBasicSlab.class, "slate_slab2", slateSlab1, slateSlab2);
		GameRegistry.registerBlock(graniteSlab1, ItemBasicSlab.class, "granite_slab1", graniteSlab1, graniteSlab2);
		GameRegistry.registerBlock(graniteSlab2, ItemBasicSlab.class, "granite_slab2", graniteSlab1, graniteSlab2);
	}

}
