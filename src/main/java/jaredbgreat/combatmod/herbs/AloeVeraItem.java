package jaredbgreat.combatmod.herbs;

import jaredbgreat.combatmod.Info;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionHelper;

public class AloeVeraItem extends Item {

	public AloeVeraItem() {
        setPotionEffect(PotionHelper.ghastTearEffect);
        setUnlocalizedName(Info.ID + "-aloeVera");
        setTextureName(Info.ID + ":Herb/aloeVera");
	}
}
