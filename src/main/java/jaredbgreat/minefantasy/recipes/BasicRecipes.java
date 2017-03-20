package jaredbgreat.minefantasy.recipes;

import jaredbgreat.minefantasy.blocks.AddonBlocks;
import minefantasy.mf2.item.list.ComponentListMF;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class BasicRecipes {
	
	public static void register() {
		
		//Recipes for decorative blocks
		GameRegistry.addRecipe(new ItemStack(AddonBlocks.slate, 4, 3),
				"SS",
				"SS",
				'S', new ItemStack(AddonBlocks.slate, 1, 0)
			);
		
		GameRegistry.addRecipe(new ItemStack(AddonBlocks.slate, 4, 1),
				"S S",
				"   ",
				"S S",
				'S', new ItemStack(AddonBlocks.slate, 1, 0)
			);
		
		GameRegistry.addRecipe(new ItemStack(AddonBlocks.slate, 4, 2),
				" S ",
				"S S",
				" S ",
				'S', new ItemStack(AddonBlocks.slate, 1, 0)
			);
		
		GameRegistry.addRecipe(new ItemStack(AddonBlocks.granite, 4, 1),
				"SS",
				"SS",
				'S', new ItemStack(AddonBlocks.granite, 1, 0)
			);
		
		GameRegistry.addShapelessRecipe(new ItemStack(AddonBlocks.granite, 1, 3), 
				new ItemStack(AddonBlocks.granite, 1, 1), Blocks.vine);
				
		GameRegistry.addSmelting(new ItemStack(AddonBlocks.granite, 1, 1), new ItemStack(AddonBlocks.granite, 1, 2), 0);
		
		GameRegistry.addSmelting(new ItemStack(AddonBlocks.granite, 1, 3), new ItemStack(AddonBlocks.granite, 1, 2), 0);

		
		//recipes for slabs
		GameRegistry.addRecipe(new ItemStack(AddonBlocks.graniteSlab1, 6, 0),
				"SSS",
				'S', new ItemStack(AddonBlocks.granite, 1, 0)
			);
		
		GameRegistry.addRecipe(new ItemStack(AddonBlocks.slateSlab1, 6, 0),
				"SSS",
				'S', new ItemStack(AddonBlocks.slate, 1, 0)
			);
		
		GameRegistry.addRecipe(new ItemStack(AddonBlocks.slateSlab1, 6, 1),
				"SSS",
				'S', new ItemStack(AddonBlocks.slate, 1, 1)
			);
		
		GameRegistry.addRecipe(new ItemStack(AddonBlocks.slateSlab1, 6, 2),
				"SSS",
				'S', new ItemStack(AddonBlocks.slate, 1, 2)
			);
		
		GameRegistry.addRecipe(new ItemStack(AddonBlocks.slateSlab1, 6, 3),
				"SSS",
				'S', new ItemStack(AddonBlocks.slate, 1, 3)
			);
		
		GameRegistry.addRecipe(new ItemStack(AddonBlocks.graniteSlab1, 6, 1),
				"SSS",
				'S', new ItemStack(AddonBlocks.granite, 1, 1)
			);
		
		GameRegistry.addRecipe(new ItemStack(AddonBlocks.graniteSlab1, 6, 2),
				"SSS",
				'S', new ItemStack(AddonBlocks.granite, 1, 2)
			);
		
		GameRegistry.addRecipe(new ItemStack(AddonBlocks.graniteSlab1, 6, 3),
				"SSS",
				'S', new ItemStack(AddonBlocks.granite, 1, 3)
			);
		
		GameRegistry.addRecipe(new ItemStack(AddonBlocks.storage, 1, 0), 
				"sss",
				"sss",
				"sss",
				's', ComponentListMF.sulfur
			);
		
		GameRegistry.addShapelessRecipe(new ItemStack(ComponentListMF.sulfur, 9, 0), 
										new ItemStack(AddonBlocks.storage, 1, 0));
		
		GameRegistry.addRecipe(new ItemStack(AddonBlocks.storage, 1, 2), 
				"ccc",
				"ccc",
				"ccc",
				'c', ComponentListMF.coke
			);
		
		GameRegistry.addShapelessRecipe(new ItemStack(ComponentListMF.coke, 9, 0), 
										new ItemStack(AddonBlocks.storage, 1, 2));
		
		GameRegistry.addRecipe(new ItemStack(AddonBlocks.storage, 1, 1), 
				"nnn",
				"nnn",
				"nnn",
				'n', ComponentListMF.nitre
			);
		
		GameRegistry.addShapelessRecipe(new ItemStack(ComponentListMF.nitre, 9, 0), 
										new ItemStack(AddonBlocks.storage, 1, 1));
		
		GameRegistry.addRecipe(new ItemStack(AddonBlocks.landingpad, 1, 0), 
				"lil",
				"iei",
				"lil",
				'i', Items.iron_ingot,
				'e', Items.ender_eye,
				'l', new ItemStack(Items.dye, 1, 4)
			);
		
		GameRegistry.addRecipe(new ItemStack(AddonBlocks.teletoy, 1, 0), 
				"rgr",
				"geg",
				"rgr",
				'r', Items.redstone,
				'g', Items.gold_ingot,
				'e', Items.ender_eye
			);
		
		GameRegistry.addRecipe(new ItemStack(AddonBlocks.telepad, 1, 0), 
				"ege",
				"rtr",
				"ele",
				'r', Items.redstone,
				't', AddonBlocks.teletoy,
				'e', Items.ender_eye,
				'g', Blocks.gold_block,
				'l', Blocks.lapis_block
			);
	}

}
