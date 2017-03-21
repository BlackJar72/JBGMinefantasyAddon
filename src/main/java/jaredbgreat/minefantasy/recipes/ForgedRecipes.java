package jaredbgreat.minefantasy.recipes;

import jaredbgreat.minefantasy.ConfigHandler;
import jaredbgreat.minefantasy.blocks.AddonBlocks;
import minefantasy.mf2.api.MineFantasyAPI;
import minefantasy.mf2.api.crafting.Salvage;
import minefantasy.mf2.api.rpg.Skill;
import minefantasy.mf2.api.rpg.SkillList;
import minefantasy.mf2.item.list.ComponentListMF;
import minefantasy.mf2.item.list.CustomToolListMF;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ForgedRecipes {
	private static final Skill artisanry = SkillList.artisanry;
	private static final Skill engineering = SkillList.engineering;
	private static final Skill construction = SkillList.construction;
	
	private static final ItemStack llapis = new ItemStack(Items.dye, 1, 4);
	
	public static void register() {
		if(ConfigHandler.craftTPs) {
			addTelepads();
		}
	}
	
	
	private static void addTelepads() {
		// These will exist in creative mode either way, so they could be
		// used by server admins, map-makers, etc., for public use.
		// This allows them to be crafted by players.		
		
		MineFantasyAPI.addAnvilRecipe(artisanry, new ItemStack(AddonBlocks.landingpad), "smeltSteel", false, "hammer", -1, -1, 1000, new Object[]
				{
					"lsl",
					"iei",
					"lsl",
					'i', ComponentListMF.bar("Steel"),
					's', ComponentListMF.bar("Silver"),
					'e', Items.ender_eye,
					'l', llapis
				});
		
		MineFantasyAPI.addAnvilRecipe(artisanry, new ItemStack(AddonBlocks.teletoy), "smeltSteel", false, "hammer", -1, -1, 1000, new Object[]
				{
					"rgr",
					"geg",
					"rgr",
					'r', Items.redstone,
					'g', ComponentListMF.bar("Gold"),
					'e', Items.ender_eye
				});
		
		MineFantasyAPI.addAnvilRecipe(artisanry, new ItemStack(AddonBlocks.telepad), "smeltEncrusted", false,"hammer", -1, -1, 1000, new Object[]
				{
					"ded",
					"gtg",
					"dld",
					'g', ComponentListMF.bar("Gold"),
					't', AddonBlocks.teletoy,
					'e', Items.ender_eye,
					'd', ComponentListMF.diamond_shards,
					'l', Blocks.lapis_block
				});
		
	}

}
