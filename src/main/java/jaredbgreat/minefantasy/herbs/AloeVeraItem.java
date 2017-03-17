package jaredbgreat.minefantasy.herbs;

import jaredbgreat.minefantasy.Info;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionHelper;

public class AloeVeraItem extends Item {

	public AloeVeraItem() {
        setPotionEffect(PotionHelper.speckledMelonEffect);
        setUnlocalizedName(Info.ID + "-aloeVera");
        setTextureName(Info.ID + ":Herb/aloeVera");
        this.setCreativeTab(CreativeTabs.tabBrewing);
	}
}
