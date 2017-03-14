package jaredbgreat.combatmod.herbs;

import jaredbgreat.combatmod.Info;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionHelper;

public class CohoshItem extends Item {

	public CohoshItem() {
        setPotionEffect(PotionHelper.blazePowderEffect);
        setUnlocalizedName(Info.ID + "-cohosh");
        setTextureName(Info.ID + ":Herb/cohosh");
	}
}
