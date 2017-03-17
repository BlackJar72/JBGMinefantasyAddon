package jaredbgreat.minefantasy.herbs;

import jaredbgreat.minefantasy.Info;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionHelper;

public class HorsetailItem extends Item {

	public HorsetailItem() {
        setPotionEffect(PotionHelper.magmaCreamEffect);
        setUnlocalizedName(Info.ID + "-horsetail");
        setTextureName(Info.ID + ":Herb/horsetail");
        setCreativeTab(CreativeTabs.tabBrewing);
	}
}
