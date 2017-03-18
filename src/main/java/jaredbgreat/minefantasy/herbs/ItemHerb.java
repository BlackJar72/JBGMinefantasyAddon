package jaredbgreat.minefantasy.herbs;

/*
 * Based on a suggestion by Sirse and modified from code 
 * provided by Sirse on GitHub.  This reduces the number
 * of classes for herbs a bit and consolidates some code.
 */

import jaredbgreat.minefantasy.Info;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionHelper;

public class ItemHerb extends ItemFood {

	public ItemHerb(EHerbs herb) {
		super(herb.hunger, herb.saturation, false);
		String herbName = herb.toString().toLowerCase();
		this.setPotionEffect(herb.potion);
		this.setUnlocalizedName(Info.ID + "-" + herbName);
		this.setTextureName(Info.ID + ":Herb/" + herbName);
		this.setCreativeTab(CreativeTabs.tabBrewing);
	}
}