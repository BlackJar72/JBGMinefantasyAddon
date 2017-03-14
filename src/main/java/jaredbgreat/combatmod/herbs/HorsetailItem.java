package jaredbgreat.combatmod.herbs;

import jaredbgreat.combatmod.Info;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionHelper;

public class HorsetailItem extends Item {

	public HorsetailItem() {
        setPotionEffect(PotionHelper.magmaCreamEffect);
        setUnlocalizedName(Info.ID + "-horsetail");
        setTextureName(Info.ID + ":Herb/horsetail");
	}
}
