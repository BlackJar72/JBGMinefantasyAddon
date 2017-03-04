package jaredbgreat.combatmod.recipes;

import jaredbgreat.combatmod.blocks.MF1Blocks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class BasicRecipes {
	
	public static void register() {
		
		//Recipes for decorative blocks
		GameRegistry.addRecipe(new ItemStack(MF1Blocks.slate, 4, 3),
				"SS",
				"SS",
				'S', new ItemStack(MF1Blocks.slate, 1, 0)
			);
		
		GameRegistry.addRecipe(new ItemStack(MF1Blocks.slate, 4, 1),
				"S S",
				"   ",
				"S S",
				'S', new ItemStack(MF1Blocks.slate, 1, 0)
			);
		
		GameRegistry.addRecipe(new ItemStack(MF1Blocks.slate, 4, 2),
				" S ",
				"S S",
				" S ",
				'S', new ItemStack(MF1Blocks.slate, 1, 0)
			);
		
		GameRegistry.addRecipe(new ItemStack(MF1Blocks.granite, 4, 1),
				"SS",
				"SS",
				'S', new ItemStack(MF1Blocks.granite, 1, 0)
			);
		
		GameRegistry.addShapelessRecipe(new ItemStack(MF1Blocks.granite, 1, 3), 
				new ItemStack(MF1Blocks.granite, 1, 1), Blocks.vine);
				
		GameRegistry.addSmelting(new ItemStack(MF1Blocks.granite, 1, 1), new ItemStack(MF1Blocks.granite, 1, 2), 0);
		
		GameRegistry.addSmelting(new ItemStack(MF1Blocks.granite, 1, 3), new ItemStack(MF1Blocks.granite, 1, 2), 0);

		
		//recipes for slabs
		GameRegistry.addRecipe(new ItemStack(MF1Blocks.graniteSlab1, 6, 0),
				"SSS",
				'S', new ItemStack(MF1Blocks.granite, 1, 0)
			);
		
		GameRegistry.addRecipe(new ItemStack(MF1Blocks.slateSlab1, 6, 0),
				"SSS",
				'S', new ItemStack(MF1Blocks.slate, 1, 0)
			);
		
		GameRegistry.addRecipe(new ItemStack(MF1Blocks.slateSlab1, 6, 1),
				"SSS",
				'S', new ItemStack(MF1Blocks.slate, 1, 1)
			);
		
		GameRegistry.addRecipe(new ItemStack(MF1Blocks.slateSlab1, 6, 2),
				"SSS",
				'S', new ItemStack(MF1Blocks.slate, 1, 2)
			);
		
		GameRegistry.addRecipe(new ItemStack(MF1Blocks.slateSlab1, 6, 3),
				"SSS",
				'S', new ItemStack(MF1Blocks.slate, 1, 3)
			);
		
		GameRegistry.addRecipe(new ItemStack(MF1Blocks.graniteSlab1, 6, 1),
				"SSS",
				'S', new ItemStack(MF1Blocks.granite, 1, 1)
			);
		
		GameRegistry.addRecipe(new ItemStack(MF1Blocks.graniteSlab1, 6, 2),
				"SSS",
				'S', new ItemStack(MF1Blocks.granite, 1, 2)
			);
		
		GameRegistry.addRecipe(new ItemStack(MF1Blocks.graniteSlab1, 6, 3),
				"SSS",
				'S', new ItemStack(MF1Blocks.granite, 1, 3)
			);
		
		GameRegistry.addRecipe(new ItemStack(MF1Blocks.landingpad, 1, 0), 
				"lil",
				"iei",
				"lil",
				'i', Items.iron_ingot,
				'e', Items.ender_eye,
				'l', new ItemStack(Items.dye, 1, 4)
			);
		
		GameRegistry.addRecipe(new ItemStack(MF1Blocks.teletoy, 1, 0), 
				"rgr",
				"geg",
				"rgr",
				'r', Items.redstone,
				'g', Items.gold_ingot,
				'e', Items.ender_eye
			);
		
		GameRegistry.addRecipe(new ItemStack(MF1Blocks.telepad, 1, 0), 
				"ege",
				"rtr",
				"ele",
				'r', Items.redstone,
				't', MF1Blocks.teletoy,
				'e', Items.ender_eye,
				'g', Blocks.gold_block,
				'l', Blocks.lapis_block
			);
	}

}
