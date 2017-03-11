package jaredbgreat.combatmod.herbs;

import cpw.mods.fml.common.registry.GameRegistry;

public class Herbs {
	
	//Blocks
	static final GinsengPlant ginseng = new GinsengPlant();
	
	//Items
	static final GinsengItem ginsengroot = new GinsengItem(2, 2f);
	
	
	public static void InitPlants() {
		GameRegistry.registerBlock(ginseng, "ginseng");
		GameRegistry.registerItem(ginsengroot, "Ginseng Root");
	}
	
	
	public static void InitRecipes() {
		
	}
}
