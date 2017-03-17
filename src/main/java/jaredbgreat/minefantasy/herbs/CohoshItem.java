package jaredbgreat.minefantasy.herbs;

import jaredbgreat.minefantasy.Info;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionHelper;

public class CohoshItem extends Item {

	public CohoshItem() {
        setPotionEffect(PotionHelper.blazePowderEffect);
        setUnlocalizedName(Info.ID + "-cohosh");
        setTextureName(Info.ID + ":Herb/cohosh");
        setCreativeTab(CreativeTabs.tabBrewing);
	}
}
