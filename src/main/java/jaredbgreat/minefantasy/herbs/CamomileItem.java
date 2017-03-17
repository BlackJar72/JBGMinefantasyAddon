package jaredbgreat.minefantasy.herbs;

import jaredbgreat.minefantasy.Info;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionHelper;

public class CamomileItem extends Item {

	public CamomileItem() {
        setPotionEffect(PotionHelper.ghastTearEffect);
        setUnlocalizedName(Info.ID + "-camomile");
        setTextureName(Info.ID + ":Herb/camomile");
        setCreativeTab(CreativeTabs.tabBrewing);
	}
}
