package jaredbgreat.minefantasy.blocks;

import static net.minecraft.block.Block.soundTypeStone;
import jaredbgreat.minefantasy.ConfigHandler;
import jaredbgreat.minefantasy.blocks.itemblock.ItemBasicSlab;
import jaredbgreat.minefantasy.blocks.itemblock.ItemBlockMF1;
import jaredbgreat.minefantasy.blocks.itemblock.TelepadItem;
import jaredbgreat.minefantasy.blocks.itemblock.TeletoyItem;
import jaredbgreat.minefantasy.blocks.special.Landingpad;
import jaredbgreat.minefantasy.blocks.special.Telepad;
import jaredbgreat.minefantasy.blocks.special.Teletoy;
import jaredbgreat.minefantasy.blocks.tileentities.LandingpadLogic;
import jaredbgreat.minefantasy.blocks.tileentities.TelepadLogic;
import jaredbgreat.minefantasy.blocks.tileentities.TeletoyLogic;
import jaredbgreat.minefantasy.herbs.Herbs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;

public class AddonBlocks {
	
	
	public static Block slate = new BasicMetaBlock("slate", Material.rock, 4, 2.2f, 6.0f, soundTypeStone);
	public static Block granite = new BasicMetaBlock("granite", Material.rock, 4, 5.0f, 18.0f, soundTypeStone);	
	public static Block storage = new BasicMetaBlock("storage", Material.rock, 3, 0.7f, 1.0f, soundTypeStone);
	
	
	public static Block slateSlab1 = new BasicSlab("slate", false, Material.rock, 4, 2.2f, 6.0f, soundTypeStone);
	public static Block slateSlab2 = new BasicSlab("slate", true, slateSlab1, Material.rock, 4, 2.2f, 6.0f, soundTypeStone);
	public static Block graniteSlab1 = new BasicSlab("granite", false, Material.rock, 4, 5.0f, 18.0f, soundTypeStone);
	public static Block graniteSlab2 = new BasicSlab("granite", true, graniteSlab1, Material.rock, 4, 5.0f, 18.0f, soundTypeStone);	
	
	public static Telepad telepad = new Telepad();
	public static Teletoy teletoy = new Teletoy();
	public static Landingpad landingpad = new Landingpad();
	
	public static void register() {
		//Some setup
		slate.setHarvestLevel("pickaxe", 1);
		granite.setHarvestLevel("pickaxe", 2);
		
		//Registering basic blocks
		
		//Registering meta-blocks
		GameRegistry.registerBlock(slate, ItemBlockMF1.class, "slate");
		GameRegistry.registerBlock(granite, ItemBlockMF1.class, "granite");
		if(ConfigHandler.includeStorage) {
			GameRegistry.registerBlock(storage, ItemBlockMF1.class, "storage_block");
		}
		
		//Registering slabs
		GameRegistry.registerBlock(slateSlab1, ItemBasicSlab.class, "slate_slab1", slateSlab1, slateSlab2);
		GameRegistry.registerBlock(slateSlab2, ItemBasicSlab.class, "slate_slab2", slateSlab1, slateSlab2);
		GameRegistry.registerBlock(graniteSlab1, ItemBasicSlab.class, "granite_slab1", graniteSlab1, graniteSlab2);
		GameRegistry.registerBlock(graniteSlab2, ItemBasicSlab.class, "granite_slab2", graniteSlab1, graniteSlab2);
		
		//Register telepads
		if(ConfigHandler.includeTPs) {
			GameRegistry.registerTileEntity(TeletoyLogic.class, "TeletoyLogic");
			GameRegistry.registerTileEntity(TelepadLogic.class, "TelepadLogic");
			GameRegistry.registerTileEntity(LandingpadLogic.class, "LandingpadLogic");
			GameRegistry.registerBlock(telepad, TelepadItem.class, telepad.getUnlocalizedName());
			GameRegistry.registerBlock(teletoy, TeletoyItem.class, teletoy.getUnlocalizedName());
			GameRegistry.registerBlock(landingpad, landingpad.getUnlocalizedName());
		}
	}

}
